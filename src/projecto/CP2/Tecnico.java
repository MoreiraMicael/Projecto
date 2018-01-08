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
    private String login, password;

    /**
     * Este é o construtor da classe tecnico
     *
     * @param nif nif
     * @param nome nome
     * @param morada morada
     * @param telefone telefone
     * @param email email
     * @param dataNascimento dataNascimento
     * @param habilitacoes habilitacoes
     * @param funcao funcao
     * @param login login
     * @param password password
     */
    public Tecnico(int nif, String nome, String morada, int telefone, String email, Calendar dataNascimento, String habilitacoes, String funcao, String login, String password) {
        super(nif, nome, morada, telefone, email, dataNascimento, habilitacoes, funcao);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassworf() {
        return password;
    }

    public void setPassworf(String passworf) {
        this.password = passworf;
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
