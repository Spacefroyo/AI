import java.util.Arrays;

/**
 * A generic Layer object which contains required methods for any layer of a
 * neural network
 */
abstract class Layer {
    /**
     * number of nodes
     */
    int size;

    /**
     * biases of the nodes
     */
    double[] b;

    /**
     * weights of the edges
     */
    double[][] w;

    /**
     * values of the nodes
     */
    double[] v;

    /**
     * previous layer in the neural network
     */
    Layer prev;

    /**
     * activation function
     */
    ActivationFunction act;

    /**
     * Constructor
     *
     * @param size number of nodes
     * @param prev previous layer in the neural network
     */
    public Layer (int size, Layer prev) {
        this.size = size;
        b = new double[size];
        v = new double[size];
        this.prev = prev;
    }

    /**
     * Randomly initialize the weights and biases
     */
    public abstract void init();

    /**
     * Propogate through this layer to get this layer's values from last
     * layer's values
     */
    public abstract void prop();

    /**
     * Gets the gradient of this layer's weights and the previous layer's biases
     *
     * @param deltas This layer's biases' gradient
     * @return First {size} rows are gradient for this layer's weights, last
     * row is gradient for previous layer's biases
     */
    public abstract double[][] backprop(double[] deltas);

    @Override
    public String toString() {
        return "{Size: " + this.size + "}";
    }

    /**
     * Get a string representation of the weights and biases
     *
     * @return A string representation of the weights and biases
     */
    public String getNums() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += (w == null ? "" : "w: " + Arrays.toString(w[i]) + " ") + "b: " + b[i] + "\n";
        }
        return s;
    }
}