package br.inatel.project.front;

import br.inatel.project.data.Database;
import br.inatel.project.data.auxData;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceUser extends JFrame{
    private JPanel loginPanel;
    private JTextField acessoBanco;
    private JLabel bancoLabel;
    private JButton acessoBotao;
    private JLabel result;
    private boolean resultaDaConex;

    //primeira interface para adquirir a senha do usuario para realizar as conexões
    public InterfaceUser(String title){
        super (title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(loginPanel);
        this.pack();
        acessoBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auxData b1 = new auxData();
                resultaDaConex = b1.connect(acessoBanco.getText());
                if (resultaDaConex) {
                    result.setText("Success");
                    JFrame menu = new menuInterfaceUser("Store Control - MENU",acessoBanco.getText());
                    menu.setVisible(true);
                    setVisible(false);
                }
                else
                    result.setText("Erro na conexão");
            }
        });
    }

}
