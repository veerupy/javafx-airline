package Airline;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static Airline.RouteSelectScene.*;

public class BookingDetails {
    static Button restartButton;
    static Label refNumber;
    static Scene scene6;
    public static void initialize(){
        restartButton = new Button("Book another Filght");
        restartButton.setMinSize(250, 75);
        restartButton.setOnAction(e -> {
            MainScene.enterScene();
            comboBox1.getItems().clear();
            comboBox2.getItems().clear();
            departureDate.setValue(null);
            returnDate.setValue(null);
        });
        Label congrats = new Label("Booking Successful");
        refNumber = new Label("");
        congrats.setFont(Font.font("Cambria", FontWeight.BOLD, 76));
        refNumber.setFont(Font.font("Cambria", FontWeight.BOLD, 36));

        VBox lastPage =new VBox();
        lastPage.setSpacing(20);
        lastPage.setMargin(congrats, new Insets(50,50,50,275));
        lastPage.setMargin(refNumber, new Insets(50,50,50,425));
        lastPage.setMargin(restartButton, new Insets(50,50,50,500));
        lastPage.getChildren().addAll(congrats,refNumber,restartButton);

        BorderPane finalLayout=new BorderPane();
        finalLayout.setCenter(lastPage);

        finalLayout.setStyle("-fx-background-color: #5F9EA0;");

        scene6=new Scene(finalLayout,1200,800);
        //scene6.getStylesheets().add("style1.css");
    }
    public static Scene getScene6(){
        return scene6;
    }
}
