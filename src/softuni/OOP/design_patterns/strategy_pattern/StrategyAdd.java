package softuni.OOP.design_patterns.strategy_pattern;

public class StrategyAdd implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
