package Airline;

import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;

import java.time.LocalDate;
import java.time.Month;

import Airline.RouteSelectScene;

import static Airline.RegularDates.regularDates;
import static Airline.RouteSelectScene.*;

public class ComplicatedDates {
    public static void complicatedDates()
    {
        String origin=comboBox1.getSelectionModel().getSelectedItem();
        String destination=comboBox2.getSelectionModel().getSelectedItem();
        if((origin.equals("Paris(CDG)") && destination.equals("Stansted(STN)"))||(destination.equals("Paris(CDG)") && origin.equals("Stansted(STN)")))
        {
            final Callback<DatePicker, DateCell> dayCellFactory2 =
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

                                    if (currentDate.isBefore(LocalDate.now()) || currentDate.isAfter(returnDate.getValue().plusMonths(6)) || currentDate.getMonth()== Month.APRIL )
                                    {
                                        setDisable(true);
                                        setStyle("-fx-background-color: #ffc0cb;");
                                    }
                                }
                            };
                        }
                    };
            departureDate.setDayCellFactory(dayCellFactory2);
        }
        else if((origin.equals("Paris(CDG)") && destination.equals("Stansted(STN)")) || (destination.equals("Paris(CDG)") && origin.equals("Stansted(STN)")))
        {
            final Callback<DatePicker, DateCell> dayCellFactory3 =
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

                                    if (currentDate.isBefore(departureDate.getValue()) || currentDate.isAfter(returnDate.getValue().plusMonths(6)) || currentDate.getMonth()==Month.APRIL )
                                    {
                                        setDisable(true);
                                        setStyle("-fx-background-color: #ffc0cb;");
                                    }
                                }
                            };
                        }
                    };
            returnDate.setDayCellFactory(dayCellFactory3);
        }
        else if((origin.equals("St Brieuc(SBK)") && destination.equals("Stansted(STN)"))||(destination.equals("St Brieuc(SBK)") && origin.equals("Stansted(STN)")))
        {
            final Callback<DatePicker, DateCell> dayCellFactory4 =
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

                                    if (currentDate.isBefore(LocalDate.now()) || currentDate.isAfter(returnDate.getValue().plusMonths(6)) || (currentDate.getMonth()==Month.APRIL || currentDate.getMonth()==Month.MARCH))
                                    {
                                        setDisable(true);
                                        setStyle("-fx-background-color: #ffc0cb;");
                                    }
                                }
                            };
                        }
                    };
            departureDate.setDayCellFactory(dayCellFactory4);
        }
        else if((origin.equals("St Brieuc(SBK)") && destination.equals("Stansted(STN)"))||(destination.equals("St Brieuc(SBK)") && origin.equals("Stansted(STN)")))
        {
            final Callback<DatePicker, DateCell> dayCellFactory5 =
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

                                    if (currentDate.isBefore(departureDate.getValue()) || currentDate.isAfter(returnDate.getValue().plusMonths(6)) || (currentDate.getMonth()==Month.APRIL || currentDate.getMonth()==Month.MARCH))
                                    {
                                        setDisable(true);
                                        setStyle("-fx-background-color: #ffc0cb;");
                                    }
                                }
                            };
                        }
                    };
            returnDate.setDayCellFactory(dayCellFactory5);
        }
        else
        {
            regularDates();
        }
    }
}
