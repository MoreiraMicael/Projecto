package projecto.CP2;

import java.util.Calendar;

public class OutrosFuncionarios extends Funcionario{
    protected String funcao;

    public OutrosFuncionarios(int nif, String nome, String morada, int telefone, String email, Calendar dataNascimento, String habilitacoes, String funcao) {
        super(nif, nome, morada, telefone, email, dataNascimento, habilitacoes);
        this.funcao = funcao;
    }
}
