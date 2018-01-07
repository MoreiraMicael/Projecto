package projecto.CP2;

import java.io.Serializable;
import java.util.ArrayList;

public class Divisao implements Serializable {

    private ArrayList<Equipamento> equipamentos = new ArrayList<>();

    String designacao, localizacao;
    int equipamentosInstalados;

    public Divisao(String designacao, String localizacao, int equipamentosInstalados) {
        this.designacao = designacao;
        this.localizacao = localizacao;
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

    public void adicionarEquipamentoDivisao(Equipamento equipamento) {
        equipamentos.add(equipamento);
        equipamentosInstalados= (equipamentosInstalados+1);
    }

    public String mostrarEquipamentosDivisao(){
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < equipamentos.size(); i++) {
            str.append(equipamentos.get(i)).append("\n");
        }
        return str.toString();
    }

    public void eliminarEquipamentoDivisao(Equipamento equipamento){
        equipamentos.remove(equipamento);
    }
}
