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

    public int getNumeroTotalTipoEquipamento() {
        return tiposEquipamento.size();
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

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    //RemoveFuncionario
    public void removerFuncionario(int j) {
        funcionarios.remove(j);
    }

    public int getNumeroTotalFuncionarios() {
        return funcionarios.size();
    }

    //Pesquisar Funcionario por nif
    public int pesquisarFuncionario(int nif){
        for (int i = 0; i < funcionarios.size(); i++){
            if (funcionarios.get(i).getNifFuncionario() == nif){
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

    public void alteraMorada (String novaMorada, int nifFuncionario) {
        for (int i = 0; i < funcionarios.size(); i++){
            if (funcionarios.get(i).getNifFuncionario() == nifFuncionario) {
                funcionarios.get(i).setMorada(novaMorada);
            }
        }
    }

    public void alteraTelefone (int novoTelefone, int nifFuncionario) {
        for (int i = 0; i < funcionarios.size(); i++){
            if (funcionarios.get(i).getNifFuncionario() == nifFuncionario) {
                funcionarios.get(i).setTelefone(novoTelefone);
            }
        }
    }

    /////////////////////////////////////////////EQUIPAMENTO

    public void adicionarEquipamento(Equipamento equipamento) {
        equipamentos.add(equipamento);
    }

    public int getNumeroTotalEquipamentos() {
        return equipamentos.size();
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

    public Divisao obterDivisao(int pos){
        return divisoes.get(pos);
    }

    public int getNumeroTotalDivisoes() {
        return divisoes.size();
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

    public int getNumeroTotalAvarias() {
        return avarias.size();
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

    public int getNumeroTotalReparacoes() {
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

    public void gravarParaFicheiro(){
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

        }catch (IOException ex) {
            ex.printStackTrace();
            //System.out.println(ex.getMessage());
        }
    }

    public void lerDoFicheiro(){
        try {
            //Lêr ficheiro e escreve na consola
            ObjectInputStream inputDados = new ObjectInputStream(new FileInputStream("dados.txt"));

            tiposEquipamento = (ArrayList<TipoEquipamento>)inputDados.readObject();
            funcionarios = (ArrayList<Funcionario>)inputDados.readObject();
            divisoes = (ArrayList<Divisao>)inputDados.readObject();
            equipamentos = (ArrayList<Equipamento>)inputDados.readObject();
            avarias = (ArrayList<Avaria>)inputDados.readObject();
            reparacoes = (ArrayList<Reparacao>)inputDados.readObject();

            //System.out.println("Tipos equipamentos: "+ (ArrayList<TipoEquipamento>) inputDados.readObject());
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

            //Fecha Ficheiro
            inputDados.close();

        }catch (Exception ex){
            ex.printStackTrace();
            //System.out.println(e.getMessage());
        }
    }
}
