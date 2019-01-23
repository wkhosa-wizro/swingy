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

/**
 *
 * @author wizro
 */
public class CharacterController {
    @Getter @Setter(AccessLevel.PUBLIC)
    private GameCharacter character;
    
    public CharacterController(GameCharacter character) {
        this.character = character;
        
    }
    
    public void move(String dir) {
        
        if (dir.equalsIgnoreCase("E")) {
            character.moveToEast();
        } else if (dir.equalsIgnoreCase("W")) {
            character.moveToWest();
        } else if (dir.equalsIgnoreCase("N")) {
            character.moveToNort();
        } else if (dir.equalsIgnoreCase("S")) {
            character.moveToSouth();
        } else {
//           System.out.println();
        }
    }
}
