package com.mithrill;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BackPropagation test = new BackPropagation(new double[][]{{1,1,0,0,1}},12,2);
        System.out.println(Arrays.deepToString(test.prediccion().get(1).activacion()));

    }
}
