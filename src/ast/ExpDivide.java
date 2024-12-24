package ast;

public class ExpDivide  extends Exp{
    Exp exp1;
    Exp exp2;

    public ExpDivide(Exp exp1, Exp exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public void compile() {
        exp1.compile();
        exp2.compile();
        emit("div");
    }
}
