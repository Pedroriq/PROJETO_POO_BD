package br.inatel.project.produtos;

public class mostraInfoVenda {

    //classe responsavel por armazenar as informações de venda com Getters e Setters
    private int idVenda;
    private float valorTotalVenda;
    private String vendaProdVenda;
    private int vendedorVenda;
    private int clienteVenda;

    public mostraInfoVenda(int idVenda, float valorTotalVenda, String vendaProdVenda, int vendedorVenda, int clienteVenda){
        this.idVenda = idVenda;
        this.valorTotalVenda = valorTotalVenda;
        this.vendaProdVenda = vendaProdVenda;
        this.vendedorVenda = vendedorVenda;
        this.clienteVenda = clienteVenda;
    }

    public float getValorTotalVenda() {
        return valorTotalVenda;
    }

    public int getClienteVenda() {
        return clienteVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public String getVendaProdVenda() {
        return vendaProdVenda;
    }

    public int getVendedorVenda() {
        return vendedorVenda;
    }

    public void setClienteVenda(int clienteVenda) {
        this.clienteVenda = clienteVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setValorTotalVenda(float valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }

    public void setVendedorVenda(int vendedorVenda) {
        this.vendedorVenda = vendedorVenda;
    }

    public void setVendaProdVenda(String vendaProdVenda) {
        this.vendaProdVenda = vendaProdVenda;
    }
}
