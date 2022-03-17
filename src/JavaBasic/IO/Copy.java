package JavaBasic.IO;

import java.io.*;

/**
 * @auther Alessio
 * @date 2022/3/13
 **/
public class Copy {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("copyTest.txt");

            fos = new FileOutputStream("copy");
            fos.flush();

            //每次拷贝1M
            byte[] bytes = new byte[1024 * 1024];
            int readCount = 0;
            while (readCount != -1) {
                fos.write(bytes, 0, readCount);
                readCount = fis.read(bytes);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
