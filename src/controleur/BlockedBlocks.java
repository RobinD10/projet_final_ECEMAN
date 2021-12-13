/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

/**
 * Enumeration des blocks non passable
 */

public enum BlockedBlocks {  //Renvoie en char les blocks non passable
    M('M'),X('X'),W('W');

    public char asChar() {
        return asChar;
    }
    private final char asChar;

    BlockedBlocks(char asChar){
        this.asChar = asChar;
    }
}