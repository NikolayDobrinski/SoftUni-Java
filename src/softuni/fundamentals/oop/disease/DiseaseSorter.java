package softuni.fundamentals.oop.disease;

import java.util.ArrayList;
import java.util.List;

public class DiseaseSorter {
    public static void main(String[] args) {
        Disease polio = new Disease("Polio", false);
        Disease flu = new Disease("Influenza", true);
        Disease malaria = new Disease("Malaria", true);
        Disease cancer = new Disease("Cancer", false);

        List<Disease> diseases = new ArrayList<Disease>();

        diseases.add(polio);
        diseases.add(flu);
        diseases.add(malaria);
        diseases.add(cancer);

        System.out.println("Curable diseases: ");
        for (Disease disease : diseases) {
            if (disease.isCurable()) {
                System.out.println(disease.getName());
            }
        }


    }
}
