package softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.models.products.computers;

import softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.models.products.BaseProduct;
import softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.models.products.components.Component;
import softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {

    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public double getOverallPerformance() {
        double avgComponentsPerformance = components.stream()
                .mapToDouble(Component::getOverallPerformance)
                .average()
                .orElse(0);
        return super.getOverallPerformance() + avgComponentsPerformance;
    }


    @Override
    public double getPrice() {
        double allComponentsPrice = components.stream().mapToDouble(c -> c.getPrice()).sum();
        double allPeripheralsPrice = peripherals.stream().mapToDouble(p -> p.getPrice()).sum();
        return super.getPrice() + allComponentsPrice + allPeripheralsPrice;
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (components.stream().anyMatch(c -> c.getClass() == component.getClass())){

            throw new IllegalArgumentException(
                    String.format(EXISTING_COMPONENT,
                            component.getClass().getSimpleName(),
                            this.getClass().getSimpleName(),
                            this.getId()));
        }
        this.components.add(component);
    }


    @Override
    public Component removeComponent(String componentType) {
        if (components.stream().noneMatch(c -> c.getClass().getSimpleName().equals(componentType))){

            throw new IllegalArgumentException(
                    String.format(NOT_EXISTING_COMPONENT,
                            componentType,
                            this.getClass().getSimpleName(),
                            this.getId()));
        }

        int index = 0;
        for (int i = 0; i < components.size(); i++) {
            Component component = components.get(i);
            if (component.getClass().getSimpleName().equals(componentType)){
                index = i;
                break;
            }
        }
        return components.remove(index);
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (peripherals.stream().anyMatch(p -> p.getClass() == peripheral.getClass())){

            throw new IllegalArgumentException(
                    String.format(EXISTING_PERIPHERAL,
                            peripheral.getClass().getSimpleName(),
                            this.getClass().getSimpleName(),
                            this.getId()));
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (peripherals.stream().noneMatch(p -> p.getClass().getSimpleName().equals(peripheralType))) {

            throw new IllegalArgumentException(
                    String.format(NOT_EXISTING_PERIPHERAL,
                            peripheralType,
                            this.getClass().getSimpleName(),
                            this.getId()));
        }

        int index = 0;
        for (int i = 0; i < peripherals.size(); i++) {
            Peripheral peripheral = peripherals.get(i);
            if (peripheral.getClass().getSimpleName().equals(peripheralType)){
                index = i;
                break;
            }
        }
        return peripherals.remove(index);
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder(super.toString());

        output.append(System.lineSeparator());
        output.append(String.format(" Components (%d):", getComponents().size()))
                .append(System.lineSeparator());
        for (Component component : components) {
            output.append("  " + component.toString())
                    .append(System.lineSeparator());
        }
        double averageOverallPerformance = peripherals.stream().mapToDouble(p -> p.getOverallPerformance()).average().orElse(0);

        output.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f)", peripherals.size(), averageOverallPerformance));
        output.append(System.lineSeparator());

        for (Peripheral peripheral : peripherals) {
            output.append("  " + peripheral.toString())
                    .append(System.lineSeparator());

        }
        return output.toString().trim();
    }

}
