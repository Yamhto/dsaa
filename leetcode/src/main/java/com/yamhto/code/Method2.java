package com.yamhto.code;

/**
 * @author yamhto
 * @className: Method2.java
 * @package com.yamhto.code
 * @description:
 * @date 2020/4/29 16:53
 */

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Method2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        /*l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);*/

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        /*l2.next.next = new ListNode(9);*/

        ListNode res = addTwoNumbers(l1, l2);


        ListNode temp = res;
        while (null != temp) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);

        int increament = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp3 = res;

        while (null != temp1 || null != temp2 || increament != 0) {
            int sum = 0;
            if (null != temp1) {
                sum += temp1.val;
                temp1 = temp1.next;
            }

            if (null != temp2) {
                sum += temp2.val;
                temp2 = temp2.next;
            }


            if (sum + increament >= 10) {
                temp3.val = sum - 10 + increament;
                increament = 1;
            } else {
                temp3.val = sum + increament;
                increament = 0;
            }

            if (temp1 == null && temp2 == null && increament == 0) {
                break;
            }

            temp3.next = new ListNode(0);
            temp3 = temp3.next;
        }


        return res;
    }
}
