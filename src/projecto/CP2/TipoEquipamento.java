package projecto.CP2;

import java.io.Serializable;

/**
 * Esta classe contém os dados dos tipos de equipamentos
 */
public class TipoEquipamento implements Serializable{
    /**
     * número do tipo de equipamento, total de equipamentos
     */
    int numero, totalEquipamentos;
    /**
     * designção do tipo de equipamento
     */
    String designacao;

    /**
     * Este é o construtor da classe TipoEquipamento
     * @param designacao designacao
     */
    public TipoEquipamento(String designacao) {
        this.designacao = designacao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTotalEquipamentos() {
        return totalEquipamentos;
    }

    public void setTotalEquipamentos(int totalEquipamentos) {
        this.totalEquipamentos = totalEquipamentos;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * mostra todos os dados da classe TipoEquipamento
     * @return dados da classe TipoEquipamento
     */
    @Override
    public String toString() {
        return "TipoEquipamento{" +
                "numero=" + numero +
                ", designacao='" + designacao + '\'' +
                ", totalEquipamentos=" + totalEquipamentos +
                '}';
    }
}
