package com.wkk.recursive.relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kongwiki@163.com
 * @since 2020/8/4上午11:29
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = generate(rowIndex + 1);
        return res.get(rowIndex);
    }

    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(new ArrayList<>());
        // 第一行
        res.get(0).add(1);
        List<Integer> pre, cur;
        for (int i = 1; i < numRows; i++) {
            pre = res.get(i - 1);
            cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j <= i - 1; j++) {
                int temp = pre.get(j - 1) + pre.get(j);
                cur.add(temp);
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}
