package br.inatel.project.produtos;

//classe responsavel por armazenar as informações de vendedor
public class newVendedor {

    private String nome;
    private String cpf;
    private int idVendedor;

    public newVendedor (String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }
}
