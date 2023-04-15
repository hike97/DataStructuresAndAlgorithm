package algorithm.primary.s_001_helloworld;

import java.util.HashMap;
import java.util.TreeMap;

import static algorithm.utils.CommonUtil.newLine;

/**
 * @author: hike97
 * @createTime: 2023/04/10 14:28
 * @description: TODO
 */
public class C07_HashMapDemo {
    public static void main(String[] args) {
        HashMap<Float, String> map = new HashMap<>();
        map.put(1234.56f,"我是123456");
        Float a = 1234.56f;
        Float b = 1234.56f;
        System.out.println(a == b);
        System.out.println(map.containsKey(a));
        System.out.println(map.containsKey(b));

        HashMap<Object, Object> map1 = new HashMap<>();
        Object o1 = new Object();
        Object o2 = new Object();
        map1.put(o1,"o1");
        System.out.println(map.containsKey(a));
        System.out.println(map.containsKey(b));
        //结论 map的key 对基本封装类型是值传递  对其它对象是引用传递

        newLine();
        TreeMap<Integer, String> treeMap1 = new TreeMap<>();

        treeMap1.put(3, "我是3");
        treeMap1.put(0, "我是3");
        treeMap1.put(7, "我是3");
        treeMap1.put(2, "我是3");
        treeMap1.put(5, "我是3");
        treeMap1.put(9, "我是3");

        System.out.println(treeMap1.containsKey(7));
        System.out.println(treeMap1.containsKey(6));
        System.out.println(treeMap1.get(3));

        treeMap1.put(3, "他是3");
        System.out.println(treeMap1.get(3));

        treeMap1.remove(3);
        System.out.println(treeMap1.get(3));

        System.out.println(treeMap1.firstKey());
        System.out.println(treeMap1.lastKey());
        // <=5 离5最近的key告诉我
        System.out.println(treeMap1.floorKey(5));
        // <=6 离6最近的key告诉我
        System.out.println(treeMap1.floorKey(6));
        // >=5 离5最近的key告诉我
        System.out.println(treeMap1.ceilingKey(5));
        // >=6 离6最近的key告诉我
        System.out.println(treeMap1.ceilingKey(6));
    }
}
