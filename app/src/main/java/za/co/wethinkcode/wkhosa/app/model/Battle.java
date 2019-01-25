/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.wkhosa.app.model;

/**
 *
 * @author wizro
 */
public class Battle {
    public static void fight(GameCharacter hero, GameCharacter enemy) {

        
        while ((hero.getStats().getLive() > 0) && 
                (enemy.getStats().getLive() > 0)) {

            int randNum = (int) (1 + Math.random() * 4);
        
            
            if (randNum != 1) {
                enemy.defend(hero.attack());
                System.out.println("You are kicking ass");
                int exp = hero.getStats().getExperience();
                int level = hero.getStats().getLevel();
                hero.getStats().setExperience((int) (exp +
                        Math.pow(10, level)));
            } else {
                hero.defend(enemy.attack());
                System.out.println("You are bieng fuckedUp too bad");
            }
            
        }
    }
    
    public static void run(GameCharacter hero, GameCharacter enemy) {

            int randNum = (int) (1 + Math.random() * 2);
            
            if (randNum == 1)
                Battle.fight(hero, enemy);
        
    }
}
