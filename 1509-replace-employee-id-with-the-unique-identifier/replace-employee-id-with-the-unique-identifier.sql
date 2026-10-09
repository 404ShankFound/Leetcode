# Write your MySQL query statement below
SELECT eu.unique_id AS unique_id, e.name AS name
FROM EmployeeUNI AS eu RIGHT JOIN Employees AS e ON eu.id=e.id;

