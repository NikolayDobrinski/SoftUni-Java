package softuni.OOP.design_patterns.PrototypePattern;

public class ConcretePrototype extends Prototype {

    public ConcretePrototype(String id) {
        super(id);
    }

    @Override
    public Prototype clone() {
        return (Prototype) this.clone();
    }
}
