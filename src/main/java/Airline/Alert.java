package Airline;

public class Alert {
    public static void alert(String message){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Warning");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
