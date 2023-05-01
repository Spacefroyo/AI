public interface Utils {
    static void add(double[][][] a, double[][][] b) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                a[i] = b[i];
                continue;
            }

            for (int j = 0; j < a[i].length; j++) {
                for (int k = 0; k < a[i][j].length; k++) {
                    a[i][j][k] += b[i][j][k];
                }
            }
        }
    }

    static void mult(double[][][] a, double coeff) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                continue;
            }

            for (int j = 0; j < a[i].length; j++) {
                for (int k = 0; k < a[i][j].length; k++) {
                    a[i][j][k] *= coeff;
                }
            }
        }
    }
}
