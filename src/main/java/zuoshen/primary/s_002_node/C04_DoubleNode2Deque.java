package zuoshen.primary.s_002_node;

/**
 * @author: hike97
 * @createTime: 2023/04/14 20:21
 * @description: 双向链表实现双端队列
 */
public class C04_DoubleNode2Deque {

    public static class MyDequeue<V>{
        private Node<V> head;
        private Node<V> tail;
        int size;

        public boolean  isEmpty(){
            return size == 0;
        }

        public int size(){
            return size;
        }

        public void offerFirst(V val){
            Node<V> cur = new Node<>(val);
            if (head == null){
                head = cur;
                tail = cur;
            }else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
            size ++;
        }

        public void offerLast(V val){
            Node<V> cur = new Node<>(val);
            if (head == null){
                head = cur;
                tail = cur;
            }else {
               tail.next = cur;
               cur.last =tail;
               tail = cur;
            }
            size ++;
        }

        public V pollFirst(){
            V val = null;
            if (head != null){
                val = head.value;
                if (head == tail){
                    head = null;
                    tail = null;
                }else {
                    head = head.next;
                    head.last = null;
                }
                size --;
            }
            return val;
        }

        public V pollLast(){
            V val = null;
            if (head != null){
                val = head.value;
                if (head == tail){
                    head = null;
                    tail = null;
                }else {
                    tail = tail.last;
                    tail.next = null;
                }
                size --;
            }
            return val;
        }

        public V peekFirst(){
            if (head != null){
                return head.value;
            }
            return null;
        }

        public V peekLast(){
            if (tail != null){
                return tail.value;
            }
            return null;
        }
    }
    public static class Node<V> {
        public V value;
        public Node<V> last;
        public Node<V> next;

        public Node(V v) {
            value = v;
            last = null;
            next = null;
        }
    }
}
