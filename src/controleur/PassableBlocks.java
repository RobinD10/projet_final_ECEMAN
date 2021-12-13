/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

/**
 * Enumeration des blocks passable
 */

public enum PassableBlocks {  //Renvoie en char les blocks passable
    o('o'),X('X'),E('E'),SPACE(' '),T('T'), t('t'),L('L'),B('<');

    public char asChar() {
        return asChar;
    }
    private final char asChar;

    PassableBlocks(char asChar){
        this.asChar = asChar;
    }

}