package softuni.OOP.design_patterns.singleton_pattern;

public class SingletonContainer {
    //ctor

    private SingletonContainer() {
    }

    //fields

    private static PopulationTracker tracker;
    private static boolean isInitialized;

    //methods

    public static PopulationTracker getTracker() {
        if (!isInitialized) {
            throw new IllegalStateException("SingletonContainer not initilized call .init() first");
        }
        return tracker;
    }

    public static void  init() {
        if (!isInitialized) {
            isInitialized = true;
            tracker = PopulationTracker.getInstance();
        }
    }
}
