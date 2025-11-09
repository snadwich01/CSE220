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

        if(len % 2 == 0){ 
            // Even length → sum of ASCII of even index chars
            for(int i = 0; i < len; i += 2){
                sum += key.charAt(i);
            }
        } else { 
            // Odd length → sum of ASCII of odd index chars
            for(int i = 1; i < len; i += 2){
                sum += key.charAt(i);
            }
        }

        return sum % ht.length;
    }

    //you need to COMPLETE this method
    //The insert() method will create a FruitNode using name(Key) & price(value)
	//then inserts it in the proper hashed index
    //If collision occurs resolve using the steps explained in the question
    public void insert(String key, Integer value){
        int index = hashFunction(key);
        FruitNode newNode = new FruitNode(key, value);

        // Case 1: Empty slot
        if(ht[index] == null){
            ht[index] = newNode;
            return;
        }

        FruitNode current = ht[index];
        FruitNode prev = null;

        // Check if key already exists -> update value
        while(current != null){
            if(current.fruit[0].equals(key)){
                current.fruit[1] = value;  // update
                return;
            }
            prev = current;
            current = current.next;
        }

        // If not found, insert in descending order by price
        current = ht[index];
        prev = null;

        while(current != null && (Integer)current.fruit[1] > value){
            prev = current;
            current = current.next;
        }

        if(prev == null){
            // Insert at head
            newNode.next = ht[index];
            ht[index] = newNode;
        } else {
            // Insert in between or at end
            newNode.next = current;
            prev.next = newNode;
        }
    }
    }


