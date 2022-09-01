# Please write a DELETE statement and DO NOT write a SELECT statement.
# Write your MySQL query statement below
delete from Person
where id not in (
                select id 
                from
                    (select min(id) as Id,Email
                    from Person
                    group by Email
                    order by Id) i
                )