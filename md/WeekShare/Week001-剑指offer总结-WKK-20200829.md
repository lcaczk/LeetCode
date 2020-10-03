## 剑指offer整理(基础版本)

涵盖经典题型, 同时量小, 所以建议先从剑指offer开始刷起, 等有基本概念之后, 再根据自己的分类, 从LeetCode上刷对应的题目即可, 最后面试前(注重算法的公司), 过一遍剑指offer即可 

### 数组部分

1. 一维数组:

   1. 元素的排序(经典的排序算法)

   2. 元素的查找(二分问题)

      >排序数组中的搜索问题，首先想到 **二分法** 解决。
      >
      >关于二分查找, 理解起来简单, 但是有很多的细节问题需要考虑, 具体可以参考[二分查找模板](https://liweiwei1419.github.io/AlgoWiki/#/?id=algowiki)

      1. Offer中的题目:

         1. [ 11 旋转数组的最小数字](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof)  注意细节部分
         2. [287. 寻找重复数](https://leetcode-cn.com/problems/find-the-duplicate-number/) 确定范围
         3. [53-I 在排序数组中查找数字 I](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof)                            
         4. [53-II 0～n-1中缺失的数字](https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof) 

      2. 延伸拓展题目:                                                                                             

         1. 半有序

            在做二分查找的时候, 应该摒弃该思想: **必须要求数据的强有序性**

            1. [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
            2. [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/) 字节经典题

         2. 确定一个有范围的整数

   3. 其他类型, 根据实际意思采用对应方法

      1. 双指针
      2. 快慢指针
      3. 滑动窗口
      4. Hash

2. 二维数组

   >  二维数组的应用
   >
   > 1. 动态规划中的状态定义, 同时使用滚动数组还可以达到降维的效果
   > 2. 和图的结合, 这个时候会进化到使用DFS, BFS, 回溯等算法 
   > 3. 直接看做矩阵, 对里面的元素进行旋转变换查找等

   现在只介绍第三种, 其余的放在其他模块中

   1. Offer中的题目:
      1. [4 二维数组中的查找](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof)  
         1. 可以根据所给的数组特性, 从左下角开始寻找
      2. [29 顺时针打印矩阵](https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/) 经典的螺旋矩阵问题
   2. 延伸拓展题目: 
      1. [59. 螺旋矩阵II](https://leetcode-cn.com/problems/spiral-matrix-ii/)
      2. [895. 螺旋矩阵III](https://leetcode-cn.com/problems/spiral-matrix-iii/) 还没做:smile:
      3. [378 有序矩阵中第k小的元素](https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/)
         1. 利用有序矩阵的特性, 使用二分查找即可

   

### 链表部分

链表的题目, 难度不大, 需要注意防止断链即可(考研的时候, 链表的各种花式操作算法). 头插法的特性, 尾插法的特性等, 过程中需要注意是否需要创建头结点(如果head节点也会被操作的话)

#### 基础通识

![](https://i.loli.net/2020/08/22/tO6L8h539QwSWrJ.png)

1. 头插和尾插的区别(**一般用于重构/创建链表的时候使用**)

   头插为逆序输出, 尾插为正序输出

   ```java
   // 头插法
   ListNode temp = cur.next;
   cur.next = dummy.next;
   dummy.next = cur;
   cur = temp;
   
   
   // 尾插法
   ListNode rear = dummy;
   rear.next = cur;
   rear = cur;
   ```

2. 基本的插入

   ```java
   s.next = cur.next;
   cur.next = s;
   ```

3. 基本的删除

   ```java
   // 已知删除节点的前驱
   pre.next = cur.next;
   
   // 仅知道删除节点
   // 首先将cur的值设置为其后继节点的值, 然后在将cur.next指向cur.next.next即可
   ListNode temp = cur.next;
   cur.val = temp.val;
   cur.next = temp.next;
   ```

   

#### 类型

1. 节点的插入

2. 节点的删除

   1. offer中的题目
      1. 18 删除链表中的节点
         1. 两种删除方式均适用
      2. 22 链表中倒数第k个节点
         1. 直接遍历, 然后删除
         2. 使用快慢指针指针
      3. 56 删除链表中重复的节点
         1. 第一种: 删除重复的元素, 留一个
         2. 第二种: 重复元素全部删除

3. **节点之间的交换**

   > 延伸拓展, 基本上达到了medium级以上的程度

   1. [24 Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs) (medium)

      ![链表.png](https://i.loli.net/2020/03/18/J98jkA5oNBZEtpm.png)

   2. [k个一组反转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/) (hard) 

4. 链表的环

   1. offer中的题目:
      1. 判断一个链表是否有环
      2. 23 链表中的环入口
      3. 52 输出两个链表的公共节点(**字节高频面试题**)
         1. 如果二叉树有父节点的话, 则判断两个节点的公共节点即可简化为该问题

5. 链表的重构

   > 重构的时候, 建议设置一个头结点, 这样所有的有效节点都能一视同仁

   1. Offer中的题目

      1. 35 复杂链表的复制
         1. 需要注意random指针的复制
      2. 25 合并两个或K个有序链表
         1. 两个属于基础操作, 然后调用k/2次合并即可
         2. 直接使用堆排序
      3. 24 反转链表
         1. 看题目的要求, 如果是倒序输出, 则头插法, 否则尾插法

   2. 延伸拓展

      > 根据题意, 然后选择头插或者尾插, 使用队列或者栈, 题目本身不难

      1. [2 Add Two Numbers](https://leetcode.com/problems/add-two-numbers)
      2. [445 Add Two NUmbersII](https://leetcode.com/problems/add-two-numbers-ii/)

链表部分不难, 主要还是做之前理清逻辑, 同时防止断链即可

### 排序思想部分

书中涉及到了堆排序, 快排, 归并排序, 掌握各种算法的特性, 以及使用场景

快速排序

1. 面试题39: [ 数组中出现次数超过一半的数字](https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof)
2. 各种排序问题

堆排序

1. 最小/最大的k个数
2. 数据流中的中位数



### 树

> 1. 树的前序遍历, 中序遍历, 后序遍历, 层次遍历(**基础**), 大多数的题目均可以使用遍历解决
>
> 2. 递归, 递归始终理解不来, 就不展开了

#### 遍历性题目:

1. offer中的题目
   1. 面试题7：[重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof) 
   2. 面试题32-I：[从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof) **层次遍历** 
   3. 面试题32-II：[从上到下打印二叉树 II](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof) **层次遍历** 
   4. 面试题32-III：[从上到下打印二叉树 III](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof)  **层次遍历**
   5. 面试题37：[序列化二叉树](https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof)  **前序+中序**
   6. 面试题54：[二叉搜索树的第k大节点](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof)  **中序遍历**
   7.  [二叉搜索树与双向链表](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof) **前序遍历 可参考jdk中LinkedList源码部分**
   8. [ 二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list)  和上题一样
2. 拓展题目(熟记其递归和非递归的形式)
   1. [ 144 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal) 
   2. [94 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal) 
   3. [102 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal) 
   4. [145 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal) 

### 动态规划

这个, 主要靠个人, 按照正常的逻辑, 首先要读懂题目, 其次学会定义状态, 然后获取抽象的状态转移方程, 最后确定边界即可(基础)



### 其他的算法或思想

1. 滑动窗口

2. 双指针

   1. 数组(快慢指针, 头尾指针)
   2. 链表(快慢指针)

3. 位运算

   1. 面试题15: [ 二进制中1的个数](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof) (n & (n-1))可用于消除n中最后一位的1

   2. 面试题56-I: [数组中数字出现的次数](https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof)   异或操作可以进行消去相同的元素

      1. 基础问: 给定一个数组, 其中有一个数字出现了1次, 其余的都出现了2次, 求 出现了1次的元素
      2. 进阶问: 给定一个数组, 其中有两个数字出现了1次, 其余的都出现了2次, 求 出现了1次的元素

   3. 面试题56-II: [数组中数字出现的次数 II](https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof) 

      类似的思路, 但不使用异或

4. 最小栈



### 优质题解

1. [Krahets](https://leetcode-cn.com/u/jyd/)
   * 解题思路清晰明了, 完爆官方题解的存在
   * 但是只做了剑指offer的题解
2. [Sweetiee 🍬](https://leetcode-cn.com/u/sweetiee/)
   * 甜姨, 题解也很棒, 写法也很优美
   * 但是目前不怎么更新了
3. [liweiwei1419](https://leetcode-cn.com/u/liweiwei1419/)
   * weiwei哥的题解, 属于模板型题解, 看一道等于看一类
   * 但是有时候写的太口水化了, 反而理解不来了





