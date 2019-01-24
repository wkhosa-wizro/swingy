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
import za.co.wethinkcode.wkhosa.app.model.GameCharacter;
import za.co.wethinkcode.wkhosa.app.model.Map;

/**
 *
 * @author wizro
 */
public class ControllerFoundArtifact {
        
    @Getter @Setter(AccessLevel.PUBLIC)
    GameCharacter hero;
    
    @Getter @Setter(AccessLevel.PUBLIC)
    Map map;
    
    public ControllerFoundArtifact(Map map, GameCharacter hero) {
        this.hero = hero;
        this.map = map;
    }
    
    public void pick() {
        ArrayList<Artifact> artifacts = Map.getArtifacts();
      
        
        for (Artifact artifact : artifacts) {
        
            System.out.println("artifact  here" + artifact.toString());
            
            if (artifact.getPosition().compare(hero.getPosition())) {
                System.out.println("You are in same location with an artifact");
            }
            
        }
        
    }

    
}
