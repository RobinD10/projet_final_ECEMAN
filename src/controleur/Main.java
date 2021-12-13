/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;



import java.io.*;
import java.util.InputMismatchException;
import static controleur.Play.*;
import static controleur.Play.startMenu;

public class Main {

    //COLOR
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) throws IOException {

        try {
            timer.start();              // Lancement du timer
            startMenu();                // Lancement du Menu
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED+"Vous n'avez pas sélectionné la bonne touche"+ANSI_RESET);
            startMenu();
        }
    }
}