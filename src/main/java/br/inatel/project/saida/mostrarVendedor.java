package br.inatel.project.saida;

import br.inatel.project.produtos.newVendedor;
import java.util.ArrayList;

public class mostrarVendedor {

        public mostrarVendedor(ArrayList<newVendedor> vendedor){

            vendedor.forEach(linha -> {
                System.out.println("ID: " + linha.getIdVendedor());
                System.out.println("NOME: " + linha.getNome());
                System.out.println("CPF: " + linha.getCpf());
                System.out.println(" ----------------------------------");
            });
        }
}


