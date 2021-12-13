/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

/**
 * Creation d'une fenetre pour reprendre une partie
 */
public class ReprendrePartie extends JFrame{
    
    JTextPane pseudoJoueur = new JTextPane();              //On cree un espace texte pour que l'utilisateur puisse ecrire son pseudo
 
    public ReprendrePartie(){                              //Constructeur de la fenetre ReprendrePartie
    
    /**
    * On cree chacun des objets de la fenetre ReprendrePartie
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
        labelTitre.setFont(new Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        labelTitre.setForeground(Color.BLACK);
        labelTitre.setText("Quel était votre ancien pseudo ?");
    
    /**
    * On definit des caracteristiques à notre boutonOk (texte, police, couleur...)
    */
        boutonOK.setFont(new Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        boutonOK.setForeground(new Color(0, 0, 0));
        boutonOK.setText("OK");
        boutonOK.setBorder(null);    
        boutonOK.setBackground(new Color(250, 250, 250));
        boutonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           //Le bouton OK verifie si le pseudo existe : s'il existe le joueur peut reprendre la partie sinon non
               String fileName = pseudoJoueur.getText();
                try {
                    File reader = new File("src\\" + fileName + ".txt");
                    if (reader.exists()){
                        JOptionPane.showMessageDialog(null , "Fichier trouvé");
                        boutonOKActionPerformed(e);
                    }
                    else{
                        JOptionPane.showMessageDialog(null , "Ce fichier n'existe pas"); 
                    }   
                }
                catch (Exception ex) {
                }
            }
        });

    /**
    * On ajoute tous les objets crees à notre panel content
    * Et on definit la taille et la position de chacun des objets
    */
        pseudoJoueur.setFont(new Font("Microsft Sans Serif", 0, 20));
        pseudoJoueur.setBackground(Color.white);
        
        content.add(pan1);
        content.setLayout(cardL);
        
        getContentPane().add(labelTitre);
        labelTitre.setBounds(50, 20, 275, 60);
        
        getContentPane().add(boutonOK);
        boutonOK.setBounds(160, 150, 80, 30);
        
        getContentPane().add(pseudoJoueur);
        pseudoJoueur.setBounds(50, 90, 300, 35);
        
        getContentPane().add(content, BorderLayout.CENTER); 
    }
    
    /**
     * Cette methode permet de fermer la fenetre ReprendrePartie
     * @param e 
     */
    private void boutonOKActionPerformed(ActionEvent e) {                                         
        this.dispose();
    }
   
}
