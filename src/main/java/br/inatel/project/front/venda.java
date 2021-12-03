package br.inatel.project.front;

import br.inatel.project.data.auxData;
import br.inatel.project.produtos.newCliente;
import br.inatel.project.produtos.newProduto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class venda extends JFrame {
    private JPanel vendaPannel;
    private JLabel idProduto;
    private JTextField idTextField;
    private JLabel qtd;
    private JTextField qtdTextField;
    private JButton calcButton;
    private JButton vendaButton;
    private JLabel resultado;
    private JTextField vendedorTextField;
    private JLabel vendedor;
    private JLabel clienteLabel;
    private JTextField clienteTextField;
    private JLabel falhaCliente;
    private JButton voltarButton;
    private static newProduto update;
    private auxData dados = new auxData();
    private float resultadoD;
    private static newCliente updateCliente;

    public venda (String title, String senha) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(vendaPannel);
        this.pack();


        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<newProduto> produtos = dados.researchProduto(senha);
                produtos.forEach(linha -> {
                    if (linha.getId() == Float.parseFloat(idTextField.getText())) {
                        update = linha;
                        resultadoD = linha.getPreco() * (Float.parseFloat(qtdTextField.getText()));
                        String resultadoString = String.valueOf(resultadoD);
                        resultado.setText(resultadoString);
                    }

                });
            }
        });
        vendaButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                dados.updateVendaEstoq(update, senha, Integer.parseInt(qtdTextField.getText()));
                ArrayList<newCliente> clientes = dados.researchCliente(senha);
                clientes.forEach(linha -> {
                    if ((linha.getNumCliente() == Integer.parseInt(clienteTextField.getText())) || (linha.getNumCliente() == -1) ) {
                        updateCliente = linha;
                        dados.insertVenda(update, senha, resultadoD, Integer.parseInt(vendedorTextField.getText()), Integer.parseInt(clienteTextField.getText()));
                        setVisible(false);
                    }
                });

            }

    });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }}




