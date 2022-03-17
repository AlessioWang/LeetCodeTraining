package JavaBasic.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @auther Alessio
 * @date 2022/3/12
 **/
public class InputStream {

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            //创建文件输入对象
            fis = new FileInputStream("E:/INST.AAA/JavaBasic/ioTest.txt");
            byte[] bytes = new byte[fis.available()];
            System.out.println(new String(bytes));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis == null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
