package za.co.wethinkcode.wkhosa.app;

import java.util.Scanner;
import za.co.wethinkcode.wkhosa.app.controller.ControllerArtifact;
import za.co.wethinkcode.wkhosa.app.controller.ControllerDisplay;
import za.co.wethinkcode.wkhosa.app.controller.ControllerEnemy;
import za.co.wethinkcode.wkhosa.app.controller.ControllerHero;
import za.co.wethinkcode.wkhosa.app.model.Artifact;
import za.co.wethinkcode.wkhosa.app.model.GameCharacter;
import za.co.wethinkcode.wkhosa.app.model.Map;
import za.co.wethinkcode.wkhosa.app.model.Position;
import za.co.wethinkcode.wkhosa.app.model.Stats;
import za.co.wethinkcode.wkhosa.app.view.console.ConsoleView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GameCharacter hero = new GameCharacter();
        ConsoleView consoleView = new ConsoleView();
        int level = 1;
        String type = "BadCop";
        Stats stats = new Stats(level, type);
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        
        hero.setStats(stats);
        hero.setPosition(new Position(0, 0));

        
        Map map = new Map(hero);
        
        GameCharacter tempCharacter;
        Artifact    tempArtifact;

        ControllerDisplay controllerDisplay;
        controllerDisplay = new ControllerDisplay(
                consoleView, map, hero);
        
        ControllerArtifact controllerArtifact = new 
                ControllerArtifact(map, hero);

        ControllerEnemy controllerEnemy = new 
                ControllerEnemy(map, hero);
        
        ControllerHero controllerHero = new 
                ControllerHero(map, hero);

        
        while (!userInput.equalsIgnoreCase("Q")) {
            
            if ((tempArtifact = controllerArtifact.check()) != null) {
                controllerDisplay.foundArtifact();
                userInput = sc.nextLine();
                controllerArtifact.pick(tempArtifact, userInput);
            }
            
            if ((tempCharacter = controllerEnemy.check()) != null) {
                controllerDisplay.foundEnemy();
                userInput = sc.nextLine();
                controllerEnemy.battle(tempCharacter, userInput);
              //  controllerMission.update();
            }
            
            
            controllerDisplay.navigation();
            userInput = sc.nextLine();
            controllerHero.move(userInput);
            controllerDisplay.updateView();
            //controllerMission.update();
            
            
        }
//        while (!userInput.equalsIgnoreCase("Q")) {
//            controllerDisplay.updateView();
//            controllerDisplay.showStats(hero.getStats().toString());
//            System.out.println(">>>>> waiting for user input");
//            userInput = sc.nextLine();
//            characterController.move(userInput);
//            controllerBattle.fight();
//            controllerFoundArtifact.pick();
//        }
    }
}
