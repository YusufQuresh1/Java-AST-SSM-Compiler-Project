package ast;

public class StmPrintStr extends Stm {

    public final Exp exp;
    char[] charValue;

    public StmPrintStr(Exp exp) {
        this.exp = exp;
    }

    @Override
    public void compile() {
        if (exp instanceof ExpString) {
            charValue = (((ExpString) exp).value).toCharArray();
            emit("push " + (int) charValue[0]);
            emit("push 1");
        } else {
            exp.compile();
            emit("push 4");
        }
        emit("sysc");

    }
}
