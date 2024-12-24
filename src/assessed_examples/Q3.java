package assessed_examples;

import ast.*;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This example outputs 654321 21 3, each on a separate line.
 */
public class Q3 {

    public static void main(String[] args) throws IOException {
        String exampleName = MethodHandles.lookup().lookupClass().getSimpleName();
        Path outpath = Paths.get("ssma/"+ exampleName + ".ssma");
        // Notes:
        //  print: like println except it doesn't output a newline
        //  newline: outputs a newline
        //  boolean conditions:
        //      where a boolean value would normally be expected (in the condition
        //      of a while loop, for example) zero is treated as false and all other
        //      values are treated as true.
        //
        // begin
        //  x := 6;
        //  while (x) {
        //      print x;
        //      y := y + x;
        //      x := x - 1;
        //  }
        //  newline;
        //  while (y) {
        //      println y;
        //      y := y / 7;
        //  }
        // end
        // ============================================================

        Program p = new Program(
            // your sequence of Stm ASTs goes here
                new StmAssign("x", new ExpInteger(6)),
                new StmWhile(new ExpVar("x"), new Block(
                        new StmPrint(new ExpVar("x")),
                        new StmAssign("y", new ExpPlus(new ExpVar("y"), new ExpVar("x"))),
                        new StmAssign("x", new ExpMinus(new ExpVar("x"), new ExpInteger(1)))
                    )
                ), new StmNewLine(),
                new StmWhile(new ExpVar("y"), new Block(
                        new StmPrintln(new ExpVar("y")),
                        new StmAssign("y", new ExpDivide(new ExpVar("y"), new ExpInteger(7)))
                ))

        );
        // ============================================================

        System.out.println("Compiling " + exampleName + "...");
        p.compile();
        System.out.println("Writing...");
        AST.write(outpath);
        System.out.println("... SSM assembly code written to " + outpath);
    }
}
