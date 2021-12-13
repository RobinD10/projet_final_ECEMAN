/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;


/**
 * Création du plateau de jeu
 */
import controleur.Level;
import modele.Map;
import modele.Perso;
import modele.ChargerMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Plateau extends JFrame {
/**
 * On cree toutes les variables dont on va avoir besoin ensuite (label, timer, perso...)
 */
    Map map = new Map(ChargerMap.mapLVL1);
    Perso player = new Perso(0, 0);
    Level level = new Level(map,player);
    
    private int heure = 0, minute = 0, seconde = 0;
    private int delais = 1000;
    private JLabel labelChrono = new JLabel(" " + heure + " : " + minute + " : " + seconde);
    private JLabel imageVie1 = new JLabel();
    private JLabel imageVie2 = new JLabel();
    private JLabel imageVie3 = new JLabel();
    private ActionListener tache_timer;
    public Timer timer1;
    

    public Plateau() {             //Constructeur du plateau
/**
* On cree chacun des objets de notre plateau
*/
        
        JPanel content = new JPanel();
        JLabel image = new JLabel();
        JLabel labelLife = new JLabel();
        JLabel labelLevel = new JLabel();
        JLabel tempsEcoule = new JLabel();
        JButton boutonReset = new JButton();
 
/**
 * On definit les caracteristiques de notre JFrame(taille...)
 */        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(970, 900);

/**
 * On cree ajoute, a notre panel, trois fois la meme image qui represente les vies du joueur
 * On leur affecte une taille ainsi qu'une position
 */          
        imageVie1.setIcon(new ImageIcon(getClass().getResource("/images/coeur.png")));
        getContentPane().add(imageVie1);
        imageVie1.setBounds(800, 5, 30, 50);
        
        imageVie2.setIcon(new ImageIcon(getClass().getResource("/images/coeur.png")));
        getContentPane().add(imageVie2);
        imageVie2.setBounds(831, 5, 30, 50);
        
        imageVie3.setIcon(new ImageIcon(getClass().getResource("/images/coeur.png")));
        getContentPane().add(imageVie3);
        imageVie3.setBounds(862, 5, 30, 50);
        
/**
 * On definit les caracteristiques de notre label tempsEcoule (texte, police, couleur...)
 */ 
        tempsEcoule.setFont(new Font("Tahoma", 0, 24));
        tempsEcoule.setForeground(Color.BLUE);
        tempsEcoule.setText("Temps écoulé :");
        
/**
 * On definit les caracteristiques de notre timer (texte, police, couleur...)
 */ 
        labelChrono.setFont(new Font("Tahoma", 0, 24));
        labelChrono.setForeground(Color.BLUE);

/**
 * On definit les caracteristiques de notre labelLife (texte, police, couleur...)
 */ 
        labelLife.setFont(new Font("Tahoma", 0, 24)); 
        labelLife.setForeground(Color.BLUE);
        labelLife.setText("Lifes :");

/**
 * On definit les caracteristiques de notre labelLevel (texte, police, couleur...)
 */         
        labelLevel.setFont(new Font("Tahoma", 0, 24)); 
        labelLevel.setForeground(Color.BLUE);
        labelLevel.setText("LEVEL");

/**
 * On definit les caracteristiques de notre boutonReset(texte, police, couleur...)
 */ 
        boutonReset.setFont(new Font("Microsoft Sans Serif", 0, 24));
        boutonReset.setForeground(new Color(255, 255, 255));
        boutonReset.setText("RESET");
        boutonReset.setBorder(null);      
        boutonReset.setBackground(new Color(0, 0, 250));
        boutonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {             //On lui affecte une action
                boutonResetActionPerformed(e);
            }
        });
        
        JPanel panel = new JPanel(new GridLayout(17, 19, 0, 0));          //On cree notre objet gridlayout qui va nous permettre de faire la grille du plateau

/**
 * On declare chacune de nos images presentent sur le plateau de jeu
 */ 
        ImageIcon Glace = new ImageIcon("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\images\\glace.png");
        ImageIcon Mur = new ImageIcon("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\images\\mur.png");
        ImageIcon Pingouin = new ImageIcon("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\images\\perso.png");
        ImageIcon Sortie = new ImageIcon("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\images\\sortie.png");
        ImageIcon Banquise = new ImageIcon("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\images\\banquise.png");
        ImageIcon Contour = new ImageIcon("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\images\\contour.png");
        ImageIcon Eau = new ImageIcon("C:\\ING3_S1\\Java POO\\Projet_Final\\src\\images\\eau.png");

/**
 * Cette boucle if permet de generer le plateau et de remplacer chacun des caracteres, constituant les maps, par une image
 */ 
        if(map != null){
            for (int i = 0; i < map.getSizeY(); i++) {
                for (int j = 0; j < map.getSizeX(); j++) {
                    if (map.getCase(i, j) == '#') {
                        image = new JLabel(Glace);
                        panel.add(image);
                    }
                    if (map.getCase(i, j) == 'M') {
                        image = new JLabel(Mur);
                        panel.add(image);
                    }
                    if (map.getCase(i, j) == 'P') {
                        image = new JLabel(Pingouin);
                        panel.add(image);
                    }
                    if (map.getCase(i, j) == 'o') {
                        image = new JLabel(Banquise);
                        panel.add(image);
                    }
                    if (map.getCase(i, j) == ' ') {
                        image = new JLabel(Eau);
                        panel.add(image);
                    }
                    if (map.getCase(i, j) == 'E') {
                        image = new JLabel(Sortie);
                        panel.add(image);
                    }
                    if (map.getCase(i, j) == '&') {
                        image = new JLabel(Contour);
                        panel.add(image);
                    }
                }
        }

/**
* On ajoute tous les objets crees à notre panel content
* Et on definit la taille et la position de chacun des objets
*/
        content.add(panel);
        
        getContentPane().add(boutonReset);
        boutonReset.setBounds(30, 810, 130, 40);
        
        getContentPane().add(labelChrono);
        labelChrono.setBounds(830, 810, 100, 40);
	chrono();            //On ajoute aussi la methode chrono qui permet de cree le timer
        
        getContentPane().add(labelLife);
        labelLife.setBounds(720, 10, 70, 40);
        
        getContentPane().add(labelLevel);
        labelLevel.setBounds(30, 10, 100, 40);
        
        getContentPane().add(tempsEcoule);
        tempsEcoule.setBounds(640, 810, 200, 40);
        
        getContentPane().add(content, BorderLayout.CENTER); 
    }
    }

/**
 * Cette methode permet de stopper le timer et d'ouvrir la fenetre Reset 
 * @param e 
 */
    private void boutonResetActionPerformed(ActionEvent e) {  
        timer1.stop();
        FenetreReset maFenetre = new FenetreReset();
        maFenetre.setVisible(true);
    }

/**
 * Cette methode permet de cree un timer et de le lancer des l'overture du plateau de jeu
 */
    public void chrono(){
        tache_timer = new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                seconde++;
                if (seconde == 60) {
                    seconde = 0;
                    minute++;
                }
                if (minute == 60) {
                    minute = 0;
                    heure++;
                }
                labelChrono.setText(heure + " : " + minute + " : " + seconde);     //Afficher le chrono dans un JLabel
            }
        };
        timer1 = new Timer(delais, tache_timer);           //Action et temps execution de la tache
        timer1.start();              //Demarrer le chrono
    }

    }

    
   
    

