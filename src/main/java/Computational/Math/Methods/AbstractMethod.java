package Computational.Math.Methods;

import org.netirc.library.jtables.JTablesBuilder;
import org.netirc.library.jtables.table.MonospaceTable;

import java.util.function.Function;

public abstract class AbstractMethod implements Solve {
    private String methodName;
    private JTablesBuilder<MonospaceTable> builder = MonospaceTable.build();

    public AbstractMethod(String methodName) {
        this.methodName = methodName;
    }

    public JTablesBuilder<MonospaceTable> getBuilder() {
        return builder;
    }

    public void printMethodName(){
        //156 это количество пунктиров в таблице
        for (int i = 0; i < 156-4-4-methodName.length(); i++) {
            //middle
            if(i==50){
                System.out.print("\t" + methodName + "\t");
            }
            System.out.print("*");
        }
        System.out.println();
    }
    public String getMethodName() {
        return methodName;
    }

}
