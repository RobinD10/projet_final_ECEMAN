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
import javax.swing.*;

public class FenetreReset extends JFrame{   
    
    /**
     * Creation d'une fenetre apres l'appuie du bouton Reset
     */
    
    public FenetreReset(){        //Constructeur de la fenetre Reset                                   
    
    /**
     * On cree chacun des objets de la fenetre Reset
     */
        CardLayout cardL = new CardLayout();
        JPanel content = new JPanel();                            
        JLabel labelTitre = new JLabel();                        
        JButton boutonReprendre = new JButton();                 
        JButton boutonRecommencer = new JButton();
        JButton boutonEnregistrer = new JButton();

    /**
     * On definit les caracteristiques de notre JFrame (taille...)
     */
        setSize(740, 200);                                        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0d, 0d, 740d, 200d, 25d, 25d));
                   
        JPanel pan1 = new JPanel();                                       //On cree l'objet pan1 qui est un autre panel
        pan1.setBackground(new Color(102, 204, 255));                     //On lui affecte une couleur de fond
        
        /**
         * On definit des caracteristiques à notre labelTitre (texte, police, couleur...)
         */
        labelTitre.setFont(new Font("Microsoft Sans Serif", 0, 24));     
        labelTitre.setForeground(Color.BLACK);
        labelTitre.setText("Que souhaitez-vous faire ?");
        
        /**
         * On definit des caracteristiques à notre boutonReprendre (texte, police, couleur...)
         */
        boutonReprendre.setFont(new Font("Microsoft Sans Serif", 0, 20)); 
        boutonReprendre.setForeground(new Color(0, 0, 0));
        boutonReprendre.setText("Reprendre la partie");
        boutonReprendre.setBorder(null);    
        boutonReprendre.setBackground(new Color(250, 250, 250));
        boutonReprendre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boutonReprendreActionPerformed(e);                        //On lui affecte une action 
            }
        });
        
        /**
         * On definit des caracteristiques à notre boutonRecommencer (texte, police, couleur...)
         */
        boutonRecommencer.setFont(new Font("Microsoft Sans Serif", 0, 20)); 
        boutonRecommencer.setForeground(new Color(0, 0, 0));
        boutonRecommencer.setText("Recommencer le niveau");
        boutonRecommencer.setBorder(null);    
        boutonRecommencer.setBackground(new Color(250, 250, 250));
        boutonRecommencer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boutonRecommencerActionPerformed(e);                       //On lui affecte une action 
            }
        });
        
        /**
         * // On definit des caracteristiques à notre boutonEnregistrer (texte, police, couleur...)
         */
        boutonEnregistrer.setFont(new Font("Microsoft Sans Serif", 0, 20)); 
        boutonEnregistrer.setForeground(new Color(0, 0, 0));
        boutonEnregistrer.setText("Enregistrer et Quitter");
        boutonEnregistrer.setBorder(null);    
        boutonEnregistrer.setBackground(new Color(250, 250, 250));
        boutonEnregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boutonEnregistrerActionPerformed(e);                      //On lui affecte une action 
            }
        });
        
        /**
         * On ajoute tous les objets crees à notre panel content
         * Et on definit la taille et la position de chacun des objets
         */
        content.add(pan1);
        content.setLayout(cardL);                                        
        
        getContentPane().add(labelTitre);                                
        labelTitre.setBounds(220, 20, 500, 60);                          
        
        getContentPane().add(boutonReprendre);                           
        boutonReprendre.setBounds(20, 125, 200, 50);                    
        
        getContentPane().add(boutonRecommencer);                        
        boutonRecommencer.setBounds(240, 125, 250, 50);                
        
        getContentPane().add(boutonEnregistrer);                        
        boutonEnregistrer.setBounds(510, 125, 210, 50);                 
        
        getContentPane().add(content, BorderLayout.CENTER); 

    }
    
    /**
     * Cette methode permet de fermer la fenetre et relancer le timer, pour reprendre la partie en cours
     * @param e 
     */
    private void boutonReprendreActionPerformed(ActionEvent e) {       
        Plateau mp = new Plateau();
        mp.chrono();
        this.dispose();
    }
    
    /**
     * Cette methode permet de recommencer le niveau sur lequel se trouvait le joueur
     * @param e 
     */
    private void boutonRecommencerActionPerformed(ActionEvent e) {                                  
        
    }
    
    /**
     * Cette methode permet d'enregistrer la partie du joueur et de quitter le plateau de jeu
     * @param e 
     */
    private void boutonEnregistrerActionPerformed(ActionEvent e) {                                 
        JOptionPane.showMessageDialog(null , "Votre partie a bien été enregistré");
        this.dispose();
    }
}
