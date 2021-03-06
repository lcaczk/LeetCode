package com.wkk.simulation.newcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/5/28
 */
public class 下厨房 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] menus = line.split(" ");
            for (String menu : menus) {
                set.add(menu);
            }
        }
        System.out.println(set.size());
    }
}
