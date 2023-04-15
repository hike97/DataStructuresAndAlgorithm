package algorithm.primary.s_002_node;

/**
 * @author: hike97
 * @createTime: 2023/04/14 19:54
 * @description: 单链表实现队列和栈的功能
 */
public class C03_SingleNode2QueueAndStack {

    public static class MyStack<V>{
        private Node<V> head;
        private int size;

        public boolean  isEmpty(){
            return size == 0;
        }

        public int size(){
            return size;
        }

        /**
         * 新增 value
         * @param value
         */
        public void offer(V value){
            Node<V> cur = new Node<>(value);
            if (head == null){
                head = cur;
            }else {
                cur.next = head;
                head = cur;
            }
            size++;
        }

        /**
         * 取出
         */
        public V poll(){
            V value = null;
            if (head != null){
                value = head.value;
                //JVM托管
                head = head.next;
                size --;
            }
            return value;
        }

        /**
         * 查看
         */
        public V peek(){
            V value = null;
            if (head != null){
                value = head.value;
            }
            return value;
        }

    }
    /**
     * 单链表模拟队列 FIFO
     * @param <V>
     */
    public static class MyQueue<V>{
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public boolean  isEmpty(){
            return size == 0;
        }

        public int size(){
            return size;
        }

        /**
         * 新增 value
         * @param value
         */
        public void offer(V value){
            Node<V> cur = new Node<>(value);
            if (tail == null){
                head = cur;
                tail = cur;
            }else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        /**
         * 取出
         */
         public V poll(){
             V value = null;
             if (head != null){
                 value = head.value;
                 //JVM托管
                 head = head.next;
                 size --;
             }
             if (head == null){
                 tail = null;
             }

             return value;
         }

        /**
         * 查看
         */
        public V peek(){
            V value = null;
            if (head != null){
                value = head.value;
            }
            return value;
        }

    }

    /**
     * 带泛型的Node
     * @param <V>
     */
    public static class Node<V> {
        public V value;
        public Node<V> next;
        public Node(V data) {
            value = data;
        }
    }
}
