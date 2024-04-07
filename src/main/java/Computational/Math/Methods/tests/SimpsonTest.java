package Computational.Math.Methods.tests;

import Computational.Math.Methods.SimpsonsMethod;
import org.junit.Test;
import org.netirc.library.jtables.exception.MalformedTableException;

public class SimpsonTest {
    @Test
    public void testFromLecture() throws MalformedTableException {
        SimpsonsMethod sm = new SimpsonsMethod();
        System.out.println(sm.solve(x->x*x,
                1d,2d,4));
    }
}
