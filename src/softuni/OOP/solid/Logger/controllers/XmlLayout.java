package softuni.OOP.solid.Logger.controllers;

import softuni.OOP.solid.Logger.enums.ReportLevel;
import softuni.OOP.solid.Logger.interfaces.Layout;

public class XmlLayout implements Layout {

    @Override
    public
    String format (String date, ReportLevel reportLevel, String message) {
        return String.format ("<log>%n" +
                "<date>"+ date +"</date>%n" +
                "<level>"+reportLevel+"</level>%n" +
                "<message>"+ message +"</message>%n" +
                "</log>");
    }
}
