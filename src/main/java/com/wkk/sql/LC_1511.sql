表: Customers

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| customer_id   | int     |
| name          | varchar |
| country       | varchar |
+---------------+---------+
customer_id 是该表主键.
该表包含公司消费者的信息.
 

表: Product

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| product_id    | int     |
| description   | varchar |
| price         | int     |
+---------------+---------+
product_id 是该表主键.
该表包含公司产品的信息.
price 是本产品的花销.
 

表: Orders

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| order_id      | int     |
| customer_id   | int     |
| product_id    | int     |
| order_date    | date    |
| quantity      | int     |
+---------------+---------+
order_id 是该表主键.
该表包含消费者下单的信息.
customer_id 是买了数量为"quantity", id为"product_id"产品的消费者的 id.
Order_date 是订单发货的日期, 格式为('YYYY-MM-DD').
 

写一个 SQL 语句,  报告消费者的 id 和名字, 其中消费者在 2020 年 6 月和 7 月, 每月至少花费了$100.

结果表无顺序要求.

查询结果格式如下例所示.

 

Customers
+--------------+-----------+-------------+
| customer_id  | name      | country     |
+--------------+-----------+-------------+
| 1            | Winston   | USA         |
| 2            | Jonathan  | Peru        |
| 3            | Moustafa  | Egypt       |
+--------------+-----------+-------------+

Product
+--------------+-------------+-------------+
| product_id   | description | price       |
+--------------+-------------+-------------+
| 10           | LC Phone    | 300         |
| 20           | LC T-Shirt  | 10          |
| 30           | LC Book     | 45          |
| 40           | LC Keychain | 2           |
+--------------+-------------+-------------+

Orders
+--------------+-------------+-------------+-------------+-----------+
| order_id     | customer_id | product_id  | order_date  | quantity  |
+--------------+-------------+-------------+-------------+-----------+
| 1            | 1           | 10          | 2020-06-10  | 1         |
| 2            | 1           | 20          | 2020-07-01  | 1         |
| 3            | 1           | 30          | 2020-07-08  | 2         |
| 4            | 2           | 10          | 2020-06-15  | 2         |
| 5            | 2           | 40          | 2020-07-01  | 10        |
| 6            | 3           | 20          | 2020-06-24  | 2         |
| 7            | 3           | 30          | 2020-06-25  | 2         |
| 9            | 3           | 30          | 2020-05-08  | 3         |
+--------------+-------------+-------------+-------------+-----------+

Result 表:
+--------------+------------+
| customer_id  | name       |
+--------------+------------+
| 1            | Winston    |
+--------------+------------+
Winston 在2020年6月花费了$300(300 * 1), 在7月花费了$100(10 * 1 + 45 * 2).
Jonathan 在2020年6月花费了$600(300 * 2), 在7月花费了$20(2 * 10).
Moustafa 在2020年6月花费了$110 (10 * 2 + 45 * 2), 在7月花费了$0.
-- 思路
select c.customer_id,c.name
from customers c
join orders o on o.customer_id=c.customer_id
join product p on p.product_id=o.product_id
group by c.customer_id, c.name
having sum(case when left(o.order_date,7)='2020-06' then p.price*o.quantity else 0 end)>=100 and
sum(case when left(o.order_date,7)='2020-07' then p.price*o.quantity else 0 end)>=100