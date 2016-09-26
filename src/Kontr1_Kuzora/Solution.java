package Kontr1_Kuzora;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Eugene13 on 22.09.2016.
 */
public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfMethod;
        System.out.println("Выберите метод решения СЛАУ (1-Метод Гаусса; 2-Метод Холецкого): ");
        while (true) {
            try {
                numberOfMethod = Integer.parseInt(reader.readLine());
                if ((numberOfMethod != 1) & (numberOfMethod != 2)) throw new Exception("Введите 1 либо 2");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        switch (numberOfMethod) {
            case 1: {
                GaussMethod gaussMethod = new GaussMethod();
                gaussMethod.simQ(gaussMethod.inputData(), SIGN_KS.ONE);
                break;
            }
            case 2: {
                CholeskyMethod choleskyMethod = new CholeskyMethod();
                Data data = choleskyMethod.inputData();
                choleskyMethod.inspection(data);
                System.out.println("Количество операций t = " + choleskyMethod.holet(data));
                for (int i = 0; i < data.getSizeN(); i++) {
                    System.out.printf("x(%2d ) = %f\n", i+1, data.getVectorB()[i]);
                }
                break;
            }
        }
    }
}
