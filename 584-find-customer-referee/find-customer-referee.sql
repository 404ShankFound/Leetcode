# Write your MySQL query statement below
#BY DEFAULT SQL QUERIES DONT RETURN NULL SO WE NEED EXTRA IS NULL
SELECT name
FROM Customer
WHERE referee_id!=2 OR referee_id IS NULL;