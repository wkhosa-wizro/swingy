package za.co.wethinkcode.wkhosa.app;

import java.util.Scanner;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.wkhosa.app.controller.ControllerArtifact;
import za.co.wethinkcode.wkhosa.app.controller.ControllerDisplay;
import za.co.wethinkcode.wkhosa.app.controller.ControllerEnemy;
import za.co.wethinkcode.wkhosa.app.controller.ControllerHero;
import za.co.wethinkcode.wkhosa.app.controller.ControllerMission;
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

        Controllers.initLevel(hero);
        
        GameCharacter tempCharacter;
        Artifact    tempArtifact;

        while (!userInput.equalsIgnoreCase("Q")) {
            
            if ((tempArtifact = Controllers.getControllerArtifact().check())
                    != null) {
                Controllers.getControllerDisplay().foundArtifact();
                userInput = sc.nextLine();
                Controllers.getControllerArtifact().pick(tempArtifact,
                                        userInput);
            }
            
            if ((tempCharacter = Controllers.getControllerEnemy().check()) 
                    != null) {
                Controllers.getControllerDisplay().foundEnemy();
                userInput = sc.nextLine();
                Controllers.getControllerEnemy().battle(tempCharacter,
                        userInput);
                if (Controllers.getControllerMission().isMissionComplete())
                    Controllers.initLevel(hero);
            }
            
            
            Controllers.getControllerDisplay().navigation();
            userInput = sc.nextLine();
            Controllers.getControllerHero().move(userInput);
            Controllers.getControllerDisplay().updateView();
            if (Controllers.getControllerMission().isMissionComplete())
                Controllers.initLevel(hero);
            
        }
    }
    

    public static class Controllers {
        
        @Getter @Setter(AccessLevel.PUBLIC)
        private static int level = 0;
        
        @Getter @Setter(AccessLevel.PUBLIC)
        private static ControllerDisplay controllerDisplay;
        @Getter @Setter(AccessLevel.PUBLIC)
        private static ControllerArtifact controllerArtifact;
        @Getter @Setter(AccessLevel.PUBLIC)
        private static ControllerEnemy controllerEnemy;
        @Getter @Setter(AccessLevel.PUBLIC)
        private static ControllerHero controllerHero;
        @Getter @Setter(AccessLevel.PUBLIC)
        private static ControllerMission controllerMission;
        @Getter @Setter(AccessLevel.PUBLIC)
        private static Map map;
        @Getter @Setter(AccessLevel.PUBLIC)
        private static ConsoleView consoleView;
        @Getter @Setter(AccessLevel.PUBLIC)
        private static GameCharacter hero;

        
        public static void initLevel(GameCharacter hero) {
            
            int mapSize = hero.getStats().getMapSize();
            hero.setPosition(new Position((mapSize + 1) / 2,
                                             (mapSize + 1) / 2));
            
            
            map = new Map(hero);
            
            
            consoleView = new ConsoleView();
            
            controllerDisplay = new ControllerDisplay(
                consoleView, map, hero);

             controllerArtifact = new 
                ControllerArtifact(map, hero);

            controllerEnemy = new 
                ControllerEnemy(map, hero);

            controllerHero = new 
                ControllerHero(map, hero);

            controllerMission = new 
                ControllerMission(map, hero);
            setHero(hero);
                       
        }
    }
}
