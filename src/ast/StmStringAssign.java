package ast;

public class StmStringAssign extends Stm{

    String varName;
    ExpString string;

    public StmStringAssign(String varName, ExpString exp) {
        this.varName = varName;
        this.string = exp;
    }

    @Override
    public void compile() {
        emit("push " + varName);
        emit("dup");
        string.compile();
        emit("swap", "store");
        for (char c : string.value.toCharArray()) {
            emit("push 1", "add", "dup", "push " + (int) c, "swap", "store");
        }
        addVar(varName);
    }
}