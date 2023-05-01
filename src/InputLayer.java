/**
 * The input layer which does not have weights or a previous layer
 */
class InputLayer extends Layer {
    /**
     * Constructor
     *
     * @param size number of nodes
     */
    public InputLayer(int size) {
        super(size, null);
        b = null;
    }

    @Override
    public void init() {}

    @Override
    public void prop() {}

    @Override
    public double[][] backprop(double[] deltas) {
        return null;
    }

    @Override
    public String toString() {
        return "Input Layer " + super.toString();
    }
}