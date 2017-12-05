package projecto.CP2;

public class Divisao {
    String designacao;
    String localizacao;
    int equipamentosInstalados;

    public Divisao(String designacao, String localizacao, int equipamentosInstalados) {
        this.designacao = designacao;
        this.localizacao = localizacao;
        this.equipamentosInstalados = equipamentosInstalados;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getEquipamentosInstalados() {
        return equipamentosInstalados;
    }

    public void setEquipamentosInstalados(int equipamentosInstalados) {
        this.equipamentosInstalados = equipamentosInstalados;
    }
}
