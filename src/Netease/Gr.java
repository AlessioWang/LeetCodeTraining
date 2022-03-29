package Netease;

/**
 * @auther Alessio
 * @date 2022/3/27
 **/
public class Gr {

    //技能1伤害
    int x;
    //技能2伤害
    int y;
    //怪1血量
    int a;
    //怪2血量
    int b;

    public static void main(String[] args) {
        Gr gr = new Gr();
        System.out.println(gr.minNumKill(1,2,5,10));
    }

    public  int minNumKill(int x, int y, int a, int b) {
        int firstNum = (int) Math.ceil(Math.min(a, b) / y);

        int lastNum = (int) Math.ceil ((Math.max(a, b) / y - firstNum * y)/x);

        return firstNum + lastNum;
    }

}
