import math.TrapezoidalRule;
import org.mariuszgromada.math.mxparser.Function;

import static utils.Convertor.toPrecision;
import static utils.IOUnit.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вас приветствует программа для демонстрации метода трапеций!");
        double a = inputA();
        double b = inputB(a);
        Function f = inputFunction();
        double eps = inputEps();
        try {
            System.out.println("Приближённый ответ: " + toPrecision(TrapezoidalRule.calcIntegral(a, b, f, eps), eps));
        } catch (NumberFormatException e) {
            System.out.println("Ответ не получен, поскольку на выбранном интервале неустранимый разрыв!");
        }
    }
}
