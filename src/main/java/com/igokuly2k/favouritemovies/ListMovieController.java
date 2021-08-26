/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.igokuly2k.favouritemovies;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author igoku
 */
public class ListMovieController implements Controller{
    private App app;
    private ObservableList<Movie> list;
    private SQLiteDatabase db;
    @FXML private TableView moviesTable;
    @FXML private TableColumn movieNameColumn;
    @FXML private TableColumn leadActorColumn;
    @FXML private TableColumn leadActressColumn;
    @FXML private TableColumn yearOfReleaseColumn;
    @FXML private TableColumn directorColumn;
    @Override
    public void setApp(App app){
        this.app=app;
        db=app.getDB();
        loadQuery();
    }
    public void goBack(MouseEvent e){
        app.changeScene("primary");
    }
    public void loadQuery(){
        list=FXCollections.observableList(db.queryAllMovie());
        movieNameColumn.setCellValueFactory(new PropertyValueFactory<>("movieName"));
        leadActorColumn.setCellValueFactory(new PropertyValueFactory<>("leadActor"));
        leadActressColumn.setCellValueFactory(new PropertyValueFactory<>("leadActress"));
        yearOfReleaseColumn.setCellValueFactory(new PropertyValueFactory<>("yearOfRelease"));
        directorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));
        moviesTable.setItems(list);
    }
}
