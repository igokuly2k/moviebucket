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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    @FXML private TextField searchField;
    @FXML private ComboBox categoryComboBox;
    @Override
    public void setApp(App app){
        this.app=app;
        db=app.getDB();
        String columns[]={"MOVIENAME","LEADACTOR","LEADACTRESS","YEAROFRELEASE","DIRECTOR"};
        categoryComboBox.setValue("MOVIENAME");
        categoryComboBox.setItems(FXCollections.observableArrayList(columns));
        loadQuery(db.queryAllMovie());
    }
    public void goBack(MouseEvent e){
        app.changeScene("primary");
    }
    public void search(MouseEvent e){
        String searchFilter=searchField.getText();
        String category = categoryComboBox.getValue().toString();
        if(!searchFilter.trim().contentEquals(""))
        loadQuery(db.queryFilter(category, searchFilter));
    }
    public void loadQuery(ArrayList<Movie> arrList){
        list=FXCollections.observableList(arrList);
        movieNameColumn.setCellValueFactory(new PropertyValueFactory<>("movieName"));
        leadActorColumn.setCellValueFactory(new PropertyValueFactory<>("leadActor"));
        leadActressColumn.setCellValueFactory(new PropertyValueFactory<>("leadActress"));
        yearOfReleaseColumn.setCellValueFactory(new PropertyValueFactory<>("yearOfRelease"));
        directorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));
        moviesTable.setItems(list);
    }
}
