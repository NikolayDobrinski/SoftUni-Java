package softuni.fundamentals.labs.dbvariables;

public class CocaColaQueue {
    public static void main(String[] args) {
        String[] names = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};

        int n = 52;

        if (n <= names.length) {
            String output = names[n - 1];
            System.out.println(output);
        } else if (n > names.length) {

            String[] second = new String[Integer.MAX_VALUE];

            for (int i = 0; i < n - names.length; i++) {

                if (i < names.length) {
                    second[names.length + 1 + i + i] = names[i];
                    second[names.length + 2 + i + i] = names[i];
                } else if (i >= names.length) {
                    second[names.length + 1 + i + i] = second[i + 1];
                    second[names.length + 2 + i + i] = second[i + 1];
                }
            }
            String result = second[n];
            System.out.println(result);

        }
    }
}


