package projecto.CP2;

import java.util.Calendar;

public class Medico extends Funcionario{
    private String especialidade;
    private String seccao;

    public Medico(int nif, String nome, String morada, int telefone, String email, Calendar dataNascimento, String habilitacoes, String especialidade, String seccao) {
        super(nif, nome, morada, telefone, email, dataNascimento, habilitacoes);
        this.especialidade = especialidade;
        this.seccao = seccao;
    }
}
