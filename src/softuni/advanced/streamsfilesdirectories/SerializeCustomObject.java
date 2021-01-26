package softuni.advanced.streamsfilesdirectories;

import java.io.*;

/**Description:
 * We have to write a program that saves and loads the information about a custom object named Courses
 * that has a String field containing its name and an integer field containing the number of students
 * attending the course. Set the name of the save file as course.ser.
 */

public class SerializeCustomObject {
    private static final String PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\course.ser";

    public static void main(String[] args) {

        Courses course = new Courses("Java Advanced", 200);

        //Serialization

        try (FileOutputStream fos = new FileOutputStream(PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(course);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Deserialization

        try (FileInputStream fis = new FileInputStream(PATH);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Courses deserializedCourse = (Courses) ois.readObject();
            System.out.println(deserializedCourse);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class Courses implements Serializable {
        private String name;

        @Override
        public String toString() {
            return String.format("%s -> %d", this.getName(), this.getStudentsCount());
        }

        private int studentsCount;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStudentsCount() {
            return studentsCount;
        }

        public void setStudentsCount(int studentsCount) {
            this.studentsCount = studentsCount;
        }

        public Courses(String name, int studentsCount) {
            this.name = name;
            this.studentsCount = studentsCount;
        }
    }
}
