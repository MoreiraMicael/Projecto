package projecto.CP2;

public class TotalAvariasAno {
    int ano;
    ESTADOAVARIA estadoavaria;
    int numeroAvarias;

    public TotalAvariasAno(int ano, ESTADOAVARIA estadoavaria, int numeroAvarias) {
        this.ano = ano;
        this.estadoavaria = estadoavaria;
        this.numeroAvarias = numeroAvarias;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public ESTADOAVARIA getEstadoavaria() {
        return estadoavaria;
    }

    public void setEstadoavaria(ESTADOAVARIA estadoavaria) {
        this.estadoavaria = estadoavaria;
    }

    public int getNumeroAvarias() {
        return numeroAvarias;
    }

    public void setNumeroAvarias(int numeroAvarias) {
        this.numeroAvarias = numeroAvarias;
    }
}
