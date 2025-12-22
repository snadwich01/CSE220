public void insert(String key, interger value, Node[] ht) {
    int index = hash(key);

    Node head = ht[index];
    Node current = head; 

    while(current != null) {
        if(current.key.equals(key)) {
            current.val =val;
            return;
        }
        current = current.next;
    }

    Node newNode = Node(key,val);

    //even-------------------------------------------
    if(val %2 ==0) {
        newNode.next = head;
        ht[index] = newNode;
        return;
    }

    //odd------------------------------------------
    if(head == null) {
        ht[index] = newNode;
        return;
    }

    Node temp = head;
    while(temp.next != null) {
        temp = temp.next;
    }

    temp.next = newNode;
}
