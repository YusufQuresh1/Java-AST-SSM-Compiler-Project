package ast;

public class StmAssign extends Stm{

    String varName;
    Exp exp;

    public StmAssign(String varName, Exp exp) {
        this.varName = varName;
        this.exp = exp;
    }

    @Override
    public void compile() {
        exp.compile();
        emit("push " + varName);
        emit("store");
        addVar(varName);
    }
}
