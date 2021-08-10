package Airline;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.time.LocalDate;

import static Airline.Alert.alert;
import static Airline.Arrays.*;
import static Airline.Arrays.name3;
import static Airline.DisplayBasicPrice.displayBasicPrice;
import static Airline.DisplayBasicPrice.getBasicPrice;
import static Airline.FlightDetails.*;
import static Airline.FlightTimes.listView2;
import static Airline.FlightTimes.listView;

import static Airline.PassengerDetails.*;
import static Airline.RouteSelectScene.*;

public class DisplayDetails {
    public static void displayDetails(){
        String details ="";
        String children="";
        double finalCost=getBasicPrice();
        double x = getBasicPrice()*60/100;
        finalCost*=comboBox3.getSelectionModel().getSelectedItem();
        if(!oneway.isSelected()){
            finalCost*=2;
        }
        for(int i=0; i<name.size(); i++)
        {
            if(dob.get(i).getValue().isAfter(LocalDate.now().minusYears(18)))
            {
                children += name.get(i).getText() +" (DOB: "+dob.get(i).getValue()+")"+ "\n";
            }
            if(outBag.get(i).isSelected())
            {
                finalCost+=15;
            }
            if(returnBag.get(i).isSelected())
            {
                finalCost+=15;
            }
            if(outBag.get(i).isSelected() && returnBag.get(i).isSelected()==false)
            {
                details += name.get(i).getText() + "- Outbound Bags-1" +"\n";
            }
            else if(returnBag.get(i).isSelected() && outBag.get(i).isSelected()==false)
            {
                details += name.get(i).getText() + "- Inbound Bags-1" +"\n";
            }
            else if(outBag.get(i).isSelected() && returnBag.get(i).isSelected())
            {
                details += name.get(i).getText() + "- Inbound Bags-1 Outbound Bags-1" +"\n";
            }
            else
            {
                details += name.get(i).getText() +"\n";
            }

            if(spanish.get(i).isSelected() && oneway.isSelected() &&(comboBox1.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") || comboBox2.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") || comboBox1.getSelectionModel().getSelectedItem().equals("Malaga(AGP)") || comboBox2.getSelectionModel().getSelectedItem().equals("Malaga(AGP)")))
            {
                if(dniCheck(dni.get(i).getText()))
                {
                    finalCost-=5;
                }
            }
            else if(spanish.get(i).isSelected() && oneway.isSelected() &&((comboBox1.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") && comboBox2.getSelectionModel().getSelectedItem().equals("Madrid(MAD)"))|| (comboBox1.getSelectionModel().getSelectedItem().equals("Malaga(AGP)") && comboBox2.getSelectionModel().getSelectedItem().equals("Malaga(AGP)"))))
            {
                if(dniCheck(dni.get(i).getText()))
                {
                    finalCost-=10;
                }
            }
            else if(spanish.get(i).isSelected() && oneway.isSelected()==false &&(comboBox1.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") || comboBox2.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") || comboBox1.getSelectionModel().getSelectedItem().equals("Malaga(AGP)") || comboBox2.getSelectionModel().getSelectedItem().equals("Malaga(AGP)")))
            {
                if(dniCheck(dni.get(i).getText()))
                {
                    finalCost-=10;
                }
            }
            else if(spanish.get(i).isSelected() && oneway.isSelected()==false &&((comboBox1.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") && comboBox2.getSelectionModel().getSelectedItem().equals("Madrid(MAD)"))|| (comboBox1.getSelectionModel().getSelectedItem().equals("Malaga(AGP)") && comboBox2.getSelectionModel().getSelectedItem().equals("Malaga(AGP)"))))
            {
                if(dniCheck(dni.get(i).getText()))
                {
                    finalCost-=20;
                }
            }
        }

        if(comboBox4.getSelectionModel().getSelectedItem()!=0)
        {
            for(int j=0; j<name2.size();j++)
            {

                children += name2.get(j).getText() +" (DOB: "+dob2.get(j).getValue()+")"+ "\n";
                if(oneway.isSelected())
                {
                    finalCost+=x;
                }
                else
                {
                    finalCost+=x*2;
                }

                if(outBag2.get(j).isSelected())
                {
                    finalCost+=15;
                }
                if(returnBag2.get(j).isSelected())
                {
                    finalCost+=15;
                }

                if(outBag2.get(j).isSelected() && returnBag2.get(j).isSelected()==false)
                {
                    details += name2.get(j).getText() + "- Outbound Bags-1" +"\n";
                }
                else if(returnBag2.get(j).isSelected() && outBag2.get(j).isSelected()==false)
                {
                    details += name2.get(j).getText() + "- Inbound Bags-1" +"\n";
                }
                else if(outBag2.get(j).isSelected() && returnBag2.get(j).isSelected())
                {
                    details += name2.get(j).getText() + "- Inbound Bags-1 Outbound Bags-1" +"\n";
                }
                else
                {
                    details += name2.get(j).getText() +"\n";
                }

                if(spanish2.get(j).isSelected() && oneway.isSelected() &&(comboBox1.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") || comboBox2.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") || comboBox1.getSelectionModel().getSelectedItem().equals("Malaga(AGP)") || comboBox2.getSelectionModel().getSelectedItem().equals("Malaga(AGP)")))
                {
                    if(dniCheck(dni2.get(j).getText()))
                    {
                        finalCost-=5;
                    }
                }
                else if(spanish2.get(j).isSelected() && oneway.isSelected() &&((comboBox1.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") && comboBox2.getSelectionModel().getSelectedItem().equals("Madrid(MAD)"))|| (comboBox1.getSelectionModel().getSelectedItem().equals("Malaga(AGP)") && comboBox2.getSelectionModel().getSelectedItem().equals("Malaga(AGP)"))))
                {
                    if(dniCheck(dni2.get(j).getText()))
                    {
                        finalCost-=10;
                    }
                }
                else if(spanish2.get(j).isSelected() && oneway.isSelected()==false &&(comboBox1.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") || comboBox2.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") || comboBox1.getSelectionModel().getSelectedItem().equals("Malaga(AGP)") || comboBox2.getSelectionModel().getSelectedItem().equals("Malaga(AGP)")))
                {
                    if(dniCheck(dni2.get(j).getText()))
                    {
                        finalCost-=10;
                    }
                }
                else if(spanish2.get(j).isSelected() && oneway.isSelected()==false &&((comboBox1.getSelectionModel().getSelectedItem().equals("Madrid(MAD)") && comboBox2.getSelectionModel().getSelectedItem().equals("Madrid(MAD)"))|| (comboBox1.getSelectionModel().getSelectedItem().equals("Malaga(AGP)") && comboBox2.getSelectionModel().getSelectedItem().equals("Malaga(AGP)"))))
                {
                    if(dniCheck(dni2.get(j).getText()))
                    {
                        finalCost-=20;
                    }
                }
            }
        }
        if(comboBox5.getSelectionModel().getSelectedItem()!=0)
        {
            for(int k=0; k<name3.size();k++)
            {
                children += name3.get(k).getText() +" (DOB: "+dob3.get(k).getValue()+")"+ "\n";
                details += name3.get(k).getText() +"\n";
            }
        }

        names.setText(details);
        names.setFont(Font.font("Cambria", FontWeight.BOLD, 12));
        minors.setText(children);
        minors.setFont(Font.font("Cambria", FontWeight.BOLD, 12));
        totalCost.setText(""+finalCost);
        totalCost.setFont(Font.font("Cambria", FontWeight.BOLD, 20));

        if(oneway.isSelected())
        {
            routes.setText("("+departureDate.getValue()+")    "+comboBox1.getValue()+"\t--------------------------->\t"+comboBox2.getValue() +" Flight Duration: "+listView.getSelectionModel().getSelectedItem());
            routes.setFont(Font.font("Cambria", FontWeight.BOLD, 14));
        }
        else
        {
            routes.setText("("+departureDate.getValue()+")    "+comboBox1.getValue()+"\t--------------------------->\t"+comboBox2.getValue()+" Flight Duration: "+listView.getSelectionModel().getSelectedItem()+"\n"+"("+returnDate.getValue()+")    "+comboBox2.getValue()+"\t--------------------------->\t"+comboBox1.getValue()+" Flight Duration: "+listView2.getSelectionModel().getSelectedItem());
            routes.setFont(Font.font("Cambria", FontWeight.BOLD, 14));
        }
    }
    public static boolean dniCheck(String number){
        boolean valid = true;
        if(number.toString().length()<9 || number.toString().length()>10)
        {
            valid = false;
        }
        else if(number.toString().length()==10)
        {
            if(number.toString().charAt(8)=='-')
            {
                number=number.substring(0,8)+number.substring(9,10);
            }
            else
            {
                valid = false;
            }
        }
        else if(number.substring(0,8).matches("\\d+"))
        {
            String dni_letters = "TRWAGMYFPDXBNJZSQVHLCKE";
            int dniNo=Integer.parseInt(number.toString().toUpperCase().substring(0,8));
            char letter = dni_letters.toUpperCase().charAt(dniNo%23);

            if(letter != number.toString().toUpperCase().charAt(8))
            {
                alert("bad dni");
                valid=false;
            }
        }
        else
        {
            valid = false;
        }
        return valid;
    }
}
