package br.inatel.project.produtos;

//classe responsavel por armazenar as informações de produto
public class newProduto {

    private int id;
    private String produto;
    private float preco;
    private int estoque;

    public newProduto (int id, String produto, float preco, int estoque){
        this.id = id;
        this.produto = produto;
        this.preco = preco;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public String getProduto() {
        return produto;
    }

    public float getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setEstoque(int estoque) {

    }
}
