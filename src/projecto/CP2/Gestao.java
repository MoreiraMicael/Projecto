package projecto.CP2;

import util.Consola;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Gestao {
    private ArrayList<TipoEquipamento> tipos = new ArrayList<>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Divisao> divisoes = new ArrayList<>();
    private ArrayList<Equipamento> equipamentos= new ArrayList<>();
    private ArrayList<Avaria> avarias = new ArrayList<>();
    private ArrayList<Reparacao> reparacoes = new ArrayList<>();


    //AdicionarTipo
    public void adicionarTipo(TipoEquipamento te)
    {
        te.setNumero(tipos.size()+1);
        tipos.add(te);
    }

    //MostrarTudo
    public String mostrarTipos(){
        StringBuilder str =new StringBuilder();
        for (int i=0; i<tipos.size();i++){
            str.append(tipos.get(i)).append("\n");
        }
        return str.toString();
    }

    //ObterElemento
    public TipoEquipamento obterTipo(int pos){
        return tipos.get(pos);
    }

    //getTotalElementosLista
    public int getTotalTipos(){
        return tipos.size();
    }

    //Pesquisa por campo unico.
    public int pesquisaTipo (int numero)
    {
        for (int i = 0; i < tipos.size(); i++)
        {
            if (tipos.get(i).getNumero()==numero)
            {
                return i;
            }
        }
        return -1;
    }

    /////////////////////////////////////////////Funcionarios

    public void inserirFuncionario(Funcionario funcionario)
    {
        //Funcionario funcionario1 = new Funcionario (nif, nome, morada, telefone, email, dataNascimento, habilitacoes);

    }

    public static void inserirFuncionario() {
        int nif, telefone, pos;
        String nome, morada, habilitacoes, email;
        Calendar dataNascimento = new GregorianCalendar();
        int errodn = 0, errode = 0;

        nif = Consola.lerInt("Indique o nif do funcionario: ", 000000000, 999999999);
        nome = Consola.lerString("Indique o nome do funcionario: ");
        morada = Consola.lerString("Indique a morada do funcionario: ");
        telefone = Consola.lerInt("Indique o nif do funcionario: ", 000000000, 999999999);
        email = Consola.lerString("Indique a morada do funcionario: ");
        //dataNascimento = Consola.lerData("Indique a data de nascimento do funcionario: ");
        habilitacoes = Consola.lerString("Indique as habilitações do funcionario: ");


        do {
            errodn = 0;
            try {
                nif = Consola.lerInt("Indique o nif do funcionario", 000000000, 999999999);
                dataNasc.setTime(formato.parse(dataN));
            } catch (ParseException e) {
                errodn = 1;
                System.err.println("Data de nascimento com formato inválido!");
            }
        } while (errodn == 1);

        do {
            errodn = 0;
            try {
                dataN = Consola.lerString("Indique a data de nascimento do aluno (dd-mm-yyyy): ");
                dataNasc.setTime(formato.parse(dataN));
            } catch (ParseException e) {
                errodn = 1;
                System.err.println("Data de nascimento com formato inválido!");
            }
        } while (errodn == 1);

        do {
            System.out.println(grh.mostrarCursos());
            numeroC = Consola.lerInt("Indique o número do curso: ", 1, Integer.MAX_VALUE);
            pos = grh.pesquisarCurso(numeroC);
            if (pos == -1)
                System.out.println("Curso não existe!");
        }while(pos==-1);
        Curso c = grh.obterCurso(pos);
        Aluno a = new Aluno(numero, nome, morada, dataNasc, dataEntrada,c);
        if (a.validarIdade()) {
            grh.adicionarAluno(a);
            System.out.println("Aluno introduzido com sucesso!");
            c.setNumAlunos(c.getNumAlunos()+ 1);
        } else {
            System.err.println("Aluno com idade inválida!");
        }

    }

    //MostrarTudo
    public String mostrarFuncionarios(){
        StringBuilder str =new StringBuilder();
        for (int i=0; i<funcionarios.size();i++){
            str.append(funcionarios.get(i)).append("\n");
        }
        return str.toString();
    }
}
