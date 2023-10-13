package fun.suder.每日一题.leetcode2022_09_23;

class MyLinkedList {


    public int val;

    public MyLinkedList next;

    public MyLinkedList prev;


    public MyLinkedList() {

    }
    
    public int get(int index) {
        MyLinkedList node = this;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.val;
    }
    
    public void addAtHead(int val) {
        MyLinkedList head = null;
        while (this.prev != null) {
            head = this.prev;
        }
        if (head!=null){
            MyLinkedList node = new MyLinkedList();
            node.val = val;
            node.next = head;
            head.prev = node;
        }else {
            this.val = val;
        }

    }
    
    public void addAtTail(int val) {
        MyLinkedList tail = null;
        while (this.next != null) {
            tail = this.next;
        }
        if(tail!=null) {
            MyLinkedList node = new MyLinkedList();
            node.val = val;
            node.prev = tail;
            tail.next = node;
        }else {
            this.val = val;
        }
    }
    
    public void addAtIndex(int index, int val) {
        MyLinkedList node = this;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        newNode.next = node.next;
        newNode.prev = node;
        node.next.prev = newNode;
        node.next = newNode;
    }
    
    public void deleteAtIndex(int index) {
        MyLinkedList node = this;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        node.next.prev = node;

    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */