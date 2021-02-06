-- 销售表Sales：

+-------------+-------+
| Column Name | Type  |
+-------------+-------+
| sale_id     | int   |
| product_id  | int   |
| year        | int   |
| quantity    | int   |
| price       | int   |
+-------------+-------+
-- (sale_id, year) 是销售表 Sales 的主键.
-- product_id 是关联到产品表 Product 的外键.
-- 注意: price 表示每单位价格
-- 产品表Product：

+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| product_id   | int     |
| product_name | varchar |
+--------------+---------+
-- product_id是表的主键.
--

-- 写一条SQL查询语句获取 Sales表中所有产品对应的 产品名称 product_name 以及该产品的所有 售卖年份 year和 价格 price 。



-- 示例：

-- Sales 表：
+---------+------------+------+----------+-------+
| sale_id | product_id | year | quantity | price |
+---------+------------+------+----------+-------+
| 1       | 100        | 2008 | 10       | 5000  |
| 2       | 100        | 2009 | 12       | 5000  |
| 7       | 200        | 2011 | 15       | 9000  |
+---------+------------+------+----------+-------+

-- Product 表：
+------------+--------------+
| product_id | product_name |
+------------+--------------+
| 100        | Nokia        |
| 200        | Apple        |
| 300        | Samsung      |
+------------+--------------+

-- Result 表：
+--------------+-------+-------+
| product_name | year  | price |
+--------------+-------+-------+
| Nokia        | 2008  | 5000  |
| Nokia        | 2009  | 5000  |
| Apple        | 2011  | 9000  |
+--------------+-------+-------+
-- join 即可
SELECT p.product_name, s.year, s.price FROM Sales AS s LEFT JOIN Product AS p ON s.product_id = p.product_id ;