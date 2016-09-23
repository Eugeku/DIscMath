package Kontr1_Kuzora;

/**
 * Created by Eugene13 on 22.09.2016.
 */
class MatrAandB {
    private double[][] MatA;
    private double[] VectorB;
    private int razmerN;
    private double[][] rashirennayaMatrica;

    MatrAandB(double[][] MatA, double[] VectorB, int razmerN) {
        this.MatA = MatA;
        this.VectorB = VectorB;
        this.razmerN = razmerN;
        this.rashirennayaMatrica = new double[razmerN][razmerN+1];
    }

    double[][] getMatA() {
        return this.MatA;
    }

    double[] getVectorB() {
        return this.VectorB;
    }

    int getRazmerN() {
        return this.razmerN;
    }

    double[][] getRashirennayaMatrica() {
        return rashirennayaMatrica;
    }
}
