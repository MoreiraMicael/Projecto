package projecto.CP2;

import java.io.Serializable;
import java.util.Calendar;

public class Tecnico extends OutrosFuncionarios implements Serializable{
    private String login, password;

    public Tecnico(int nif, String nome, String morada, int telefone, String email, Calendar dataNascimento, String habilitacoes, String funcao, String login, String passworf) {
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
