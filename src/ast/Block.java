package ast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Block extends AST {

    public final List<Stm> statements;

    public Block(List<Stm> statements) {
        this.statements = Collections.unmodifiableList(statements);
    }

    public Block(Stm ...stms) {
        this(Arrays.asList(stms));
    }

    public void compile() {
        for (Stm stm : statements) {
            stm.compile();
        }
    }
}
