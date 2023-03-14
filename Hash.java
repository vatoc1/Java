

// implemented chaining hash function, i implemented linked list manually. Time complexity for deleting , inserting and searching element is  Amortized O(1)


class Node {
    private Integer value;
    private Node next;

    public Node(Integer value) {
        this.value=value;
        this.next=null;
    }

    public Node search(Integer key) {
        Node temp = this;
        while(temp!=null) {
            if(temp.value==key) {
                return temp;
            }
            temp=temp.next;
            
        }
        return null;

    }
    public Node add(Integer value) {
        if(search(value)!=null) {
            System.out.println("Can't add element , already exists");
            return this;
        }
        Node newNode = new Node(value);
        newNode.next=this;
        return newNode;

        
    }
    public Node delete(Integer value) {
        if(this.value==value) {
            if(this.next==null) {
                return null;
            }
            return this.next;
        }
        Node temp = this.next;
        Node prev = this;
        while(temp!=null) {
            if(temp.value==value) {
                prev.next=temp.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }

        return this;

        

    }

    public void printList() {
        Node temp = this;
        while(temp!=null) {
            System.out.println(temp.value);
            temp=temp.next;
        }
    }

    public int getKey() {
        return value;
    }
    

}


public class Hash {

    private Node [] hashtable;

    public Hash() {
        hashtable = new Node[10];
        

    }

    public int hashFunction(int  value) {
        return value%10;
    }

    public void add(int value) {
        if(hashtable[hashFunction(value)]==null) {
            hashtable[hashFunction(value)] = new Node(value);
            return;
        }
        hashtable[hashFunction(value)] = hashtable[hashFunction(value)].add(value);

    }

    public void delete(int value) {
        if(hashtable[hashFunction(value)]==null) {
            System.out.println("no such element");
            return;
        }
        hashtable[hashFunction(value)] = hashtable[hashFunction(value)].delete(value);

    }
    public boolean search(int value) {
        if(hashtable[hashFunction(value)]==null) {
            return false;
        }
        if(hashtable[hashFunction(value)].search(value)!=null) {
            return true;
        } 
        return false;
    }


    


    


    

    
}



