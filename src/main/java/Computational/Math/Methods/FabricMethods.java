package Computational.Math.Methods;

import Computational.Math.Methods.RectangleMethods.LeftRectangles;
import org.netirc.library.jtables.exception.MalformedTableException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FabricMethods {
    public ArrayList<AbstractMethod> methodList;
    public FabricMethods(){
        methodList = new ArrayList<>(
                List.of(new SimpsonsMethod(),new LeftRectangles())
        );
    }
    public void executeMethod(MethodName methodName, Function<Double,Double> function, double a, double b, double accuracy) throws MalformedTableException {
            if(methodName == MethodName.SIMPSON) {
                SimpsonsMethod sm = new SimpsonsMethod();
                var n = 4;
                Double Integral0 = sm.solve(function, a, b, n, false);
                System.out.println("Мы дошли до сюда");
                n *= 2;
                Double Integral1 = sm.solve(function, a, b, n, false);
                while (!(Math.abs(Integral1 - Integral0) < accuracy)) {
                    n *= 2;
                    Integral0 = Integral1;
                    Integral1 = sm.solve(function, a, b, n, false);
                }
                Integral1 = sm.solve(function, a, b, n, true);
                System.out.println(Integral1 - Integral0);
                return;
            }
            if(methodName == MethodName.RECTANGLES){
                var left = new LeftRectangles();
                var n = 4;
                Double Integral0 = left.solve(function,a,b,n,false);
                System.out.println("Мы дошли до сюда");
                n*=2;
                Double Integral1 = left.solve(function,a,b,n,false);
                while(!(Math.abs(Integral1 - Integral0) < accuracy)){
                    n*=2;
                    Integral0 = Integral1;
                    Integral1 = left.solve(function,a,b,n,false);
                }
                Integral1 = left.solve(function,a,b,n,true);
                System.out.println(Integral1 - Integral0);
                return;
        }
    }
    public void printNameMethods(){
        for (int i = 0; i < methodList.size(); i++) {
            System.out.println(i+1+". " + methodList.get(i).getMethodName());
        }
    }
}
