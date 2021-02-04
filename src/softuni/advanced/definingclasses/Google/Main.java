package softuni.advanced.definingclasses.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Person> people = new HashMap<>();

        //"<Name> company <companyName> <department> <salary>"
        //"<Name> pokemon <pokemonName> <pokemonType>"
        //"<Name> parents <parentName> <parentBirthday>"
        //"<Name> children <childName> <childBirthday>"
        //"<Name> car <carModel> <carSpeed>"

        String command = scan.nextLine();

        while (!command.equals("End")) {
            String[] current = command.split("\\s+");
            String name = current[0];
            String info = current[1];

            if (!people.containsKey(name)) {
                Person person = new Person(name);
                people.put(name, person);
            }

            if (info.equals("company")) {
                String companyName = current[2];
                String department = current[3];
                Double salary = Double.parseDouble(current[4]);

                Company newCompany = new Company(companyName, department, salary);
                people.get(name).setCompany(newCompany);

            } else if (info.equals("pokemon")) {
                String pokemonName = current[2];
                String pokemonType = current[3];

                Pokemon newPokemon = new Pokemon(pokemonName, pokemonType);
                people.get(name).getPokemonsNameType().add(newPokemon);

            } else if (info.equals("parents")) {
                String parentName = current[2];
                String parentBirthday = current[3];

                Parents newParent = new Parents(parentName, parentBirthday);
                people.get(name).getParentsNameBirthday().add(newParent);
            } else if (info.equals("children")) {
                String childName = current[2];
                String childBirthday = current[3];

                Children newChildren = new Children(childName, childBirthday);
                people.get(name).getChildrenNameBirthday().add(newChildren);
            } else if (info.equals("car")) {
                String carModel = current[2];
                int carSpeed = Integer.parseInt(current[3]);

                Car newCar = new Car(carModel, carSpeed);
                people.get(name).setCar(newCar);
            }

            command = scan.nextLine();
        }
        String personToPrint = scan.nextLine();

        System.out.println(people.get(personToPrint));

    }
}
