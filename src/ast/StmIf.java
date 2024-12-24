package ast;

public class StmIf extends Stm{

    private Exp condition;
    private Block falseBody;
    private Block trueBody;


    public StmIf(Exp condition, Block falseBody, Block trueBody) {
        this.condition = condition;
        this.falseBody = falseBody;
        this.trueBody = trueBody;

    }

    @Override
    public void compile() {
        String trueLabel = freshName("false_branch");
        String endLabel = freshName("if_end");

        condition.compile();
        emit("push " + trueLabel);
        emit("jump_z");

        trueBody.compile();
        emit("push " + endLabel);
        emit("jump");

        emit(trueLabel + ":");
        falseBody.compile();

        emit(endLabel + ":");

    }
}
