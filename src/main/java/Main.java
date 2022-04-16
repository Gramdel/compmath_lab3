import math.TrapezoidalRule;
import org.mariuszgromada.math.mxparser.*;

import static utils.IOUnit.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вас приветствует программа для демонстрации метода трапеций!");
        double a = inputA();
        double b = inputB(a);
        Function f = inputFunction();
        double eps = inputEps();
        System.out.println(TrapezoidalRule.calcIntegral(a, b, f, eps));
    }
}
