package br.inatel.project.principal;

import br.inatel.project.front.InterfaceUser;

import javax.swing.*;

//classe responsavel por chamar a primeira ação de senha
public class Principal  {

    public static void main(String[] args){
        JFrame frame = new InterfaceUser("Store Control - LOGIN");
        frame.setVisible(true);
    }
}
