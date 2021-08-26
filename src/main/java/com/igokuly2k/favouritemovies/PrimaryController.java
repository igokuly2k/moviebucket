/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.igokuly2k.favouritemovies;

import javafx.scene.input.MouseEvent;

/**
 *
 * @author igoku
 */
public class PrimaryController implements Controller {
    private App app;
    @Override
    public void setApp(App app){
        this.app=app;
    }
    
    public void goToAddMovie(MouseEvent e) {
        app.changeScene("AddMovie");
    }
    
    public void goToListMovie(MouseEvent e) {
        app.changeScene("ListMovie");
    }
}
