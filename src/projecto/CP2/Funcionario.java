package projecto.CP2;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Esta classe contém todos os dados sobre os funcionários
 */
public class Funcionario implements Serializable {
    /**
     * nif do funcionário, telefone, idade, número total de funcionários
     */
    protected int nifFuncionario, telefone, anos, numeroTotalFuncionarios;
    /**
     * nome do funcionário, morada, email, habilitações
     */
    protected String nome, morada, email, habilitacoes;
    /**
     * data de nascimento
     */
    protected Calendar dataNascimento;

    /**
     * este é o construtor da classe funcionário
     *
     * @param nif            do funcionário
     * @param nome           do funcionário
     * @param morada         do funcionário
     * @param telefone       do funcionário
     * @param email          do funcionário
     * @param dataNascimento do funcionário
     * @param habilitacoes   do funcionário
     */
    public Funcionario(int nif, String nome, String morada, int telefone, String email, Calendar dataNascimento, String habilitacoes) {
        this.nifFuncionario = nif;
        this.nome = nome;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.habilitacoes = habilitacoes;
        this.anos = calcularIdade();
    }

    public int getNifFuncionario() {
        return nifFuncionario;
    }

    public void setNifFuncionario(int nif) {
        this.nifFuncionario = nifFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getHabilitacoes() {
        return habilitacoes;
    }

    public void setHabilitacoes(String habilitacoes) {
        this.habilitacoes = habilitacoes;
    }

    public int getNumeroTotalFuncionarios() {
        return numeroTotalFuncionarios;
    }

    public void setNumeroTotalFuncionarios(int numeroTotalFuncionarios) {
        this.numeroTotalFuncionarios = numeroTotalFuncionarios;
    }

    /**
     * método para calcular a idade do funcionário
     *
     * @return valor inteiro
     */
    public int calcularIdade() {
        int anos;
        Calendar dataAtual = Calendar.getInstance();
        anos = dataAtual.get(Calendar.YEAR) - dataNascimento.
                get(Calendar.YEAR);
        if (dataAtual.get(Calendar.DAY_OF_YEAR) <
                dataNascimento.get(Calendar.DAY_OF_YEAR))
            anos--;
        return anos;
    }

    /**
     * método para verificar se o funcionário é maior de idade
     *
     * @return verdadeiro ou falso
     */
    public boolean maiorIdade() {
        if (anos >= 18) {
            return true;
        } else
            return false;
    }

    /**
     * mostra todos os dados da classe funcionário
     *
     * @return dados da classe funcionário
     */
    @Override
    public String toString() {
        return "Funcionario{" +
                "nifFuncionario=" + nifFuncionario +
                ", telefone=" + telefone +
                ", anos=" + anos +
                ", numeroTotalFuncionarios=" + numeroTotalFuncionarios +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", email='" + email + '\'' +
                ", habilitacoes='" + habilitacoes + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
