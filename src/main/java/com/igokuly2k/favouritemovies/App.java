package com.igokuly2k.favouritemovies;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private Parent root;
    private Scene scene;
    private Stage primaryStage;
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage=primaryStage;
        loadScene("primary");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MovieBucket");
        primaryStage.show();
    }
    
    public void changeScene(String sceneStr) {
                loadScene(sceneStr);
                primaryStage.setScene(scene);
    }
    public void loadScene(String fxml) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml+".fxml"));
        root = loader.load();
        Controller controller = loader.getController();
        controller.setApp(this);
        scene = new Scene(root);
        }
        catch(IOException e){
            for(StackTraceElement str:e.getStackTrace())
            System.out.println(str.toString());
        }
    }
    public static void main(String[] args) {
        launch();
    }
}
