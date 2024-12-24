package ast;

public class ExpTimes extends Exp{
    Exp exp1;
    Exp exp2;

    public ExpTimes(Exp exp1, Exp exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public void compile() {
        exp1.compile();
        exp2.compile();
        emit("mul");

    }
}
