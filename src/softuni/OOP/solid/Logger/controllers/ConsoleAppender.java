package softuni.OOP.solid.Logger.controllers;

import softuni.OOP.solid.Logger.interfaces.Layout;

public abstract class ConsoleAppender extends BaseAppender{

    public
    ConsoleAppender (Layout layout) {
        super (layout);
    }

    @Override
    public void append(String message) {
        System.out.println(message);
    }
}
