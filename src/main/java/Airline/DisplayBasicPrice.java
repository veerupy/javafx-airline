package Airline;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.time.DayOfWeek;

import static Airline.PassengerDetails.basicPrice;
import static Airline.RouteSelectScene.*;


public class DisplayBasicPrice {
    static int[][] fares= new int[7][7];
    public static int price;
    public static int getBasicPrice(){
        return fares[comboBox1.getSelectionModel().getSelectedIndex()][comboBox2.getSelectionModel().getSelectedIndex()+1];
    }

    public static void calculateBasicPrice()
    {
        fares[0][1]=100; fares[0][2]=100;fares[0][3]=120;fares[0][4]=80;fares[0][5]=40;fares[0][6]=240;
        fares[1][1]=100;fares[1][2]=200;fares[1][3]=200;fares[1][4]=60;fares[1][5]=60;fares[1][6]=60;
        fares[2][0]=100;fares[2][1]=200;fares[2][3]=150;fares[2][4]=80;fares[2][5]=140;
        fares[3][1]=120;fares[3][2]=200;fares[3][3]=0;fares[3][4]=250;fares[3][5]=250;fares[3][6]=280;
        fares[4][1]=80;fares[4][2]=60;fares[4][3]=150;fares[4][4]=0;fares[4][5]=60;fares[4][6]=100;
        fares[5][1]=40;fares[5][2]=60;fares[5][3]=80;fares[5][4]=250;fares[5][5]=0;fares[5][6]=120;
        fares[6][1]=240;fares[6][2]=60;fares[6][3]=140;fares[6][4]=280;fares[6][5]=100;fares[6][6]=120;
    }
    public static double displayBasicPrice(){
        price =getBasicPrice();
        if(oneway.isSelected())
        {
            if(departureDate.getValue().getDayOfWeek().equals(DayOfWeek.FRIDAY) || departureDate.getValue().getDayOfWeek().equals(DayOfWeek.SATURDAY) || departureDate.getValue().getDayOfWeek().equals(DayOfWeek.SUNDAY))
            {
                price+=(price/100)*20;
                basicPrice.setText(""+price);
                basicPrice.setFont(Font.font("Cambria", FontWeight.BOLD, 26));
            }
        }
        else if(oneway.isSelected()==false)
        {
            if((departureDate.getValue().getDayOfWeek().equals(DayOfWeek.FRIDAY) || departureDate.getValue().getDayOfWeek().equals(DayOfWeek.SATURDAY) || departureDate.getValue().getDayOfWeek().equals(DayOfWeek.SUNDAY)) &&!(returnDate.getValue().getDayOfWeek().equals(DayOfWeek.FRIDAY) || returnDate.getValue().getDayOfWeek().equals(DayOfWeek.SATURDAY) || returnDate.getValue().getDayOfWeek().equals(DayOfWeek.SUNDAY)))
            {
                price+=(price/100)*20;
                price+=getBasicPrice();
                basicPrice.setText(""+price);
                basicPrice.setFont(Font.font("Cambria", FontWeight.BOLD, 26));
            }
            else if((returnDate.getValue().getDayOfWeek().equals(DayOfWeek.FRIDAY) || returnDate.getValue().getDayOfWeek().equals(DayOfWeek.SATURDAY) || returnDate.getValue().getDayOfWeek().equals(DayOfWeek.SUNDAY))&&!(departureDate.getValue().getDayOfWeek().equals(DayOfWeek.FRIDAY) || departureDate.getValue().getDayOfWeek().equals(DayOfWeek.SATURDAY) || departureDate.getValue().getDayOfWeek().equals(DayOfWeek.SUNDAY)))
            {
                price+=(price/100)*20;
                price+=getBasicPrice();
                basicPrice.setText(""+price);
                basicPrice.setFont(Font.font("Cambria", FontWeight.BOLD, 26));
            }
            else if((returnDate.getValue().getDayOfWeek().equals(DayOfWeek.FRIDAY) || returnDate.getValue().getDayOfWeek().equals(DayOfWeek.SATURDAY) || returnDate.getValue().getDayOfWeek().equals(DayOfWeek.SUNDAY))&&(departureDate.getValue().getDayOfWeek().equals(DayOfWeek.FRIDAY) || departureDate.getValue().getDayOfWeek().equals(DayOfWeek.SATURDAY) || departureDate.getValue().getDayOfWeek().equals(DayOfWeek.SUNDAY)))
            {
                price*=2;
                price+=(price/100)*20;
                basicPrice.setText(""+price);
                basicPrice.setFont(Font.font("Cambria", FontWeight.BOLD, 26));
            }
        }
        else
        {
            if(oneway.isSelected())
            {
                basicPrice.setText(""+price);
                basicPrice.setFont(Font.font("Cambria", FontWeight.BOLD, 26));
            }
            else
            {
                price*=2;
                basicPrice.setText(""+price);
                basicPrice.setFont(Font.font("Cambria", FontWeight.BOLD, 26));
            }
        }
        return price;
    }
}
