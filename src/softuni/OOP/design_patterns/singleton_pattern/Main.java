package softuni.OOP.design_patterns.singleton_pattern;

public class Main {
    public static void main(String[] args) {

        SingletonContainer.init();

        PopulationTracker tracker = SingletonContainer.getTracker();

        tracker.add("Sofia", 10);
        tracker.add("Plovdiv", 100);

        readNewPopulationData();

    }

    public static void readNewPopulationData() {
        PopulationTracker tracker = SingletonContainer.getTracker();
        tracker.add("Sofia", 10);
        tracker.add("Plovdiv", 100);

    }

}
