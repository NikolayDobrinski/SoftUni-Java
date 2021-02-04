package softuni.advanced.definingclasses.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemonsNameType;
    private List<Parents> parentsNameBirthday;
    private List<Children> childrenNameBirthday;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.pokemonsNameType = new ArrayList<>();
        this.parentsNameBirthday = new ArrayList<>();
        this.childrenNameBirthday = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemonsNameType() {
        return pokemonsNameType;
    }

    public void setPokemonsNameType(List<Pokemon> pokemonsNameType) {
        this.pokemonsNameType = pokemonsNameType;
    }

    public List<Parents> getParentsNameBirthday() {
        return parentsNameBirthday;
    }

    public void setParentsNameBirthday(List<Parents> parentsNameBirthday) {
        this.parentsNameBirthday = parentsNameBirthday;
    }

    public List<Children> getChildrenNameBirthday() {
        return childrenNameBirthday;
    }

    public void setChildrenNameBirthday(List<Children> childrenNameBirthday) {
        this.childrenNameBirthday = childrenNameBirthday;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.name).append(System.lineSeparator());
        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(this.company.toString()).append(System.lineSeparator());
        }

        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(this.car.getCarModel()).append(" ").append(this.car.getCarSpeed()).append(System.lineSeparator());
        }

        sb.append("Pokemon:").append(System.lineSeparator());
        this.pokemonsNameType.stream().forEach(p -> sb.append(p.getPokemonName() + " " + p.getPokemonType()).append(System.lineSeparator()));

        sb.append("Parents:").append(System.lineSeparator());
        parentsNameBirthday.stream().forEach(p -> sb.append(p.getParentName() + " " + p.getParentBirthday()).append(System.lineSeparator()));

        sb.append("Children:").append(System.lineSeparator());
        childrenNameBirthday.stream().forEach(c -> sb.append(c.getChildName() + " " + c.getChildBirthday()).append(System.lineSeparator()));


        return sb.toString();

    }
}
