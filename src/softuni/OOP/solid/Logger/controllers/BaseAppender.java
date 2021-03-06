package softuni.OOP.solid.Logger.controllers;

import softuni.OOP.solid.Logger.enums.ReportLevel;
import softuni.OOP.solid.Logger.interfaces.Appender;
import softuni.OOP.solid.Logger.interfaces.Layout;

public abstract class BaseAppender implements Appender {

    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesAppendedCount;

    protected
    BaseAppender (Layout layout) {
        this.layout = layout;
    }

    public
    ReportLevel getReportLevel () {
        return reportLevel;
    }

    @Override
    public void appendMessage(String datetime, ReportLevel reportLevel, String message) {
        if (reportLevel.ordinal() >= this.reportLevel.ordinal()) {
            String result = this.layout.format (datetime, reportLevel, message);
            this.append(result);
            this.messagesAppendedCount++;
        }
    }

    protected abstract void append(String result);

    public
    void setReportLevel (ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public
    String toString () {
        return String.format ("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass ().getSimpleName (),this.layout.getClass ().getSimpleName (),
                this.reportLevel.name (), this.messagesAppendedCount);
    }
}
