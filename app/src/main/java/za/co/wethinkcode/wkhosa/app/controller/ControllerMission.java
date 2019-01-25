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
import za.co.wethinkcode.wkhosa.app.model.Position;

/**
 *
 * @author wizro
 */
public class ControllerMission {
    
    @Getter @Setter(AccessLevel.PUBLIC)
    private Map map;
    
    @Getter @Setter(AccessLevel.PUBLIC)
    private GameCharacter hero;
    
    public ControllerMission(Map map, GameCharacter hero) {
        this.map = map;
        this.hero = hero;
    }
    
    public boolean isMissionComplete() {
        
        updateBorders();
        if (hero.getStats().getLive() <= 0) {
            System.out.println("You have been killed mission failed");
            System.exit(0);
        }
        
        if (map.getBorders().size() == 4) {
            System.out.println("Mission Completed");
            int level = hero.getStats().getLevel();
            int mapSize = hero.getStats().getMapSize();
            Position pos = new Position(mapSize / 2, mapSize / 2);
            hero.setPosition(pos);
            
//            int exp = hero.getStats().getExperience();
            
            hero.getStats().setLevel(level + 1);
                        
            System.out.println("Welcome to new level");
            return true;
        }
        return false;
    }
    
    private void updateBorders() {
        int x = hero.getPosition().getX();
        int y = hero.getPosition().getY();
        
        if (x == 0) {
           if (!map.getBorders().contains("WEST")) {
               map.getBorders().add("WEST");
           }
        }

        if (x == (hero.getStats().getMapSize() - 1)) {
           if (!map.getBorders().contains("EAST")) {
               map.getBorders().add("EAST");
           }
        }

        if (y == 0) {
           if (!map.getBorders().contains("SOUTH")) {
               map.getBorders().add("SOUTH");
           }
        }

        if (y == (hero.getStats().getMapSize() - 1)) {
           if (!map.getBorders().contains("NORTH")) {
               map.getBorders().add("NORTH");
           }
        }

    }
    
}
