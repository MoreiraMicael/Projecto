package projecto.CP2;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Esta classe contém todos os dados sobre os técnicos
 */
public class Tecnico extends OutrosFuncionarios implements Serializable {
    /**
     * login e password do técnico
     */
    private String login, passworf;

    /**
     * Este é o construtor da classe tecnico
     *
     * @param nif
     * @param nome
     * @param morada
     * @param telefone
     * @param email
     * @param dataNascimento
     * @param habilitacoes
     * @param funcao
     * @param login
     * @param password
     */
    public Tecnico(int nif, String nome, String morada, int telefone, String email, Calendar dataNascimento, String habilitacoes, String funcao, String login, String passworf) {
        super(nif, nome, morada, telefone, email, dataNascimento, habilitacoes, funcao);
        this.login = login;
        this.passworf = passworf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassworf() {
        return passworf;
    }

    public void setPassworf(String passworf) {
        this.passworf = passworf;
    }

    /**
     * mostra todos os dados da classe técnico
     *
     * @return dados da classe técnico
     */
    @Override
    public String toString() {
        return "Tecnico{" +
                "funcao ='" + funcao + '\'' +
                "nif ='" + nifFuncionario + '\'' +
                ", nome ='" + nome + '\'' +
                ", morada ='" + morada + '\'' +
                ", telefone =" + telefone +
                ", email ='" + email + '\'' +
                ", dataNascimento =" + dataNascimento +
                ", habilitacoes ='" + habilitacoes + '\'' +
                '}';
    }
}
