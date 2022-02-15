package DataStructure.Hash;

import java.util.HashSet;

/**
 * @auther Alessio
 * @date 2022/2/8
 **/
public class MyHashTable {

    private EmpList[] empListArray;
    private int size;

    public MyHashTable(int size) {
        this.size = size;
        empListArray = new EmpList[size];
        for (int i = 0; i < size; i++) {
            empListArray[i] = new EmpList();
        }
    }

    public int hashFunc(Emp emp) {
        return emp.id % size;
    }

    public void add(Emp emp) {
        int listIndex = hashFunc(emp);
        empListArray[listIndex].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empListArray[i].list();
        }
    }

    public Emp find(int id) {
        int listIndex = id % size;
       return empListArray[listIndex].find(id);
    }
}
class Emp {
    public int id;
    public String name;
    public String address;
    public Emp next;

    public Emp(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        HashSet set = new HashSet();
    }
}

class EmpList {
    Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
        }

        Emp cur = head;
        while (cur.next != null) {
            cur = cur.next;
            System.out.println("add one");
        }
        cur.next = emp;
    }

    public void list() {
        if (this.head == null) {
            System.out.println("List is null");
            return;
        }

        Emp cur = head;
        while (true) {
            System.out.printf("id = %d name = %s address = %s ", cur.id, cur.name, cur.address);
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
    }

    public Emp find(int id) {
        if (head == null) {
            System.out.println("空表");
            return null;
        }

        Emp cur = head;
        while (true) {
            if (cur.id == id) {
                break;
            }
            if (cur.next == null) {
                cur = null;
                break;
            }
            cur = cur.next;
        }
        return cur;
    }


}
