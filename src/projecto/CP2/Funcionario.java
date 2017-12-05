package projecto.CP2;

import java.util.Calendar;

public class Funcionario {
    protected int nif;
    protected String nome;
    protected String morada;
    protected int telefone;
    protected String email;
    protected Calendar dataNascimento;
    protected String habilitacoes;

    public Funcionario(int nif, String nome, String morada, int telefone, String email, Calendar dataNascimento, String habilitacoes) {
        this.nif = nif;
        this.nome = nome;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.habilitacoes = habilitacoes;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
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

    @Override
    public String toString() {
        return "Funcionario{" +
                "nif=" + nif +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", telefone=" + telefone +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", habilitacoes='" + habilitacoes + '\'' +
                '}';
    }
}
