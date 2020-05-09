package Model;

import Controller.GameController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

public class Main extends Application implements EventHandler<ActionEvent> {

    Button exitButton;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        GameController pizzaGame = new GameController();
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.setTitle("Pizza Clicker");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        StackPane backPanel = new StackPane();
        backPanel.setPadding(new Insets(20,20,20,20));
        backPanel.setStyle("-fx-background-color: transparent");
        primaryStage.show();

        exitButton = new Button();
        exitButton.setLabel("EXIT");
        exitButton.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource()==exitButton){
            System.out.println("TESTING BUTTON ACTION"); 
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
