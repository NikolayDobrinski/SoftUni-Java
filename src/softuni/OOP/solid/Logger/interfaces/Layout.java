package softuni.OOP.solid.Logger.interfaces;

import softuni.OOP.solid.Logger.enums.ReportLevel;

public interface Layout {

    String format(String date, ReportLevel reportLevel, String message);
}
