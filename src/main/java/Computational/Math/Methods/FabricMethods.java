package Computational.Math.Methods;

import Computational.Math.Methods.RectangleMethods.LeftRectangles;
import Computational.Math.Methods.RectangleMethods.MiddleRectangles;
import Computational.Math.Methods.RectangleMethods.RightRectangles;
import org.netirc.library.jtables.exception.MalformedTableException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FabricMethods {
    public ArrayList<AbstractMethod> methodList;

    public FabricMethods() {
        methodList = new ArrayList<>(
                List.of(new SimpsonsMethod(), new LeftRectangles(), new MiddleRectangles(), new RightRectangles(), new TrapezoidMethod())
        );
    }

    public void executeMethod(MethodName methodName, Function<Double, Double> function, double a, double b, double accuracy) throws MalformedTableException {
        AbstractMethod method = getMethodByMethodName(methodName);
        var n = 4;
        Double Integral0 = method.solve(function, a, b, n, false);
        n *= 2;
        Double Integral1 = method.solve(function, a, b, n, false);
        while (!(Math.abs(Integral1 - Integral0) < accuracy)) {
            n *= 2;
            Integral0 = Integral1;
            Integral1 = method.solve(function, a, b, n, false);
        }
        method.solve(function, a, b, n, true);
    }

    public AbstractMethod getMethodByMethodName(MethodName methodName) {
        return switch (methodName) {
            case SIMPSON -> new SimpsonsMethod();
            case RECTANGLES_LEFT -> new LeftRectangles();
            case RECTANGLES_MIDDLE -> new MiddleRectangles();
            case RECTANGLES_RIGHT -> new RightRectangles();
            case TRAPEZOID -> new TrapezoidMethod();
        };
    }

    public void printNameMethods() {
        for (int i = 0; i < methodList.size(); i++) {
            System.out.println(i + 1 + ". " + methodList.get(i).getMethodName());
        }
    }
}
