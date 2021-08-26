/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igokuly2k.favouritemovies;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 *
 * @author igoku
 */
public class AddMovieController implements Controller {

    private App app;
    private SQLiteDatabase db;
    @FXML private TextField movieNameField;
    @FXML private TextField leadActorField;
    @FXML private TextField leadActressField;
    @FXML private TextField yearOfReleaseField;
    @FXML private TextField directorField;
    @FXML private Text errorStatus;
    @Override
    public void setApp(App app) {
        this.app = app;
        db=app.getDB();
    }
    public void goBack(MouseEvent e){
        app.changeScene("primary");
    }
    public void submit(MouseEvent e){
        if(!Movie.validateYear(yearOfReleaseField.getText()))
            setErrorStatus("Invalid Year");
        else{
            Movie m = new Movie(movieNameField.getText(),
            leadActorField.getText(),
            leadActressField.getText(),
            yearOfReleaseField.getText(),
            directorField.getText());
            db.addMovie(m);
            setErrorStatus("Successfully Submitted");
        }
    }
    public void setErrorStatus(String str){
        errorStatus.setText(str);
    }
}
