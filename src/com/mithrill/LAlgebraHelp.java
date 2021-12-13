package com.mithrill;

import java.util.Arrays;

public class LAlgebraHelp {

    public static double [][] mat_Multiplication(double [][] mat_B, double[][] mat_A){
        double [][] mat_XTmultX = new double[mat_B.length][mat_A[0].length];
        for (int i = 0; i < mat_B.length; i++) {
            for (int j = 0; j < mat_A[0].length; j++) {
                double x = 0;
                for (int k = 0; k < mat_B[0].length; k++) {
                    x += mat_B[i][k] * mat_A[k][j];
                }
                mat_XTmultX[i][j] = x;
            }
        }
        return mat_XTmultX;
    }

    public static double[][] multi(double[][] ma, double a) {
        double[][] ans=new double[ma.length][ma[0].length];

        for(int i = 0; i< ma.length; i++)
        {
            for(int j = 0; j< ma[0].length; j++)
            {
                ans[i][j] = ma[i][j] *a;
            }
        }
        return ans;
    }

    public static double [][] multiplicacion(double [][] a, double [][] b) {
        for(int i = 0; i<b.length; i++)
        {
            for(int j = 0; j<b[0].length; j++)
            {
                a[i][j]*=b[i][j];
            }
        }
        return a;
    }

    public static double[][] mat_Sum(double[][] mat_A, double[][] mat_B){
        double[][] mat_sum;
        
        if(mat_A.length == mat_B.length && mat_B[0].length == mat_A[0].length){
            mat_sum = new double[mat_A.length][mat_A[0].length];
            for(int i=0;i<mat_A.length;i++){
                for(int j=0;j<mat_A[0].length;j++){
                    mat_sum[i][j] = mat_A[i][j] + mat_B[i][j];
                }
            }
            return mat_sum;
        } else {
            return null;
        }
    }


    public static double[][] mat_rest(double[][] mat_A, double[][] mat_B){
        double[][] mat_rest;

        if(mat_A.length == mat_B.length && mat_B[0].length == mat_A[0].length){
            mat_rest = new double[mat_A.length][mat_A[0].length];
            for(int i=0;i<mat_A.length;i++){
                for(int j=0;j<mat_A[0].length;j++){
                    mat_rest[i][j] = mat_A[i][j] - mat_B[i][j];
                }
            }
            return mat_rest;
        } else {
            return null;
        }
    }


    public static double [][] matrix_XT (double [][] matrix_X){
        double [][] mat_XT = new double[matrix_X[0].length][matrix_X.length];
        for (int i = 0; i < matrix_X.length; i++) {
            for (int j = 0; j < matrix_X[0].length; j++){
                mat_XT[j][i] = matrix_X[i][j];

            }
        }
        return mat_XT;
    }

    //Esta me la traje del logistic regression
    public static double[][] sigmoide(double [][] neuron) {
        for(int i = 0; i < neuron.length; i++)
        {
            for(int j = 0; j < neuron[0].length; j++)
                neuron[i][j] = 1/(1+Math.exp(-neuron[i][j]));
        }
        return neuron;
    }

    public static double [][] dSigmoide(double [][] matInput) {
        double[][] matAns = new double[matInput.length][matInput[0].length];
        for(int i = 0; i< matInput.length; i++)
        {
            for(int j = 0; j< matInput[0].length; j++)
                matAns[i][j] = matInput[i][j] * (1-matInput[i][j]);
        }
        return matAns;
    }

    public static double[][] convertir_Array_Matrix(double[]x) {

        double[][] result = new  double[x.length][1];
        for(int i =0;i<x.length;i++)
            result[i][0]=x[i];
        return result;

    }

    //funcion sigmoide activacion
    //funcion sigmoide derivada
}