import java.util.function.Function;

public class NN {
    private double[][] nodes;

    private double[][][] w;

    private double[][] b;

    private ActivationFunction act = new Sigmoid();

    private Function<double[][], Double> cost;
    private double cost(double[][] x) { return cost.apply(x); }

    public NN(int[] layers) {
        nodes = new double[layers.length][];
        w = new double[layers.length-1][][];
        b = new double[layers.length-1][];
        nodes[0] = new double[layers[0]];
        for (int i = 1; i < layers.length; i++) {
            nodes[i] = new double[layers[i]];
            w[i-1] = new double[layers[i]][layers[i - 1]];
            b[i-1] = new double[layers[i]];
        }
    }

    public NN()

    public void prop(double[] input) {
        nodes[0] = input;
        for (int i = 1; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                double sum = b[i-1][j];
                for (int k = 0; k < nodes[i - 1].length; k++) {
                    sum += nodes[i - 1][k] * w[i][j][k];
                }
                nodes[i][j] = act.func(sum);
            }
        }
    }

    public double[] predictions() { return nodes[nodes.length-1]; }

    public double cost(double[] actual) {
        return cost(new double[][] {actual, predictions()});
    }

    public void backprop(double[] actual) {
        double[][] deltas = new double[nodes.length][];
        for (int i = 0; i < deltas.length; i++) {
            deltas[i] = new double[nodes[i].length];
        }
        for (int i = 0; i < predictions().length; i++) {
            deltas[nodes.length - 1][i] = 2 * (actual[i] - predictions()[i]) * act.der(predictions()[i]);
        }
        for (int i = nodes.length - 2; i > 0; i--) {
            for (int j = 0; j < nodes[i].length; j++) {
                double sum = 0;
                for (int k = 0; k < nodes[i + 1].length; k++) {
                    sum += deltas[i + 1][k] * w[i + 1][k][j];
                }
                deltas[i][j] = sum * act.der(nodes[i][j]);
            }
        }
        for (int i = 1; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                b[i][j] += deltas[i][j];
                for (int k = 0; k < nodes[i - 1].length; k++) {
                    w[i][j][k] += deltas[i][j] * nodes[i - 1][k];
                }
            }
        }
    }

    public void update(double[][] inputs, double[][] actual) {
        for (int i = 0; i < inputs.length; i++) {
            prop(inputs[i]);
            backprop(actual[i]);
        }
    }

    class Layer {

    }
}