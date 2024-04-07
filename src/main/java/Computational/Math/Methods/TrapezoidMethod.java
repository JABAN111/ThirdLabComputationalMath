package Computational.Math.Methods;

import org.netirc.library.jtables.exception.MalformedTableException;
import org.netirc.library.jtables.table.MonospaceTable;

import java.util.function.Function;

public class TrapezoidMethod extends AbstractMethod{
    public TrapezoidMethod() {
        super("Метод трапеций");
    }

    @Override
    public MonospaceTable solve(Function<Double, Double> function, Double a, Double b, int n) throws MalformedTableException {
        printMethodName();
        var builder = getBuilder();
        var h = (b-a)/n;
        var y0 = function.apply(a);
        var yLast = function.apply(b);
        //сумма yi, исключая 0 и последний
        var sumYi = 0d;
        var result = 0d;
        builder.columns("i","xi","fi");
        builder.row("0",String.format("%.3f",a),String.format("%.3f",y0));
        for (int i = 1; i < n; i++) {
            sumYi += function.apply(a + h*i);
            builder.row(i+"",String.format("%.3f",a+h*i),String.format("%.3f",function.apply(a + h*i)));
        }
        result += h*((y0+yLast)/2 + sumYi);
        builder.row(n+"",String.format("%.3f",b),String.format("%.3f",yLast));

        //sorry for this but komy now legko?
        System.out.println("final answer: " + result);
        return builder.getTable();
    }
}
