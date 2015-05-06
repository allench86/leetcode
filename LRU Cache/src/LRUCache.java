import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity = 0;
    Map<Integer, DoubleLinkNode> cache;
    DoubleLinkList list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, DoubleLinkNode>();
        this.list = new DoubleLinkList();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DoubleLinkNode value = cache.get(key);
            list.moveToFront(value);
            return value.getVal();
        }
        else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            DoubleLinkNode existingNode = cache.get(key);
            existingNode.setVal(value);
            list.moveToFront(existingNode);
        }
        else {
            if (this.cache.size() == this.capacity) {
                DoubleLinkNode lastNode = list.removeTheEnd();
                cache.remove(lastNode.key);
            }
            DoubleLinkNode node = new DoubleLinkNode(key, value);
            list.addToFront(node);
            cache.put(key, node);
        }

    }

    public static class DoubleLinkList {
        DoubleLinkNode head;

        public DoubleLinkList() {
            this.head = new DoubleLinkNode(-1, -1);
            this.head.setNext(head);
            this.head.setPre(head);
        }

        public DoubleLinkNode addToFront(DoubleLinkNode newNode) {
            if (newNode == null) {
                return newNode;
            }

            if (isEmpty()) {
                head.setNext(newNode);
                newNode.setNext(head);
                newNode.setPre(head);
                head.setPre(newNode);
            }
            else {
                DoubleLinkNode p = head.next;
                head.setNext(newNode);
                newNode.setNext(p);
                p.setPre(newNode);
                newNode.setPre(head);
            }
            return newNode;
        }

        public DoubleLinkNode moveToFront(DoubleLinkNode node) {
            if (node.pre == head) {
                return node;
            }

            DoubleLinkNode p = node.pre;
            DoubleLinkNode q = node.next;

            q.setPre(p);
            p.setNext(q);

            return addToFront(node);
        }

        public DoubleLinkNode removeTheEnd() {
            if (isEmpty()) {
                return null;
            }
            DoubleLinkNode p = head.pre;
            DoubleLinkNode q = p.pre;

            head.setPre(q);
            q.setNext(head);

            p.setNext(null);
            p.setPre(null);

            return p;
        }

        private boolean isEmpty() {
            return head.next == head && head.pre == head;
        }
    }

    public static class DoubleLinkNode {
        int key;
        int val;
        DoubleLinkNode pre;
        DoubleLinkNode next;

        public DoubleLinkNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public DoubleLinkNode getPre() {
            return pre;
        }

        public void setPre(DoubleLinkNode pre) {
            this.pre = pre;
        }

        public DoubleLinkNode getNext() {
            return next;
        }

        public void setNext(DoubleLinkNode next) {
            this.next = next;
        }
    }
}
