package com.yamhto.collection.test;

import com.yamhto.collection.StaticArray;

/**
 * @author yamhto
 * @className: Test.java
 * @package com.yamhto.collection.test
 * @description:
 * @date 2020/4/29 9:49
 */
public class Test {

    public static void main(String[] args) {
        StaticArray<String> arrays = new StaticArray<String>(10);

        arrays.add("aaa");
        arrays.add("bbb");
        arrays.add("ccc");
        arrays.add("ddd");

        arrays.remove("aaa");

        for (String str : arrays){
            System.out.println(str);
            //System.out.println(arrays.size());
        }

    }
}
