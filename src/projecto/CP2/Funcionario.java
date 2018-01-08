package projecto.CP2;

import java.io.Serializable;
import java.util.Calendar;

public class Funcionario implements Serializable {
    protected int nifFuncionario, telefone, anos, numeroTotalFuncionarios;
    protected String nome, morada, email, habilitacoes;
    protected Calendar dataNascimento;

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

    public  int calcularIdade() {
        int anos;
        Calendar dataAtual= Calendar.getInstance();
        anos= dataAtual.get(Calendar.YEAR)-dataNascimento.
                get(Calendar.YEAR);
        if (dataAtual.get(Calendar.DAY_OF_YEAR)<
                dataNascimento.get(Calendar.DAY_OF_YEAR) )
            anos --;
        return anos;
    }

    public boolean maiorIdade(){
        if (anos >= 18){
            return true;
        }else
            return false;
    }

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
