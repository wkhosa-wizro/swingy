/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.wkhosa.app.view.console;

import java.util.ArrayList;
import za.co.wethinkcode.wkhosa.app.App;
import za.co.wethinkcode.wkhosa.app.App.Controllers;

/**
 *
 * @author wizro
 */
public class ConsoleView {
   public void viewGameDetails(String name, String pos, String mapSize) {
       System.out.println("");
       System.out.println("Hero: " + name);
       System.out.println("Position: " + pos);
       System.out.println("Map Size: " + mapSize);
       System.out.println("");
       ArrayList<String> borders = Controllers.getMap().getBorders();
       System.out.print("Borders Reached :");
       for (String b : borders) {
           System.out.print(" <" + b + ">");
       }
       System.out.println(" :");
   } 
}
