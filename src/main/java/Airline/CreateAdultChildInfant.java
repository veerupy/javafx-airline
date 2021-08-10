package Airline;

import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static Airline.Arrays.*;
import static Airline.PassengerDetails.*;
import static Airline.RouteSelectScene.comboBox1;
import static Airline.RouteSelectScene.comboBox2;

public class CreateAdultChildInfant {
    static VBox p,p2,p3;
    public static void createAdult()
    {
        p.getChildren().clear();
        count=comboBox3.getSelectionModel().getSelectedItem();
        arrays();
        for (int i= 0; i < count; i++)
        {
            adult.add(i,new HBox());
            questions.add(i,new VBox());
            inputs.add(i,new VBox());
            spanish.add(i,new CheckBox("English?"));
            outBag.add(i,new CheckBox("Outbound Bag?"));
            returnBag.add(i,new CheckBox("Return Bag?"));
            name.add(i,new TextField("Name"));
            dob.add(i,new DatePicker());
            int x = i;
            dni.add(i,new TextField("Enter DNI"));
            dni.get(i).setVisible(false);
            spanish.get(i).setOnAction(e->{
                if(spanish.get(x).isSelected() &&(comboBox1.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") || comboBox1.getSelectionModel().getSelectedItem().equals("Malaga(AGP)") || comboBox2.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") || comboBox2.getSelectionModel().getSelectedItem().equals("Malaga(AGP)")))
                    dni.get(x).setVisible(true);
                else
                    dni.get(x).setVisible(false);
            });

            //questions.get(i).getChildren().addAll(spanish.get(i),outBag.get(i),returnBag.get(i));
            questions.get(i).setSpacing(1);
            inputs.get(i).getChildren().addAll(name.get(i),dob.get(i),dni.get(i));
            inputs.get(i).setSpacing(5);
            adult.get(i).getChildren().addAll(inputs.get(i),questions.get(i));
            adult.get(i).setSpacing(5);
            p.getChildren().addAll(adult.get(i));
            p.setSpacing(15);
        }
    }
    public static void createChild()
    {
        p2.getChildren().clear();
        count2=comboBox4.getSelectionModel().getSelectedItem();
        arrays2();
        for (int i= 0; i < count2; i++)
        {
            child.add(i,new HBox());
            questions2.add(i,new VBox());
            inputs2.add(i,new VBox());
            int x = i;
            spanish2.add(i,new CheckBox("English?"));
            outBag2.add(i,new CheckBox("Outbound Bag?"));
            returnBag2.add(i,new CheckBox("Return Bag?"));
            name2.add(i,new TextField("Name"));
            dob2.add(i,new DatePicker());
            dni2.add(i,new TextField("Enter DNI"));
            dni2.get(i).setVisible(false);
            spanish2.get(i).setOnAction(e->{
                if(spanish2.get(x).isSelected() &&(comboBox1.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") || comboBox1.getSelectionModel().getSelectedItem().equals("Malaga(AGP)") || comboBox2.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") || comboBox2.getSelectionModel().getSelectedItem().equals("Malaga(AGP)")))
                    dni2.get(x).setVisible(true);
                else
                    dni2.get(x).setVisible(false);
            });

            //questions2.get(i).getChildren().addAll(spanish2.get(i),outBag2.get(i),returnBag2.get(i));
            questions2.get(i).setSpacing(1);
            inputs2.get(i).getChildren().addAll(name2.get(i),dob2.get(i),dni2.get(i));
            inputs2.get(i).setSpacing(5);
            child.get(i).getChildren().addAll(inputs2.get(i),questions2.get(i));
            child.get(i).setSpacing(5);

            p2.getChildren().addAll(child.get(i));
            p2.setSpacing(15);
        }
    }
    public static void createInfant()
    {
        p3.getChildren().clear();
        count3=comboBox5.getSelectionModel().getSelectedItem();
        arrays3();
        for (int i= 0; i < count3; i++)
        {
            infant.add(i,new VBox());
            name3.add(i,new TextField("Name"));
            dob3.add(i,new DatePicker());
            infant.get(i).getChildren().addAll(name3.get(i),dob3.get(i));
            infant.get(i).setSpacing(5);
            p3.getChildren().addAll(infant.get(i));
            p3.setSpacing(15);
        }
    }
}
