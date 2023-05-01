/**
 * A fully connected layer where there is an edge connecting every node in the
 * previous layer to every node in this layer
 */
class FCLayer extends Layer {
    /**
     * Constructor
     *
     * @param size number of nodes
     * @param prev previous layer in the neural network
     */
    public FCLayer(int size, Layer prev) {
        super(size, prev);
        w = new double[size][prev.size];
        act = new Sigmoid();
    }

    @Override
    public void init() {
        for (int j = 0; j < size; j++) {
            b[j] = 2*Math.random()-1;
            for (int k = 0; k < prev.size; k++) {
                w[j][k] = 2*Math.random()-1;
            }
        }
    }

    @Override
    public void prop() {
        for (int i = 0; i < size; i++) {
            v[i] = b[i];
            for (int j = 0; j < prev.size; j++) {
                v[i] += w[i][j] * prev.v[j];
            }
            v[i] = act.func(v[i]);
        }
    }

    @Override
    public double[][] backprop(double[] deltas) {
        double[][] dw = new double[size+1][prev.size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < prev.size; j++) {
                dw[i][j] = deltas[i] * act.der(act.inv(v[i])) * prev.v[j];
            }
        }

        double[] db = new double[prev.size];
        for (int j = 0; j < prev.size; j++) {
            for (int i = 0; i < size; i++) {
                db[j] += deltas[i] * act.der(act.inv(v[i])) * w[i][j];
            }
            db[j] *= act.der(act.inv(prev.v[j]));
        }

        dw[size] = db;

        return dw;
    }

    @Override
    public String toString() {
        return "Fully Connected Layer " + super.toString();
    }
}