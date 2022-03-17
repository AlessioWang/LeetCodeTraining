package JavaBasic.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @auther Alessio
 * @date 2022/3/12
 **/
public class FileOutputStreamTest {

    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("myFile", true);
            byte[] bytes = {90, 100, 103, 93};
            fileOutputStream.write(bytes);

            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
