//package Computational.Math.Methods.tests;
//
//import Computational.Math.Methods.RectangleMethods.LeftRectangles;
//import Computational.Math.Methods.RectangleMethods.MiddleRectangles;
//import Computational.Math.Methods.RectangleMethods.RightRectangles;
//import org.junit.Test;
//import org.netirc.library.jtables.exception.MalformedTableException;
//
//public class RectanglesTest {
//    @Test
//    public void testFromPaper() {
//        LeftRectangles lf = new LeftRectangles();
//        try {
//            System.out.println(lf.solve(
//                    x -> 4 * Math.pow(x, 3) - 5 * Math.pow(x, 2) + 6 * x - 7, 0d, 2d, 10));
//        } catch (MalformedTableException e) {
//            System.err.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void testFromPresentation() {
//        LeftRectangles lf = new LeftRectangles();
//        try {
//            System.out.println(lf.solve(x -> x * x, 1d, 2d, 5));
//        } catch (MalformedTableException e) {
//            System.err.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void testRight() {
//        var rf = new RightRectangles();
//        try {
//            System.out.println(rf.solve(x -> x * x, 1d, 2d, 5));
//        } catch (MalformedTableException e) {
//            System.err.println(e.getMessage());
//        }
//    }
//    @Test
//    public void testMiddle(){
//        var rf = new MiddleRectangles();
//        try {
//            System.out.println(rf.solve(x -> x * x, 1d, 2d, 5).toStringHorizontal());
//        } catch (MalformedTableException e) {
//            System.err.println(e.getMessage());
//        }
//    }
//
//}
//
