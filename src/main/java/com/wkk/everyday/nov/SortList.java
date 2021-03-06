package com.wkk.everyday.nov;

import com.common.structure.ListNode;

import java.util.Arrays;

/**
 * 148. SortList
 * @author kongwiki@163.com
 * @since 2020/11/21
 */
public class SortList {
    public static ListNode sortList(ListNode head) {
        if(head == null) {
            return head;
        }
        int len = getLen(head);
        int[] array = new int[len];
        int i = 0;
        ListNode cur = head;
        while(cur != null){
            array[i++] = cur.val;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1);
        Arrays.sort(array);
        cur = new ListNode(array[0]);
        dummy.next = cur;
        while(i < len) {
            i++;
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        return dummy.next;

    }
    private static int getLen(ListNode head) {
        int num = 0;
        ListNode cur = head;
        while(cur!=null) {
            cur = cur.next;
            num++;
        }
        return num;
    }

    public static int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = sortList(node1);
        System.out.println(1);
        int[] nums = {1, 2, 1, 1};
        int i = singleNumber(nums);
        System.out.println(i);
        System.out.println(3 & 1);
    }
}
