import java.io.*;
import java.util.Arrays;

public class NNExample {
    public static void main(String[] args) throws IOException {
        int range = 1;

        int n = 50;
        double[][] inputs = new double[n][2];
        double[][] outputs = new double[n][];
        for (int i = 0; i < n; i++) {
            inputs[i][0] = 2*range*Math.random()-range;
            inputs[i][1] = 2*range*Math.random()-range;
            outputs[i] = dist(inputs[i]);
        }

        int[] sizes = {2, 5, 5, 1};
//        sizes = new int[]{2, 2, 1};
        NN model = new NN(sizes, new ReLU());
        model.addTrainset(inputs, outputs);

        n = 500000;
//        n = 30;
        inputs = new double[n][2];
        outputs = new double[n][1];
        for (int i = 0; i < n; i++) {
            inputs[i][0] = 2*range*Math.random()-range;
            inputs[i][1] = 2*range*Math.random()-range;
            outputs[i] = dist(inputs[i]);
        }


        System.out.println(model);
        double[] losses = model.trainOn(inputs, outputs, 10000);
//        double[] losses = model.trainOn(inputs, outputs, n);
        for (int i = 0; i < losses.length; i++) {
            if ((int)Math.log(i) != (int)Math.log(i+1)) System.out.println(losses[i]);
        }
    }

    public static double[] dist(double[] inputs) {
        double[] outputs = new double[1];
        outputs[0] = Math.sqrt(inputs[0]*inputs[0] + inputs[1]*inputs[1]);
        return outputs;
    }
}
