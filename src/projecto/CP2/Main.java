package projecto.CP2;

import util.Consola;

import java.awt.image.TileObserver;
import java.beans.FeatureDescriptor;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    private static Gestao gestao = new Gestao();
    static Scanner sc = new Scanner(System.in);

    static String[] menuPrincipal = {"1 - Gerir Funcionários",
            "2 - Gerir Divisões",
            "3 - Gerir Tipos Equipamentos",
            "4 - Gerir Equipamentos",
            "5 - Gerir Avarias",
            "6 - Estatisticas",
            "0 - Sair"};

    static String[] menuFunc = {"1 - Inserir Funcionário", "2 - Alterar Funcionário", "3 - Consultar todos Funcionários", "4 - Eliminar Funcionários", "0 - Voltar"};
    static String[] menuAlterarFuncionario = {"1 - Alterar morada", "2 - Alterar numero telefone", "0 - Voltar"};
    static String[] menuDiv = {"1 - Inserir Divisão", "2 - Consultar Divisão", "0 - Voltar"};
    static String[] menuTipo = {"1 - Inserir Tipo Equipamento", "2 - Consultar todos tipos de equipamentos", "0 - Voltar"};
    static String[] menuEq = {"1 - Inserir Equipamento", "2 - Consultar todos equipamentos", "3 - Associar Equipamento a Divisão", "4 - Consultar por Divisão", "0 - Voltar"};
    static String[] menuAv = {"1 - Registar Avaria", "2 - Consultar Avaria", "3 - Alterar estado avaria", "4 - Reparações", "0 - Voltar"};
    static String[] menuEstatisticas = {"1 - Percentagem de equipamentos com avarias no hospital", "2 - ", "3 - ", "4 - ", "0 - Voltar"};

    public static void main(String[] args) {
        int opcao = 0;

        gestao.lerDoFicheiro();

        do {
            System.out.println(gestao.mostrarNumeroDeEquipamentosPorTipo());
            System.out.println("### MENU PRINCIPAL ###");
            mostraMenu(menuPrincipal);
            opcao = lerInteiro("Introduza uma opção: ", 0, 8);
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
                                if (gestao.getNumeroTotalFuncionarios() > 0) {
                                    System.out.println(alterarFuncionario());
                                }else System.out.println("Não existem funcionarios Inseridos.\n ");
                                break;
                            case 3:
                                if (gestao.getNumeroTotalFuncionarios() > 0) {
                                    System.out.println(gestao.mostrarTodosFuncionarios());
                                }else System.out.println("Não existem funcionarios Inseridos.\n ");
                                break;
                            case 4:
                                if (gestao.getNumeroTotalFuncionarios() > 0) {
                                    removerFuncionario();
                                }else System.out.println("Não existem funcionarios Inseridos.\n ");
                                break;
                            default:
                                gestao.gravarParaFicheiro();
                                System.out.println("A Guardar Alterações..\n");
                                System.out.println("A Voltar ao Menu Anterior..");
                                break;
                        }
                    } while (opcao2 != 0);
                    break;
                case 2:
                    int opcao3 = 0;
                    do {
                        System.out.println("### MENU DIVISÃO ###");
                        mostraMenu(menuDiv);
                        opcao3 = lerInteiro("Introduza uma Opção: ", 0, 2);
                        switch (opcao3) {
                            case 1:
                                inserirDivisao();
                                break;
                            case 2:
                                if (gestao.getNumeroTotalDivisoes() > 0) {
                                    pesquisaDivisao();
                                }else System.out.println("Não Existem Divisoes Inseridos.\n ");
                                break;
                            default:
                                gestao.gravarParaFicheiro();
                                System.out.println("A Guardar Alterações..\n");
                                System.out.println("A Voltar ao Menu Anterior..");
                                break;
                        }
                    } while (opcao3 != 0);
                    break;
                case 3://MENU TIPOS EQUIPAMENTO
                    int opcao4 = 0;
                    do {
                        System.out.println("### MENU TIPO EQUIPAMENTO ###");
                        mostraMenu(menuTipo);
                        opcao4 = lerInteiro("Introduza uma Opção: ", 0, 2);
                        switch (opcao4) {
                            case 1:
                                adicionarTipoEquipamento();
                                break;
                            case 2:
                                if (gestao.getNumeroTotalTipoEquipamento() > 0) {
                                    System.out.println(gestao.mostrarTipos());
                                }else System.out.println("Não Existem Tipos de Equipamentos Inseridos.\n ");
                                break;
                            default:
                                gestao.gravarParaFicheiro();
                                System.out.println("A Guardar Alterações..\n");
                                System.out.println("A Voltar ao Menu Anterior..");
                                break;
                        }
                    } while (opcao4 != 0);
                    break;
                    case 4:
                    int opcao5 = 0;
                    do {
                        System.out.println("### MENU EQUIPAMENTO ###");
                        mostraMenu(menuEq);
                        opcao5 = lerInteiro("Introduza uma opção: ", 0, 4);
                        switch (opcao5) {
                            case 1:
                                if (gestao.getNumeroTotalTipoEquipamento() > 0) {
                                    inserirEquipamento();
                                }else System.out.println("Precissa de criar um tipo de equipamento antes de criar um equipamento.\n ");
                                break;
                            case 2:
                                if (gestao.getNumeroTotalTipoEquipamento() > 0) {
                                    System.out.println(gestao.mostrarTodosEquipamentos());
                                }else System.out.println("Não existem equipamentos Inseridos.\n ");
                                break;
                            case 3:
                                if (gestao.getNumeroTotalTipoEquipamento() > 0) {
                                    associarEquipamentoDivisao();
                                }else System.out.println("Não existem equipamentos Inseridos.\n ");
                                break;
                            case 4:
                                if (gestao.getNumeroTotalTipoEquipamento() > 0) {
                                    consultarEquipamentosPorDivisao();
                                }else System.out.println("Não existem equipamentos Inseridos.\n ");
                                break;
                            default:
                                gestao.gravarParaFicheiro();
                                System.out.println("A Guardar Alterações..\n");
                                System.out.println("A voltar ao menu anterior..\n");
                                break;
                        }
                    } while (opcao5 != 0);
                    break;
                case 5:
                    int opcao6 = 0;
                    do {
                        System.out.println("### MENU AVARIAS ###");
                        mostraMenu(menuAv);
                        opcao6 = lerInteiro("Introduza uma opção: ", 0, 4);
                        switch (opcao6) {
                            case 1:
                                if (gestao.getNumeroTotalEquipamentos() > 0) {
                                    criarAvaria();
                                }else System.err.println("Não existem Equipamentos Inseridos.\n ");
                                break;
                            case 2:
                                if (gestao.getNumeroTotalAvarias() > 0) {
                                    pesquisarAvaria();
                                }else System.err.println("Não existem Avarias Inseridas.\n ");
                                break;
                            case 3:
                                if (gestao.getNumeroTotalAvarias() > 0) {
                                    alterarEstadoAvaria();
                                }else System.err.println("Não existem Avarias Inseridas.\n ");
                                break;
                            case 4:
                                if (gestao.getNumeroTotalAvarias() > 0) {
                                    pesquisarReparacao();
                                }else System.err.println("Não existem Avarias Inseridas.\n ");
                                break;
                            default:
                                gestao.gravarParaFicheiro();
                                System.out.println("A Guardar Alterações..\n");
                                System.out.println("A voltar ao menu anterior..\n");
                                break;
                        }
                    } while (opcao6 != 0);
                    break;
                case 6:
                    int opcao8 = 0;
                    do {
                        System.out.println("### MENU ESTATISTICAS ###");
                        mostraMenu(menuEstatisticas);
                        opcao8 = lerInteiro("Introduza uma opção: ", 0, 4);
                        switch (opcao8) {
                            case 1:
                                if (gestao.getNumeroTotalAvarias() > 0) {
                                    gestao.percentagemAvarias();
                                }else System.err.println("Não existem Avarias Inseridas.\n ");
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("A voltar ao menu anterior..\n");
                                break;
                        }
                    } while (opcao8 != 0);
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
        int nifFuncionario, telefone, j, menuTipoFuncionario;
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

    public static Funcionario alterarFuncionario() {
        int nif, pos, telefone;
        Funcionario f;
        String morada;
        int opcao = 0;
        System.out.println(gestao.mostrarTodosFuncionarios());
        nif = Consola.lerInt("Indique o Nif do funcionario: ", 000000000, 999999999);
        pos = gestao.pesquisarFuncionario(nif);
        f = gestao.obterFuncionario(pos);
        if (pos == -1) {
            System.err.println("Não existe nenhum utilizador com esse nif, ou nif introduzido incorrectamente. ");
        } else {
            do {
                System.out.println("### MENU ALTERAR FUNCIONARIO ###");
                mostraMenu(menuAlterarFuncionario);
                opcao = lerInteiro("Introduza uma opção: ", 0, 2);
                switch (opcao) {
                    case 1:
                        morada = Consola.lerString("Indique a nova morada do funcionario: ");
                        f.setMorada(morada);
                        f =  new Funcionario(nif,f.nome,morada,f.telefone,f.email,f.dataNascimento,f.habilitacoes);
                        break;
                    case 2:
                        telefone = Consola.lerInt("Indique o novo numero de telefone do funcionario: ", 000000000, 999999999);
                        f.setTelefone(telefone);
                        f =  new Funcionario(nif,f.nome,f.morada,telefone,f.email,f.dataNascimento,f.habilitacoes);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } while (pos == -1);
        }
        return f;
    }

    public static void removerFuncionario() {
        int nifFuncionario, j;
        do {
            System.out.println(gestao.mostrarTodosFuncionarios());
            nifFuncionario = Consola.lerInt("Insira o nif do funcionario que pretende Eleminar: ", 000000000, 999999999);
            j = gestao.pesquisarFuncionario(nifFuncionario);
            if (j != -1){
                gestao.removerFuncionario(j);
                System.err.println("Funcionario removido");
                break;
            }else{
                System.err.println("O funcionario com esse nif não existe ou ja foi eliminado");
            }
        } while (j == -1);
        System.out.println("Funcionário removido com sucesso!");
    }
///////////////////////////////////////////////EQUIPAMENTO
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
            nifFuncionario = Consola.lerInt("Insira o nif do Funcionario: ", 000000000,999999999);
            j = gestao.pesquisarFuncionario(nifFuncionario);
            if (j == -1)
                System.err.println("não existem nenhum funcionario com esse nif. ");
            else{
                funcionario = gestao.obterFuncionario(j);
                if (funcionario instanceof Tecnico) {
                    tecnico = (Tecnico) funcionario;
                    do {
                        numeroIventario = Consola.lerInt("Indique o numero de inventário: ", 000000000, 999999999);
                        j = gestao.pesquisarEquipamento(numeroIventario);
                        if (j != -1)
                            System.err.println("Já existe um equipamento com esse número. ");
                    } while (j != -1); //repete se ja existir número
                    descricao = Consola.lerString("Descricao do equipamento: ");
                    numeroSerie = Consola.lerInt("Indique o numero de Serie: ", 000000000, 999999999);
                    custo = Consola.lerFloat("Indique qual o custo do equipamento: ", 000000000, 999999999);
                    System.out.println(gestao.mostrarTipos());
                    do {
                        numeroTipo = Consola.lerInt("Numero do Tipo de Equipamento: ", 000000000, 999999999);
                        j = gestao.pesquisaTipo(numeroTipo);
                        if (j == -1) {
                            System.out.println("Tipo de equipamento nao encontrado. ");
                        }
                    } while (j == -1);
                    tipoEquipamento = new TipoEquipamento(descricao);
                    //tipoEquipamento = gestao.obterTipo(j);
                    equipamento = new Equipamento(descricao, numeroIventario, numeroSerie, custo, dataIventario, tipoEquipamento, tecnico);
                    tipoEquipamento.setTotalEquipamentos(tipoEquipamento.getTotalEquipamentos() + 1);
                    gestao.adicionarEquipamento(equipamento);
                    System.out.println("Equipamento criado com sucesso! ");
                }else{
                    //j=-1;
                    System.err.println("Esse Funcionário não é tecnico ");
                }
            }
        } while (j == -1); //repete se ja existir número
    }

    private static void associarEquipamentoDivisao() {
        int j, numeroIventario;
        String designacao;
        Divisao divisao;
        Equipamento equipamento;

        System.out.println(gestao.mostrarDesignacaoDivisoes());
        do {
            designacao = Consola.lerString("Insira a Designacao da Divisao que pretende associar o Equipamento: ");
            j = gestao.procurarDesignacaoNasDivisoes(designacao);

            if(j == -1){
                System.out.println("Divisao nao encontrada.\n");
            }
        }while (j == -1);

        divisao = gestao.obterDivisao(j);
        System.out.println(gestao.mostrarTodosEquipamentos());
        do {
            numeroIventario = Consola.lerInt("Numero de Inventario do equipamento que pretende associar: ", 000000000, 999999999);
            j = gestao.pesquisarEquipamento(numeroIventario);

            if(j == -1){
                System.out.println("Equipamento não encontrado.\n");
            }
        }while (j == -1);

        equipamento = gestao.obterEquipamento(j);
        equipamento.setDivisao(divisao);
        divisao.adicionarEquipamentoDivisao(equipamento);
        System.out.println("Equipamento associado com sucesso.\n");
    }

    private static void consultarEquipamentosPorDivisao(){
        int j;
        String designacao;
        Divisao divisao;
        System.out.println(gestao.mostrarDesignacaoDivisoes());
        do {
            designacao = Consola.lerString("Designacao da divisao a consultar: ");
            j = gestao.procurarDesignacaoNasDivisoes(designacao);
            if(j == -1){
                System.out.println("Divisao nao encontrada.\n");
            }
        }while (j == -1);
        divisao = gestao.obterDivisao(j);
        System.out.println(divisao.mostrarEquipamentosDivisao());
    }

    //////////////////////////////////////////////TIPOEQUIPAMENTO
    //AdicionarTipo
    public static void adicionarTipoEquipamento( ) {
        String designacao;
        TipoEquipamento tipoEquipamento;
        designacao = Consola.lerString("Indique qual a designação do Tipo de Equipamento: ");
        tipoEquipamento = new TipoEquipamento(designacao);
        gestao.adicionarTipoEquipamento(tipoEquipamento);
        System.out.println("Tipo de Equipamento Inserido\n");
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
            System.out.println(gestao.mostrarTodasDivisoes());
            designacao = Consola.lerString("Indique a designação da divisão: ");
            j = gestao.procurarDesignacaoNasDivisoes(designacao);
                if (j == -1)
                    System.err.println("Não existe nenhuma divisão com essa designação.  ");
        }while (j == -1);
            divisao = gestao.obterDivisao(j);
            System.out.println(divisao);
    }

    //////////////////////////////////////////////AVARIA
    public static void criarAvaria() {
        String descricao;
        int numeroInventario, nifFuncionario, j, n;
        Equipamento equipamento;
        Funcionario funcionario;
        Avaria avaria;
        do {
            System.out.println(gestao.mostrarTodosEquipamentos());
            numeroInventario = Consola.lerInt("Insira o numero de inventario do equipamento avariado: ", 000000000, 999999999);
            j = gestao.pesquisarEquipamento(numeroInventario);
            if (j == -1) {
                System.out.println("Nenhum equipamento encontrado com esse numero de inventario. ");
            }
        }while (j == -1) ;
        equipamento = gestao.obterEquipamento(j);
        do {
            nifFuncionario = Consola.lerInt("Insira o nif do funcionário:", 000000000, 999999999);
            n = gestao.pesquisarFuncionario(nifFuncionario);
            if (n == -1)
                System.err.println("Numero incorrecto ou não existe nehum funcionario com esse numero");
        } while (n == -1);
        descricao = Consola.lerString("Insira a descricao da avaria: ");
        System.out.println("Avaria inserida com Sucesso!");
        funcionario = gestao.obterFuncionario(j);
        avaria = new Avaria(equipamento, descricao, funcionario);
        equipamento.adicioarAvariaEquipamento(avaria);
        equipamento.setEstadoEquipamento(ESTADOEQUIPAMENTO.indisponivel);
        gestao.criarAvaria(avaria);
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
            System.out.println(gestao.mostrarTodasAvarias());
            idAvaria = Consola.lerInt("Indique qual o id da Avaria a que pretende mudar o estado: ", 000000000, 999999999);
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
            System.out.println("2- Irreparavél - abater ");
        } while (opcao !=1 && opcao != 2);
        if (opcao == 1) {
            avaria.getEquipamentoAssociado().setEstadoEquipamento(ESTADOEQUIPAMENTO.disponivel);
            dataReparacao = Consola.lerData("Insira a data em que a reparacao foi realizada (dd-mm-yyyy): ");
            descricao = Consola.lerString("Insira a descrição da reparação: ");
            custo = Consola.lerFloat("Insira o custo da reparação: ", 000000000, 999999999);
            do {
                System.out.println(gestao.mostrarTodosFuncionarios());
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
            System.out.println("Estado do equipamento alterado. ");
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
            System.out.println("Estado do equipamento alterado. ");
        }
    }

    private static void pesquisarAvaria() {
        int numeroEquipamento, j;
        Equipamento equipamento;
        do {
            numeroEquipamento = Consola.lerInt("Número de Inventario do equipamento que pretende consultar: ", 000000000, 999999999);
            j = gestao.pesquisarEquipamento(numeroEquipamento);
            if(j == -1){
                System.out.println("Equipamento não encontrado!");
            }
        }while (j == -1);
        equipamento = gestao.obterEquipamento(j);
        System.out.println(equipamento.mostrarAvariasEquipamento());
    }

    private static void pesquisarReparacao() {
        int numeroEquipamento, j;
        Equipamento equipamento;
        do {
            numeroEquipamento = Consola.lerInt("Número de Inventario do equipamento que pretende consultar: ", 000000000, 999999999);
            j = gestao.pesquisarEquipamento(numeroEquipamento);
            if(j == -1){
                System.out.println("Equipamento não encontrado!");
            }
        }while (j == -1);
        equipamento = gestao.obterEquipamento(j);
        System.out.println(equipamento.mostrarReparacoes());
    }
}
