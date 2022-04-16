package utils;

import java.util.Scanner;

import org.mariuszgromada.math.mxparser.*;

public class IOUnit {
    private static final Scanner reader = new Scanner(System.in);

    private static void handleError(String msg) {
        System.out.println(msg);
        System.out.println("Enter = повторить ввод, любая другая клавиша + Enter = выход:");
        if (reader.nextLine().isEmpty()) {
            return;
        }
        System.out.println("Программа завершает работу.");
        System.exit(-1);
    }

    public static double inputA() {
        double a;
        while (true) {
            System.out.println("Введите нижний предел интеграла (действительное число с точкой в качестве разделителя):");
            String tmp = reader.nextLine();
            try {
                a = Double.parseDouble(tmp);
                break;
            } catch (NumberFormatException e) {
                handleError("Ошибка ввода! Требуется ввести действительное число с точкой (\".\") в качестве разделителя.");
            }
        }
        return a;
    }

    public static double inputB(double a) {
        double b;
        while (true) {
            System.out.println("Введите верхний предел интеграла (действительное число с точкой в качестве разделителя, большее \"" + a + "\"):");
            String tmp = reader.nextLine();
            try {
                b = Double.parseDouble(tmp);
                if (b <= a) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                handleError("Ошибка ввода! Требуется ввести действительное число с точкой (\".\") в качестве разделителя, которое больше, чем \"" + a + "\".");
            }
        }
        return b;
    }

    public static Function inputFunction() {
        Function f;
        while (true) {
            System.out.println("Введите подинтегральную функцию f(x) (разделитель действительных чисел - точка):");
            String tmp = reader.nextLine();
            f = new Function("f", tmp, "x");
            try {
                if (!f.checkSyntax()) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException e) {
                handleError("Ошибка ввода! Введённая функция не прошла проверку синтаксиса.");
            }
        }
        return f;
    }

    public static double inputEps() {
        double eps;
        while (true) {
            System.out.println("Введите точность (положительное действительное число меньшее 1 с точкой в качестве разделителя):");
            String tmp = reader.nextLine();
            try {
                eps = Double.parseDouble(tmp);
                if (eps <= 0 || eps >= 1) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                handleError("Ошибка ввода! Требуется ввести положительное действительное число, которое меньше 1, с точкой (\".\") в качестве разделителя.");
            }
        }
        return eps;
    }
}
