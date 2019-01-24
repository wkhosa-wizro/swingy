/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.wkhosa.app.controller;

import java.util.ArrayList;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.wkhosa.app.model.GameCharacter;
import za.co.wethinkcode.wkhosa.app.model.Map;

/**
 *
 * @author wkhosa
 */
public class ControllerBattle {
    
    @Getter @Setter(AccessLevel.PUBLIC)
    GameCharacter hero;
    
    @Getter @Setter(AccessLevel.PUBLIC)
    Map map;
    
    public ControllerBattle(Map map, GameCharacter hero) {
        this.hero = hero;
        this.map = map;
    }
    
    public void fight() {
        ArrayList<GameCharacter> enemies = Map.getEnemies();
      
        
        for (GameCharacter enemy : enemies) {
        
            System.out.println("enemy  here" + enemy.toString());
            
            if (enemy.getPosition().compare(hero.getPosition())) {
                System.out.println("You are in same location with an enemy");
            }
            
        }
        
    }
    
}