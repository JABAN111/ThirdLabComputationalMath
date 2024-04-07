package Computational.Math.Methods.RectangleMethods;

import Computational.Math.Methods.AbstractMethod;
import org.netirc.library.jtables.JTablesBuilder;
import org.netirc.library.jtables.exception.MalformedTableException;
import org.netirc.library.jtables.table.MonospaceTable;

import java.util.function.Function;

public class LeftRectangles extends AbstractMethod {

    public LeftRectangles(){
        super("Метод левых прямоугольников");
    }

    @Override
    public MonospaceTable solve(Function<Double, Double> function, Double a, Double b, int n) throws MalformedTableException {
        printMethodName();
        var builder = getBuilder();
        builder.columns("i","xi","fi","currentSum");
        double h = (b-a)/n;
        double currentX = a;
        double previousFun = 0;
        double result = 0;
        builder.row("0",String.format("%.3f",currentX),String.format("%.3f",function.apply(currentX)), result +"");
        for (int i = 1; i < n + 1; i++) {
            previousFun = function.apply(currentX);
            currentX += h;
            result += previousFun*h;
            builder.row(i+"",String.format("%.3f",currentX),String.format("%.3f",function.apply(currentX)), String.format("%.3f",result));
        }
        return builder.getTable();
    }
}
