// Omar Elsayed B00993452 lab4

import java.util.ArrayList;

public class GenericStack <T>{
    private ArrayList<T> stack;

    public GenericStack(){
        stack = new ArrayList<>();
    }

    public int size(){
        return stack.size();
    }

    public T pop(){
        return stack.remove(stack.size() -1 );
    }

    public T peek() {
        return stack.get(stack.size() - 1); // access element ontop of the stack (last element in array list)
    }

    public void push(T element) {
        stack.add(element);
    }


    public boolean isEmpty() {
        if(stack.size() == 0) {
            return true;
        }
        return false;
    }

}
