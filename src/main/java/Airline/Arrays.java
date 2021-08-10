package Airline;

import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Arrays {
    static ArrayList<CheckBox> spanish,outBag,returnBag,spanish2,outBag2,returnBag2;
    static ArrayList<TextField> name,name2,name3,dni,dni2;
    static ArrayList<DatePicker> dob,dob2,dob3;


    static int count = 1;
    static int count2=0;
    static int count3=0;

    static ArrayList<VBox> questions,questions2,inputs,inputs2,infant;
    static ArrayList<HBox> adult,child;
    public static void arrays(){
        adult = new ArrayList<HBox>(count);
        questions = new ArrayList<VBox>(count);
        inputs = new ArrayList<VBox>(count);
        spanish = new ArrayList<CheckBox>(count);
        outBag = new ArrayList<CheckBox>(count);
        returnBag = new ArrayList<CheckBox>(count);
        name = new ArrayList<TextField>(count);
        dni = new ArrayList<TextField>(count);
        dob = new ArrayList<DatePicker>(count);
    }
    public static void arrays2(){
        child = new ArrayList<HBox>(count2);
        questions2 = new ArrayList<VBox>(count2);
        inputs2 = new ArrayList<VBox>(count2);
        spanish2 = new ArrayList<CheckBox>(count2);
        outBag2 = new ArrayList<CheckBox>(count2);
        returnBag2 = new ArrayList<CheckBox>(count2);
        name2 = new ArrayList<TextField>(count2);
        dni2 = new ArrayList<TextField>(count2);
        dob2 = new ArrayList<DatePicker>(count2);
    }
    public static void arrays3(){

        infant = new ArrayList<VBox>(count3);
        name3 = new ArrayList<TextField>(count3);
        dob3 = new ArrayList<DatePicker>(count3);
    }
}
