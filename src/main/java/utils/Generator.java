package utils;

import zuoshen.primary.s_002_node.entity.ListNode;

import java.util.Random;

/**
 * @author: hike97
 * @createTime: 2023/05/11 19:38
 * @description: 生成器
 */
public class Generator {

    // 一个随机数生成器
    private static Random random = new Random();

    /**
     *  根据链表长度和是否有序生成一个随机链表
      */
    public static ListNode generateRandomList(int length, boolean sorted) {
        // 如果长度小于等于0，返回空链表
        if (length <= 0) {
            return null;
        }
        // 创建一个头节点，初始值为随机数
        ListNode head = new ListNode(random.nextInt(100));
        // 记录当前节点
        ListNode curr = head;
        // 循环生成剩余的节点
        for (int i = 1; i < length; i++) {
            // 创建一个新节点，初始值为随机数
            ListNode node = new ListNode(random.nextInt(100));
            // 如果需要有序，那么保证新节点的值不小于当前节点的值
            if (sorted && node.val < curr.val) {
                node.val = curr.val;
            }
            // 将新节点连接到当前节点后面
            curr.next = node;
            // 更新当前节点
            curr = node;
        }
        // 返回头节点
        return head;
    }

    public static ListNode generateRandomList(int length) {
        // 如果长度小于等于0，返回空链表
        if (length <= 0) {
            return null;
        }
        // 创建一个头节点，初始值为随机数
        ListNode head = new ListNode(random.nextInt(100));
        // 记录当前节点
        ListNode curr = head;
        // 循环生成剩余的节点
        for (int i = 1; i < length; i++) {
            // 创建一个新节点，初始值为随机数
            ListNode node = new ListNode(random.nextInt(100));
            // 将新节点连接到当前节点后面
            curr.next = node;
            // 更新当前节点
            curr = node;
        }
        // 返回头节点
        return head;
    }

    // 根据是否倒序对链表进行反转
    public static ListNode reverseList(ListNode head, boolean reversed) {
        // 如果不需要倒序或者链表为空或者只有一个节点，直接返回头节点
        if (!reversed || head == null || head.next == null) {
            return head;
        }
        // 记录前一个节点，初始为null
        ListNode prev = null;
        // 记录当前节点，初始为头节点
        ListNode curr = head;
        // 循环遍历链表
        while (curr != null) {
            // 记录下一个节点，防止断链
            ListNode next = curr.next;
            // 将当前节点的后继指向前一个节点，实现反转
            curr.next = prev;
            // 更新前一个节点为当前节点
            prev = curr;
            // 更新当前节点为下一个节点
            curr = next;
        }
        // 返回反转后的头节点，即原来的尾节点
        return prev;
    }

    /**
     * 生成随机数组
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
