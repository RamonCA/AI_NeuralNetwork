package com.mithrill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackPropagation {
    double [][] neuron;
    int hidden, output;

    public BackPropagation(double[][] neuron, int hidden, int output) {
        this.neuron = neuron;
        this.hidden = hidden;
        this.output = output;
    }

    public double[][] initializeMat (int filas, int columnas){
        double[][] initVal = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                initVal[i][j]= 1; //Math.random()*2-1;
            }
        }
        return initVal;
    }

    public List<FeedForwad> NeuronInitializer(){
        List <FeedForwad>layers = new ArrayList<>();
        double[][] weights = initializeMat(hidden, neuron[0].length);
        double[][] bias = initializeMat(1, hidden);
        double[][] tNeuron = LAlgebraHelp.matrix_XT(neuron);

        FeedForwad firstLayer = new FeedForwad(weights, tNeuron, bias);
        double [][] neuronNext = firstLayer.activacion();
        layers.add(firstLayer);

        FeedForwad secondLayer = new FeedForwad(initializeMat(output,neuronNext.length), neuronNext,
                initializeMat(1, output));
        layers.add(secondLayer);

        return layers;
    }

    public void training(List<FeedForwad> data, double [] isample, double[] itarget){
        double [][] sample = LAlgebraHelp.convertir_Array_Matrix(isample);
        double [][] target = LAlgebraHelp.convertir_Array_Matrix(itarget);

        FeedForwad firstLayer = data.get(0);
        FeedForwad secondLayer = data.get(1);

        firstLayer.setNeuronPrev(sample);
        //System.out.println(Arrays.deepToString(sample));
        secondLayer.setNeuronPrev(firstLayer.activacion());
        //System.out.println(Arrays.deepToString(target));
        double [][] output = secondLayer.activacion();
        //System.out.println(Arrays.deepToString(output));
        double [][] error = LAlgebraHelp.mat_rest(target, output);
        double [][] gradient = LAlgebraHelp.dSigmoide(output);

        gradient = LAlgebraHelp.mat_Multiplication(gradient, error);
        gradient = LAlgebraHelp.multi(gradient, 0.01);

        double [][] auxHiddenOutput = LAlgebraHelp.mat_Multiplication(gradient, LAlgebraHelp.matrix_XT(secondLayer.getNeuronPrev()));

        secondLayer.setWeights(LAlgebraHelp.mat_Sum(secondLayer.getWeights(), auxHiddenOutput));
        secondLayer.setBias(LAlgebraHelp.mat_Sum(secondLayer.getBias(), gradient));

        double [][] hidErr = LAlgebraHelp.mat_Multiplication(LAlgebraHelp.matrix_XT(auxHiddenOutput), error);
        double [][] hiddGradient = LAlgebraHelp.dSigmoide(secondLayer.getNeuronPrev());

//        System.out.println("hgrad = " + hiddGradient.length);
//        System.out.println("herr = " + hidErr.length);

        hiddGradient = LAlgebraHelp.multiplicacion(hiddGradient, hidErr);
        hiddGradient = LAlgebraHelp.multi(hiddGradient, 0.01);

        double [][] auxInputHidden = LAlgebraHelp.mat_Multiplication(hiddGradient, LAlgebraHelp.matrix_XT(sample));
        //System.out.println("FL size = " + auxInputHidden.length + " " + auxInputHidden[0].length) ;
        firstLayer.setWeights(LAlgebraHelp.mat_Sum(firstLayer.getWeights(), auxInputHidden));
        firstLayer.setBias(LAlgebraHelp.mat_Sum(firstLayer.getBias(),hiddGradient));

        data.set(0, firstLayer);
        data.set(1, secondLayer);
    }

    public List<FeedForwad> cycleTraining(List<FeedForwad> data,double[][]dataset_x, double[][]dataset_y, int iterations)
    {
        for(int i=0;i<iterations;i++)
        {
            int sampleN =  (int)(Math.random() * dataset_x.length );
            this.training(data,dataset_x[sampleN], dataset_y[sampleN]);
        }

        return data;
    }

    public List<FeedForwad> prediction(List<FeedForwad> finalData, double [][]userInput){
        List <FeedForwad>layers = new ArrayList<>();
        double[][] weights = finalData.get(0).getWeights();
        double[][] bias = finalData.get(0).getBias();
        double[][] tNeuron = LAlgebraHelp.matrix_XT(userInput);

        FeedForwad firstLayer = new FeedForwad(weights, tNeuron, bias);
        double [][] neuronNext = firstLayer.activacion();
        layers.add(firstLayer);

        FeedForwad secondLayer = new FeedForwad(initializeMat(output,neuronNext.length), neuronNext,
                initializeMat(1, output));
        layers.add(secondLayer);

        return layers;
    }
}
