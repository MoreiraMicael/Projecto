package projecto.CP2;

import java.util.Calendar;

public class Formacao {
    int idFormacao;
    String descricao;
    Calendar dataFormacao = Calendar.getInstance();
    Funcionario funcionario;
    Equipamento equipamento;

    public Formacao(String descricao, Calendar dataFormacao, Funcionario funcionario, Equipamento equipamento) {
        this.descricao = descricao;
        this.dataFormacao = dataFormacao;
        this.funcionario = funcionario;
        this.equipamento = equipamento;
    }

    public int getIdFormacao() {
        return idFormacao;
    }

    public void setIdFormacao(int idFormacao) {
        this.idFormacao = idFormacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getDataFormacao() {
        return dataFormacao;
    }

    public void setDataFormacao(Calendar dataFormacao) {
        this.dataFormacao = dataFormacao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public String toString() {
        return "Formacao{" +
                "idFormacao=" + idFormacao +
                ", descricao='" + descricao + '\'' +
                ", dataFormacao=" + dataFormacao +
                ", funcionario=" + funcionario +
                ", equipamento=" + equipamento +
                '}';
    }
}
