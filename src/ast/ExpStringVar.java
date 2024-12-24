package ast;

public class ExpStringVar extends Exp{

    public final String name;

    public ExpStringVar(String name) {
        this.name = name;
    }

    @Override
    public void compile() {
        emit("push " + name);
        addVar(name);
    }
}
