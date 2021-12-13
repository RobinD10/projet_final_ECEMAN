/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

/**
 * Creation de la fenetre Reset
 */
public class Regles extends JFrame {
    
    /**
     * On cree chacun des objets de notre menu
     */
    private JButton boutonFermer = new JButton();
    private JLabel labelTitre = new JLabel();
    private JTextArea texte = new JTextArea();
    
    public Regles(){                //Constructeur de la fenetre Reset

        CardLayout cardL = new CardLayout();
        JPanel content = new JPanel();
    
    /**
     * On definit les caracteristiques de notre JFrame (taille...)
     */
        setSize(681, 467);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0d, 0d, 681d, 467d, 25d, 25d));
                   
        JPanel pan1 = new JPanel();
        pan1.setBackground(new Color (102, 204, 255)); 
        content.add(pan1);
        content.setLayout(cardL);
    
    /**
    * On definit des caracteristiques à notre boutonFermer (texte, police, couleur...)
    */
        boutonFermer.setFont(new Font("Microsoft Sans Serif", 0, 14));
        boutonFermer.setForeground(new Color(0, 0, 0));
        boutonFermer.setText("Fermer");
        boutonFermer.setBorder(null);     
        boutonFermer.setBackground(new Color(250, 250, 250));
        boutonFermer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {          //On lui affecte une action
                boutonFermerActionPerformed(e);
            }
        });

    /**
    * On definit des caracteristiques à notre labelTitre (texte, police, couleur...)
    */
        labelTitre.setFont(new Font("Tahoma", 0, 24));
        labelTitre.setForeground(Color.red);
        labelTitre.setText("Règle du jeu :");
     
    /**
    * On definit des caracteristiques à notre texte (texte, police, couleur...)
    * Et on ecrit les regles du jeu
    */    
        texte.setColumns(20);
        texte.setRows(5);
        texte.setText("Le but du jeu est de déplacer le personnage jusqu'à la porte de sortie tout en \nrecouvrant chacun des blocs de glace. \n\nPour déplacer le personnage, il suffit d'utilser les lettres : \n\t- Q pour aller à gauche\n\t- S pour descendre\n\t- D pour aller à droite\n\t- Z pour monter\n\n ATTENTION : Sans potion de légèreté, une fois la case passé impossible d'y\n retourner, sous peine de perdre une vie. Vous avez 3 vies pour finir le niveau.");
        texte.setFont(new Font("Microsft Sans Serif", 3, 14));
        texte.setOpaque(false);
        texte.setEditable(false);

    /**
    * On ajoute tous les objets crees à notre panel content
    * Et on definit la taille et la position de chacun des objets
    */
        getContentPane().add(texte);
        texte.setBounds(70, 120, 600, 250);
        
        getContentPane().add(labelTitre);
        labelTitre.setBounds(270, 20, 160, 60);
        
        getContentPane().add(boutonFermer);
        boutonFermer.setBounds(280, 400, 130, 40);
        
        getContentPane().add(content, BorderLayout.CENTER);        
    }
    
    /**
    * Cette methode permet de fermer la fenetre Reset
    */
    private void boutonFermerActionPerformed(ActionEvent e) {                                         
        this.dispose();
    }
}
