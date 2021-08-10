package Airline;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.time.LocalDate;

import static Airline.Alert.alert;
import static Airline.ComplicatedDates.complicatedDates;
import static Airline.FlightTimes.flightTimes;
import static Airline.FlightTimes.listView2;
import static Airline.RegularDates.regularDates;

public class RouteSelectScene {
    static Scene scene2;
    static ComboBox<String> comboBox2;
    static ComboBox<String> comboBox1;
    static DatePicker departureDate;
    static DatePicker returnDate;
    static Button nextButton1;
    static RadioButton oneway;
    static ComboBox<Integer> comboBox;
    public static void initialize(){
        Label destinationsLabel = new Label("Select Origin and Destination");
        destinationsLabel.setFont(Font.font("Cambria", FontWeight.BOLD, 30));

        Label travelDatesLabel = new Label("Select Travel Dates");
        travelDatesLabel.setFont(Font.font("Cambria", FontWeight.BOLD, 30));

        Label noOfPassangersLabel = new Label("Select number of passengers");
        noOfPassangersLabel.setStyle("-fx-font-size:17;");
        Label retDateLabel = new Label("Select Return Date");
        retDateLabel.setStyle("-fx-font-size:17;");


        Separator separator1 = new Separator();
        Separator separator2 = new Separator();

        oneway = new RadioButton("One Way");
        oneway.getStyleClass().add("radio-color");
        oneway.setStyle("-fx-font-size:17;");

        returnDate = new DatePicker();
        returnDate.setDisable(true);
        departureDate = new DatePicker();
        departureDate.setOnAction(e-> {returnDate.setDisable(false);
            nextButton1.setDisable(false);
        });
        departureDate.setValue(LocalDate.now());
        returnDate.setValue(LocalDate.now().plusDays(5));
        regularDates();

        oneway.setOnAction(e-> {
            if(oneway.isSelected())
            {
                retDateLabel.setVisible(false);
                returnDate.setDisable(true);
                returnDate.setStyle("-fx-opacity: 0");
                returnDate.getEditor().setStyle("-fx-opacity: 0");
                returnDate.setValue(departureDate.getValue().plusDays(5));
            }
            else{
                retDateLabel.setVisible(true);
                returnDate.setDisable(false);
                returnDate.setStyle("-fx-opacity: 1");
                returnDate.getEditor().setStyle("-fx-opacity: 1");
            }
        });

        VBox depDate = new VBox();
        Label deptDateLabel = new Label("Select Departure Date");
        deptDateLabel.setStyle("-fx-font-size:17;");
        depDate.setSpacing(10);
        depDate.getChildren().addAll(deptDateLabel,departureDate);

        VBox retDate = new VBox();
        retDate.setSpacing(10);
        retDate.getChildren().addAll(retDateLabel,returnDate);

        HBox dates = new HBox();
        dates.setSpacing(175);
        dates.getChildren().addAll(depDate,retDate);

        comboBox1 = new ComboBox<>();
        comboBox1.setPromptText("Origin");
        comboBox1.setMinWidth(250);
        comboBox1.setMinHeight(50);


        comboBox1.setStyle("-fx-font-size:20;");

        comboBox1.getItems().addAll("Cork(ORK)","Madrid(MAD)","St Brieuc(SBK)","Jersey(JER)","Paris(CDG)","Stansted(STN)","Malaga(AGP)");
        comboBox2 = new ComboBox<>();
        comboBox2.setStyle("-fx-font-size:20;");
        comboBox2.setPromptText("Destination");
        comboBox2.setMinWidth(250);
        comboBox2.setMinHeight(50);
        comboBox2.getItems().addAll("Cork(ORK)","Madrid(MAD)","St Brieuc(SBK)","Jersey(JER)","Paris(CDG)","Stansted(STN)","Malaga(AGP)");

        comboBox1.setOnAction(e -> {

            try{
                comboBox2.getItems().clear();
                comboBox2.setPromptText("Destination");
                comboBox2.getItems().addAll("Cork(ORK)","Madrid(MAD)","St Brieuc(SBK)","Jersey(JER)","Paris(CDG)","Stansted(STN)","Malaga(AGP)");
                comboBox2.getItems().removeAll(comboBox1.getSelectionModel().getSelectedItem());

                if(comboBox1.getSelectionModel().getSelectedItem().equals("St Brieuc(SBK)"))
                {
                    comboBox2.getItems().remove("Jersey(JER)");
                }
                if(comboBox1.getSelectionModel().getSelectedItem().equals("Jersey(JER)"))
                {
                    comboBox2.getItems().remove("St Brieuc(SBK)");
                }

            }catch(NullPointerException n)
            {
                System.out.println("");
            }
        });

        comboBox2.setOnAction(e-> {

            try{
                if(comboBox2.getSelectionModel().getSelectedItem().equals("St Brieuc(SBK)"))
                {
                    comboBox1.getItems().remove("Jersey(JER)");
                }
                if(comboBox2.getSelectionModel().getSelectedItem().equals("Jersey(JER)"))
                {
                    comboBox1.getItems().remove("St Brieuc(SBK)");
                }
                complicatedDates();
            }catch(NullPointerException n)
            {
                System.out.println("");
            }
        });
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(1,2,3,4,5,6,7,8);
        comboBox.setValue(1);

        HBox originAndDestination = new HBox();
        originAndDestination.setSpacing(100);
        originAndDestination.getChildren().addAll(comboBox1,comboBox2);

        nextButton1 = new Button("Next");
        nextButton1.setFont(Font.font("Serif", FontWeight.BLACK,30));
        nextButton1.setDisable(true);
        nextButton1.setMinSize(250, 75);
        nextButton1.getStyleClass().add("button-blue");
        nextButton1.setOnAction(e -> {
            if(comboBox1.getSelectionModel().isEmpty() || comboBox2.getSelectionModel().isEmpty())
            {
                alert("Please select both, origin and destination");
            }
            else if(departureDate.getValue().isAfter(returnDate.getValue()))
            {
                alert("Cannot fly out and back on the same day or your departure date is after your return date");
            }
            else{
                MainScene.availableTimesScene();
                flightTimes();
                if(oneway.isSelected())
                {
                    listView2.setDisable(true);
                    //flightBackTimeLabel.setStyle("-fx-opacity: 0");
                    listView2.setStyle("-fx-opacity: 0");
                }
            }
        });

        HBox numOfPassengers = new HBox();
        numOfPassengers.setSpacing(20);
        numOfPassengers.getChildren().addAll(noOfPassangersLabel,comboBox);

        VBox pageTwo = new VBox();
        pageTwo.setSpacing(1);
        pageTwo.setMargin(destinationsLabel, new Insets(30,30,30,100));
        pageTwo.setMargin(originAndDestination, new Insets(30,30,30,300));
        pageTwo.setMargin(travelDatesLabel, new Insets(30,30,30,100));
        pageTwo.setMargin(oneway, new Insets(30,30,30,250));
        pageTwo.setMargin(dates, new Insets(30,30,30,300));
        pageTwo.setMargin(numOfPassengers, new Insets(30,30,30,250));
        pageTwo.setMargin(nextButton1, new Insets(30,30,30,450));
        pageTwo.getChildren().addAll(destinationsLabel,separator1,originAndDestination,travelDatesLabel,separator2,oneway,dates,numOfPassengers,nextButton1);

        BorderPane destinationsLayout = new BorderPane();
        destinationsLayout.setCenter(pageTwo);
        destinationsLayout.setStyle("-fx-background-color: #5F9EA0;");
        scene2 = new Scene(destinationsLayout, 1200, 800);
        //scene2.getStylesheets().add("style1.css");
    }
    public static Scene getScene2(){
        return scene2;
    }
}
