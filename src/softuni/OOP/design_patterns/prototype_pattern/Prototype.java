package softuni.OOP.design_patterns.prototype_pattern;

public abstract class Prototype {
    private String id;

    public Prototype(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public abstract Prototype clone();
}
