package ast;

public class StmNewLine extends Stm {

    @Override
    public void compile() {
        emit("push 2", "sysc");
    }
}
