package softuni.OOP.solid.Logger.controllers;

import softuni.OOP.solid.Logger.enums.ReportLevel;
import softuni.OOP.solid.Logger.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public
    String format (String date, ReportLevel reportLevel, String message) {
        return String.format ("%s - %s - %s",date,reportLevel,message);
    }
}
