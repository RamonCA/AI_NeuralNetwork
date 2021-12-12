package com.mithrill;

import java.util.Arrays;

public class FeedForwad {

    double [][] weights;
    double [][] neuronPrev;
    double [][] bias;

    public FeedForwad(double[][] weights, double[][] neuronPrev, double[][] bias) {
        this.weights = weights;
        this.neuronPrev = neuronPrev;
        //this.neuronNext = neuronNext;
        this.bias = bias;
    }

    public double[][] getNeuronPrev() {
        return neuronPrev;
    }

    public void setNeuronPrev(double[][] neuronPrev) {
        this.neuronPrev = neuronPrev;
    }

    /*public double[] getNeuronNext() {
        return neuronNext;
    }*/

    /*public void setNeuronNext(double[] neuronNext) {
        this.neuronNext = neuronNext;
    }*/

    public double[][] getWeights() {
        return weights;
    }

    public void setWeights(double[][] weights) {
        this.weights = weights;
    }

    public double[][] getBias() {
        return bias;
    }

    public void setBias(double[][] bias) {
        this.bias = bias;
    }

    //SuperFuncion Activacion double[][] output
        //double [][] neuronNext;
        //funcion mutiplicaion Weights x neuronPrev = multActWgs
        //funcion suma multActWgs + bias = nextAct
        //funcion sigmoide nextAct = neuronNext
        //return neuronNext;

    public double[][] activacion() {
        double[][] neuronNext, multActWgs, nextAct;
//        System.out.println(new StringBuilder().append("Weights").append(Arrays.deepToString(weights)).toString());
//        System.out.println(new StringBuilder().append("BIas").append(Arrays.deepToString(bias)).toString());
//        System.out.println(new StringBuilder().append("NeuronT").append(Arrays.deepToString(LAlgebraHelp.matrix_XT(neuronPrev))).toString());
        multActWgs = LAlgebraHelp.mat_Multiplication(weights,LAlgebraHelp.matrix_XT(neuronPrev));
//        System.out.println("w*nt" + Arrays.deepToString(multActWgs));
//        System.out.println(Arrays.deepToString(bias));
        nextAct = LAlgebraHelp.mat_Sum(multActWgs, LAlgebraHelp.matrix_XT(bias));
//        System.out.println("NextNN" + Arrays.deepToString(nextAct));
//        assert nextAct != null;
        assert nextAct != null;
        neuronNext = LAlgebraHelp.sigmoide(LAlgebraHelp.matrix_XT(nextAct));
        return neuronNext;
    }
}
