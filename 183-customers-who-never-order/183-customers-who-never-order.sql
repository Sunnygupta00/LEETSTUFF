# Write your ySQL query statement below
SELECT name as Customers FROM Customers WHERE id NOT IN (SELECT customerID FROM orders);
-- select name as Customers from customers where id not in (select customerid from orders);