/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import vue.Menu;

/**
 * Creation du main de la partie graphique, qui permet de lancer le jeu
 */
public class Projet_Final {

    public static void main(String[] args) throws IOException {
       Menu monMenu = new Menu();
       monMenu.setVisible(true);
    }
}
