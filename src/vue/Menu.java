/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Creation de notre menu d'accueil
 */
public class Menu extends JFrame {                          
   
    /**
     * On cree chacun des objets de notre menu
     */
    private JButton boutonQuitter = new JButton();               //On cee tous les boutons, label, sous-menu qu'on a besoin pour notre menu
    private JLabel imageBackground = new JLabel();
    private JMenu menuJouer = new JMenu();
    private JMenu menuRegles = new JMenu();
    private JMenuBar barreMenu = new JMenuBar();
    private JMenuItem sousMenu1 = new JMenuItem();
    private JMenuItem sousMenu2 = new JMenuItem();
    private JMenuItem sousMenuScores = new JMenuItem();
    
    /**
     * On cree le constructeur du menu
     */
    public Menu() {
        initialisation();
    }
            
    /**
     * Cette methode permet de creer l'ensemble du menu
     */
    private void initialisation() {                              
        
    /**
     * On definit les caracteristiques de notre JFrame (taille...)
     */
        setDefaultCloseOperation(EXIT_ON_CLOSE);                  
        setPreferredSize(new Dimension(1000, 692));
        setResizable(false);
        getContentPane().setLayout(null);
        
    /**
     * On definit des caracteristiques à notre boutonQuitter (texte, police, couleur...)
     */
        boutonQuitter.setFont(new Font("Microsoft Sans Serif", 1, 18));    
        boutonQuitter.setForeground(new Color(255, 255, 255));
        boutonQuitter.setText("Quitter");
        boutonQuitter.setBorder(null);
        boutonQuitter.setBorderPainted(false);
        boutonQuitter.setContentAreaFilled(false);
        boutonQuitter.setOpaque(false);
        boutonQuitter.addActionListener(new ActionListener() {            //On lui affecte une action 
            @Override
            public void actionPerformed(ActionEvent e) {
                boutonQuitterActionPerformed(e);
            }
        });
        getContentPane().add(boutonQuitter);                          //On ajoute notre bouton Quitter au panel
        boutonQuitter.setBounds(759, 555, 130, 50);                   //On lui donne une position et une taille sur le panel
        
        /**
         * On définit des caractéristiques à notre image de fond (taille...)
         */
        imageBackground.setIcon(new ImageIcon(getClass().getResource("/images/ThinIce.png")));     
        getContentPane().add(imageBackground);
        imageBackground.setBounds(0, 0, 1000, 660);

        menuJouer.setText("Jouer");                                 //On ajoute le titre de notre menu Jouer

        sousMenu1.setText("Nouvelle Partie");                       //On ajoute le titre de notre sous menu Nouvelle Partie
        sousMenu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           //On lui affecte une action 
                sousMenu1ActionPerformed(e);
            }
        });
        barreMenu.add(menuJouer);              //On ajoute notre menu Jouer à notre menuBarre
        menuJouer.add(sousMenu1);              //On ajoute notre sous_menu1 au menu Jouer

        sousMenu2.setText("Reprendre une Partie");
        sousMenu2.addActionListener(new ActionListener() {         //On lui affecte une action 
            @Override
            public void actionPerformed(ActionEvent e) {
                sousMenu2ActionPerformed(e);
            }
        });
        menuJouer.add(sousMenu2);              //On ajoute notre sous_menu2 à notre menu Jouer

        sousMenuScores.setText("Score");
        sousMenuScores.addActionListener(new ActionListener() {          //On lui affecte une action 
            @Override
            public void actionPerformed(ActionEvent e) {
                sousMenuScoresActionPerformed(e);
            }
        });
        menuJouer.add(sousMenuScores);        //On ajoute notre sousMenuScores au menu Jouer

        menuRegles.setText("Règles");
        menuRegles.addMouseListener(new MouseAdapter() {              //On lui affecte une action 
            @Override
            public void mouseClicked(MouseEvent evt) {
                menuReglesMouseClicked(evt);
            }
        });
        barreMenu.add(menuRegles);

        setJMenuBar(barreMenu);        
        
        pack();
    }                     

    /**
     * Cette methode permet de quitter le menu
     * @param e 
     */
    private void boutonQuitterActionPerformed(ActionEvent e) {                                      
        this.dispose();
    }                            
    
    /**
     * Cette methode permet d'ouvrir la fenetre Reset
     * @param evt 
     */
    private void menuReglesMouseClicked(MouseEvent evt) {                               
        Regles mesRegles = new Regles();
        mesRegles.setVisible(true);
    }  
    
    /**
     *  Cette methode permet d'ouvrir la fenetre pour commencer une nouvelle partie
     * @param e 
     */
    private void sousMenu1ActionPerformed(ActionEvent e) {                               
        NouvellePartie monJoueur = new NouvellePartie();
        monJoueur.setVisible(true);
    } 
    
    /**
     * Cette methode permet d'ouvrir la fenetre pour reprendre une partie
     * @param e 
     */
    private void sousMenu2ActionPerformed(ActionEvent e) {                              
        ReprendrePartie monJoueur = new ReprendrePartie();
        monJoueur.setVisible(true);
    } 
    
    /**
     * Cette methode permet d'ouvrir la fenetre avec le tableau des scores  
     * @param e 
     */
    private void sousMenuScoresActionPerformed(ActionEvent e) {                               
        TableauScores monTableau = new TableauScores();
        monTableau.setVisible(true);
    } 
}
