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
import za.co.wethinkcode.wkhosa.app.model.Armor;
import za.co.wethinkcode.wkhosa.app.model.Artifact;
import za.co.wethinkcode.wkhosa.app.model.GameCharacter;
import za.co.wethinkcode.wkhosa.app.model.Helm;
import za.co.wethinkcode.wkhosa.app.model.Map;
import za.co.wethinkcode.wkhosa.app.model.Weapon;

/**
 *
 * @author wizro
 */
public class ControllerArtifact {
    
    @Getter @Setter(AccessLevel.PUBLIC)
    private Map map;

    @Getter @Setter(AccessLevel.PUBLIC)
    private GameCharacter hero;
    
    public ControllerArtifact(Map map, GameCharacter hero) {
        this.map = map;
        this.hero = hero;
    }
    
    public Artifact check() {
        ArrayList<Artifact> artifacts = Map.getArtifacts();
        
        System.out.println("artifacts >>> " + artifacts.toString());
        
        for (Artifact found : artifacts) {
            
            if (hero.getPosition().compare(found.getPosition())) {
                System.out.println("artifact found ...");
                return found;
            }
        }
        
        return null;
    }
    
    public void pick(Artifact artifact, String choice) {
        
        if (choice.equalsIgnoreCase("Y") || 
                (choice.toUpperCase()).startsWith("Y")) {
            map.getArtifacts().remove(artifact);
            if (artifact.getType().equalsIgnoreCase("armor"))
                hero.setArmor((Armor)(artifact));
            else if (artifact.getType().equalsIgnoreCase("weapon"))
                hero.setWeapon((Weapon)artifact);
            else if (artifact.getType().equalsIgnoreCase("helm"))
                hero.setHelm((Helm)artifact);
            else {
            }            
        }
    }
    
}
