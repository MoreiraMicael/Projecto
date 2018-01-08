package projecto.CP2;

import util.Consola;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    private static Gestao gestao = new Gestao();

    static Scanner sc = new Scanner(System.in);
    static String[] menuPrincipal = {"1- Gerir Funcionários",
            "2- Gerir Divisões",
            "3- Gerir Equipamentos",
            "4- Gerir Avarias",
            "0- Sair"};

    static String[] menuFunc = {"1- Inserir Funcionário", "2- Alterar Funcionário", "3- Consultar todos Funcionários", "4- Eliminar Funcionários", "0-Voltar"};
    static String[] menuDiv = {"1- Inserir Divisão", "2- Consultar Divisão", "0- Voltar"};
    static String[] menuEq = {"1- Inserir Equipamento", "2- Consultar todos equipamentos", "0- Voltar"};
    static String[] menuAv = {"1- Registar Avaria", "2- Consultar Avaria", "Alterar estado avaria", "0- Voltar"};

    public static void main(String[] args) {
        int opcao = 0;

        gestao.lerDoFicheiro();

        do {
            System.out.println("### MENU PRINCIPAL ###");
            mostraMenu(menuPrincipal);
            opcao = lerInteiro("Introduza uma opção: ", 0, 4);
            switch (opcao) {
                case 1:
                    int opcao2 = 0;
                    do {
                        System.out.println("### MENU FUNCIONÁRIO ###");
                        mostraMenu(menuFunc);
                        opcao2 = lerInteiro("Introduza uma opção: ", 0, 4);
                        switch (opcao2) {
                            case 1:
                                inserirFuncionario();
                                break;
                            case 2:
                                alteraFuncionario();
                                break;
                            case 3:
                                System.out.println(gestao.mostrarTodosFuncionarios());
                                break;
                            case 4:
                                removerFuncionario();
                                break;
                            default:
                                System.out.println("A voltar ao menu anterior..");
                                break;
                        }
                    } while (opcao2 != 0);
                    break;
                case 2:
                    int opcao3 = 0;
                    do {
                        System.out.println("### MENU DIVISÃO ###");
                        mostraMenu(menuDiv);
                        opcao3 = lerInteiro("Introduza uma opção: ", 0, 2);
                        switch (opcao3) {
                            case 1:
                                inserirDivisao();
                                break;
                            case 2:
                                pesquisaDivisao();
                                break;
                            default:
                                System.out.println("A voltar ao menu anterior..");
                                break;
                        }
                    } while (opcao3 != 0);
                    break;
                case 3:
                    int opcao4 = 0;
                    do {
                        System.out.println("### MENU EQUIPAMENTO ###");
                        mostraMenu(menuEq);
                        opcao4 = lerInteiro("Introduza uma opção: ", 0, 2);
                        switch (opcao4) {
                            case 1:
                                inserirEquipamento();
                                break;
                            case 2:
                                System.out.println(gestao.mostrarTipos());
                                break;
                            default:
                                System.out.println("A voltar ao menu anterior..");
                                break;
                        }
                    } while (opcao4 != 0);
                    break;
                case 4:
                    int opcao5 = 0;
                    do {
                        System.out.println("### MENU AVARIAS ###");
                        mostraMenu(menuAv);
                        opcao5 = lerInteiro("Introduza uma opção: ", 0, 3);
                        switch (opcao5) {
                            case 1:
                                criarAvaria();
                                break;
                            case 2:
                                alterarEstadoAvaria();
                                break;
                            case 3:
                                pesquisarAvaria();
                                break;
                            default:
                                System.out.println("A voltar ao menu anterior..");
                                break;
                        }
                    } while (opcao5 != 0);
                    break;
                case 0:
                    System.out.println("0- A sair...");
                    break;
                default:
                    System.out.println("Opção inválida...");
            }
        } while (opcao != 0);

        gestao.gravarParaFicheiro();

    }

    static void mostraMenu(String[] opcoes) {
        for (int i = 0; i < opcoes.length; i++)
            System.out.println(opcoes[i]);
    }

    static int lerInteiro(String mensagem, int limiteInferior, int limiteSuperior) {
        int inteiro = 0;
        do {
            System.out.println(mensagem);
            inteiro = sc.nextInt();
        } while (inteiro < limiteInferior || inteiro > limiteSuperior);

        return inteiro;
    }

    //////////////////////////////////////////////FUNCIONARIO
    public static void inserirFuncionario() {
        int nifFuncionario, telefone, pos, j, menuTipoFuncionario;
        int errodn = 0;
        String nome, morada, habilitacoes, email, especialidade, seccao, funcao, login, password;
        Calendar dataNascimento = new GregorianCalendar();
        Funcionario funcionario;

        do {
            nifFuncionario = Consola.lerInt("Indique o nif do funcionario: ", 000000000, 999999999);
            j = gestao.pesquisarFuncionario(nifFuncionario);
            if (j != -1){
                System.err.println("Já existe um utilizador com esse nif. ");
            }else {
                nome = Consola.lerString("Indique o nome do funcionario: ");
                morada = Consola.lerString("Indique a morada do funcionario: ");
                telefone = Consola.lerInt("Indique o numero de telefone do funcionario: ", 000000000, 999999999);
                email = Consola.lerString("Indique o email do funcionario: ");
                dataNascimento = Consola.lerData("Indique a data de nascimento do funcionario: ");
                habilitacoes = Consola.lerString("Indique as habilitações do funcionario: ");

                do {

                    System.out.println("Indique qual a função do Funcionario que pretende inserir: ");
                    System.out.println("1 - Médico ");
                    System.out.println("2 - Tecnico ");
                    System.out.println("3 - Outro ");

                    menuTipoFuncionario = Consola.lerInt("Opção: ", 1, 3);

                }while (menuTipoFuncionario < 1 && menuTipoFuncionario > 3 );

                if (menuTipoFuncionario == 1) {
                    especialidade = Consola.lerString("Qual a especialidade do médico? ");
                    seccao = Consola.lerString("Qual a secção de trabalho do médico? ");

                    funcionario = new Medico(nifFuncionario, nome, email, telefone, morada, dataNascimento, habilitacoes, especialidade, seccao);

                    if (funcionario.maiorIdade()) {
                        gestao.adicionarFuncionario(funcionario);
                        funcionario.setNumeroTotalFuncionarios(funcionario.getNumeroTotalFuncionarios()+ 1);
                    } else {
                        System.err.println("O funcionario que introduziu não é maior de idade ");
                    }

                }
                if (menuTipoFuncionario == 2) {
                    funcao = "Tecnico";
                    login = Consola.lerString("Insira o nome de login para o Tecnico: ");
                    password = Consola.lerString("Insira a password para o Tecnico: ");

                    funcionario = new Tecnico(nifFuncionario, nome, morada, telefone, email, dataNascimento, funcao, habilitacoes, login, password);

                    if (funcionario.maiorIdade()) {
                        gestao.adicionarFuncionario(funcionario);
                        funcionario.setNumeroTotalFuncionarios(funcionario.getNumeroTotalFuncionarios()+ 1);
                    } else {
                        System.err.println("O funcionario que introduziu não é maior de idade ");
                    }

                }
                if (menuTipoFuncionario == 3) {

                    funcao = Consola.lerString("Qual a função do funcionário? ");

                    funcionario = new OutrosFuncionarios(nifFuncionario, nome, morada, telefone, email, dataNascimento, habilitacoes, funcao);

                    if (funcionario.maiorIdade()) {
                        gestao.adicionarFuncionario(funcionario);
                        funcionario.setNumeroTotalFuncionarios(funcionario.getNumeroTotalFuncionarios()+ 1);
                    } else {
                        System.err.println("O funcionario que introduziu não é maior de idade ");
                    }
                }
            }
        }while (j != -1);

    }

    private static void alteraFuncionario() {

        Funcionario funcionario;
        int j, telefoneNovo;
        String moradaNova;

        do {
            int nifFuncionario = Consola.lerInt("Insera o nif do Funcionario a que pretende fazer as alteraçoes: ",000000000,999999999);
            j = gestao.pesquisarFuncionario(nifFuncionario);

            if (j == -1){
                System.err.println("Não existe nenhum utilizador com esse nif, ou nif introduzido incorrectamente. ");
            }else {
                System.out.println("Alterar Dados Funcionario\n");
                System.out.println("\t0. Sair");
                System.out.println("\t1. Alterar Morada");
                System.out.println("\t2. Alterar Telefone");
                System.out.println("\nOpcao: ");

                int opcao;
                Scanner numero = new Scanner(System.in);
                do {
                    opcao = numero.nextInt();
                    switch (opcao) {
                        case 1:
                            moradaNova = Consola.lerString("Indique a nova morada do funcionario: ");
                            gestao.alteraMorada(nifFuncionario, moradaNova);
                            break;
                        case 2:
                            telefoneNovo = Consola.lerInt("Indique o novo telefone do funcionario: ",000000000,999999999);
                            gestao.alteraTelefone(nifFuncionario, telefoneNovo);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                } while (opcao != 0);
            }
        }while (j == -1);
    }

    public static void removerFuncionario() {
        int nifFuncionario, j;
        do {
            nifFuncionario = Consola.lerInt("Insira o nif do funcionario que pretende Eleminar: ", 000000000, 999999999);
            j = gestao.pesquisarFuncionario(nifFuncionario);
            if (j == -1)
                System.err.println("O funcionario com eese nif não existe ou ja foi eliminado");
        } while (j == -1);

        gestao.removerFuncionario(nifFuncionario);
        //System.out.println("Funcionário removido com sucesso!");
    }

///////////////////////////////////////////////EQUIPAMENTO
    public void registarEquipamento() {

        int numeroSerie, numeroIventario, nifTecnico, j, numeroTipoEquipamento;
        String descricao, estado;
        float custo;
        Calendar dataIventario = Calendar.getInstance();
        TipoEquipamento tipoEquipamento;
        Divisao divisao;
        Funcionario funcionario;
        Tecnico tecnico=null;
        Equipamento equipamento;
        int totalAvariasEquipamento;
        int errodn = 0, errode = 0;

        do {
            nifTecnico = Consola.lerInt("Indique o nif do técnico:", 1,999999999);
            j = gestao.pesquisarFuncionario(nifTecnico);
            if (j==-1)
                System.err.println("Não existe nenhum técnico com esse nif. ");
            else{
                funcionario = gestao.obterFuncionario(j);

                if (funcionario instanceof Tecnico)
                    tecnico=(Tecnico) funcionario;
                else{
                    j=-1;
                    System.err.println("Não existe nenhum técnico com esse nif. ");
                }

            }
        } while (j == -1);
        //existe tecnico com esse nif

        do {
            numeroIventario = Consola.lerInt("Indique o numero de inventário do equipamento: ", 1,999999999);
            j = gestao.pesquisarEquipamento(numeroIventario);
                if (j != -1)
                    System.err.println("Numero de inventario já foi utilizado");
        } while (j != -1);
        //repete

        numeroSerie = Consola.lerInt("Indique o numero de serie do equipamento: ", 000000000, 999999999);
        descricao = Consola.lerString("Indique a descricao do equipamento: ");
        custo = Consola.lerFloat("Indique qual o custo do equipamento: ", 000000000,999999999);

        //System.out.println("------------------ LISTAGEM TIPOS DE EQUIPAMENTO ------------------");
        //System.out.println(gestao.mostrarTipos());
        //System.out.println("------------------ FIM LISTAGEM ------------------");
        do {

            numeroTipoEquipamento = Consola.lerInt("Insira o Numero do Tipo de Equipamento: ", 0 , 999999999);
            j = gestao.pesquisaTipo(numeroTipoEquipamento);

            if(j == -1){
                System.out.println("Tipo de equipamento nao encontrado! ");
            }
        }while (j == -1);

        tipoEquipamento = gestao.obterTipo(j);

        equipamento = new Equipamento(descricao, numeroIventario, numeroSerie, custo, dataIventario, tipoEquipamento, tecnico);


        tipoEquipamento.setTotalEquipamentos(tipoEquipamento.getTotalEquipamentos()+1);

        gestao.adicionarEquipamento(equipamento);

        System.out.println("Equipamento adicionado com sucesso!");
    }

    //////////////////////////////////////////////DIVISAO

    private static void inserirDivisao() {
        //int equipamentosInstalados = Divisao.getEquipamentosInstalados();
        int equipamentosInstalados = 0;
        int j;
        Divisao divisao;
        String localizacao;
        int errodn , errode = 0;

        do {
            String designacao = Consola.lerString("Indique a designação da divisão: ");
            j = gestao.procurarDesignacaoNasDivisoes(designacao);

            if (j == -1){
                //perguntar se existem equipamentos já na sala  //equipamentosInstalados = Consola.lerInt("Quantos equipamentos ja existem na sala : ", 000000000, 999999999);
                localizacao = Consola.lerString("Indique a localizacao da Divisão: ");

                divisao = new Divisao(designacao, localizacao, equipamentosInstalados);
                gestao.inserirDivisao(divisao);
            }
            else {
                System.out.println("já existe uma divião com esta designação");
            }
        }while (j != -1);


    }


    //Pesquisa por campo unico: designacao
    private static void pesquisaDivisao() {
        int j;
        String designacao;
        Divisao divisao;

        do {
            designacao = Consola.lerString("Indique a designação da divisão: ");
            j = gestao.procurarDesignacaoNasDivisoes(designacao);
                if (j == -1){
                    System.err.println("Não existe nenhuma divisão com essa designação.  ");
                }
        }while (j != -1);

        divisao = gestao.obterDivisao(j);
        System.out.println(divisao);

    }



    //Pesquisa por campo unico: designacao da Divisao
    /*public int pesquisaDivisaoDesignacao( ) {
        Divisao di
        for (int i = 0; i < divisoes.size(); i++) {
            if (divisoes.get(i).getDesignacao() == designcao) {
                System.out.println("" + divisoes.get(i));
                return i;
            }
        }
        System.out.println("Nenhuma divisao com essa designacao encontrada. ");
        return -1;
    }*/



    //////////////////////////////////////////////AVARIA
    public static void criarAvaria() {
        String descricao;
        int numeroInventario, nifFuncionario, j, n;
        Equipamento equipamento;
        Funcionario funcionario;
        Avaria avaria;

        do {
            numeroInventario = Consola.lerInt("Insira o numero de inventario do equipamento avariado: ", 000000000, 999999999);
            j = gestao.pesquisarEquipamento(numeroInventario);

            if(j != -1){
                System.out.println("Equipamento já existe");
                break;

            }else
                equipamento = gestao.obterEquipamento(numeroInventario);
                descricao = Consola.lerString("Insira a descricao da avaria: ");
                do {
                    nifFuncionario = Consola.lerInt("Insira o nif do funcionário:", 000000000,999999999);
                    n = gestao.pesquisarFuncionario(nifFuncionario);
                    if (n ==-1)
                        System.err.println("Numero incorrecto ou não existe nehum funcionario com esse numero");
                } while (n != -1);
                funcionario = gestao.obterFuncionario(j);
                avaria = new Avaria(equipamento, descricao, funcionario);
                equipamento.adicioarAvariaEquipamento(avaria);
                //equipamento.setEstado(ESTADO.INDISPONIVEL);
                gestao.criarAvaria(avaria);

                //System.out.println("Avaria inserida com Sucesso!");

        }while (j == -1);


    }

    private static void alterarEstadoAvaria() {
        int idAvaria, nifFuncionario, j, opcao;
        int errodn = 0;
        float custo;
        String data, descricao;
        Calendar dataReparacao = new GregorianCalendar();
        Avaria avaria;
        Funcionario funcionario;
        Funcionario tecnico;
        Reparacao reparacao;

        do {
            idAvaria = Consola.lerInt("Indique qual o id da Avaria a que pretende mudar o estado: ", 000000000, 999999999);;
            j = gestao.pesquisarAvaria(idAvaria);
            if(j == -1){
                System.out.println("Nenhuma avaria encontrada com o id introduzido. ");
            }
        }while (j == -1);

        avaria = gestao.obterAvaria(j);

        do {
            opcao = Consola.lerInt("Opção: ", 1, 2);

            System.out.println("Para que estado pretende alterar o estado do equipamento ?\n ");
            System.out.println("1- Reparado ");
            System.out.println("2- Irreparavél ");

        } while (opcao !=1 && opcao != 2);

        if (opcao == 1) {
            avaria.getEquipamentoAssociado().setEstadoEquipamento(ESTADOEQUIPAMENTO.disponivel);

            dataReparacao = Consola.lerData("Insira a data em que a reparacao foi realizada (dd-mm-yyyy): ");
            descricao = Consola.lerString("Insira a descrição da reparação: ");
            custo = Consola.lerFloat("Insira o custo da reparação: ", 000000000, 999999999);

            do {
                nifFuncionario = Consola.lerInt("Insira o nif do técnico que realizou a reparação: ", 000000000,999999999);
                j = gestao.pesquisarFuncionario(nifFuncionario);
                if (j==-1)
                    System.err.println("Numero nif encorrecto ou não existe nehum funcionario com esse nif. ");
                else {
                    funcionario = gestao.obterFuncionario(j);

                    if (funcionario instanceof Tecnico)
                        tecnico = funcionario;
                    else {
                        j = -1;
                        System.err.println("Funcionario com previlegios insuficientes.\n Necessita de ser Tecnico ");
                    }
                }
            } while (j == -1);

            tecnico = gestao.obterFuncionario(j);

            reparacao = new Reparacao(avaria, dataReparacao, descricao, custo, tecnico);

            avaria.getEquipamentoAssociado().adicioarReparacao(reparacao);
            reparacao.getAvaria().setEstadoAvaria(ESTADOAVARIA.reparado);
            gestao.adicionarReparacao(reparacao);
            //System.out.println("Alteracao de estado do equipamento feita com sucesso!");


        }
        if (opcao == 2) {
            avaria.getEquipamentoAssociado().setEstadoEquipamento(ESTADOEQUIPAMENTO.abatido);
            avaria.getEquipamentoAssociado().getDivisao().eliminarEquipamentoDivisao(avaria.getEquipamentoAssociado());
            //avaria.getEquipamentoAssociado().setDivisao(null);

            dataReparacao = Consola.lerData("Insira a data em que a reparacao foi realizada (dd-mm-yyyy): ");
            descricao = Consola.lerString("Insira a descrição da reparação: ");
            custo = Consola.lerFloat("Insira o custo da reparação: ", 000000000, 999999999);

            do {
                nifFuncionario = Consola.lerInt("Insira o nif do técnico que realizou a reparação: ", 000000000,999999999);
                j = gestao.pesquisarFuncionario(nifFuncionario);
                if (j==-1)
                    System.err.println("Numero nif encorrecto ou não existe nehum funcionario com esse nif. ");
                else {
                    funcionario = gestao.obterFuncionario(j);

                    if (funcionario instanceof Tecnico)
                        tecnico = funcionario;
                    else {
                        j = -1;
                        System.err.println("Funcionario com previlegios insuficientes.\n Necessita de ser Tecnico ");
                    }
                }
            } while (j == -1);

            tecnico = gestao.obterFuncionario(j);

            reparacao = new Reparacao(avaria, dataReparacao, descricao, custo, tecnico);

            avaria.getEquipamentoAssociado().adicioarReparacao(reparacao);
            reparacao.getAvaria().setEstadoAvaria(ESTADOAVARIA.irreparavel);
            gestao.adicionarReparacao(reparacao);
            //System.out.println("Alteracao de estado do equipamento feita com sucesso!");
        }
    }

    private static void pesquisarAvaria() {
        int numeroEquipamento, j;
        Equipamento equipamento;

        /*System.out.println("------------------ LISTAGEM EQUIPAMENTOS ------------------");
        System.out.println(gestao.mostrarTodosEquipamentos());
        System.out.println("------------------ FIM LISTAGEM ------------------");*/
        do {

            numeroEquipamento = Consola.lerInt("Número de Inventario do equipamento que pretende consultar: ", 000000000, 999999999);
            j = gestao.pesquisarEquipamento(numeroEquipamento);

            if(j == -1){
                System.out.println("[AVISO] Equipamento não encontrado! Coloque uma da listagem anterior.");
            }
        }while (j == -1);

        equipamento = gestao.obterEquipamento(j);
        System.out.println(equipamento.mostrarAvariasEquipamento());
        //System.out.println(equipamento.mostrarReparacoes());
    }


    //////////////////////////////////////////////TIPOEQUIPAMENTO
    //AdicionarTipo
    public static void adicionarTipoEquipamento( ) {
        String designacao;
        TipoEquipamento tipoEquipamento;

        designacao = Consola.lerString("Indique qual a designação do Tipo de Equipamento: ");
        tipoEquipamento = new TipoEquipamento(designacao);

        gestao.adicionarTipoEquipamento(tipoEquipamento);
        //System.out.println("Tipo de Equipamento Inserido com Sucesso!");
    }

    public static void inserirEquipamento(){

        int numeroIventario,numeroSerie, nifFuncionario, numeroTipo, j;
        String descricao;
        float custo;
        Calendar dataIventario = Calendar.getInstance();
        Equipamento equipamento;
        TipoEquipamento tipoEquipamento;
        Funcionario funcionario;
        Tecnico tecnico;

        do {
            nifFuncionario = Consola.lerInt("Insira o nif do Funcionario:", 000000000,999999999);
            j = gestao.pesquisarFuncionario(nifFuncionario);
            if (j == -1)
                System.err.println("não existem nenhum funcionario com esse nif. ");
            else{
                funcionario = gestao.obterFuncionario(j);

                if (funcionario instanceof Tecnico) {
                    tecnico = (Tecnico) funcionario;

                    do {
                        numeroIventario = Consola.lerInt("Indique o numero de inventário:", 1, Integer.MAX_VALUE);
                        j = gestao.pesquisarEquipamento(numeroIventario);
                        if (j != -1)
                            System.err.println("Já existe um equipamento com esse número");
                    } while (j != -1); //repete se ja existir número

                    descricao = Consola.lerString("Descricao do equipamento: ");
                    numeroSerie = Consola.lerInt("Indique o numero de Serie:", 000000000, 999999999);
                    custo = Consola.lerFloat("Indique qual o custo do equipamento: ", 000000000, 999999999);

                    System.out.println(gestao.mostrarTipos());
                    do {

                        numeroTipo = Consola.lerInt("Numero do Tipo de Equipamento: ", 000000000, 999999999);
                        j = gestao.pesquisaTipo(numeroTipo);

                        if (j == -1) {
                            System.out.println("[AVISO] Tipo de equipamento nao encontrado! coloque uma da Listagem anterior.");
                        }
                    } while (j == -1);

                    tipoEquipamento = gestao.obterTipo(j);

                    equipamento = new Equipamento(descricao, numeroIventario, numeroSerie, custo, dataIventario, tipoEquipamento, tecnico);

                    tipoEquipamento.setTotalEquipamentos(tipoEquipamento.getTotalEquipamentos() + 1);

                    gestao.adicionarEquipamento(equipamento);

                    System.out.println("Equipamento criado com sucesso!");
                }else{
                    //j=-1;
                    System.err.println("Esse Funcionário não é tecnico");
                }
            }
        } while (j == -1); //repete se ja existir número
    }
}
