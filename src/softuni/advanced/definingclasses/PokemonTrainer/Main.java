package softuni.advanced.definingclasses.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String command = scan.nextLine();

        while (!command.equals("Tournament")) {
            String[] line = command.split("\\s+");

            String trainerName = line[0];
            String pokemonName = line[1];
            String pokemonElement = line[2];
            int pokemonHealth = Integer.parseInt(line[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainers.putIfAbsent(trainerName, new Trainer());
            trainers.get(trainerName).addPokemon(pokemon);

            command = scan.nextLine();
        }

        command = scan.nextLine();

        while (!command.equals("End")) {

            for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {
                if (trainer.getValue().pokeCollectionSize() > 0) {
                    boolean havePokemon = false;
                    for (Pokemon pokemon : trainer.getValue().getPokemons()) {
                        if (pokemon.getElement().equals(command)) {
                            havePokemon = true;
                            trainer.getValue().setNumOfBadges();
                            break;
                        }
                    }
                    if (!havePokemon) {
                        trainer.getValue().missingPokemonPenalty();
                    }
                }
            }

            command = scan.nextLine();
        }
        trainers.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue().getNumOfBadges(), b1.getValue().getNumOfBadges()))
                .forEach(t -> {
                    System.out.println(String.format("%s %s %s", t.getKey(),
                            t.getValue().getNumOfBadges(),
                            t.getValue().pokeCollectionSize()));
                });
    }
}
