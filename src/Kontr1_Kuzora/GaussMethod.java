package Kontr1_Kuzora;

/**
 * Created by Eugene13 on 22.09.2016.
 */
class GaussMethod extends Method {
    void simQ(MatrAandB matrAandB, PRIZNAK_KS ks) {
        final double EPS = 1e-21;
        double max, u, v;
        int i, j, K1, l, nn;
        label1:
        {
            nn = matrAandB.getRazmerN();
            double[][] razshirMatrica = matrAandB.getRashirennayaMatrica();
            for (i = 0; i < nn; i++) { //перенос из матрицы A в расширенную матрицу
                for (j = 0; j < nn; j++) {
                    razshirMatrica[i][j] = matrAandB.getMatA()[i][j];
                }
            }
            for (i = 0; i < nn; i++) {// перенос из матрицы B в расширенную матрицу
                razshirMatrica[i][nn] = matrAandB.getVectorB()[i];
            }
            for (i = 0; i < matrAandB.getRazmerN(); i++) {//+
                max = Math.abs(razshirMatrica[i][i]);//+
                K1 = i;//+
                for (l = i + 1; l < nn; l++) {//+
                    if (Math.abs(razshirMatrica[l][i]) > max) {
                        max = Math.abs(razshirMatrica[l][i]);
                        K1 = l;
                    }
                }
                if (max < EPS) {
                    ks = PRIZNAK_KS.ONE;
                    System.out.println("СЛАУ не имеет единственного решения");
                    break label1;
                } else {
                    ks = PRIZNAK_KS.ZERO;
                }
                if (K1 != i) {
                    for (j = 0; j < nn + 1; j++) {//+
                        u = razshirMatrica[i][j];
                        razshirMatrica[i][j] = razshirMatrica[K1][j];
                        razshirMatrica[K1][j] = u;
                    }
                }
                v = razshirMatrica[i][i];
                for (j = i; j < nn + 1; j++) {//+
                    razshirMatrica[i][j] = razshirMatrica[i][j] / v;
                }
                for (l = i + 1; l < nn; l++) {
                    v = razshirMatrica[l][i];
                    for (j = i + 1; j < nn + 1; j++) {
                        razshirMatrica[l][j] = razshirMatrica[l][j] - razshirMatrica[i][j] * v;
                    }
                }
            }
            matrAandB.getVectorB()[nn - 1] = razshirMatrica[nn - 1][nn];
            for (i = nn - 2; i >= 0; i--) {
                matrAandB.getVectorB()[i] = razshirMatrica[i][nn];
                for (j = i + 1; j < nn; j++) {
                    matrAandB.getVectorB()[i] = matrAandB.getVectorB()[i] - razshirMatrica[i][j] * matrAandB.getVectorB()[j];
                }
            }
            System.out.println("");
            for (i = 0; i < nn; i++) {
                System.out.println("x( " + i + " )= " + matrAandB.getVectorB()[i]);
            }
            System.out.println(ks);
        }
    }
}



