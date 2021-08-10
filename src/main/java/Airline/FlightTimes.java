package Airline;

import javafx.scene.control.ListView;

import static Airline.RouteSelectScene.comboBox1;
import static Airline.RouteSelectScene.comboBox2;

public class FlightTimes {
    static ListView<String> listView,listView2;
    public static void flightTimes(){
        String origin=comboBox1.getSelectionModel().getSelectedItem();
        String destination=comboBox2.getSelectionModel().getSelectedItem();
        listView.getItems().clear();
        listView2.getItems().clear();

        if(origin.equals("Cork(ORK)") && destination.equals("Madrid(MAD)")){
            listView.getItems().add("09:20-13:00");
            listView2.getItems().add("18:00-20:00");
        }
        if(destination.equals("Cork(ORK)") && origin.equals("Madrid(MAD)")){
            listView2.getItems().add("09:20-13:00");
            listView.getItems().add("18:00-20:00");
        }
        if(origin.equals("Cork(ORK)") && destination.equals("St Brieuc(SBK)")){
            listView.getItems().add("10:30-14:00");
            listView2.getItems().add("19:00-20:20");
        }
        if(destination.equals("Cork(ORK)") && origin.equals("St Brieuc(SBK)")){
            listView2.getItems().add("10:30-14:00");
            listView.getItems().add("19:00-20:20");
        }
        if(origin.equals("Cork(ORK)") && destination.equals("Jersey(JER)")){
            listView.getItems().add("14:00-16:00");
            listView2.getItems().add("10:00-12:00");
        }
        if(destination.equals("Cork(ORK)") && origin.equals("Jersey(JER)")){
            listView2.getItems().add("14:00-16:00");
            listView.getItems().add("10:00-12:00");
        }
        if(origin.equals("Cork(ORK)") && destination.equals("Paris(CDG)")){
            listView.getItems().addAll("09:00-12:15","16:20-21:05");
            listView2.getItems().addAll("13:30-15:00","22:00-23:50");
        }
        if(destination.equals("Cork(ORK)") && origin.equals("Paris(CDG)")){
            listView2.getItems().addAll("09:00-12:15","16:20-21:05");
            listView.getItems().addAll("13:30-15:00","22:00-23:50");
        }
        if(origin.equals("Cork(ORK)") && destination.equals("Stansted(STN)")){
            listView.getItems().addAll("08:20-09:50","11:20-13:05");
            listView2.getItems().addAll("11:00-12:20","18:00-19:20");
        }
        if(destination.equals("Cork(ORK)") && origin.equals("Stansted(STN)")){
            listView2.getItems().addAll("08:20-09:50","11:20-13:05");
            listView.getItems().addAll("11:00-12:20","18:00-19:20");
        }
        if(origin.equals("Cork(ORK)") && destination.equals("Malaga(AGP)")){
            listView.getItems().addAll("08:00-11:30");
            listView2.getItems().addAll("13:00-14:20");
        }
        if(destination.equals("Cork(ORK)") && origin.equals("Malaga(AGP)")){
            listView2.getItems().addAll("08:00-11:30");
            listView.getItems().addAll("13:00-14:20");
        }
        if(origin.equals("Madrid(MAD)") && destination.equals("St Brieuc(SBK)")){
            listView.getItems().add("12:00-13:30");
            listView2.getItems().add("18:00-20:20");
        }
        if(destination.equals("Madrid(MAD)") && origin.equals("St Brieuc(SBK)")){
            listView2.getItems().add("12:00-13:30");
            listView.getItems().add("18:00-20:20");
        }
        if(origin.equals("Madrid(MAD)") && destination.equals("Jersey(JER)")){
            listView.getItems().add("06:20-08:00");
            listView2.getItems().add("18:00-21:20");
        }
        if(destination.equals("Madrid(MAD)") && origin.equals("Jersey(JER)")){
            listView2.getItems().add("06:20-08:00");
            listView.getItems().add("18:00-21:20");
        }
        if(origin.equals("Madrid(MAD)") && destination.equals("Paris(CDG)")){
            listView.getItems().addAll("08:00-10:00");
            listView2.getItems().addAll("19:20-21:05");
        }
        if(destination.equals("Madrid(MAD)") && origin.equals("Paris(CDG)")){
            listView2.getItems().addAll("08:00-10:00");
            listView.getItems().addAll("19:20-21:05");
        }
        if(origin.equals("Madrid(MAD)") && destination.equals("Stansted(STN)")){
            listView.getItems().addAll("14:00-15:20","19:05-21:20");
            listView2.getItems().addAll("10:20-14:00");
        }
        if(destination.equals("Madrid(MAD)") && origin.equals("Stansted(STN)")){
            listView2.getItems().addAll("14:00-15:20","19:05-21:20");
            listView.getItems().addAll("10:20-14:00");
        }
        if(origin.equals("Madrid(MAD)") && destination.equals("Malaga(AGP)")){
            listView.getItems().addAll("08:00-09:05");
            listView2.getItems().addAll("20:00-21:05");
        }
        if(destination.equals("Madrid(MAD)") && origin.equals("Malaga(AGP)")){
            listView2.getItems().addAll("08:00-09:05");
            listView.getItems().addAll("20:00-21:05");
        }
        if(origin.equals("St Brieuc(SBK)") && destination.equals("Paris(CDG)")){
            listView.getItems().addAll("06:20-07:15");
            listView2.getItems().addAll("19:00-20:05");
        }
        if(destination.equals("St Brieuc(SBK)") && origin.equals("Paris(CDG)"))	{
            listView2.getItems().addAll("06:20-07:15");
            listView.getItems().addAll("19:00-20:05");
        }
        if(origin.equals("St Brieuc(SBK)") && destination.equals("Stansted(STN)")){
            listView.getItems().addAll("08:05-08:30");
            listView2.getItems().addAll("18:00-20:00");
        }
        if(destination.equals("St Brieuc(SBK)") && origin.equals("Stansted(STN)")){
            listView2.getItems().addAll("08:05-08:30");
            listView.getItems().addAll("18:00-20:00");
        }
        if(origin.equals("St Brieuc(SBK)") && destination.equals("Malaga(AGP)")){
            listView.getItems().addAll("12:00-15:30");
            listView2.getItems().addAll("20:00-21:30");
        }
        if(destination.equals("St Brieuc(SBK)") && origin.equals("Malaga(AGP)")){
            listView2.getItems().addAll("12:00-15:30");
            listView.getItems().addAll("20:00-21:30");
        }
        if(origin.equals("Jersey(JER)") && destination.equals("Paris(CDG)")){
            listView.getItems().addAll("08:00-10:15");
            listView2.getItems().addAll("20:00-20:15");
        }
        if(destination.equals("Jersey(JER)") && origin.equals("Paris(CDG)")){
            listView2.getItems().addAll("08:00-10:15");
            listView.getItems().addAll("20:00-20:15");
        }
        if(origin.equals("Jersey(JER)") && destination.equals("Stansted(STN)")){
            listView.getItems().addAll("17:00-18:30");
            listView2.getItems().addAll("09:00-10:30");
        }
        if(destination.equals("Jersey(JER)") && origin.equals("Stansted(STN)")){
            listView2.getItems().addAll("17:00-18:30");
            listView.getItems().addAll("09:00-10:30");
        }
        if(origin.equals("Jersey(JER)") && destination.equals("Malaga(AGP)")){
            listView.getItems().addAll("08:00-11:30");
            listView2.getItems().addAll("18:00-19:30");
        }
        if(destination.equals("Jersey(JER)") && origin.equals("Malaga(AGP)")){
            listView2.getItems().addAll("08:00-11:30");
            listView.getItems().addAll("18:00-19:30");
        }
        if(origin.equals("Paris(CDG)") && destination.equals("Stansted(STN)")){
            listView.getItems().addAll("18:00-18:30");
            listView2.getItems().addAll("09:00-10:30");
        }
        if(destination.equals("Paris(CDG)") && origin.equals("Stansted(STN)")){
            listView2.getItems().addAll("18:00-18:30");
            listView.getItems().addAll("09:00-10:30");
        }
        if(origin.equals("Paris(CDG)") && destination.equals("Malaga(AGP)")){
            listView.getItems().addAll("11:50-13:30");
            listView2.getItems().addAll("18:05-12:30");
        }
        if(destination.equals("Paris(CDG)") && origin.equals("Malaga(AGP)")){
            listView2.getItems().addAll("11:50-13:30");
            listView.getItems().addAll("18:05-12:30");
        }
        if(origin.equals("Stansted(STN)") && destination.equals("Malaga(AGP)")){
            listView.getItems().addAll("11:50-13:30");
            listView2.getItems().addAll("18:05-12:30");
        }
        if(destination.equals("Stansted(STN)") && origin.equals("Malaga(AGP)")){
            listView2.getItems().addAll("08:50-11:00","13:30-16:20");
            listView.getItems().addAll("15:00-16:10","20:35-21:05");
        }
    }
}
