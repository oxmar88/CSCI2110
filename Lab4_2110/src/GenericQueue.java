// Omar Elsayed B00993452 lab4


import java.util.ArrayList;

public class GenericQueue <T>{
    private ArrayList<T>  queue ;

    public GenericQueue(){
        queue = new ArrayList<>(); // intializing queue as a new empty arraylist
    }

    public int size(){
        return queue.size();
    }

    public void enqueue(T elment){
        queue.add(elment);
    }

    public T dequeue(){
        return queue.remove(0); // removes first object in queue as queue is FIFO structure
    }

    public T peek(){
        return queue.get(0);
    }

    public boolean isEmpty() {
        if(queue.size() == 0) {
            return true;
        }
        return false;
    }

    public int positionOf(T item){
        return queue.indexOf(item);
        // used java documnetion to figure out how this function work
        // https://www.w3schools.com/java/ref_string_indexof.asp
        // it returns an integer which is the position of our T type item
    }

    public void remove(T item){
        queue.remove(item);
    }
}
