package projecto.CP2;

import util.Consola;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Gestao {
    private ArrayList<TipoEquipamento> tiposEquipamento = new ArrayList<>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Divisao> divisoes = new ArrayList<>();
    private ArrayList<Equipamento> equipamentos = new ArrayList<>();
    private ArrayList<Avaria> avarias = new ArrayList<>();
    private ArrayList<Reparacao> reparacoes = new ArrayList<>();


    /////////////////////////////////////////////TipoEquipamento

    public void adicionarTipoEquipamento (TipoEquipamento tipo){
        tipo.setNumero(tiposEquipamento.size() + 1);
        tiposEquipamento.add(tipo);
    }
    //MostrarTudo
    public String mostrarTipos() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < tiposEquipamento.size(); i++) {
            str.append(tiposEquipamento.get(i)).append("\n");
        }
        return str.toString();
    }

    //ObterElemento
    public TipoEquipamento obterTipo(int pos) {
        return tiposEquipamento.get(pos);
    }

    //getTotalElementosLista
    public int getTotalTipos() {
        return tiposEquipamento.size();
    }

    //Pesquisa por campo unico: numero de equipamento
    public int pesquisaTipo(int numero) {
        for (int i = 0; i < tiposEquipamento.size(); i++) {
            if (tiposEquipamento.get(i).getNumero() == numero) {
                return i;
            }
        }
        return -1;
    }

    /////////////////////////////////////////////Funcionarios

    //MostrarUmFuncionario
    public int pesquisarFuncionario(int nif){
        for (int i = 0; i < funcionarios.size(); i++){
            if (funcionarios.get(i).getNif() == nif){
                return i;
            }
        }
        return  -1;
    }

    public Funcionario obterFuncionario(int pos){
        return funcionarios.get(pos);
    }

    //MostrarTodosFuncionarios
    public String  mostrarTodosFuncionarios() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < funcionarios.size(); i++) {
            str.append(funcionarios.get(i)).append("\n");
        }
        return str.toString();
    }

    //RemoveFuncionario
    public boolean removerFuncionario() {
        int nif = 0;
        int pos = -1;
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNif() == nif) {
                pos = i;
            }
        }
        if (pos == -1){
            return false;}
        else{
            funcionarios.remove(pos);
            return true;
        }
    }

    /////////////////////////////////////////////EQUIPAMENTO

    public void adicionarEquipamento(Equipamento equipamento) {
        equipamentos.add(equipamento);
    }

    public int pesquisarEquipamento(int numeroIventario) {
        for (int i = 0; i < equipamentos.size(); i++){
            if (equipamentos.get(i).getNumeroIventario() == numeroIventario){
                return i;
            }
        }
        return -1;
    }

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

    public Equipamento obterEquipamento(int pos){
        return equipamentos.get(pos);
    }

    //////////////////////////////////////////////DIVISAO
    public void inserirDivisao(Divisao divisao) {
        this.divisoes.add(divisao);
    }

    public int procurarDesignacaoNasDivisoes(String designacao){
        for (int i = 0; i < divisoes.size(); i++){
            if (divisoes.get(i).getDesignacao().equalsIgnoreCase(designacao)){
                return i;
            }
        }
        return  -1;
    }
    //////////////////////////////////////////////AVARIA
    public void criarAvaria(Avaria avaria){
        avaria.setIdAvaria(avarias.size() +1);
        avarias.add(avaria);
    }

    public int pesquisarAvaria(int idAvaria) {
        for (int i = 0; i < avarias.size(); i++){
            if (avarias.get(i).getIdAvaria() == idAvaria){
                return i;
            }
        }
        return -1;
    }

    public String mostrarTodasAvarias() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < avarias.size(); i++) {
            str.append(avarias.get(i)).append("\n");
        }
        return str.toString();
    }

    public Avaria obterAvaria(int pos){
        return avarias.get(pos);
    }

    //////////////////////////////////////////////REPARAÇÃO
    public void adicionarReparacao (Reparacao reparacao) {
        reparacao.setIdReparacao(reparacoes.size() + 1);
        reparacoes.add(reparacao);
    }
    public int getNumReparacoes() {
        return reparacoes.size();
    }
    public int pesquisarReparacoes(int numReparacao) {
        for (int i = 0; i < reparacoes.size(); i++){
            if (reparacoes.get(i).getIdReparacao() == numReparacao){
                return i;
            }
        }
        return -1;
    }
    public String mostrarReparacoes() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < reparacoes.size(); i++) {
            str.append(reparacoes.get(i)).append("\n");
        }
        return str.toString();
    }
    public Reparacao obterReparacao(int pos){
        return reparacoes.get(pos);
    }
}
