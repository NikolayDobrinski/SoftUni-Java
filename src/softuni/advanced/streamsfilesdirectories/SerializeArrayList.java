package softuni.advanced.streamsfilesdirectories;

import java.io.*;
import java.util.List;

/**Description:
 * We have to write a program that saves and loads an ArrayList of doubles to a file.
 */

public class SerializeArrayList {

    private static final String PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\list.ser";

    public static void main(String[] args) {

        List<Double> list = List.of(4.6, 3.8, 1.0, 8.9);

        //Serialization

        try (FileOutputStream fos = new FileOutputStream(PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(list);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Deserialization

        try (FileInputStream fis = new FileInputStream(PATH);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Double> deserializedList = (List<Double>) ois.readObject();
            deserializedList.forEach(e -> System.out.println(e));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
