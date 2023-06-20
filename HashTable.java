package Hashing;

public class HashTable {

    private HashNode [] bucket;
    private int NumberOfBuckets;
    private int size;

    HashTable(){
        this(10);
    }
    HashTable(int capacity){
        NumberOfBuckets = capacity;
        bucket = new HashNode[NumberOfBuckets];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    private class HashNode{
        private int key; //Any generic type
        private String value;
        private HashNode next;

        HashNode(int key , String value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public void put(Integer key , String value){
        if (key == null || value == null){
            throw new IllegalArgumentException("Enter valid values");
        }
        int bucketIndex = getIndex(key);
        HashNode head = bucket[bucketIndex];
        while (head != null){
            if (head.key == key){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucket[bucketIndex];
        HashNode node = new HashNode(key , value);
        node.next = head;
        bucket[bucketIndex] = node;
    }

    private int getIndex(Integer key){
        return key%NumberOfBuckets;
    }

    public String get(Integer key){
        int bucketIndex = getIndex(key);
        HashNode head = bucket[bucketIndex];
        while (head != null){
            if (head.key == key){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public String remove(Integer key){
        int bucketIndex = getIndex(key);
        HashNode head = bucket[bucketIndex];
        HashNode previous = null;

        while (head !=null){
            if (head.key == key){
                break;
            }
            previous = head;
            head = head.next;
        }
        if (head == null){
            return null;
        }
        size --;
        if (previous != null){
            previous.next = head.next;
        }else {
            bucket[bucketIndex] = head.next;
        }
        return head.value;
    }

    public static void main(String[] args) {

        HashTable h = new HashTable(10);
        h.put(31 , "Rasha");
        h.put(21 , "Faheem");
        h.put(25 , "Taimoor");
        h.put(21 , "Khalid");

        System.out.println("The size of hash table is " + h.size());

        System.out.printf("The value corresponding to key %d is %s " , 31 , h.get(31));
        System.out.println();

        System.out.println(h.remove(21));
        System.out.println(h.size());
    }
}