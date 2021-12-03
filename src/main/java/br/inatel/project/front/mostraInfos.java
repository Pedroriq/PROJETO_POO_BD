package br.inatel.project.front;

import br.inatel.project.data.auxData;
import br.inatel.project.produtos.mostraInfoVenda;
import br.inatel.project.produtos.newCliente;
import br.inatel.project.produtos.newProduto;
import br.inatel.project.produtos.newVendedor;
import br.inatel.project.saida.mostrarClientes;
import br.inatel.project.saida.mostrarProdutos;
import br.inatel.project.saida.mostrarVendas;
import br.inatel.project.saida.mostrarVendedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class mostraInfos extends JFrame {
    private JPanel mostraPanel;
    private JButton voltarButton;
    private JButton vendedorButton;
    private JButton clienteButton;
    private JButton vendaButton;
    private JButton produtoButton;
    private JCheckBox caixaCheckBox;

    public mostraInfos(String title, String senha) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mostraPanel);
        this.pack();

        //menu responsavel para mostrar as informações das tabelas nos banco de dados utilizando o metodo de ArrayList
        vendedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auxData dados = new auxData();
                ArrayList<newVendedor> vendedores = dados.researchVendedor(senha);
                mostrarVendedor vendedor = new mostrarVendedor(vendedores);
            }

        });
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auxData dados = new auxData();
                ArrayList<newCliente> clientes = dados.researchCliente(senha);
                mostrarClientes cliente = new mostrarClientes(clientes);

            }
        });
        produtoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auxData dados = new auxData();
                ArrayList<newProduto> produtos = dados.researchProduto(senha);
                mostrarProdutos produto = new mostrarProdutos(produtos);
            }
        });


        vendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auxData dados = new auxData();
                ArrayList<mostraInfoVenda> mostraInfoVendas = dados.researchVenda(senha);
                mostrarVendas venda = new mostrarVendas(mostraInfoVendas);
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
