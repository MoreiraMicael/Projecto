package projecto.CP2;

import java.io.Serializable;
import java.util.Calendar;

public class OutrosFuncionarios extends Funcionario implements Serializable{
    protected String funcao;

    public OutrosFuncionarios(int nif, String nome, String morada, int telefone, String email, Calendar dataNascimento, String habilitacoes, String funcao) {
        super(nif, nome, morada, telefone, email, dataNascimento, habilitacoes);
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Outro Funcionario{" + '\n' +
                "Função: " + funcao + '\n' +
                ", Nif Funcionario: " + nifFuncionario + '\n' +
                ", Numero de Telefone: " + telefone + '\n' +
                ", Idade do Funcionario: " + anos + '\n' +
                ", Nome do Funcionario: " + nome + '\n' +
                ", Morada do Funcionario: " + morada + '\n' +
                ", Email do Funcionario: " + email + '\n' +
                ", Habilitações do Funcionario: " + habilitacoes + '\n' +
                ", Data de Nascimento do Funcionario: " + dataNascimento + '\n' +
                '}';
    }
}
