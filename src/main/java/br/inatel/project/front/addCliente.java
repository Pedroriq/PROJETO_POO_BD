package br.inatel.project.front;

import br.inatel.project.data.auxData;
import br.inatel.project.produtos.newCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Classe responsavel por inserir um novo cliente ao banco
public class addCliente extends JFrame {
    private JLabel nomeLabel;
    private JTextField nomeTextField;
    private JTextField enderecoTextField;
    private JLabel enderecoLabel;
    private JButton addClienteButton;
    private JPanel addClientePanel;
    private JButton voltaButton;

    //construtor dos cliente extendido do JFrame
    public addCliente(String title, String senha){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(addClientePanel);
        this.pack();


        //ação ao clica no botão de adicionar cliente
        addClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Insererindo novo cliente de acordo com os valores recebindos no text field
                newCliente cliente = new newCliente(nomeTextField.getText(), enderecoTextField.getText());
                auxData dados = new auxData();
                //chamando a funçaõ de inserir clientes na classe de dados
                boolean close = dados.insertCliente(cliente,senha);
                //fechando janela após adição bem sucedida
                if (close){
                    setVisible(false);
                }
                else
                    System.out.println("ERROR");
            }
        });
        //para voltar para o menu
        voltaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

}
