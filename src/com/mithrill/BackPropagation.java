package com.mithrill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackPropagation {
    double [][] neuron;
    int hidden, output;
    FeedForwad firstLayer;
    FeedForwad secondLayer;

    public BackPropagation(double[][] neuron, int hidden, int output) {
        this.neuron = neuron;
        this.hidden = hidden;
        this.output = output;
    }

    public double[][] initializeMat (int filas, int columnas){
        double[][] initVal = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                initVal[i][j]= Math.random()*2-1;
            }
        }
        return initVal;
    }

    public void NeuronInitializer(){
        //List <FeedForwad>layers = new ArrayList<>();
        double[][] weights = initializeMat(hidden, neuron[0].length);
        double[][] bias = initializeMat(1, hidden);
        double[][] tNeuron = LAlgebraHelp.matrix_XT(neuron);

        firstLayer = new FeedForwad(weights, tNeuron, bias);
        double [][] neuronNext = firstLayer.activacion();

        secondLayer = new FeedForwad(initializeMat(output,neuronNext.length), neuronNext,
                initializeMat(1, output));
    }

    public void training(double [] isample, double[] itarget){
        double [][] sample = LAlgebraHelp.convertir_Array_Matrix(isample);
        double [][] target = LAlgebraHelp.convertir_Array_Matrix(itarget);

        //NeuronInitializer();
        //FeedForwad firstLayer = data.get(0);
        //FeedForwad secondLayer = data.get(1);

        firstLayer.setNeuronPrev(sample);
        //System.out.println(Arrays.deepToString(sample));
        secondLayer.setNeuronPrev(firstLayer.activacion());
        //System.out.println(Arrays.deepToString(target));
        double [][] output = secondLayer.activacion();
        //System.out.println(Arrays.deepToString(output));
        double [][] error = LAlgebraHelp.mat_rest(target, output);
        double [][] gradient = LAlgebraHelp.dSigmoide(output);

        assert error != null;
        gradient = LAlgebraHelp.mat_Multiplication(gradient, error);
        gradient = LAlgebraHelp.multi(gradient, 0.01);

        double [][] auxHiddenOutput = LAlgebraHelp.mat_Multiplication(gradient, LAlgebraHelp.matrix_XT(secondLayer.getNeuronPrev()));

        secondLayer.setWeights(LAlgebraHelp.mat_Sum(secondLayer.getWeights(), auxHiddenOutput));
        secondLayer.setBias(LAlgebraHelp.mat_Sum(secondLayer.getBias(), gradient));

        double [][] hidErr = LAlgebraHelp.mat_Multiplication(LAlgebraHelp.matrix_XT(auxHiddenOutput), error);
        double [][] hiddGradient = LAlgebraHelp.dSigmoide(secondLayer.getNeuronPrev());

//        System.out.println("hgrad = " + hiddGradient.length);
//        System.out.println("herr = " + hidErr.length);

        LAlgebraHelp.multiplicacion(hiddGradient, hidErr);
        hiddGradient = LAlgebraHelp.multi(hiddGradient, 0.01);

        double [][] auxInputHidden = LAlgebraHelp.mat_Multiplication(hiddGradient, LAlgebraHelp.matrix_XT(sample));
        //System.out.println("FL size = " + auxInputHidden.length + " " + auxInputHidden[0].length) ;
        firstLayer.setWeights(LAlgebraHelp.mat_Sum(firstLayer.getWeights(), auxInputHidden));
        firstLayer.setBias(LAlgebraHelp.mat_Sum(firstLayer.getBias(),hiddGradient));

        //data.set(0, firstLayer);
        //data.set(1, secondLayer);
    }

    public void cycleTraining(double[][]dataset_x, double[][]dataset_y, int iterations)
    {
        for(int i=0;i<iterations;i++)
        {
            int sampleN =  (int)(Math.random() * dataset_x.length );
            this.training(dataset_x[sampleN], dataset_y[sampleN]);
        }

        //return data;
    }

    public List<FeedForwad> prediction(double [] userInput){
        List <FeedForwad>layers = new ArrayList<>();
        firstLayer.setNeuronPrev(LAlgebraHelp.convertir_Array_Matrix(userInput));
        double [][] neuronNext = firstLayer.activacion();
        layers.add(firstLayer);
        layers.add(secondLayer);
        return layers;
    }
}
