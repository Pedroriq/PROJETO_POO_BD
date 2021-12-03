package br.inatel.project.front;

import br.inatel.project.data.auxData;
import br.inatel.project.produtos.newVendedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addVendedor extends JFrame {
    private JTextField nomeTextField;
    private JLabel nomeLabel;
    private JTextField cpfTextField;
    private JButton addVendedorButton;
    private JPanel addVendedorPannel;
    private JLabel cpfLabel;
    private JButton voltarButton;
    private JLabel checkLabel;

    public addVendedor(String title, String passaword){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(addVendedorPannel);
        this.pack();


        addVendedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             newVendedor vendedor = new newVendedor(nomeTextField.getText(), cpfTextField.getText());
             auxData dados = new auxData();
             boolean close = dados.insertVendedor(vendedor,passaword);
             if(close){
                 setVisible(false);
             }
             else{
                 checkLabel.setText("ERROR");
             }


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
