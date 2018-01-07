package projecto.CP2;

public class TipoEquipamento {

    int numero, totalEquipamentos;
    String designacao;
    int numeroTotalEquipamentos;

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

    @Override
    public String toString() {
        return "TipoEquipamento{" +
                "numero=" + numero +
                ", designacao='" + designacao + '\'' +
                ", numeroTotalEquipamentos=" + numeroTotalEquipamentos +
                '}';
    }
}
