/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.wkhosa.app.controller;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.wkhosa.app.model.GameCharacter;
import za.co.wethinkcode.wkhosa.app.view.console.ConsoleView;

/**
 *
 * @author wizro
 */
public class ControllerDisplay {
   @Getter @Setter(AccessLevel.PUBLIC) 
   private ConsoleView consoleView;
   
   @Getter @Setter(AccessLevel.PUBLIC) 
   private GameCharacter hero;
   
   
   public ControllerDisplay(ConsoleView consoleView, GameCharacter hero) {
       this.consoleView = consoleView;
       this.hero = hero;
   }
   
   public void updateView() {
       consoleView.viewGameDetails();
   }
}
