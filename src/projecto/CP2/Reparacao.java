package projecto.CP2;
import java.io.Serializable;
import java.util.Calendar;

public class Reparacao implements Serializable {
    private int idReparacao;
    private Avaria avaria;
    private Calendar dataReparacao;
    private String descricao;
    private float custo;
    Funcionario funcionario;

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
