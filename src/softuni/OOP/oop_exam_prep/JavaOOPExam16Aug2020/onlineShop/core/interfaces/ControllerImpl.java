package softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.core.interfaces;

import softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.models.products.components.*;
import softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.models.products.computers.Computer;
import softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.models.products.computers.DesktopComputer;
import softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.models.products.computers.Laptop;
import softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.models.products.peripherals.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.common.constants.ExceptionMessages.*;
import static softuni.OOP.oop_exam_prep.JavaOOPExam16Aug2020.onlineShop.common.constants.OutputMessages.REMOVED_PERIPHERAL;


public class ControllerImpl implements Controller {

    private Map<Integer, Computer> computers;
    private Map<Integer, Component> components;
    private Map<Integer, Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new HashMap<>();
        this.components = new HashMap<>();
        this.peripherals = new HashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {

        Computer computer = null;

        if (computerType.equals("Laptop")) {
            computer = new Laptop(id, manufacturer, model, price);
        } else if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }

        computers.put(id, computer);
        return String.format("Computer with id %d added successfully.", id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model,
                                double price, double overallPerformance, String connectionType) {


        if (peripherals.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }

        Peripheral peripheral = null;

        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }

        peripherals.put(id, peripheral);

        computerIdExists(computerId);

        computers.get(computerId).getPeripherals().add(peripheral);

        return String.format("Peripheral %s with id %d added successfully in computer with id %d.",
                peripheralType, id, computerId);

    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {

        computerIdExists(computerId);

        Peripheral peripheral = computers.get(computerId).removePeripheral(peripheralType);

        peripherals.remove(peripheral.getId());

        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model,
                               double price, double overallPerformance, int generation) {

        computerIdExists(computerId);

        Component component = null;

        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }

        computers.get(computerId).getComponents().add(component);

        components.put(id, component);

        return String.format("Component %s with id %d added successfully in computer with id %d.",
                componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {

        computerIdExists(computerId);

        Component component = computers.get(computerId).removeComponent(componentType);

        components.remove(component.getId());

        return String.format("Successfully removed %s with id %d.", componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        computerIdExists(id);

        Computer computer = computers.remove(id);

        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {

        Computer buyBest = computers.values().stream()
                .filter(c -> c.getPrice() <= budget) // Predicate -> returns the elements that matches the condition if true
                .max(Comparator.comparing(computer1 -> computer1.getOverallPerformance()))
                .orElse(null);

        if (buyBest == null) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }

        computers.remove(buyBest.getId());

        return buyBest.toString();
    }

    @Override
    public String getComputerData(int id) {
        computerIdExists(id);

        Computer computer = computers.get(id);

        return computer.toString();
    }

    private void computerIdExists(int id) {
        if (!this.computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
    }
}
