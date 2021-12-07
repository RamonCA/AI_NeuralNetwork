public class LAlgebraHelp {

    private double [][] mat_Multiplication(double [][] mat_A, double[][] mat_B){
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

    private double [][] matrix_XT (double [][] matrix_X){
        double [][] mat_XT = new double[matrix_X[0].length][matrix_X.length];
        for (int i = 0; i < matrix_X.length; i++) {
            for (int j = 0; j < matrix_X[0].length; j++){
                mat_XT[j][i] = matrix_X[i][j];

            }
        }
        return mat_XT;
    }

    //funcion sigmoide activacion
    //funcion sigmoide derivada
}