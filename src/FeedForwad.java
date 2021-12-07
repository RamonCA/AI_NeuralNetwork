public class FeedForwad {

    double [][] weights;
    double [] neuronPrev;
    double [] neuronNext;
    double [] bias;

    public FeedForwad(double[][] weights, double[] neuronPrev, double[] neuronNext, double[] bias) {
        this.weights = weights;
        this.neuronPrev = neuronPrev;
        this.neuronNext = neuronNext;
        this.bias = bias;
    }

    public double[] getNeuronPrev() {
        return neuronPrev;
    }

    public void setNeuronPrev(double[] neuronPrev) {
        this.neuronPrev = neuronPrev;
    }

    public double[] getNeuronNext() {
        return neuronNext;
    }

    public void setNeuronNext(double[] neuronNext) {
        this.neuronNext = neuronNext;
    }

    public double[][] getWeights() {
        return weights;
    }

    public void setWeights(double[][] weights) {
        this.weights = weights;
    }

    public double[] getBias() {
        return bias;
    }

    public void setBias(double[] bias) {
        this.bias = bias;
    }

    //SuperFuncion Activacion
        //funcion mutiplicaion Weights x neuronPrev = multActWgs
        //funcion suma multActWgs + bias = nextAct
        //funcion sigmoide nextAct = neuronNext
}
