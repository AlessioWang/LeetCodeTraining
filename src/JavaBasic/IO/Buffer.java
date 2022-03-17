package JavaBasic.IO;

import java.io.*;

/**
 * @auther Alessio
 * @date 2022/3/13
 **/
public class Buffer {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("myFile");
        BufferedReader br = new BufferedReader(reader);

        String s;
        while (br.readLine() != null) {
            s = br.readLine();
            System.out.println(s);
        }

        br.close();
    }

}
