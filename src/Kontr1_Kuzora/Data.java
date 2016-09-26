package Kontr1_Kuzora;

/**
 * Created by Eugene13 on 22.09.2016.
 * Class Data:
 * 1) Хранит все исходные и полученные данные;
 * 2) Доступ к приватным полям организован через Геттеры.
 */
class Data {
    private double[][] matA;
    private double[] vectorB;
    private int sizeN;
    private double[][] supplementedMatrix;
    private double[][] transposedMatrix;
    private double[][] symmetricMatrix;

    Data(double[][] matA, double[] vectorB, int sizeN) {
        this.matA = matA;
        this.vectorB = vectorB;
        this.sizeN = sizeN;
        this.supplementedMatrix = new double[sizeN][sizeN + 1];
        this.transposedMatrix = new double[sizeN + 1][sizeN];
        this.symmetricMatrix = new double[sizeN + 1][sizeN + 1];
    }

    double[][] getMatA() {
        return this.matA;
    }

    double[] getVectorB() {
        return this.vectorB;
    }

    int getSizeN() {
        return this.sizeN;
    }

    double[][] getSupplementedMatrix() {
        return supplementedMatrix;
    }

    double[][] getTransposedMatrix() {
        return transposedMatrix;
    }

    double[][] getSymmetricMatrix() {
        return symmetricMatrix;
    }
}
