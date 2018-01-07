package projecto.CP2;

import java.util.Calendar;

public class Avaria {
    private int idAvaria;
    private Calendar dataRegisto = Calendar.getInstance();
    private Equipamento equipamentoAssociado;
    private String descricaoAvaria;
    private Funcionario funcionarioRegistou;
    private ESTADOAVARIA estadoAvaria = ESTADOAVARIA.porReparar;

    public Avaria(Equipamento equipamentoAssociado, String descricaoAvaria, Funcionario funcionarioRegistou) {
        this.equipamentoAssociado = equipamentoAssociado;
        this.descricaoAvaria = descricaoAvaria;
        this.funcionarioRegistou = funcionarioRegistou;
    }

    public int getIdAvaria() {
        return idAvaria;
    }

    public void setIdAvaria(int idAvaria) {
        this.idAvaria = idAvaria;
    }

    public Equipamento getEquipamentoAssociado() {
        return equipamentoAssociado;
    }

    public void setEquipamentoAssociado(Equipamento equipamentoAssociado) {
        this.equipamentoAssociado = equipamentoAssociado;
    }

    public String getDescricaoAvaria() {
        return descricaoAvaria;
    }

    public void setDescricaoAvaria(String descricaoAvaria) {
        this.descricaoAvaria = descricaoAvaria;
    }

    public Funcionario getFuncionarioRegistou() {
        return funcionarioRegistou;
    }

    public void setFuncionarioRegistou(Funcionario funcionarioRegistou) {
        this.funcionarioRegistou = funcionarioRegistou;
    }

    public ESTADOAVARIA getEstadoAvaria() {
        return estadoAvaria;
    }

    public void setEstadoAvaria(ESTADOAVARIA estadoAvaria) {
        this.estadoAvaria = estadoAvaria;
    }

    @Override
    public String toString() {
        return "Avaria{" +
                "idAvaria=" + idAvaria +
                ", dataRegisto=" + dataRegisto +
                ", equipamentoAssociado=" + equipamentoAssociado +
                ", descricaoAvaria='" + descricaoAvaria + '\'' +
                ", funcionarioRegistou=" + funcionarioRegistou +
                '}';
    }
}
