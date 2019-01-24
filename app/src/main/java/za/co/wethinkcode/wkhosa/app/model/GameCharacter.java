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

    @Getter @Setter(AccessLevel.PUBLIC)
    private Helm helm;

    @Getter @Setter(AccessLevel.PUBLIC)
    private Armor armor;

    @Getter @Setter(AccessLevel.PUBLIC)
    private Weapon weapon;
    
    public void moveToEast() {
        int x = this.position.getX();
        
        if (x < (this.stats.getMapSize() - 1)) {
            this.position.setX(x + 1);
        }
    }
    
    public void moveToWest() {
        int x = this.position.getX();
        
        if (x > 0) {
            this.position.setX(x - 1);
        }
    }

    public void moveToNort() {
        int y = this.position.getY();
        
        if (y < (this.stats.getMapSize() - 1)) {
            this.position.setY(y + 1);
        }
    }
    
    public void moveToSouth() {
        int y = this.position.getY();
        
        if (y > 0) {
            this.position.setY(y - 1);
        }
    }

    public int attack() {
        return stats.getAttack() * stats.getHitPoints() / (10);
    }
    
    public void defend(int attack) {
        int currentLive = stats.getLive();
        
        stats.setLive(currentLive - (attack / stats.getDefense()));
    }
 
}
