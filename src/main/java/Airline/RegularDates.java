package Airline;

import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;

import java.time.LocalDate;

import static Airline.RouteSelectScene.departureDate;
import static Airline.RouteSelectScene.returnDate;

public class RegularDates {
    public static void regularDates()
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

                                if (currentDate.isBefore(LocalDate.now()) || currentDate.isAfter(LocalDate.now().plusMonths(6)))
                                {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                            }
                        };
                    }
                };
        departureDate.setDayCellFactory(dayCellFactory);

        final Callback<DatePicker, DateCell> dayCellFactory1 =
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

                                if (currentDate.isBefore(departureDate.getValue().plusDays(5)) || currentDate.isAfter(returnDate.getValue().plusMonths(6)))
                                {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                            }
                        };
                    }
                };
        returnDate.setDayCellFactory(dayCellFactory1);
    }
}
