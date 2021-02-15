package softuni.advanced.examprep.VetClinic;

/** Description:
 * Our task is to create a repository, which stores items by creating the classes described below.
 * - class Pet with the following fields - name, age, owner. The class should override the toString()
 * method in the following format - "{name} {age} ({owner})".
 * - class Clinic that has data (a collection, which stores the Pets) and field - capacity.
 * We have to implement the following features: Method add, Method remove, Method getPet, Method getOldestPet(),
 * Getter getCount and Method getStatistics() – returns a String in the following format:
 * "The clinic has the following patients: {name} {owner}"
 */

public class Main {
    public static void main(String[] args) {

        // Initialize the repository
        Clinic clinic = new Clinic(20);

// Initialize entity
        Pet dog = new Pet("Ellias", 5, "Tim");

// Print Pet
        System.out.println(dog); // Ellias 5 (Tim)

// Add Pet
        clinic.add(dog);

// Remove Pet
        System.out.println(clinic.remove("Ellias")); // true
        System.out.println(clinic.remove("Pufa")); // false

        Pet cat = new Pet("Bella", 2, "Mia");
        Pet bunny = new Pet("Zak", 4, "Jon");

        clinic.add(cat);
        clinic.add(bunny);

// Get Oldest Pet
        Pet oldestPet = clinic.getOldestPet();
        System.out.println(oldestPet); // Zak 4 (Jon)

// Get Pet
        Pet pet = clinic.getPet("Bella", "Mia");
        System.out.println(pet); // Bella 2 (Mia)

// Count
        System.out.println(clinic.getCount()); // 2

// Get Statistics
        System.out.println(clinic.getStatistics());
//The clinic has the following patients:
//Bella Mia
//Zak Jon

    }
}
