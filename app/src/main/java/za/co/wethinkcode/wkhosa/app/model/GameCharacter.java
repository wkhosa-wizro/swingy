/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.wkhosa.app.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author wizro
 */
@ToString
public class GameCharacter {
    @Getter @Setter(AccessLevel.PUBLIC)
    private Position position;
    
    @Getter @Setter(AccessLevel.PUBLIC)
    private String name;
    
    @Getter @Setter(AccessLevel.PUBLIC)
    protected String type;
    
    @Getter @Setter(AccessLevel.PUBLIC)
    private Stats stats;

    
//    @Getter @Setter(AccessLevel.PUBLIC)
//    private Helm helm;
//
//    @Getter @Setter(AccessLevel.PUBLIC)
//    private Armor armor;
//
//    @Getter @Setter(AccessLevel.PUBLIC)
//    private Weapon weapon;
//    
//    @Getter @Setter(AccessLevel.PUBLIC)
//    private Stats stats;

    
}
