public interface LossFunction {
    double func(double[] expected, double[] actual);
    double[] der(double[] expected, double[] actual);
}

class MSE implements LossFunction {
    @Override
    public double func(double[] expected, double[] actual) {
        double sum = 0;
        for (int i = 0; i < expected.length; i++) {
            sum += Math.pow(expected[i] - actual[i], 2);
        }
        return sum/expected.length;
    }

    @Override
    public double[] der(double[] expected, double[] actual) {
        double[] deltas = new double[actual.length];
        for (int i = 0; i < expected.length; i++) {
            deltas[i] = 2 * (expected[i] - actual[i]);
        }
        return deltas;
    }
}