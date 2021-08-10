package Airline;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainScene {
    static Stage window = new Stage();
    static Scene scene;
    public static void enterScene(){
        EnterScene.initialize();
        scene = EnterScene.getScene1();
        window.setScene(scene);
        window.show();
    }
    public static void routeSelectScene(){
        RouteSelectScene.initialize();
        scene = RouteSelectScene.getScene2();
        window.setScene(scene);
    }
    public static void availableTimesScene(){
        AvailableTimesScene.initialize();
        scene = AvailableTimesScene.getScene3();
        window.setScene(scene);
    }
    public static void passengerDetailsScene(){
        PassengerDetails.initialize();
        scene = PassengerDetails.getScene4();
        window.setScene(scene);
    }
    public static void flightDetails(){
        FlightDetails.initialize();
        scene = FlightDetails.getScene5();
        window.setScene(scene);
    }
    public static void bookingDetails(){
        BookingDetails.initialize();
        scene = BookingDetails.getScene6();
        window.setScene(scene);
    }
}
