package softuni.fundamentals.oop.marathon;

public class Athlete {
    private String name;
    private int speed;
    private static String marathonLocation;

    public Athlete (String name, int speed, String marathonLocation){
        this.name = name;
        this.speed = speed;
        this.marathonLocation = marathonLocation;
    }

    public void setMarathonLocation (String marathonLocation) {
        this.marathonLocation = marathonLocation;
    }

    @Override
    public String toString() {
        return "Athlete " + name + " is running at speed " + speed + " in " + marathonLocation;
    }

}
