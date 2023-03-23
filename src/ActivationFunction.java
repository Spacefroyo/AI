public interface ActivationFunction {
    double func(double x);
    double inv(double x);
    double der(double x);
}

class Sigmoid implements ActivationFunction {
    @Override
    public double func(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    @Override
    public double inv(double x) {
        return -Math.log(1 / x - 1);
    }

    @Override
    public double der(double x) {
        double func = func(x);
        return func * (1 - func);
    }
}