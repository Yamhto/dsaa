package com.yamhto.stack;

/**
 * @author yamhto
 * @className: Stack.java
 * @package com.yamhto.stack
 * @description:
 * @date 2020/4/29 9:10
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    /**
     * 插进去数据
     *
     * @param e
     */
    void push(E e);

    /**
     * 移除顶对象并作为此函数的值返回该对象
     *
     * @return
     */
    E pop();

    /**
     * 找到但不移除此列表的头(第一个元素)
     *
     * @return
     */
    E peek();


}
