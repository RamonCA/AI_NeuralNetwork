import java.util.ArrayList;
import java.util.List;

public class BackPropagation {

    //FeedForwad current;
    double [][] target;
    double [][] input;
    double [][] bias;
    int hidden;
    int output;

    public BackPropagation(double[][] target, double[][] input, double[][] bias, int hidden, int output) {
        this.target = target;
        this.input = input;
        this.bias = bias;
        this.hidden = hidden;
        this.output = output;
    }

    public double [][] RandomWeight(int fila, int col) {
        double [][] curr_weight = new double [fila][col];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < col; j++) {
                //initWeights_IH [i][j] = random;
            }
        }
    }

    public double [][] outputInit () {//recibir weight/bias IH y HO y inputX
        //obtener output de iteracion
        //FeedForwad inputHidden;
        //FeedForward HiddenOutput
        //double [][] hidden = current.SuperActivacion(de input a hidden) => weights_IH(inicial son random), input(neuronPrev), bias_IH.
        //return current.SuperActivacion(de hidden a output) => weights_HO(inicial son random), hidden(recien calculada), bias_HO.
        return new double[][] {{0}};
    }
}
