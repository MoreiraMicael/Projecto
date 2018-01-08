package projecto.CP2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * esta classe permite saber em que local se encontram os equipamentos
 */
public class Divisao implements Serializable {
    /**
     * array para criar e guardar os equipamentos
     */
    private ArrayList<Equipamento> equipamentos = new ArrayList<>();
    /**
     * designação e localização da divisão
     */
    String designacao, localizacao;
    /**
     * equipamento instalado na divisão
     */
    int equipamentosInstalados;

    /**
     * Este é o construtor da classe divisão
     *
     * @param designacao             designação da divisão
     * @param localizacao            localização da divisão
     * @param equipamentosInstalados equipamentos instalados na divisão
     */
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

    /**
     * método para adicionar equipamentos a divisões
     *
     * @param equipamento equipamento associado à divisão
     */
    public void adicionarEquipamentoDivisao(Equipamento equipamento) {
        equipamentos.add(equipamento);
        equipamentosInstalados = (equipamentosInstalados + 1);
    }

    /**
     * método para listar os equipamentos associados às divisões
     *
     * @return equipamentos associados às divisões
     */
    public String mostrarEquipamentosDivisao() {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < equipamentos.size(); i++) {
            str.append(equipamentos.get(i)).append("\n");
        }
        return str.toString();
    }

    /**
     * método para eliminar equipamentos das divisões
     *
     * @param equipamento equipamento eliminado
     */
    public void eliminarEquipamentoDivisao(Equipamento equipamento) {
        equipamentos.remove(equipamento);
    }
}
