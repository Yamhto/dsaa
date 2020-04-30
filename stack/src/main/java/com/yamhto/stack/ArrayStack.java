package com.yamhto.stack;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yamhto
 * @className: ArrayStack.java
 * @package com.yamhto.stack
 * @description:
 * @date 2020/4/29 9:14
 */
public class ArrayStack<E>  implements Stack<E>{

    List<E> lists;

    public ArrayStack(int capacity){
        lists = new ArrayList<E>(capacity);
    }

    public ArrayStack(){
        lists = new ArrayList<E>();
    }


    public int getSize() {
        return lists.size();
    }

    public boolean isEmpty() {
        return lists.isEmpty();
    }

    public void push(E e) {

    }

    public E pop() {
        return null;
    }

    public E peek() {
        return null;
    }
}
