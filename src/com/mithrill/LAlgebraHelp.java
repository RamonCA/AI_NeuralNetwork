package com.mithrill;
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

    //funcion sigmoide activacion
    //funcion sigmoide derivada
}