/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.wkhosa.app.model;

import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author wizro
 */
@ToString
public class Position {
    @Getter @Setter(AccessLevel.PUBLIC) private int x;
    @Getter @Setter(AccessLevel.PUBLIC) private int y;
    
    public Position(@NotNull int x, @NotNull int y) {
        this.x = x;
        this.y = y;
    }    
}
