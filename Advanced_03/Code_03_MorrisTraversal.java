package Advanced_03;

public class Code_03_MorrisTraversal {
    //recurrent
    public static void process(Node head){
        if (head==null){
            return;
        }
        System.out.println(head.value+" ");//pre
        process(head.left);
        process(head.right);
    }
    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void morris(Node head){
        if (head == null) {
            return;
        }
        Node cur=head;
        while (cur!=null){
            System.out.println(cur.value);
            if (cur.left==null){
                cur=cur.right;
            }else {
                Node mostRight=cur.left;
                while (mostRight.right!=null&&mostRight.right!=cur){
                    mostRight=mostRight.right;
                }
                if (mostRight==null){
                    mostRight.right=cur;
                    cur=cur.left;
                }else {
                    mostRight.right=null;
                    cur=cur.right;
                }
            }
        }
    }
    //pre
    public static void morrisPre(Node head){
        if (head==null)return;
        Node cur=head;
        while (cur!=null){
            if (cur.left==null){
                System.out.println(cur.value+" ");
                cur=cur.right;
            }else {
                Node mostright=cur.left;
                while (mostright.right!=null&&mostright.right!=cur){
                    mostright=mostright.right;
                }
                if (mostright.right==null){
                    System.out.println(cur.value);
                    mostright.right=cur;
                    cur=cur.left;
                }else {
                    mostright.right=null;
                    cur=cur.right;
                }
            }
        }
    }
    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                    printEdge(cur1.left);
                }
            }
            cur1 = cur1.right;
        }
        printEdge(head);
        System.out.println();
    }

    public static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }
    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
}
