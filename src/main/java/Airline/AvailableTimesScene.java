package Airline;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static Airline.DisplayBasicPrice.calculateBasicPrice;
import static Airline.DisplayBasicPrice.displayBasicPrice;
import static Airline.FlightTimes.listView2;
import static Airline.FlightTimes.listView;
import static Airline.PassengerDetails.comboBox3;
import static Airline.RouteSelectScene.comboBox;
import static Airline.RouteSelectScene.oneway;

public class AvailableTimesScene {
    static Scene scene3;
    static Label availableTimeLabel;
    static Label flightBackTimeLabel;
    public static void initialize(){

        availableTimeLabel = new Label("Select Available Times");
        availableTimeLabel.setFont(Font.font("Cambria", FontWeight.BOLD, 30));

        Label flightOutTimeLabel = new Label("Flight Out");
        flightOutTimeLabel.setFont(Font.font("Cambria", FontWeight.BOLD, 20));
        flightBackTimeLabel = new Label("Flight Back");
        flightBackTimeLabel.setFont(Font.font("Cambria", FontWeight.BOLD, 20));


        Button nextButton2 = new Button("Next");
        nextButton2.setDisable(true);
        nextButton2.setOnAction(e -> {
            MainScene.passengerDetailsScene();
            comboBox3.getItems().clear();
            for(int i=1; i<comboBox.getSelectionModel().getSelectedItem()+1;i++)
            {
                comboBox3.getItems().addAll(i);
            }
        });
        listView = new ListView<String>();
        listView2 = new ListView<String>();
        listView2.setDisable(true);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(oneway.isSelected()){
                    if(newValue!=null){
                        nextButton2.setDisable(false);
                    }
                }
                else{
                    if(newValue!=null){
                        listView2.setDisable(false);
                        listView2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                            @Override
                            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                                if(newValue!=null){
                                    nextButton2.setDisable(false);
                                }
                            }
                        });
                    }
                }
            }
        });

        nextButton2.setMinSize(200, 65);
        nextButton2.setFont(Font.font("Serif", FontWeight.BLACK,30));
        Button backButton1 = new Button("Back");
        backButton1.setMinSize(100, 50);
        backButton1.setFont(Font.font("Serif", FontWeight.BLACK,22));
        backButton1.setOnAction(e -> MainScene.routeSelectScene());

        VBox flightOut =new VBox();
        flightOut.getChildren().addAll(flightOutTimeLabel,listView);

        VBox flightBack =new VBox();
        flightBack.getChildren().addAll(flightBackTimeLabel,listView2);

        HBox flightTimes = new HBox();
        flightTimes.setSpacing(150);
        flightTimes.getChildren().addAll(flightOut,flightBack);

        HBox buttons = new HBox();
        buttons.setSpacing(10);
        buttons.setMargin(backButton1, new Insets(9,15,0,0));
        buttons.getChildren().addAll(backButton1,nextButton2);

        VBox pageThree =new VBox();
        pageThree.setMargin(availableTimeLabel, new Insets(30,30,30,100));
        pageThree.setMargin(flightTimes, new Insets(30,30,30,300));
        pageThree.setMargin(buttons, new Insets(30,30,30,450));
        pageThree.getChildren().addAll(availableTimeLabel,flightTimes,buttons);
        BorderPane timesLayout = new BorderPane();
        timesLayout.setCenter(pageThree);

        timesLayout.setStyle("-fx-background-color: #5F9EA0;");
        scene3 = new Scene(timesLayout, 1200, 800);
        //scene3.getStylesheets().add("style1.css");
    }

    public static Scene getScene3() {
        return scene3;
    }
}
