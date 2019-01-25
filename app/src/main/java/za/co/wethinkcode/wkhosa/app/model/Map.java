/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.wkhosa.app.model;

import java.util.ArrayList;
import java.util.Random;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author wizro
 */
@ToString
public class Map {
 
    @ToString.Exclude
    private final String [] enemyTypes = {"BadCop", "GoodCop", "CIT",
                                                "Buglar"};
    @ToString.Exclude
    private final String [] artifactTypes = {"Helm", "Armor", 
                                                    "Weapons"};
    
    @ToString.Exclude @Getter @Setter(AccessLevel.PUBLIC)
    private ArrayList<String> borders = new ArrayList<String>();
    
    @Getter @ToString.Exclude
    private final GameCharacter hero;
    
    @Getter
    private static ArrayList<GameCharacter> enemies = new 
                                        ArrayList<GameCharacter>();
    @Getter
    private static ArrayList<Artifact> artifacts = new 
                                        ArrayList<Artifact>();

    
//    @Getter
//    private static ArrayList<Artifact> artifacts = new ArrayList<Artifact>();
    
    public Map(GameCharacter hero) {
        this.hero = hero;
        createEnemies();
        createArtifacts();
        //For debuging 
//        System.out.println("enemies " + enemies.toString());
//        System.out.println("artifact " + artifacts.toString());
    }
    
//    public void update() {
//        artifacts.clear();
//        enemies.clear();
//        borders.clear();
//        createEnemies();
//        createArtifacts();
//        //For debuging 
//        System.out.println("enemies " + enemies.toString());
//        System.out.println("artifact " + artifacts.toString());
//        
//    }
    
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

    public void createArtifacts() {
        
        int level = hero.getStats().getLevel();
        int mapSize = hero.getStats().getMapSize();
        
        for (int i = 0; i < level ; i++) {
            Random randx = new Random();
            int x = randx.nextInt(mapSize);
            Random randy = new Random();
            int y = randy.nextInt(mapSize);
            
            Random randType = new Random();
            int type = randType.nextInt(artifactTypes.length);

            
            Position pos = new Position(x, y);
            if (artifactTypes[type].equalsIgnoreCase("Armor")) {
                Artifact artifact = new Armor(artifactTypes[type], pos);                
                Stats stats = new Stats(level, artifactTypes[type]);
                artifact.setStats(stats);
                artifacts.add(artifact);
            } else if (artifactTypes[type].equalsIgnoreCase("Weapon")) {
                Artifact artifact = new Weapon(artifactTypes[type], pos);
                Stats stats = new Stats(level, artifactTypes[type]);
                artifact.setStats(stats);
                artifacts.add(artifact);
            }else {
                Artifact artifact = new Helm(artifactTypes[type], pos);
                Stats stats = new Stats(level, artifactTypes[type]);
                artifact.setStats(stats);
                artifacts.add(artifact);
            }
            
        }
        
    }
    
}
