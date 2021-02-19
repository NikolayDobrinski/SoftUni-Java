package softuni.advanced.examprep.Rabbits;

import java.util.List;

/** Description:
 * Our task is to create a repository which stores departments by creating the classes described below.
 * - class Rabbit with the following fields - name, species, available  /boolean - true by default/.
 * - class Cage that has data (a collection which stores the entity Rabbit) and should have those fields -
 *      name, capacity, data: List<Rabbit> that holds added rabbits.
 * Then, we have to Implement the following features:
 * getName(), getCapacity(), add(Rabbit rabbit), removeRabbit(String name) returns boolean,
 * removeSpecies(String species), sellRabbit(String name) returns the rabbit, sellRabbitBySpecies(String species),
 * count(), report() - returns only not sold rabbits.
 */

public class Main {
    public static void main(String[] args) {

        //Initialize the repository (Cage)
        Cage cage = new Cage("Wildness", 20);

        //Initialize entity
        Rabbit rabbit = new Rabbit("Fluffy", "Blanc de Hotot");

        //Print Rabbit
        System.out.println(rabbit); // Rabbit (Blanc de Hotot): Fluffy

        //Add Rabbit
        cage.add(rabbit);
        System.out.println(cage.count()); //1

        //Remove Rabbit
        cage.removeRabbit("Rabbit Name"); //false

        Rabbit secondRabbit = new Rabbit("Bunny", "Brazilian");
        Rabbit thirdRabbit = new Rabbit("Jumpy", "Cashmere Lop");
        Rabbit fourthRabbit = new Rabbit("Puffy", "Cashmere Lop");
        Rabbit fifthRabbit = new Rabbit("Marlin", "Brazilian");

        //Add Rabbits
        cage.add(secondRabbit);
        cage.add(thirdRabbit);
        cage.add(fourthRabbit);
        cage.add(fifthRabbit);

        //Sell Rabbit by name
        System.out.println(cage.sellRabbit("Bunny")); //Rabbit (Brazilian): Bunny
        //Sell Rabbit by species
        List<Rabbit> soldSpecies = cage.sellRabbitBySpecies(("Cashmere Lop"));

        soldSpecies.forEach(f -> {
            System.out.println(f.getName());
        });
        //Jumpy
        //Puffy

        System.out.println(cage.report());
        //Rabbits available at Wildness:
        //Rabbit (Blanc de Hotot): Fluffy
        //Rabbit (Brazilian): Marlin

    }
}
