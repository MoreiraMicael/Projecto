package projecto.CP2;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Esta classe permite registar as reparações dos equipamentos
 */
public class Reparacao implements Serializable {
    /**
     * identificação da reparação
     */
    private int idReparacao;
    /**
     * avaria do equipamento
     */
    private Avaria avaria;
    /**
     * data de reparação do equipamento
     */
    private Calendar dataReparacao;
    /**
     * descrição da reparação
     */
    private String descricao;
    /**
     * custo da reparação
     */
    private float custo;
    /**
     * funcionário que registou a reparação
     */
    Funcionario funcionario;

    /**
     * Este é o contrutor da classe reparação
     *
     * @param avaria avaria
     * @param dataReparacao dataReparacao
     * @param descricao descricao
     * @param custo custo
     * @param funcionario funcionario
     */
    public Reparacao(Avaria avaria, Calendar dataReparacao, String descricao, float custo, Funcionario funcionario) {
        this.avaria = avaria;
        this.dataReparacao = dataReparacao;
        this.descricao = descricao;
        this.custo = custo;
        this.funcionario = funcionario;
    }

    public int getIdReparacao() {
        return idReparacao;
    }

    public void setIdReparacao(int idReparacao) {
        this.idReparacao = idReparacao;
    }

    public Avaria getAvaria() {
        return avaria;
    }

    public void setAvaria(Avaria avaria) {
        this.avaria = avaria;
    }

    public Calendar getDataReparacao() {
        return dataReparacao;
    }

    public void setDataReparacao(Calendar dataReparacao) {
        this.dataReparacao = dataReparacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * mostra todos os dados da classe reparação
     *
     * @return dados da classe reparação
     */
    @Override
    public String toString() {
        return "Reparacao{" +
                "idReparacao=" + idReparacao +
                ", avaria=" + avaria +
                ", dataReparacao=" + dataReparacao +
                ", descricao='" + descricao + '\'' +
                ", custo=" + custo +
                ", funcionario=" + funcionario +
                '}';
    }
}
