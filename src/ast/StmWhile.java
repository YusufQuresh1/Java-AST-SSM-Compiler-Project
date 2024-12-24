package ast;

import java.util.List;

public class StmWhile extends Stm {
    private Exp condition;
    private Block body;

    public StmWhile(Exp condition, Block body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public void compile() {
        String startLabel = freshName("start_while");
        String endLabel = freshName("end_while");

        // Emit start of the loop label
        emit(startLabel + ":");

        // Compile condition expression
        condition.compile();
        emit("push " + endLabel);
        emit("jump_z"); // Jump to end of loop if condition is false

        // Compile loop body
        body.compile();

        // Jump back to the start of the loop
        emit("push " + startLabel);
        emit("jump");

        // Emit end of the loop label
        emit(endLabel + ":");
    }
}
