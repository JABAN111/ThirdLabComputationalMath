package Computational.Math;

import Computational.Math.Methods.FabricMethods;
import Computational.Math.Methods.Functions;
import Computational.Math.Methods.MethodName;
import org.netirc.library.jtables.exception.MalformedTableException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        FabricMethods fabricMethods = new FabricMethods();
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            do{
                System.out.println("Выберите название метода: ");
                fabricMethods.printNameMethods();
                System.out.print(">>> ");
                int idMethod = Integer.parseInt(bf.readLine());
                MethodName methodName = getNameByID(idMethod);
                System.out.println("Выберите одно из уравнений: ");
                Functions.printFunctions();
                System.out.print(">>> ");
                int idFunction = Integer.parseInt(bf.readLine()) - 1;
                System.out.println("Выберите начало отрезка:");
                System.out.print(">>> ");
                double a = Integer.parseInt(bf.readLine());
                System.out.println("Выберите конец отрезка:");
                System.out.print(">>> ");
                double b = Integer.parseInt(bf.readLine());
                System.out.println("Выберите точность");
                System.out.print(">>> ");
                float epsilon = Float.parseFloat(bf.readLine());
                fabricMethods.executeMethod(methodName,Functions.getFunctionById(idFunction)
                ,a,b,epsilon);
            }while (true);

        }catch (IOException | MalformedTableException e){
            System.err.println("Invalid input");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
    public static MethodName getNameByID(int id){
        return switch (id) {
            case 1 -> MethodName.SIMPSON;
            case 2 -> MethodName.RECTANGLES;
            default -> null;
        };


    }
}