package br.inatel.project.saida;

import br.inatel.project.produtos.newCliente;
import java.util.ArrayList;

//classes responsaveis para mostrar os itens desejados no terminal
public class mostrarClientes  {
    public mostrarClientes(ArrayList<newCliente> cliente) {
        cliente.forEach(linha -> {
            System.out.println("ID: " + linha.getNumCliente());
            System.out.println("NOME: " + linha.getNome());
            System.out.println("ENDERECO: " + linha.getEndereco());
            System.out.println(" ----------------------------------");
        });

    }
}
