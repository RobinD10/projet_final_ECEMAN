/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

public class Ennemi {

    private int xEnemy;
    private int yEnemy;

    private char currentEnemyCase = '<';


    public Ennemi(int x, int y){
        xEnemy = x;
        yEnemy = y;
    }

    public void initEnemy() {
        currentEnemyCase = 'o';
    }

    //Getter
    public int getXEnemy() {
        return xEnemy;
    }
    public void setxEnemy(int xEnemy) {
        this.xEnemy = xEnemy;
    }

    //Setter
    public int getyEnemy() {
        return yEnemy;
    }
    public void setyEnemy(int yEnemy) {
        this.yEnemy = yEnemy;
    }

    public int []GetEnemyCoords(){
        return new int[]{xEnemy, yEnemy};
    }

    public void setEnemyCoords(int x,int y){
        xEnemy = x;
        yEnemy = y;
    }


    public char getCurrentEnemyCase() {
        return currentEnemyCase;
    }

    public void setCurrentEnemyCase(char currentEnemyCase) {
        this.currentEnemyCase = currentEnemyCase;
    }
}