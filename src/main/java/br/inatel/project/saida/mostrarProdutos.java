package br.inatel.project.saida;

import br.inatel.project.produtos.newCliente;
import br.inatel.project.produtos.newProduto;

import javax.swing.*;
import java.util.ArrayList;

public class mostrarProdutos {
    public mostrarProdutos(ArrayList<newProduto> produto){

        produto.forEach(linha -> {
            System.out.println("ID: " + String.valueOf(linha.getId()));
            System.out.println("PRODUTO: " + linha.getProduto());
            System.out.println("ESTOQUE: " + linha.getEstoque());
            System.out.println("PREÇO: " +  linha.getPreco());
            System.out.println(" ----------------------------------");
        });

    }


}
