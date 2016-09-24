package Kontr1_Kuzora;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Eugene13 on 22.09.2016.
 */
abstract class Method implements Inputable {
    @Override
    public Data inputData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        double[][] A;
        double[] B;
        System.out.print("Введите количество уравнений n: ");
        while (true) {
            try {
                n = Integer.parseInt(reader.readLine());
                break;
            } catch (Exception e) {
                System.out.print("Повторите ввод n:");
            }
        }
        A = new double[n][n];
        B = new double[n];
        System.out.println("");
        System.out.println("Ввод двумерного массива А( " + n + " x " + n + " ):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ii = i + 1;
                int jj = j + 1;
                System.out.print("Ввод элемента А[ " + ii + " , " + jj + " ]:");
                try {
                    A[i][j] = Double.parseDouble(reader.readLine());
                } catch (Exception e) {
                    System.out.print("Повторите ввод элемента А[ " + ii + " , " + jj + " ]:");
                }
            }
        }
        System.out.println("");
        System.out.println("Ввод вектора B( " + n + " ):");
        for (int i = 0; i < n; i++) {
            int ii = i + 1;
            System.out.print("Ввод элемента В[ " + ii + " ]:");
            try {
                B[i] = Double.parseDouble(reader.readLine());
            } catch (Exception e) {
                System.out.print("Повторите ввод элемента В[ " + ii + " ]:");
            }
        }
        Data data = new Data(A, B, n);
        return data;
    }
}
