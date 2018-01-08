package projecto.CP2;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Esta classe contém todos os dados sobre os médicos
 */
public class Medico extends Funcionario implements Serializable {
    /**
     * especialidade e secção do médico
     */
    private String especialidade, seccao;

    /**
     * Este é o construtor da classe médico
     *
     * @param nif            do médico
     * @param nome           do médico
     * @param morada         do médico
     * @param telefone       do médico
     * @param email          do médico
     * @param dataNascimento do médico
     * @param habilitacoes   do médico
     * @param especialidade  do médico
     * @param seccao         do médico
     */
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

    /**
     * mostra todos os dados da classe médico
     *
     * @return dados da classe médico
     */
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
