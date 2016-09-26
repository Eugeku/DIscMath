package Kontr1_Kuzora;

/**
 * Created by Eugene13 on 24.09.2016.
 *  * Class CholeskyMethod:
 * 1) Реализована основная логика решения СЛАУ методом Холецкого;
 * 2) Наследует все методы и поля от класса
 * Method (Data inputData()-ввод данных);
 * 3) В классе реализован метод проверки
 * введенных матриц (void inspection(Data data)).
 */
class CholeskyMethod extends Method {
    void inspection(Data data) {
        int i, j, k, t, tt;
        int n = data.getSizeN();
        double[][] supMatrix = data.getSupplementedMatrix();
        double[][] transMatrix = data.getTransposedMatrix();
        double[][] simMatrix = data.getSymmetricMatrix();
        t = 0;
        tt = 0;
        for (i = 0; i < n; i++) {
            tt += i;
        }
        label2:
        {
            label1:
            for (i = 0; i < n - 1; i++) {
                for (j = i + 1; j < n; j++) {
                    if (data.getMatA()[i][j] != data.getMatA()[j][i]) {
                        System.out.println("Матрица А - несимметричная!");
                        break label1;
                    } else {
                        t++;
                    }
                    if (t == tt) {
                        System.out.println("Матрица А - симметричная!");
                        break label2;
                    }
                }
            }
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    supMatrix[i][j] = data.getMatA()[i][j];
                }
            }
            for (i = 0; i < n; i++) {
                supMatrix[i][n] = data.getVectorB()[i];
            }
            for (i = 0; i < n; i++) {
                for (j = 0; j < n + 1; j++) {
                    transMatrix[j][i] = supMatrix[i][j];
                }
            }
            for (i = 0; i < n + 1; i++) {
                for (j = 0; j < n + 1; j++) {
                    simMatrix[i][j] = 0;
                }
            }
            for (i = 0; i < n + 1; i++) {
                for (j = 0; j < n + 1; j++) {
                    for (k = 0; k < n; k++) {
                        simMatrix[i][j] = simMatrix[i][j] + transMatrix[i][k] * supMatrix[k][j];
                    }
                }
            }
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    data.getMatA()[i][j] = simMatrix[i][j];
                }
                data.getVectorB()[i] = simMatrix[i][n];
            }
        }
    }

    int holet(Data data) {
        int k, l2, l3;
        double l1;
        int n = data.getSizeN();
        double[][] L = new double[n][n];
        double[] y = new double[n];
        double[] x = new double[n];
        double[][] matA = data.getMatA();
        double[] vecB = data.getVectorB();
        for (k = 0; k < n; k++) {
            if (matA[k][k] == 0) {
                System.out.println("Главная диагональ содержит ноль.");
                return 0;
            }
        }
        for (k = 0; k < n; k++) {
            l1 = 0;
            for (l3 = 0; l3 < k; l3++) {
                l1 = l1 + L[k][l3] * L[k][l3];
            }
            L[k][k] = Math.sqrt(matA[k][k] - l1);
            l1 = 0;
            for (l3 = k + 1; l3 < n; l3++) {
                for (l2 = 0; l2 < k; l2++) {
                    l1 = l1 + L[l3][l2] * L[k][l2];
                }
                L[l3][k] = (matA[l3][k] - l1) / L[k][k];
            }
        }
        for (k = 0; k < n; k++) {
            l1 = 0;
            for (l3 = 0; l3 < k; l3++) {
                l1 = l1 + L[k][l3] * y[l3];
            }
            y[k] = (vecB[k] - l1) / L[k][k];
        }
        for (k = n - 1; k >= 0; k--) {
            l1 = 0;
            for (l3 = n - 1; l3 > k - 1; l3--) {
                l1 = l1 + L[l3][k] * x[l3];
            }
            x[k] = (y[k] - l1) / L[k][k];
        }
        for (k = 0; k < n; k++) {
            vecB[k] = x[k];
        }
        return 2 * n * n;
    }
}
