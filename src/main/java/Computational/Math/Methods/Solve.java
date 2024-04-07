package Computational.Math.Methods;

import org.netirc.library.jtables.exception.MalformedTableException;
import org.netirc.library.jtables.table.MonospaceTable;

import java.util.function.Function;

@FunctionalInterface
public interface Solve {
    MonospaceTable solve(Function<Double, Double> function, Double a, Double b, int n) throws MalformedTableException;
}
