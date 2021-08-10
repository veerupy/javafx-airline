package Airline;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

import java.time.LocalDate;

import static Airline.Alert.alert;
import static Airline.Arrays.*;
import static Airline.CreateAdultChildInfant.*;
import static Airline.DisplayBasicPrice.*;
import static Airline.DisplayDetails.displayDetails;
import static Airline.RouteSelectScene.*;

public class PassengerDetails {
    static Scene scene4;
    static ComboBox<Integer> comboBox3,comboBox4,comboBox5;
    static Label basicPrice;
    static Button nextButton3;
    public static void initialize(){
        Label passengerDetailsLabel = new Label("Passenger Details");
        passengerDetailsLabel.setFont(Font.font("Cambria", FontWeight.BOLD, 26));
        Label priceLabel = new Label("Basic Single Fare:");
        priceLabel.setFont(Font.font("Cambria", FontWeight.BOLD, 26));

        Separator separator3 = new Separator();

        comboBox3 = new ComboBox<>();
        comboBox3.setMinWidth(200);
        comboBox3.setMinHeight(25);

        comboBox3.setPromptText("Adults 6+");
        comboBox3.setOnAction(e-> {
            createAdult();
            comboBox4.getItems().clear();
            for(int i=0; i<comboBox.getSelectionModel().getSelectedItem()-comboBox3.getSelectionModel().getSelectedItem()+1;i++)
            {
                comboBox4.getItems().addAll(i);
            }
            dobDates();
        });
        comboBox4 = new ComboBox<>();
        comboBox4.setMinWidth(200);
        comboBox4.setMinHeight(25);
        comboBox4.setOnAction(e -> {
            try{
                createChild();
                comboBox5.getItems().clear();
                for(int i=0; i<comboBox.getSelectionModel().getSelectedItem()-(comboBox3.getSelectionModel().getSelectedItem()+comboBox4.getSelectionModel().getSelectedItem())+1;i++)
                {
                    comboBox5.getItems().addAll(i);
                }
                dobDates();
            }catch(NullPointerException n)
            {
                System.out.println("");
            }
        });
        comboBox4.setPromptText("Children(2-5)");
        comboBox5 = new ComboBox<>();
        comboBox5.setMinWidth(200);
        comboBox5.setMinHeight(25);
        comboBox5.setPromptText("Infants(Under 2)");
        comboBox5.setOnAction(e ->{
            try{
                createInfant();
                dobDates();
            }catch(NullPointerException p)
            {
                System.out.println("");
            }
        });


        nextButton3 = new Button("Proceed To Checkout");
        nextButton3.setOnAction(e -> {
            if(comboBox3.getSelectionModel().isEmpty() || comboBox4.getSelectionModel().isEmpty()||comboBox5.getSelectionModel().isEmpty())
            {
                alert("You must select all passengers values");
            }
            else if((comboBox3.getSelectionModel().getSelectedItem()*2)<(comboBox4.getSelectionModel().getSelectedItem()+comboBox5.getSelectionModel().getSelectedItem()))
            {
                alert("One Adult cannot book more than 2 children under 6 ears of age");
            }
            else if(comboBox3.getSelectionModel().getSelectedItem()+comboBox4.getSelectionModel().getSelectedItem()+comboBox5.getSelectionModel().getSelectedItem()!=comboBox.getSelectionModel().getSelectedItem())
            {
                alert("You did not select enough passengers");
            }
            else
            {
                int count =0;
                for(int i=0; i<dob.size();i++)
                {
                    if(dob.get(i).getValue().isAfter(LocalDate.now().minusYears(18)))
                    {
                        count++;
                    }
                }
                if(count==comboBox3.getSelectionModel().getSelectedItem())
                {
                    alert("At least one adult must be present");
                }
                else if(((comboBox3.getSelectionModel().getSelectedItem()-count)*2)<(comboBox4.getSelectionModel().getSelectedItem()+comboBox5.getSelectionModel().getSelectedItem()))
                {
                    alert("One Adult cannot book more than 2 children under 6 ears of age");
                }
                else
                {
                    MainScene.flightDetails();
                    displayDetails();
                }
            }
        });

        calculateBasicPrice();

        basicPrice = new Label(""+getBasicPrice());
//        displayBasicPrice();
        basicPrice.setFont(Font.font("Cambria", FontWeight.BOLD, 26));

        nextButton3.setMinSize(500, 25);
        Button backButton3 = new Button("Back");
        backButton3.setOnAction(e -> MainScene.routeSelectScene());
        HBox priceLabels= new HBox();
        priceLabels.getChildren().addAll(priceLabel,basicPrice);

        HBox pageFourLabels = new HBox();
        pageFourLabels.setSpacing(450);
        pageFourLabels.getChildren().addAll(passengerDetailsLabel,priceLabels);

        p = new VBox();
        p2 = new VBox();
        p3= new VBox();

        VBox adultBox=new VBox();
        adultBox.setSpacing(10);
        adultBox.getChildren().addAll(comboBox3,p);

        VBox childBox=new VBox();
        childBox.setSpacing(10);
        childBox.getChildren().addAll(comboBox4,p2);

        VBox infantBox=new VBox();
        infantBox.setSpacing(10);
        infantBox.getChildren().addAll(comboBox5,p3);


        HBox numOfPassangersInputs = new HBox();
        numOfPassangersInputs.setSpacing(100);
        numOfPassangersInputs.getChildren().addAll(adultBox,childBox,infantBox);

        VBox pageFour =new VBox();
        pageFour.setMargin(pageFourLabels, new Insets(30,30,30,100));
        pageFour.setMargin(numOfPassangersInputs, new Insets(30,30,30,100));
        pageFour.setMargin(nextButton3, new Insets(30,30,30,400));
        pageFour.getChildren().addAll(pageFourLabels,separator3,numOfPassangersInputs,nextButton3);

        BorderPane passengersLayout = new BorderPane();
        passengersLayout.setCenter(pageFour);

        ScrollPane scrollPane = new ScrollPane(passengersLayout);
        scrollPane.setFitToHeight(true);

        passengersLayout.setStyle("-fx-background-color: #5F9EA0;");
        scene4=new Scene(scrollPane,1200,800);
        //scene4.getStylesheets().add("style1.css");
    }

    public static Scene getScene4() {
        return scene4;
    }

    private static void dobDates(){
        try{
            for(int i=0; i<dob.size();i++)
            {
                final Callback<DatePicker, DateCell> dayCellFactory =
                        new Callback<DatePicker, DateCell>() {
                            @Override
                            public DateCell call(final DatePicker datePicker)
                            {
                                return new DateCell()
                                {
                                    @Override
                                    public void updateItem(LocalDate currentDate, boolean empty)
                                    {
                                        super.updateItem(currentDate, empty);

                                        if (currentDate.isAfter(LocalDate.now().minusYears(6)) || currentDate.isAfter(LocalDate.now()))
                                        {
                                            setDisable(true);
                                            setStyle("-fx-background-color: #ffc0cb;");
                                        }
                                    }
                                };
                            }
                        };
                dob.get(i).setDayCellFactory(dayCellFactory);
                dob.get(i).setValue(LocalDate.now().minusYears(6));
            }
            for(int i=0; i<dob2.size();i++)
            {
                if(comboBox4.getSelectionModel().getSelectedItem()!=0)
                {

                    final Callback<DatePicker, DateCell> dayCellFactory =
                            new Callback<DatePicker, DateCell>() {
                                @Override
                                public DateCell call(final DatePicker datePicker)
                                {
                                    return new DateCell()
                                    {
                                        @Override
                                        public void updateItem(LocalDate currentDate, boolean empty)
                                        {
                                            super.updateItem(currentDate, empty);


                                            if (currentDate.isAfter(LocalDate.now().minusYears(2)) || currentDate.isAfter(LocalDate.now()))
                                            {
                                                setDisable(true);
                                                setStyle("-fx-background-color: #ffc0cb;");
                                            }


                                        }
                                    };
                                }
                            };

                    dob2.get(i).setDayCellFactory(dayCellFactory);
                    dob2.get(i).setValue(LocalDate.now().minusYears(2));
                }
            }
            for(int i=0; i<dob3.size();i++)
            {
                if(comboBox5.getSelectionModel().getSelectedItem()!=0)
                {

                    final Callback<DatePicker, DateCell> dayCellFactory =
                            new Callback<DatePicker, DateCell>() {
                                @Override
                                public DateCell call(final DatePicker datePicker)
                                {
                                    return new DateCell()
                                    {
                                        @Override
                                        public void updateItem(LocalDate currentDate, boolean empty)
                                        {
                                            super.updateItem(currentDate, empty);

                                            if (currentDate.isBefore(LocalDate.now().minusYears(2)) || currentDate.isAfter(LocalDate.now()))
                                            {
                                                setDisable(true);
                                                setStyle("-fx-background-color: #ffc0cb;");
                                            }
                                        }
                                    };
                                }
                            };
                    dob3.get(i).setDayCellFactory(dayCellFactory);
                    dob3.get(i).setValue(LocalDate.now().minusYears(2));
                }
            }
        }catch(NullPointerException e)
        {
            System.out.println("");
        }
    }

}
