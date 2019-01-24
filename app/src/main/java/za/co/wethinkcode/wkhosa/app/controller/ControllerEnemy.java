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
import za.co.wethinkcode.wkhosa.app.model.Artifact;
import za.co.wethinkcode.wkhosa.app.model.Battle;
import za.co.wethinkcode.wkhosa.app.model.GameCharacter;
import za.co.wethinkcode.wkhosa.app.model.Map;

/**
 *
 * @author wizro
 */
public class ControllerEnemy {
    @Getter @Setter(AccessLevel.PUBLIC)
    private Map map;
    
    @Getter @Setter(AccessLevel.PUBLIC)
    private GameCharacter hero;

    public ControllerEnemy(Map map, GameCharacter hero) {
        this.map = map;
        this.hero = hero;
    }
    
    public GameCharacter check() {
        ArrayList<GameCharacter> enemies = Map.getEnemies();
        
                System.out.println("enemy >>> " + enemies.toString());
        
        for (GameCharacter found : enemies) {
            
            if (hero.getPosition().compare(found.getPosition())) {
                System.out.println("enemy found ...");
                return found;
            }
        }
        
        return null;
    }
   
    public void battle(GameCharacter enemy, String action) {
        
        if (action.equalsIgnoreCase("R")) {
            System.out.println("I am running like a coward");
            Battle.run(hero, enemy);
        }
        else {
            System.out.println("I am fighting like a hero\n");
            Battle.fight(hero, enemy);
            if (enemy.getStats().getLive() <= 0) {
                map.getEnemies().remove(enemy);
            }
        }
    }
}
