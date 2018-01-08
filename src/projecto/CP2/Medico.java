package projecto.CP2;

import java.io.Serializable;
import java.util.Calendar;

public class Medico extends Funcionario implements Serializable{
    private String especialidade, seccao;

    public Medico(int nif, String nome, String morada, int telefone, String email, Calendar dataNascimento, String habilitacoes, String especialidade, String seccao) {
        super(nif, nome, morada, telefone, email, dataNascimento, habilitacoes);
        this.especialidade = especialidade;
        this.seccao = seccao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getSeccao() {
        return seccao;
    }

    public void setSeccao(String seccao) {
        this.seccao = seccao;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "especialidade='" + especialidade + '\'' +
                ", seccao='" + seccao + '\'' +
                ", nifFuncionario=" + nifFuncionario +
                ", telefone=" + telefone +
                ", anos=" + anos +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", email='" + email + '\'' +
                ", habilitacoes='" + habilitacoes + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
