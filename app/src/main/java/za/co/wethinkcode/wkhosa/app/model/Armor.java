/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.wkhosa.app.model;

import lombok.ToString;

/**
 *
 * @author wizro
 */
@ToString
public class Armor extends Artifact {
    
    public Armor(String name, Position pos) {
        super(name, pos);
        this.type = "armor";
    }    
}
