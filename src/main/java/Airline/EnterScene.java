package Airline;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EnterScene {
    static Scene scene1;
    public static void initialize(){
        Button startButton = new Button("Book a Flight");
        startButton.setMinSize(250, 75);
        startButton.setFont(Font.font("Serif", FontWeight.BLACK,30));
        startButton.setOnAction(e -> {
            MainScene.routeSelectScene();
        });



        Image image = new Image("file:logo.jpg");

        ImageView imageView = new ImageView(image);

        Label welcome = new Label("Welcome to JavaAir",imageView);
        welcome.setFont(Font.font("Cambria", FontWeight.BOLD, 76));


        VBox firstPage =new VBox();
        firstPage.setSpacing(100);
        firstPage.setMargin(welcome, new Insets(150,100,100,250));
        firstPage.setMargin(startButton, new Insets(0,100,100,500));
        firstPage.getChildren().addAll(welcome,startButton);
        BorderPane layout = new BorderPane();
        layout.setCenter(firstPage);
        layout.setStyle("-fx-background-color: #5F9EA0;");
        scene1 = new Scene(layout, 1200, 800);
        //scene1.getStylesheets().add("file:style1.css");
    }
    public static Scene getScene1(){
        return scene1;
    }
}
