public interface ActivationFunction {
    double func(double x);
    double inv(double x);
    double der(double x);
}

class Linear implements ActivationFunction {
    @Override
    public double func(double x) {
        return x;
    }

    @Override
    public double inv(double x) {
        return x;
    }

    @Override
    public double der(double x) {
        return 1;
    }
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

class ReLU implements ActivationFunction {
    @Override
    public double func(double x) {
        return Math.max(0, x);
    }

    @Override
    public double inv(double x) {
        return x;
    }

    @Override
    public double der(double x) {
        return x < 0 ? 0 : 1;
    }
}