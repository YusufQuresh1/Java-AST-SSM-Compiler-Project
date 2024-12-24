package ast;

public class ExpString extends Exp{
    String value;

    public ExpString(String value) {
        this.value = value;
    }

    @Override
    public void compile() {
        emit("push " + value.length());
    }
}
