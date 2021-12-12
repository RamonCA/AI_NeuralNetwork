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
                initVal[i][j]=Math.random()*2-1;
            }
        }
        return initVal;
    }
    //prediccion inicial
    public List<FeedForwad> prediccion (){
        List <FeedForwad>layers = new ArrayList<>();
        double[][] weights = initializeMat(hidden, neuron[0].length);
        double[][] bias = initializeMat(1, hidden);

//        System.out.println("Datos:");
//        System.out.println("Weights" + Arrays.deepToString(weights));
//        System.out.println("Bias" + Arrays.deepToString(bias));
//        System.out.println("Neuron" + Arrays.deepToString(neuron));
        FeedForwad firstLayer = new FeedForwad(weights, neuron, bias);
        double [][] neuronNext = firstLayer.activacion();
        layers.add(firstLayer);
        FeedForwad secondLayer = new FeedForwad(initializeMat(output,neuronNext.length), neuronNext,
                initializeMat(1, output));
        layers.add(secondLayer);

        return layers;
    }
}
