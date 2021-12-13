package com.mithrill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        double [][] X= {
                {0,0,1,0,0,0,1,1,0,0,1,1,1,1,1,0,1,1,0,1,0,0,1,0,1},//IZQUIERDA
                {0,0,1,0,0,0,1,1,0,0,1,1,1,1,1,0,1,1,0,1,0,0,1,0,1},//IZQUIERDA
                {0,0,1,0,0,0,1,0,0,0,1,1,1,1,1,0,1,0,0,1,0,0,1,0,1},//IZQUIERDA
                {0,1,1,0,0,1,1,0,0,0,1,1,1,1,1,1,1,0,0,1,0,1,1,0,1},//IZQUIERDA
                {0,0,1,0,0,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,0,1,0,0},//DERECHA
                {0,0,1,0,0,0,0,0,1,0,1,1,1,1,1,1,0,0,1,0,1,0,1,0,0},//DERECHA
                {0,0,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0,1,1,1,0,1,1,0}//DERECHA

        };
        double [][] Y= {
                {0,0},{0,0},{0,0},{0,0},{1,1},{1,1},{1,1}
        };

	// write your code here
        BackPropagation test = new BackPropagation(new double[][]{{0,0,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,0}},12,2);
        List<FeedForwad> data;
        //data = test.NeuronInitializer();
        test.NeuronInitializer();
        test.cycleTraining(X, Y, 100000);
        data = test.prediction(new double[]{0,0,1,0,0,0,1,1,0,0,1,1,1,1,1,0,1,1,0,1,0,0,1,0,1});
        System.out.println(Arrays.deepToString(data.get(1).activacion()));
    }
}
