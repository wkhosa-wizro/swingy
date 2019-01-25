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
import za.co.wethinkcode.wkhosa.app.view.console.ConsoleView;

/**
 *
 * @author wizro
 */
public class ControllerDisplay {
   @Getter @Setter(AccessLevel.PUBLIC) 
   private ConsoleView consoleView;
   
   @Getter @Setter(AccessLevel.PUBLIC) 
   private GameCharacter hero;

   @Getter @Setter(AccessLevel.PUBLIC) 
   private Map map;
      
   
   public ControllerDisplay(ConsoleView consoleView, Map map, 
                    GameCharacter hero) {
       this.consoleView = consoleView;
       this.hero = hero;
       this.map = map;
   }
   
   public void updateView() {
       consoleView.viewGameDetails(hero.getName(),
                        hero.getPosition().toString(),
                        Integer.toString(hero.getStats().getMapSize()));
       
       System.out.println("Hero >>> " + hero.getStats().toString());
//       for (String s : map.getBorders()) {
//           System.out.println("Border reached ... " + s);
//       }
   }

    public void showStats(String stats) {
        System.out.println(stats);
    }
    
    public void foundArtifact() {
        System.out.println("You have found an Artifact" + 
                " Do you want ot pick it up [Y/N]");
    }
    
    public void foundEnemy() {
        
        System.out.println("You have been ambushed by your worst " +
                "enemy Will you Fight or Run [F/R]");
    }
    
    public void navigation() {
        System.out.println("To move in East, West, North, South " +
                " direction [E/W/N/S]");
    }
}
