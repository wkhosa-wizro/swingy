/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.wkhosa.app.model;

import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Random;

/**
 *
 * @author wizro
 */
@ToString
public class Stats {
    @Getter @Setter(AccessLevel.PUBLIC)
    private String characterName;

    @Getter @Setter(AccessLevel.PUBLIC)
    private String type;
    
    @Getter @Setter(AccessLevel.PUBLIC)
    private int level;
    
    @Getter @Setter(AccessLevel.PUBLIC)
    private int attack;
    
    @Getter @Setter(AccessLevel.PUBLIC)
    private int defense;

    @Getter @Setter(AccessLevel.PUBLIC)
    private int hitPoints;

    @Getter @Setter(AccessLevel.PUBLIC)
    private int mapSize;

    @Getter @Setter(AccessLevel.PUBLIC)
    private int live = 100;
    
    @ToString.Exclude
    private final String [] names = {"Bra Tiza", "Uncle Betty", "Ta Frank", 
                "Malumes", "Cashman", "Docter", "Mawaza", "Boss D"};
    
    public Stats(@NotNull int level, @NotNull String type) {
        this.level = level;
        this.mapSize = (this.level - 1) * 5 + 10 - (this.level % 2);
        
        if (type.equalsIgnoreCase("BadCop")) {
            badCopStats();
        } else if(type.equalsIgnoreCase("GoodCop")) {
            goodCopStats();
        } else if(type.equalsIgnoreCase("CIT")) {
            citStats();
        } else if(type.equalsIgnoreCase("Buglar")) {
            buglarStats();
        } else
            shoplifterStats();
        
    }
    
    //public Stats() {}
    
    private int statsPoint(int num) {
        return num * (this.level * 10) + 
                ((this.level - 1)*(this.level - 1));
    }

    public String getRandomName() {
        Random rand = new Random();
        
        int n = rand.nextInt(names.length);
        
        return this.names[n];
    }

    private void goodCopStats() {
        
        Random rand = new Random();
        
        int n = rand.nextInt(names.length);
        
        setType("GoodCop");
        setAttack(statsPoint(10));
        setDefense(statsPoint(12));
        setHitPoints(statsPoint(15));
    }

    private void badCopStats() {
        
        setType("BadCop");
        setAttack(statsPoint(20));
        setDefense(statsPoint(15));
        setHitPoints(statsPoint(22));
    }

    private void citStats() {
        
        setType("CIT Robber");
        setAttack(statsPoint(30));
        setDefense(statsPoint(20));
        setHitPoints(statsPoint(32));
    }
    
    private void buglarStats() {
        
        setType("Buglar");
        setAttack(statsPoint(10));
        setDefense(statsPoint(6));
        setHitPoints(statsPoint(12));
    }    
    
    private void shoplifterStats() {
        
        setType("Shoplifter");
        setAttack(statsPoint(3));
        setDefense(statsPoint(2));
        setHitPoints(statsPoint(5));
    }    
}
