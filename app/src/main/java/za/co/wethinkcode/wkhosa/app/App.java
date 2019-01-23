package za.co.wethinkcode.wkhosa.app;

import za.co.wethinkcode.wkhosa.app.controller.ControllerDisplay;
import za.co.wethinkcode.wkhosa.app.model.GameCharacter;
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
        
        hero.setStats(stats);
        
        ControllerDisplay controllerDisplay = new ControllerDisplay(
                                        consoleView, hero);
        
        controllerDisplay.updateView();
        System.out.println( "Hello World!" );
        controllerDisplay.showStats(hero.getStats().toString());
    }
}
