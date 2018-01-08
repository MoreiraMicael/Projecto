package projecto.CP2;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Esta classe mostra todos os dados dos outros funcionários
 */
public class OutrosFuncionarios extends Funcionario implements Serializable {
    /**
     * função de outros funcionários
     */
    protected String funcao;

    /**
     * Este é o construtor da classe OutrosFuncionários
     *
     * @param nif            de outros funcionários
     * @param nome           de outros funcionários
     * @param morada         de outros funcionários
     * @param telefone       de outros funcionários
     * @param email          de outros funcionários
     * @param dataNascimento de outros funcionários
     * @param habilitacoes   de outros funcionários
     * @param funcao         de outros funcionários
     */
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

    /**
     * mostra todos os dados da classe OutrosFuncionários
     *
     * @return dados da classe OutrosFuncionários
     */
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
