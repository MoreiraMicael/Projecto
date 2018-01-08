package projecto.CP2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Esta classe permite registar todos os equipamentos
 */
public class Equipamento implements Serializable {
    /**
     * descrição do equipamento
     */
    private String descricao;
    /**
     * número do equipamento, número de série do equipamento, total de avarias do equipamento
     */
    private int numeroIventario, numeroSerie, totalAvariasEquipamento;
    /**
     * custo de reparação do equipamento
     */
    private float custo;
    /**
     * data que o equipamento foi inventariado
     */
    private Calendar dataIventario;
    /**
     * divisão do equipamento
     */
    private Divisao divisao;
    /**
     * tecnico que inventariou o equipamento
     */
    private Tecnico tecnico;
    /**
     * estado do equipamento
     */
    private ESTADOEQUIPAMENTO estadoEquipamento = ESTADOEQUIPAMENTO.disponivel;
    /**
     * tipo de equipamento
     */
    private TipoEquipamento tipoEquipamento;
    /**
     * array para criar e guardar as avarias
     */
    private ArrayList<Avaria> avarias = new ArrayList<>();
    /**
     * array para criar e guardar as reparações
     */
    private ArrayList<Reparacao> reparacoes = new ArrayList<>();

    /**
     * construtor da classe equipamento
     *
     * @param descricao       descrição do equipamento
     * @param numeroIventario número de inventário do equipamento
     * @param numeroSerie     número de série do equipamento
     * @param custo           custo de reparação do equipamento
     * @param dataIventario   data de inventariação
     * @param tipoEquipamento tipo de equipamento
     * @param tecnico         tecnico que inventariou o euqipamento
     */

    public Equipamento(String descricao, int numeroIventario, int numeroSerie, float custo, Calendar dataIventario, TipoEquipamento tipoEquipamento, Tecnico tecnico) {
        super();
        this.descricao = descricao;
        this.numeroIventario = numeroIventario;
        this.numeroSerie = numeroSerie;
        this.custo = custo;
        this.dataIventario = dataIventario;
        this.tipoEquipamento = tipoEquipamento;
        this.tecnico = tecnico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroIventario() {
        return numeroIventario;
    }

    public void setNumeroIventario(int numeroIventario) {
        this.numeroIventario = numeroIventario;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public Calendar getDataIventariacao() {
        return dataIventario;
    }

    public void setDataIventariacao(Calendar dataIventariacao) {
        this.dataIventario = dataIventariacao;
    }

    public Divisao getDivisao() {
        return divisao;
    }

    public void setDivisao(Divisao divisao) {
        this.divisao = divisao;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public ESTADOEQUIPAMENTO getEstadoEquipamento() {
        return estadoEquipamento;
    }

    public void setEstadoEquipamento(ESTADOEQUIPAMENTO estadoEquipamento) {
        this.estadoEquipamento = estadoEquipamento;
    }

    public boolean avariado() {
        if(avarias.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public int getTotalAvariasEquipamento() {
        return totalAvariasEquipamento;
    }

    public void setTotalAvariasEquipamento(int totalAvariasEquipamento) {
        this.totalAvariasEquipamento = totalAvariasEquipamento;
    }

    /**
     * método para adicionar uma avaria
     *
     * @param avaria do equipamento
     */

    public void adicioarAvariaEquipamento(Avaria avaria) {
        avarias.add(avaria);
    }

    /**
     * método para mostrar as avarias dos equipamentos
     *
     * @return avarias dos equipamentos
     */
    public String mostrarAvariasEquipamento() {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < avarias.size(); i++) {
            str.append(avarias.get(i)).append("\n");
        }
        return str.toString();
    }

    /**
     * método para adicionar reparações nos equipamentos
     *
     * @param reparacao do equipamento
     */
    public void adicioarReparacao(Reparacao reparacao) {
        reparacoes.add(reparacao);
    }

    /**
     * método para mostrar reparações nos equipamentos
     *
     * @return reparações nos equipamentos
     */
    public String mostrarReparacoes() {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < reparacoes.size(); i++) {
            str.append(reparacoes.get(i)).append("\n");
        }
        return str.toString();
    }

    /**
     * mostra todos os dados da classe equipamento
     *
     * @return dados da classe equipamento
     */
    @Override
    public String toString() {
        return "Equipamento [descricao=" + descricao +
                ", numeroIventario=" + numeroIventario +
                ", numeroSerie=" + numeroSerie +
                ", custo=" + custo +
                ", dataIventariacao=" + dataIventario +
                ", divisao=" + divisao +
                ", tecnico=" + tecnico +
                ", estado=" + estadoEquipamento +
                ", tipoEquipamesnto=" + tipoEquipamento +
                ", totalAvariasEquipamento= " + totalAvariasEquipamento;
    }
}
