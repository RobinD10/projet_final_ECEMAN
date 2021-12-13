/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.io.*;
import javax.swing.*;

/**
 * Creation d'une fenetre pour debuter une nouvelle partie
 */
public class NouvellePartie extends JFrame{                      
    JTextPane pseudoJoueur = new JTextPane();                    //On cree un espace texte pour que l'utilisateur puisse ecrire son pseudo
    
    public NouvellePartie(){            //Constructeur de la fenetre NouvellePartie
    /**
     * On cree chacun des objets de la fenetre NouvellePartie
     */
        CardLayout cardL = new CardLayout();
        JPanel content = new JPanel();
        JLabel labelTitre = new JLabel();
        JButton boutonOK = new JButton();

    /**
     * On definit les caracteristiques de notre JFrame (taille...)
     */
        setSize(400, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0d, 0d, 400d, 200d, 25d, 25d));
                   
        JPanel pan1 = new JPanel();
        pan1.setBackground(new Color(102, 204, 255)); 
    
    /**
    * On definit des caracteristiques à notre labelTitre (texte, police, couleur...)
    */
        labelTitre.setFont(new Font("Microsoft Sans Serif", 0, 18)); 
        labelTitre.setForeground(Color.BLACK);
        labelTitre.setText("Saisissez votre pseudo :");
    
    /**
    * On definit des caracteristiques à notre boutonOK (texte, police, couleur...)
    */
        boutonOK.setFont(new Font("Microsoft Sans Serif", 0, 14)); 
        boutonOK.setForeground(new Color(0, 0, 0));
        boutonOK.setText("OK");
        boutonOK.setBorder(null);    
        boutonOK.setBackground(new Color(250, 250, 250));
        boutonOK.addActionListener(new ActionListener() {                //Le bouton OK verifie si le pseudo n'existe pas deja sinon il cree un fichier a ce nom
            public void actionPerformed(ActionEvent e) {
                String fileName = pseudoJoueur.getText();
                File reader = new File("src\\" + fileName + ".txt");
                
                if (reader.exists()){
                    JOptionPane.showMessageDialog(null , "Ce pseudo existe déjà");
                }
                else{
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src\\" + fileName + ".txt")));           
            
                } catch (IOException ex) {}
                
                boutonOKActionPerformed(e);              //Et on lui affecte une autre action
                }
            }
        });

    /**
    * On definit des caracteristiques à notre TextPane (texte, police, couleur...)
    */
        pseudoJoueur.setFont(new Font("Microsft Sans Serif", 0, 20));
        pseudoJoueur.setBackground(Color.white);
        
    /**
    * On ajoute tous les objets crees à notre panel content
    * Et on definit la taille et la position de chacun des objets
    */
        content.add(pan1);
        content.setLayout(cardL);
        
        getContentPane().add(labelTitre);
        labelTitre.setBounds(50, 20, 250, 60);
        
        getContentPane().add(boutonOK);
        boutonOK.setBounds(160, 150, 80, 30);
        
        getContentPane().add(pseudoJoueur);
        pseudoJoueur.setBounds(50, 90, 300, 35);
        
        getContentPane().add(content, BorderLayout.CENTER); 

    }
    
    /**
     * Cette permet de fermer la fenetre NouvellePartie et d'ouvrir le plateau de jeu
     * @param e 
     */
    private void boutonOKActionPerformed(ActionEvent e) {                                         
        this.dispose();
        Plateau monPlateau = new Plateau();
        monPlateau.setVisible(true);
    }
}
