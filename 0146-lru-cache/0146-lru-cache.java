class LRUCache {
    class Node{
        int data,val;
        Node prev,next;

        Node(int data,int val){
            this.data=data;
            this.val=val;
            prev=next=null;
        }
    }
    public HashMap<Integer,Node>map;
    public Node head,tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        // Dummy nodes banate hain
        head=new Node(0,0);
        tail=new Node(0,0);

        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;//agar key exist nahi karti return -1
        Node temp=map.get(key);//agar key mil gayi
        remove(temp);//us node ko remove karke dubara insert karenge
        insert(temp);//taaki wo most recently used ban jaye
        return temp.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){//agar key already exist karti hai
            remove(map.get(key));//purana node remove kar do
        }
        if(map.size()==capacity){//agar capacity full ho chuki hai
            remove(tail.prev);//tail.prev->least recently used node hota hai
        }
        insert(new Node(key,value));//naya node insert karo
    }
    public void remove(Node node){
        map.remove(node.data);//hashmap se bhi remove kar do
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void insert(Node node){
        map.put(node.data,node);//hashmap mai add kar do
        node.next=head.next;//node ka next=old first
        head.next.prev=node;//old first ka prev=node
        head.next=node;//head ka next=node
        node.prev=head;//node ka prev=head
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */