package br.inatel.project.front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuInterfaceUser extends JFrame{

    private JPanel menuPanel;
    private JButton addProduto;
    private JButton vendaButton;
    private JButton addVendedorButton;
    private JButton clienteButton;
    private JButton mostrarInfoButton;

    //menu responsavel por seleção das ações disponiveis
    public menuInterfaceUser(String title, String senha){
        super (title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(menuPanel);
        this.pack();


        addProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addProduto = new addProduto("Store Control - ADD PRODUTO",senha);
                addProduto.setVisible(true);
            }
        });
        vendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame venda = new venda ("Store Control - VENDA", senha);
                venda.setVisible(true);
            }
        });

        addVendedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addVendedor = new addVendedor ("Store Control - ADD VENDEDOR", senha);
                addVendedor.setVisible(true);
            }
        });
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addCliente = new addCliente ("Store Control - ADD CLIENTE", senha);
                addCliente.setVisible(true);
            }
        });
        mostrarInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mostraInfo = new mostraInfos("Store Control - INFORMAÇÕES",senha);
                mostraInfo.setVisible(true);
            }
        });
    };

}

