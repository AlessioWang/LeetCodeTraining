package Sort.ComparableImp;

/**
 * @auther Alessio
 * @date 2022/2/26
 **/
public class TestClient {

    public static void main(String[] args) {
        Student std1 = new Student(10, "aaa");
        Student std2 = new Student(12, "bbb");

        System.out.println(compare(std1,std2));
    }

    public static Comparable compare(Student std1, Student std2){
        int comp = std1.compareTo(std2);
        return comp > 0? std1: (comp == 0 ?  std1 : std2);
    }


}
