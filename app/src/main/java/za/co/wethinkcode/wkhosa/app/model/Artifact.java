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
public abstract class Artifact {
    
    @Getter @Setter(AccessLevel.PUBLIC)
    private String name;

    @Getter @Setter(AccessLevel.PUBLIC)
    protected String type;

    @Getter @Setter(AccessLevel.PUBLIC)
    protected Stats stats;

    @Getter @Setter(AccessLevel.PUBLIC)
    protected Position position;

    public Artifact(String name, Position pos) {
        this.name = name;
        this.position = pos;
    }
    
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
    
}
