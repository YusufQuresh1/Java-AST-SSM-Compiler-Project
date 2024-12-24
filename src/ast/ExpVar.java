package ast;

public class ExpVar extends Exp{

    public final String name;

    public ExpVar(String name) {
        this.name = name;
    }

    @Override
    public void compile() {
        emit("push " + name);
        emit("load");
        addVar(name);
    }
}
