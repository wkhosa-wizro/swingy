/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.wkhosa.app.view.console;

import java.util.ArrayList;
import za.co.wethinkcode.wkhosa.app.App;
import za.co.wethinkcode.wkhosa.app.App.Controllers;
import za.co.wethinkcode.wkhosa.app.model.Stats;

/**
 *
 * @author wizro
 */
public class ConsoleView {
   public void viewGameDetails(String name, String pos, String mapSize) {
       
       Stats heroStats = Controllers.getHero().getStats();
       
       System.out.println("");
       System.out.println("\tHero\t\t\t\t\t\t: " + " ");
       System.out.println("\tYour Current Position\t\t\t\t: " + pos);
       System.out.println("\tMap Size\t\t\t\t\t: " + mapSize);
       System.out.println("\tLive %\t\t\t\t\t\t: " + heroStats.getLive());
       System.out.println("\tLevel\t\t\t\t\t\t: " + heroStats.getLevel());
       System.out.println("\tEXP\t\t\t\t\t\t: " + heroStats.getExperience() +
                                                                        " EXP");
       System.out.println("");
       ArrayList<String> borders = Controllers.getMap().getBorders();
       System.out.print("  Borders Reached :");
       for (String b : borders) {
           System.out.print(" <" + b + ">");
       }
       System.out.println(":");
   } 
   
   public void viewPrompt() {
       System.out.print("\t>>> ");
   }
   
   public void gameView(String msg) {
    
       System.out.println("------------------------------------------------" + 
               "------------------------");
       System.out.println("\t" + msg);
       System.out.println("------------------------------------------------" + 
               "------------------------"); 
   }
}
