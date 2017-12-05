package projecto.CP2;

public class TipoEquipamento {

    int numero;
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
