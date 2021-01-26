package softuni.advanced.streamsfilesdirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**Description:
 * We have to write a program that makes a copy of a .jpg file.
 */

public class CopyAPicture {
    private static final String PICTURE_PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\picture.jpg";
    private static final String PICTURE_COPY_PATH = "src\\softuni\\advanced\\streamsfilesdirectories\\resources\\picture-copy.jpg";

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(PICTURE_PATH);
             FileOutputStream fos = new FileOutputStream(PICTURE_COPY_PATH)) {

            int oneByte = fis.read();

            while (oneByte >= 0) {
                fos.write(oneByte);
                oneByte = fis.read();
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }


    }
}
