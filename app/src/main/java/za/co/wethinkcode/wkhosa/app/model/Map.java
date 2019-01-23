/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.wkhosa.app.model;

import java.util.ArrayList;
import java.util.Random;
import lombok.Getter;

/**
 *
 * @author wizro
 */
public class Map {
 
    private String [] enemyTypes = {"BadCop", "GoodCop", "CIT",
                                                "Buglar"};
    
    @Getter
    private GameCharacter hero;
    
    @Getter
    private static ArrayList<GameCharacter> enemies = new 
                                        ArrayList<GameCharacter>();
    
//    @Getter
//    private static ArrayList<Artifact> artifacts = new ArrayList<Artifact>();
    
    public Map(GameCharacter hero) {
        this.hero = hero;
        createEnemies();
        
        //For debuging 
        System.out.println("enemies " + enemies.toString());
    }
    
    public void createEnemies() {
        
        int level = hero.getStats().getLevel();
        int mapSize = hero.getStats().getMapSize();
        
        for (int i = 0; i < level ; i++) {
            Random randx = new Random();
            int x = randx.nextInt(mapSize);
            Random randy = new Random();
            int y = randy.nextInt(mapSize);
            
            Random randType = new Random();
            int type = randType.nextInt(enemyTypes.length);

            

            Position pos = new Position(x, y);
            GameCharacter enemy = new GameCharacter();
            Stats stats = new Stats(level, enemyTypes[type]);
            enemy.setStats(stats);
            enemy.setName(hero.getStats().getRandomName());
            enemy.setPosition(pos);

            enemies.add(enemy);
        }
        
    }
    
}
