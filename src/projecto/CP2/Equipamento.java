package projecto.CP2;

import java.util.ArrayList;
import java.util.Calendar;

public class Equipamento {
  private String descricao;
  private int numeroIventario, numeroSerie, totalAvariasEquipamento;
  private float custo;
  private Calendar dataIventario;
  private Divisao divisao;
  private Tecnico tecnico;
  private ESTADOEQUIPAMENTO estadoEquipamento = ESTADOEQUIPAMENTO.disponivel;
  private TipoEquipamento tipoEquipamento;

	private ArrayList<Avaria> avarias = new ArrayList<>();
	private ArrayList<Reparacao> reparacoes = new ArrayList<>();

	/**
	* Default empty Equipamento constructor
	*/
	public Equipamento() {
		super();
	}
	/**
	* Default Equipamento constructor
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
	/**
	* Returns value of descricao
	* @return
	*/
	public String getDescricao() {
		return descricao;
	}
	/**
	* Sets new value of descricao
	* @param
	*/
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	* Returns value of numeroIventario
	* @return
	*/
	public int getNumeroIventario() {
		return numeroIventario;
	}
	/**
	* Sets new value of numeroIventario
	* @param
	*/
	public void setNumeroIventario(int numeroIventario) {
		this.numeroIventario = numeroIventario;
	}
	/**
	* Returns value of numeroSerie
	* @return
	*/
	public int getNumeroSerie() {
		return numeroSerie;
	}
	/**
	* Sets new value of numeroSerie
	* @param
	*/
	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	/**
	* Returns value of custo
	* @return
	*/
	public float getCusto() {
		return custo;
	}
	/**
	* Sets new value of custo
	* @param
	*/
	public void setCusto(float custo) {
		this.custo = custo;
	}
	/**
	* Returns value of dataIventariacao
	* @return
	*/
	public Calendar getDataIventariacao() {
		return dataIventario;
	}
	/**
	* Sets new value of dataIventariacao
	* @param
	*/
	public void setDataIventariacao(Calendar dataIventariacao) {
		this.dataIventario = dataIventariacao;
	}
	/**
	* Returns value of divisao
	* @return
	*/
	public Divisao getDivisao() {
		return divisao;
	}
	/**
	* Sets new value of divisao
	* @param
	*/
	public void setDivisao(Divisao divisao) {
		this.divisao = divisao;
	}
	/**
	* Returns value of tecnico
	* @return
	*/
	public Tecnico getTecnico() {
		return tecnico;
	}
	/**
	* Sets new value of tecnico
	* @param
	*/
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	/**
	* Returns value of estado
	* @return
	*/
	public ESTADOEQUIPAMENTO getEstadoEquipamento() {
		return estadoEquipamento;
	}
	/**
	* Sets new value of estado
	* @param
	*/
	public void setEstadoEquipamento(ESTADOEQUIPAMENTO estadoEquipamento) {
		this.estadoEquipamento = estadoEquipamento;
	}
	/**
	* Returns value of tipoEqui
	* @return
	*/
	public TipoEquipamento getTipoEqui() {
		return tipoEquipamento;
	}
	/**
	* Sets new value of tipoEqui
	* @param
	*/
	public void setTipoEqui(TipoEquipamento tipoEqui) {
		this.tipoEquipamento = tipoEqui;
	}
	/**
	* Returns value of totalAvariasEquipamento
	* @return
	*/
	public int getTotalAvariasEquipamento() {
		return totalAvariasEquipamento;
	}
	/**
	* Sets new value of totalAvariasEquipamento
	* @param
	*/
	public void setTotalAvariasEquipamento(int totalAvariasEquipamento) {
		this.totalAvariasEquipamento = totalAvariasEquipamento;
	}

	public void adicioarAvariaEquipamento(Avaria avaria) {
		avarias.add(avaria);
	}

	public String mostrarAvariasEquipamento(){
		StringBuilder str = new StringBuilder("");
		for (int i = 0; i < avarias.size(); i++) {
			str.append(avarias.get(i)).append("\n");
		}
		return str.toString();
	}

	public void adicioarReparacao(Reparacao reparacao) {
		reparacoes.add(reparacao);
	}

	public String mostrarReparacoes(){
		StringBuilder str = new StringBuilder("");
		for (int i = 0; i < reparacoes.size(); i++) {
			str.append(reparacoes.get(i)).append("\n");
		}
		return str.toString();
	}


	/**
	* Create string representation of Equipamento for printing
	* @return
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
