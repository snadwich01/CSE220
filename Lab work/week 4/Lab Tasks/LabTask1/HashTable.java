/*You will have to complete the FruitNode Contrustor first
 then within this class you only have to complete two methods
 hashFunction() and insert()
 the rest of the metods are already written
 DO NOT TOUCH any other methods or codes*/
public class HashTable {

    //ht[] :: is the HashTable array that stores the FruitNode objects
    private FruitNode[] ht;

    //Constructor that initializes the HashTable array
	//DO NOT change this Constructor
    public HashTable(int size){
        this.ht = new FruitNode[size];
    }
    
    //This method basically prints the HashTable
    //DO NOT change this method
    public void show(){
        for(int i=0; i<ht.length; i++){
            System.out.print( i+" " );
            FruitNode n = ht[i];
            while (n!=null){
                System.out.print("('"+n.fruit[0]+"', "+n.fruit[1]+") --> ");
                n = n.next;
            }
            System.out.println();
        }
    }

    //you need to COMPLETE this method
    private int hashFunction( String key ){
        int len = key.length();
        int sum = 0;

        if(len % 2 == 0) {
            for(int i= 0; i < len; i+= 2) {
                sum += key.charAt(i);
            }
        } else {
            for(int i = 1; i < len; i += 2) {
                sum += key.charAt(i);
            }
        }

        return sum % len;
    }

    //you need to COMPLETE this method
    //The insert() method will create a FruitNode using name(Key) & price(value)
	//then inserts it in the proper hashed index
    //If collision occurs resolve using the steps explained in the question
    public void insert(String key, Integer value){
        int index = hashFunction(key);
        FruitNode fruit = new FruitNode(key, value);
        FruitNode curr = ht[index];
        FruitNode prev = null;

        if(ht[index] == null) {
            ht[index] = fruit;
            return;
        }

        while(curr != null) {
            if(curr.fruit[0].equals(key)) {
                curr.fruit[1] = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        curr = ht[index];
        prev = null;

        while(curr != null && (Integer)curr.fruit[1] > value) {
            prev = curr;
            curr = curr.next;
        }

        if(prev == null) {
            fruit.next = ht[index];
            ht[index] = fruit;
        } else {
            fruit.next = curr;
            prev.next = fruit;
        }
    }
    }
