package br.inatel.project.produtos;

//classe responsavel por armazenar as informações de cliente
public class newCliente {

    private String nome;
    private String endereco;
    private int numCadastro;


    public newCliente(int numCadastro,String nome, String endereco){
        this.numCadastro = numCadastro;
        this.nome = nome;
        this.endereco = endereco;
    }

    public newCliente(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }


    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getNumCliente() {
        return numCadastro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setnumCadastro(int numCliente) {
        this.numCadastro = numCliente;
    }
}
