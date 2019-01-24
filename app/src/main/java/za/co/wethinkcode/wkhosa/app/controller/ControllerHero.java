/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.wkhosa.app.controller;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.wkhosa.app.model.GameCharacter;
import za.co.wethinkcode.wkhosa.app.model.Map;

/**
 *
 * @author wizro
 */
public class ControllerHero {
    @Getter @Setter(AccessLevel.PUBLIC)
    private Map map;
    private GameCharacter hero;
    
    public ControllerHero(Map map, GameCharacter hero) {
        this.hero = hero;
        this.map = map;
    }
    
    public void move(String dir) {
        
        if (dir.equalsIgnoreCase("E")) {
            hero.moveToEast();
        } else if (dir.equalsIgnoreCase("W")) {
            hero.moveToWest();
        } else if (dir.equalsIgnoreCase("N")) {
            hero.moveToNort();
        } else if (dir.equalsIgnoreCase("S")) {
            hero.moveToSouth();
        } else {
//           System.out.println();
        }
    }
}
