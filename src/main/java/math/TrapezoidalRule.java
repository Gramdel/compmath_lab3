package math;

import org.mariuszgromada.math.mxparser.Function;

public class TrapezoidalRule {
    public static double calcIntegral(double a, double b, Function f, double eps) {
        double currResult = 0, prevResult = 0;
        for (int n = 1; n <= 2 || Math.abs(currResult - prevResult) > eps; n *= 2) {
            prevResult = currResult;
            currResult = 0;
            double h = (b - a) / n;
            for (int i = 0; i <= n; i++) {
                double tmp = f.calculate(a + h * i);
                if (!Double.isFinite(tmp)) {
                    tmp = (f.calculate(a + h * i - eps) + f.calculate(a + h * i + eps)) / 2;
                }
                if (i == 0 || i == n) {
                    tmp /= 2;
                }
                currResult += tmp;
            }
            currResult *= h;
            System.out.println("n = " + n + ", result = " + currResult);
        }
        return currResult;
    }
}
