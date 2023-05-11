package zuoshen.primary.s_001_helloworld;

import utils.CommonUtil;

import static utils.CommonUtil.newLine;

/**
 * @author: hike97
 * @createTime: 2023/04/08 19:56
 * @description: 等概率返回问题
 */
public class C04_Random{
    private static final int TIMES = 1000_0000;

    public static void main(String[] args) {
        /**
         * random 能做到等数等概率随机
         */
        int count = 0;
        for (int i = 0; i < TIMES; i++) {
            if (Math.random() < 0.5) {
                count++;
            }
        }
        System.out.println((double) count / (double) TIMES);

        newLine();
        //1. [0,1) -> [0,8) 范围扩大到8时，结果小于5的概率是8分之5
        count = 0;
        for (int i = 0; i < TIMES; i++) {
            if (Math.random() * 8 < 5) {
                count++;
            }
        }
        System.out.println((double) count / (double) TIMES);
        System.out.println((double) 5 / (double) 8);
        newLine();

        //2. [0,K) -> [0,8]
        int K = 9;
        int[] counts = new int[9];
        for (int i = 0; i < TIMES; i++) {
            int ans = (int) (Math.random() * K); // [0,K-1]
            counts[ans]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + "这个数，出现了 " + counts[i] + " 次");
        }
        newLine();

        System.out.println("已知f() 等概率返回1~5");
        CommonUtil.printP(TIMES,6,C04_Random::f);
        System.out.println("第一步：0~1 等概率事件函数f1()");
        CommonUtil.printNumP(TIMES,C04_Random::f1,0);
        System.out.println("第二步：0~6 等概率事件函数f2");
        CommonUtil.printP(TIMES,8,C04_Random::f2);
        System.out.println("第三步：1~7 等概率事件函数g");
        CommonUtil.printP(TIMES,8,C04_Random::g);
        CommonUtil.newLine();
        System.out.println("01 不等概率 随机到 01 等概率");
        CommonUtil.printNumP(TIMES,C04_Random::y,1);

    }
    /**
     * 题目2：01 不等概率 随机到 01 等概率
     */
    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    /**
     * roll 两次 如果两个结果相等 不反回
     */
    public static int y() {
        int ans;
        do {
          ans = x();
        }while (ans == x());
        return ans;
    }
    /**
     * 题目1：已知一个函数f,等概率返回 1~5，
     * 如何加工f(x)得到g(f(x))1~7 等概率出现一次
     * 延伸：
     * 从 a~b 随机到 c~d
     */
    public static int f(){
        //[0,4] => [1,5]
        return (int) (Math.random()*5)+1;
    }
    //1.返回 0~1 等概率出现一次
    public static int f1(){
        int ans;
        do {
            ans = f();
            //当结果位1 时 重置 其余结果进行2分处理 23 返回 0 45 返回 1
        }while (ans == 1);
        return ans <= 3 ? 0:1;
    }
    //2.加工f1得到f2做到0~7等概率返回
    public static int f2(){
        int ans;
        do {
            //连续调用 三次 f1 拼接三位二进制数 000~111 这样会等概率随机返回0~7
            ans = (f1()<<2)+(f1()<<1)+f1();
         //在此基础上 只要得到7 就不返回结果 就做到了 0~6 等概率随机返回
        }while (ans == 7);
        return ans;
    }
    //3.最终获得g() 将 f2 的结果+1
    public static int g(){
        return f2()+1;
    }
}
