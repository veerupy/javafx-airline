package Airline;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Random;

import static Airline.Alert.alert;
import static Airline.BookingDetails.refNumber;

public class FlightDetails {
    static Scene scene5;
    static ComboBox<String> cardExpYear,cardExpMonth;
    static Label names,routes,minors,totalCost;
    static TextField creditCardInput,cvvNo;
    static Random rand;
    public static void initialize(){
        Label flightDetails = new Label("Flight Details");
        flightDetails.setFont(Font.font("Cambria", FontWeight.BOLD, 20));
        Separator separator4 = new Separator();
        Label route = new Label("Route: ");
        route.setFont(Font.font("Cambria", FontWeight.BOLD, 14));
        Separator separator5 = new Separator();
        Label passengers = new Label("Passengers:");
        passengers.setFont(Font.font("Cambria", FontWeight.BOLD, 14));
        Label minorsLabel = new Label("Minors:");
        minorsLabel.setFont(Font.font("Cambria", FontWeight.BOLD, 14));
        Separator separator6 = new Separator();
        Label finalPrice = new Label("Total Cost: ");
        finalPrice.setFont(Font.font("Cambria", FontWeight.BOLD, 20));
        Separator separator7 = new Separator();
        names = new Label("");
        routes = new Label("");
        minors = new Label("");
        totalCost= new Label("");

        HBox fCost= new HBox();
        fCost.getChildren().addAll(finalPrice,totalCost);


        Label payment = new Label("Payment");
        payment.setFont(Font.font("Cambria", FontWeight.BOLD, 18));
        Label cardLabel= new Label("Enter credit card number");
        creditCardInput= new TextField();

        cardExpYear= new ComboBox();
        cardExpYear.setPromptText("Year");
        cardExpYear.getItems().addAll("2017","2018","2019","2020","2021","2022");
        cardExpMonth= new ComboBox();
        cardExpMonth.setPromptText("Month");
        cardExpMonth.getItems().addAll("January","February","March","April","May","June","July","August","September","October","November","December");
        cvvNo= new TextField();
        cvvNo.setPromptText("CVV");
        cvvNo.setMaxWidth(50);
        Label expDateLabel = new Label("Enter Expiry Date:");

        Button checkoutBtn=new Button("Checkout");
        checkoutBtn.setMinSize(250,50);
        checkoutBtn.setOnAction(e-> {
            if(cardExpYear.getSelectionModel().isEmpty() || cardExpMonth.getSelectionModel().isEmpty())
            {
                alert("Please fill out all credit card details");
            }
            else
            {
                int check = cardCheck();
                if(check==0){
                    MainScene.bookingDetails();
                    rand = new Random();
                    int ref=rand.nextInt(100000000);
                    refNumber.setText("Ref No.: "+ref);
                }
            }
        });

        HBox expDate= new HBox();
        expDate.setSpacing(5);
        expDate.getChildren().addAll(expDateLabel,cardExpYear,cardExpMonth);


        VBox detailsLabels = new VBox();
        detailsLabels.setMargin(flightDetails, new Insets(1,10,10,50));
        detailsLabels.setMargin(route, new Insets(1,10,10,50));
        detailsLabels.setMargin(passengers, new Insets(1,10,10,50));
        detailsLabels.setMargin(names, new Insets(1,10,10,50));
        detailsLabels.setMargin(routes, new Insets(1,10,10,200));
        detailsLabels.setMargin(minorsLabel, new Insets(1,10,10,50));
        detailsLabels.setMargin(minors, new Insets(1,10,10,50));
        detailsLabels.setMargin(finalPrice, new Insets(1,10,10,50));
        detailsLabels.getChildren().addAll(flightDetails,separator4,route,routes,separator5,passengers,names,separator6,minorsLabel,minors,separator7,fCost);


        HBox paymentValidation = new HBox();
        paymentValidation.setSpacing(5);
        paymentValidation.getChildren().addAll(cardLabel,creditCardInput);

        VBox paymentDetails =new VBox();
        paymentDetails.setMargin(cvvNo, new Insets(20,10,10,100));
        paymentDetails.getChildren().addAll(expDate,cvvNo,paymentValidation);

        VBox pageFive = new VBox();
        pageFive.setSpacing(5);
        pageFive.setMargin(payment, new Insets(20,10,10,550));
        pageFive.setMargin(paymentDetails, new Insets(20,10,10,475));
        pageFive.setMargin(checkoutBtn, new Insets(20,10,10,500));
        pageFive.getChildren().addAll(detailsLabels,payment,paymentDetails,checkoutBtn);

        BorderPane checkoutLayout = new BorderPane();
        checkoutLayout.setCenter(pageFive);

        checkoutLayout.setStyle("-fx-background-color: #5F9EA0;");

        scene5=new Scene(checkoutLayout,1200,800);
        //scene5.getStylesheets().add("style1.css");



    }

    public static Scene getScene5() {
        return scene5;
    }

    public static int cardCheck(){
        int sum=0;
        String card= creditCardInput.getText();

        if(creditCardInput.getText().isEmpty() || creditCardInput.getText().length()!=12 || card.matches("[a-z]*"))
        {
            alert("Bad credit card number");
            return 1;
        }
        else{
            return 0;
        }

    }
}
