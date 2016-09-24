package Kontr1_Kuzora;

/**
 * Created by Eugene13 on 22.09.2016.
 */
class GaussMethod extends Method {
    void simQ(Data data, SIGN_KS ks) {
        final double EPS = 1e-21;
        double max, u, v;
        int i, j, K1, l, n;
        label1:
        {
            n = data.getSizeN();
            double[][]supMatrix = data.getSupplementedMatrix();
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    supMatrix[i][j] = data.getMatA()[i][j];
                }
            }
            for (i = 0; i < n; i++) {
                supMatrix[i][n] = data.getVectorB()[i];
            }
            for (i = 0; i < data.getSizeN(); i++) {
                max = Math.abs(supMatrix[i][i]);
                K1 = i;
                for (l = i + 1; l < n; l++) {
                    if (Math.abs(supMatrix[l][i]) > max) {
                        max = Math.abs(supMatrix[l][i]);
                        K1 = l;
                    }
                }
                if (max < EPS) {
                    ks = SIGN_KS.ONE;
                    System.out.println("СЛАУ не имеет единственного решения");
                    break label1;
                } else {
                    ks = SIGN_KS.ZERO;
                }
                if (K1 != i) {
                    for (j = 0; j < n + 1; j++) {//+
                        u = supMatrix[i][j];
                        supMatrix[i][j] = supMatrix[K1][j];
                        supMatrix[K1][j] = u;
                    }
                }
                v = supMatrix[i][i];
                for (j = i; j < n + 1; j++) {//+
                    supMatrix[i][j] = supMatrix[i][j] / v;
                }
                for (l = i + 1; l < n; l++) {
                    v = supMatrix[l][i];
                    for (j = i + 1; j < n + 1; j++) {
                        supMatrix[l][j] = supMatrix[l][j] - supMatrix[i][j] * v;
                    }
                }
            }
            data.getVectorB()[n - 1] = supMatrix[n - 1][n];
            for (i = n - 2; i >= 0; i--) {
                data.getVectorB()[i] = supMatrix[i][n];
                for (j = i + 1; j < n; j++) {
                    data.getVectorB()[i] = data.getVectorB()[i] - supMatrix[i][j] * data.getVectorB()[j];
                }
            }
            System.out.println("");
            for (i = 0; i < n; i++) {
                System.out.println("x( " + i + " )= " + data.getVectorB()[i]);
            }
            System.out.println(ks);
        }
    }
}



