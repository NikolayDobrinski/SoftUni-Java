package softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.core;

import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.aquariums.Aquarium;
import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.aquariums.FreshwaterAquarium;
import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.aquariums.SaltwaterAquarium;
import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.decorations.Decoration;
import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.decorations.Ornament;
import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.decorations.Plant;
import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.fish.Fish;
import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.fish.FreshwaterFish;
import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.entities.fish.SaltwaterFish;
import softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

import static softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.common.ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM;
import static softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.common.ConstantMessages.WATER_NOT_SUITABLE;
import static softuni.OOP.oop_exam_prep.JavaOOPExam10April2021.aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        aquariums.add(aquarium);
        return String.format("Successfully added %s.", aquariumType);

    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new NullPointerException(INVALID_DECORATION_TYPE);
        }
        decorations.add(decoration);
        return String.format("Successfully added %s.", type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);

        Decoration decoration = this.decorations.findByType(decorationType);
        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        aquarium.addDecoration(decoration);
        decorations.remove(decoration);

        return String.format("Successfully added %s to %s.", decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Aquarium aquarium = this.aquariums.stream().filter(f -> f.getName().equals(aquariumName)).findFirst().orElse(null);

        Fish fish;
        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        if (fish.getClass().getSimpleName().equals("FreshwaterFish") &&
                aquarium.getClass().getSimpleName().equals("SaltwaterAquarium") ||
                fish.getClass().getSimpleName().equals("SaltwaterFish") &&
                        aquarium.getClass().getSimpleName().equals("FreshwaterAquarium")) {
            return WATER_NOT_SUITABLE;
        }

        aquarium.addFish(fish);
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        aquarium.feed();
        return String.format("Fish fed: %d", aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        double fishSum = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decorationSum = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        return String.format("The value of Aquarium %s is %.2f.", aquariumName, fishSum + decorationSum);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium aquarium : aquariums) {
            sb.append(aquarium.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
