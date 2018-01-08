package projecto.CP2;

import util.Consola;

import javax.naming.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.management.ThreadInfo;
import java.util.ArrayList;

/**
 * Esta classe permite gerir as outras classes
 */
public class Gestao {
    /**
     * array para criar e guardar os tipos de equipamentos
     */
    private ArrayList<TipoEquipamento> tiposEquipamento = new ArrayList<>();
    /**
     * array para criar e guardar os funcionários
     */
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    /**
     * array para criar e guardar as divisões
     */
    private ArrayList<Divisao> divisoes = new ArrayList<>();
    /**
     * array para criar e guardar os equipamentos
     */
    private ArrayList<Equipamento> equipamentos = new ArrayList<>();
    /**
     * array para criar e guardar as avarias
     */
    private ArrayList<Avaria> avarias = new ArrayList<>();
    /**
     * array para criar e guardar as reparações
     */
    private ArrayList<Reparacao> reparacoes = new ArrayList<>();

    /**
     * método para adicionar tipos de equipamentos
     *
     * @param tipo de equipamento
     */

    public void adicionarTipoEquipamento(TipoEquipamento tipo) {
        tipo.setNumero(tiposEquipamento.size() + 1);
        tiposEquipamento.add(tipo);
    }

    public int getNumeroTotalTipoEquipamento() {
        return tiposEquipamento.size();
    }

    /**
     * método para mostrar todos os tipos de equipamentos
     *
     * @return todos tipos de equipamentos
     */

    public String mostrarTipos() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < tiposEquipamento.size(); i++) {
            str.append(tiposEquipamento.get(i)).append("\n");
        }
        return str.toString();
    }

    public TipoEquipamento obterTipo(int pos) {
        return tiposEquipamento.get(pos);
    }

    public int getTotalTipos() {
        return tiposEquipamento.size();
    }

    /**
     * método para pesquisar por tipo de equipamento
     *
     * @param numero numero
     * @return tipo equipamento
     */
    public int pesquisaTipo(int numero) {
        for (int i = 0; i < tiposEquipamento.size(); i++) {
            if (tiposEquipamento.get(i).getNumero() == numero) {
                return i;
            }
        }
        return -1;
    }

    /**
     * método para adicionar funcionários
     *
     * @param funcionario funcionario
     */

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    /**
     * método para remover funcionários
     *
     * @param j j
     */
    public void removerFuncionario(int j) {
        funcionarios.remove(j);
    }

    public int getNumeroTotalFuncionarios() {
        return funcionarios.size();
    }

    /**
     * método para pesquisar funcionário pelo nif
     *
     * @param nif nif
     * @return funcionário
     */
    public int pesquisarFuncionario(int nif) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNifFuncionario() == nif) {
                return i;
            }
        }
        return -1;
    }

    public Funcionario obterFuncionario(int pos) {
        return funcionarios.get(pos);
    }

    /**
     * método para mostrar todos os funcionários existentes
     *
     * @return todos os funcionários
     */
    public String mostrarTodosFuncionarios() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < funcionarios.size(); i++) {
            str.append(funcionarios.get(i)).append("\n");
        }
        return str.toString();
    }

    /**
     * método para alterar a morada dos funcionários
     *
     * @param novaMorada novaMorada
     * @param nifFuncionario nifFuncionario
     */
    public void alteraMorada(String novaMorada, int nifFuncionario) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNifFuncionario() == nifFuncionario) {
                funcionarios.get(i).setMorada(novaMorada);
            }
        }
    }

    /**
     * método para alterar o telefone dos funcionários
     *
     * @param novoTelefone novoTelefone
     * @param nifFuncionario nifFuncionario
     */
    public void alteraTelefone(int novoTelefone, int nifFuncionario) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNifFuncionario() == nifFuncionario) {
                funcionarios.get(i).setTelefone(novoTelefone);
            }
        }
    }

    /**
     * método para adicionar equipamentos
     *
     * @param equipamento equipamento
     */

    public void adicionarEquipamento(Equipamento equipamento) {
        equipamentos.add(equipamento);
    }

    public int getNumeroTotalEquipamentos() {
        return equipamentos.size();
    }

    /**
     * método para pesquisar um equipamento
     *
     * @param numeroIventario numeroIventario
     * @return equipamento equipamento
     */
    public int pesquisarEquipamento(int numeroIventario) {
        for (int i = 0; i < equipamentos.size(); i++) {
            if (equipamentos.get(i).getNumeroIventario() == numeroIventario) {
                return i;
            }
        }
        return -1;
    }

    /**
     * método para mostrar todos os equipamentos existentes
     *
     * @return todos os equipamentos
     */
        public String mostrarTodosEquipamentos() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < equipamentos.size(); i++) {
            str.append(equipamentos.get(i)).append("\n");
        }
        return str.toString();
    }

    public int numeroEquipamentos() {
        return equipamentos.size();
    }

    public Equipamento obterEquipamento(int pos) {
        return equipamentos.get(pos);
    }

    /**
     * método para inserir divisões
     *
     * @param divisao divisao
     */

    public void inserirDivisao(Divisao divisao) {
        this.divisoes.add(divisao);
    }

    public Divisao obterDivisao(int pos) {
        return divisoes.get(pos);
    }

    public int getNumeroTotalDivisoes() {
        return divisoes.size();
    }

    public String mostrarTodasDivisoes() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < divisoes.size(); i++) {
            str.append(divisoes.get(i)).append("\n");
        }
        return str.toString();
    }

    /**
     * método para procurar divisões por designação
     *
     * @param designacao designacao
     * @return divisões divisões
     */
    public int procurarDesignacaoNasDivisoes(String designacao) {
        for (int i = 0; i < divisoes.size(); i++) {
            if (divisoes.get(i).getDesignacao().equalsIgnoreCase(designacao)) {
                return i;
            }
        }
        return -1;
    }

    public String mostrarDesignacaoDivisoes() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < divisoes.size(); i++) {
            str.append(divisoes.get(i).getDesignacao()).append("\n");
        }
        return str.toString();
    }

    /**
     * método para inserir uma avaria
     *
     * @param avaria avaria
     */

    public void criarAvaria(Avaria avaria) {
        avaria.setIdAvaria(avarias.size() + 1);
        avarias.add(avaria);
    }

    public int getNumeroTotalAvarias() {
        return avarias.size();
    }

    /**
     * método para pesquisar uma avaria
     *
     * @param idAvaria idAvaria
     * @return return numeroTotalAvarias
     */
    public int pesquisarAvaria(int idAvaria) {
        for (int i = 0; i < avarias.size(); i++) {
            if (avarias.get(i).getIdAvaria() == idAvaria) {
                return i;
            }
        }
        return -1;
    }

    /**
     * método para mostrar todas as avarias
     *
     * @return return Avarias
     */
    public String mostrarTodasAvarias() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < avarias.size(); i++) {
            str.append(avarias.get(i)).append("\n");
        }
        return str.toString();
    }

    public Avaria obterAvaria(int pos) {
        return avarias.get(pos);
    }

    /**
     * método para inserir uma reparação
     *
     * @param reparacao reparacao
     */

    public void adicionarReparacao(Reparacao reparacao) {
        reparacao.setIdReparacao(reparacoes.size() + 1);
        reparacoes.add(reparacao);
    }

    public int getNumReparacoes() {
        return reparacoes.size();
    }

    public int getNumeroTotalReparacoes() {
        return reparacoes.size();
    }

    /**
     * método para pesquisar uma reparação
     *
     * @param numReparacao numReparacao
     * @return reparação reparação
     */
    public int pesquisarReparacoes(int numReparacao) {
        for (int i = 0; i < reparacoes.size(); i++) {
            if (reparacoes.get(i).getIdReparacao() == numReparacao) {
                return i;
            }
        }
        return -1;
    }

    /**
     * método para mostrar todas as reparações
     *
     * @return return Reparacoes
     */
    public String mostrarReparacoes() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < reparacoes.size(); i++) {
            str.append(reparacoes.get(i)).append("\n");
        }
        return str.toString();
    }

    public Reparacao obterReparacao(int pos) {
        return reparacoes.get(pos);
    }

    /**
     * método para guardar os ficheiros
     */
    public void gravarParaFicheiro() {
        try {
            //Cria Ficheiro
            //FileOutputStream output = new FileOutputStream("C:\\Users\\Moreira\\IdeaProjects\\Projecto\\dados.txt");
            //ObjectOutputStream outputDados = new ObjectOutputStream(output);

            ObjectOutputStream outputDados = new ObjectOutputStream(new FileOutputStream("dados.txt"));

            //Escreve no Ficheiro
            outputDados.writeObject(tiposEquipamento);
            outputDados.writeObject(funcionarios);
            outputDados.writeObject(divisoes);
            outputDados.writeObject(equipamentos);
            outputDados.writeObject(avarias);
            outputDados.writeObject(reparacoes);
            //Fecha Ficheiro
            outputDados.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * método para ler os ficheiros guardados
     */
    public void lerDoFicheiro() {
        try {
            //Ler ficheiro e escreve na consola
            ObjectInputStream inputDados = new ObjectInputStream(new FileInputStream("dados.txt"));

            tiposEquipamento = (ArrayList<TipoEquipamento>) inputDados.readObject();
            funcionarios = (ArrayList<Funcionario>) inputDados.readObject();
            divisoes = (ArrayList<Divisao>) inputDados.readObject();
            equipamentos = (ArrayList<Equipamento>) inputDados.readObject();
            avarias = (ArrayList<Avaria>) inputDados.readObject();
            reparacoes = (ArrayList<Reparacao>) inputDados.readObject();

            /*/System.out.println("Tipos equipamentos: "+ (ArrayList<TipoEquipamento>) inputDados.readObject());
            System.out.println("Tipos equipamentos: "+ tiposEquipamento);
            //System.out.println("Funcionario: "+ (ArrayList<Funcionario>) inputDados.readObject());
            System.out.println("Funcionario: "+ funcionarios);
            //System.out.println("Divisao: "+ (ArrayList<Divisao>) inputDados.readObject());
            System.out.println("Divisao: "+ divisoes);
            //System.out.println("Equipamento: "+ (ArrayList<Equipamento>) inputDados.readObject());
            System.out.println("Equipamento: "+ equipamentos);
            //System.out.println("Avaria: "+ (ArrayList<Avaria>) inputDados.readObject());
            System.out.println("Avaria: "+ avarias);
            //System.out.println("Reparacao: "+ (ArrayList<Reparacao>) inputDados.readObject());
            System.out.println("Reparacao: "+ reparacoes);

            *///Fecha Ficheiro
            inputDados.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void percentagemAvarias() {
        try {
            float percentagem = 0;
            int avarias = 0;
            for ( Equipamento equipamento: equipamentos) {
                if(equipamento.avariado()) {
                    avarias++;
                }
            }
            if(avarias >0 ) {
                percentagem = ((float)avarias/getNumeroTotalEquipamentos())*100;
                System.out.println("Equipamentos avariados: "+percentagem+" %\n");
            }else   {
                System.out.println("Nenhum equipamento avariado. \n");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String mostrarNumeroDeEquipamentosPorTipo() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < equipamentos.size(); i++) {
            System.out.println("Equipamentos: " + tiposEquipamento.get(i).getTotalEquipamentos());
            str.append(equipamentos.get(i).getTipoEquipamento());
        }
        return str.toString();
    }
}
