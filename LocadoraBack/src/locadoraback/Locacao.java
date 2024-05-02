package locadoraback;

import java.util.Date;

public class Locacao {

    private int     codCliente;
    private int     codVeiculo;
    private Date    dataLocacao;
    private Date    dataReserva;
    private Date    dataDevolucao;
    private int     kmInicial;
    private int     kmFinal;
    private boolean danosVeiculo;

    @Override
    public String toString() {
        return    " codCliente="    + codCliente 
                + " codVeiculo="    + codVeiculo 
                + " dataLocacao="   + dataLocacao 
                + " dataReserva="   + dataReserva 
                + " dataDevolucao=" + dataDevolucao 
                + " kmInicial="     + kmInicial 
                + " kmFinal="       + kmFinal 
                + " danosVeiculo="  + danosVeiculo;
    }

    
//area de getters e setters
    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodVeiculo() {
        return codVeiculo;
    }

    public void setCodVeiculo(int codVeiculo) {
        this.codVeiculo = codVeiculo;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(int kmInicial) {
        this.kmInicial = kmInicial;
    }

    public int getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(int kmFinal) {
        this.kmFinal = kmFinal;
    }

    public boolean isDanosVeiculo() {
        return danosVeiculo;
    }

    public void setDanosVeiculo(boolean danosVeiculo) {
        this.danosVeiculo = danosVeiculo;
    }
    
    
}
