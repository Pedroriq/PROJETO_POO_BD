package br.inatel.project.front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import br.inatel.project.data.auxData;
import br.inatel.project.produtos.newProduto;


public class addProduto extends JFrame{


    private JPanel addProdutoPanel;
    private JLabel ID;
    private JTextField idTextField;
    private JLabel PRODUTO;
    private JTextField produtoTextField;
    private JLabel PRECO;
    private JTextField precoTextField;
    private JButton salvarButton;
    private JLabel ESTOQUE;
    private JTextField estoqueTextField;
    private JButton updateEstoque;
    private JButton voltarButton;
    private newProduto update;

    public addProduto(String title, String senha){
        super (title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(addProdutoPanel);
        this.pack();


        //botão para salvar novo item na aba produtos
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newProduto produto = new newProduto(Integer.parseInt(idTextField.getText()), produtoTextField.getText(),Float.parseFloat(precoTextField.getText()),Integer.parseInt(estoqueTextField.getText()));
                auxData dados = new auxData();
                boolean close = dados.insertProduto(produto,senha);
                if (close){
                    setVisible(false);
                }
                else
                    System.out.println("ERROR");
            }
        });

        //botão para realizar o update de estoque
        updateEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auxData dados = new auxData();
                ArrayList<newProduto> produtos = dados.researchProduto(senha);
                produtos.forEach(linha-> {
                    if (linha.getId() == Float.parseFloat(idTextField.getText())){
                            update = linha;
                           boolean close = dados.updateEstoque(update, senha, Integer.parseInt(estoqueTextField.getText()));
                           if (close){
                               setVisible(false);
                           }
                            else
                               System.out.println("ERROR");
                    }
                    });
                };
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    };
}
