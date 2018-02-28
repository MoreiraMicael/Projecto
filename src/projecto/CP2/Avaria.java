package projecto.CP2;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Esta classe permite registar as avarias dos equipamentos
 */
public class Avaria implements Serializable {
    /**
     * numero para identificar avaria
     */
    private int idAvaria;
    /**
     * data de registo da avaria
     */
    private Calendar dataRegisto = Calendar.getInstance();
    /**
     * equipamento associado à avaria
     */
    private Equipamento equipamentoAssociado;
    /**
     * descrição da avaria
     */
    private String descricaoAvaria;
    /**
     * funcionário que registou a avaria
     */
    private Funcionario funcionarioRegistou;
    /**
     * Estado em que se encontra o equipamento avariado
     */
    private ESTADOAVARIA estadoAvaria = ESTADOAVARIA.porReparar;

    /**
     * Este é o construtor da classe avaria
     *
     * @param equipamentoAssociado equipamento associado à avaria
     * @param descricaoAvaria      descrição da avaria
     * @param funcionarioRegistou  funcionário que registou a avaria
     */
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

    public ESTADOAVARIA getEstadoAvaria(String estado) {
        return estadoAvaria;
    }

    public void setEstadoAvaria(ESTADOAVARIA estadoAvaria) {
        this.estadoAvaria = estadoAvaria;
    }

    /**
     * mostra todos os dados da classe avaria
     *
     * @return dados da classe avaria
     */
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
