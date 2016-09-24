package Kontr1_Kuzora;

/**
 * Created by Eugene13 on 22.09.2016.
 */
class Data {
    private double[][] matA;
    private double[] vectorB;
    private int sizeN;
    private double[][] supplementedMatrix;

    Data(double[][] MatA, double[] vectorB, int sizeN) {
        this.matA = MatA;
        this.vectorB = vectorB;
        this.sizeN = sizeN;
        this.supplementedMatrix = new double[sizeN][sizeN+1];
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
}
