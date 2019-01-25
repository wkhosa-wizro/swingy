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
//            System.out.println("You have been killed mission failed");
            System.exit(0);
        }
        
        if (map.getBorders().size() == 4) {
//            System.out.println("Mission Completed>>>>");
            int level = hero.getStats().getLevel();
            
//            int exp = hero.getStats().getExperience();
            int nextLevelExp = level * 1000 + 
                    (int)Math.pow(level - 1 , 2) * 450;
            if (hero.getStats().getExperience() >= nextLevelExp) {
                hero.getStats().setLevel(level + 1);
//                System.out.println("Leveling up... wait... >>>>");
            }
            int mapSize = hero.getStats().getMapSize();
            Position pos = new Position(mapSize / 2, mapSize / 2);
            hero.setPosition(pos);

//            System.out.println("Welcome to new level");
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
               int exp = hero.getStats().getExperience();
               int level = hero.getStats().getLevel();
               hero.getStats().setExperience(exp + level * 100);
           }
        }

        if (x == (hero.getStats().getMapSize() - 1)) {
           if (!map.getBorders().contains("EAST")) {
               map.getBorders().add("EAST");
               int exp = hero.getStats().getExperience();
               int level = hero.getStats().getLevel();
               hero.getStats().setExperience(exp + level * 200);
           }
        }

        if (y == 0) {
           if (!map.getBorders().contains("SOUTH")) {
               map.getBorders().add("SOUTH");
               int exp = hero.getStats().getExperience();
               int level = hero.getStats().getLevel();
               hero.getStats().setExperience(exp + level * 100);
           }
        }

        if (y == (hero.getStats().getMapSize() - 1)) {
           if (!map.getBorders().contains("NORTH")) {
               map.getBorders().add("NORTH");
               int exp = hero.getStats().getExperience();
               int level = hero.getStats().getLevel();
               hero.getStats().setExperience(exp + level * 200);
           }
        }

    }
    
}
