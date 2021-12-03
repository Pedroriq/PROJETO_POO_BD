package br.inatel.project.saida;

import br.inatel.project.produtos.mostraInfoVenda;
import br.inatel.project.produtos.newProduto;

import javax.swing.*;
import java.util.ArrayList;

public class mostrarVendas {
;

    public mostrarVendas(ArrayList<mostraInfoVenda> venda){

        venda.forEach(linha -> {
            System.out.println("ID: " + linha.getIdVenda());
            System.out.println("VALOR TOTAL DA VENDA: " + linha.getValorTotalVenda());
            System.out.println("PRODUTO: " + linha.getVendaProdVenda());
            System.out.println("ID VENDEDOR: " + linha.getVendedorVenda());
            System.out.println("ID DO CLIENTE: " + linha.getClienteVenda());
            System.out.println(" ----------------------------------");
        });

    }
}
