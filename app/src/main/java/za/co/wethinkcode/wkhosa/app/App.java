package za.co.wethinkcode.wkhosa.app;

import java.util.Scanner;
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
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        
        hero.setStats(stats);
        ControllerDisplay controllerDisplay = new ControllerDisplay(
                                        consoleView, hero);
        
        while (!userInput.equalsIgnoreCase("Q")) {
            controllerDisplay.updateView();
            controllerDisplay.showStats(hero.getStats().toString());
            System.out.println(">>>>> waiting for user input");
            userInput = sc.nextLine();
        }
    }
}
