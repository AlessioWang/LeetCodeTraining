package DataStructure.hash;

import java.util.Scanner;

/**
 * @auther Alessio
 * @date 2022/2/8
 **/
public class HashTableDemo {

    public static void main(String[] args) {
        HashTableDemo demo = new HashTableDemo();
    }

    public HashTableDemo() {
        MyHashTable myHashTable = new MyHashTable(5);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    System.out.println("输入地址");
                    String address = scanner.next();
                    Emp emp = new Emp(id, name, address);
                    myHashTable.add(emp);
                    break;
                case "list":
                    myHashTable.list();
                    break;

                case "find":
                    int idFind = scanner.nextInt();
                    System.out.println("名字 : " + myHashTable.find(idFind).name);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }


}
