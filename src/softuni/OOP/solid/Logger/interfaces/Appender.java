package softuni.OOP.solid.Logger.interfaces;

import softuni.OOP.solid.Logger.enums.ReportLevel;

public interface Appender {

    void appendMessage(String datetime, ReportLevel reportLevel, String message);

    void setReportLevel (ReportLevel error);
}
