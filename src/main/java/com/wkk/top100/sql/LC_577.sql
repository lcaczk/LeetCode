-- 选出所有 bonus < 1000 的员工的 name 及其 bonus。

--Employee 表单

+-------+--------+-----------+--------+
| empId |  name  | supervisor| salary |
+-------+--------+-----------+--------+
|   1   | John   |  3        | 1000   |
|   2   | Dan    |  3        | 2000   |
|   3   | Brad   |  null     | 4000   |
|   4   | Thomas |  3        | 4000   |
+-------+--------+-----------+--------+
--empId 是这张表单的主关键字
--Bonus 表单

+-------+-------+
| empId | bonus |
+-------+-------+
| 2     | 500   |
| 4     | 2000  |
+-------+-------+
--empId 是这张表单的主关键字
--输出示例：

+-------+-------+
| name  | bonus |
+-------+-------+
| John  | null  |
| Dan   | 500   |
| Brad  | null  |
+-------+-------+

SELECT t1.name, t2.bonus FROM Employee AS t1 LEFT JOIN Bonus AS t2 ON t1.empId = t2.empId
WHERE t2.bonus < 1000 or ISNULL(t2.bonus);