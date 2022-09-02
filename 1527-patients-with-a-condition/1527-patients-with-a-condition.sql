# Write your MySQL query statement below
-- SELECT * FORM Patients WHERE conditions LIKE '% DIAB1%' or conditions LIKE 'DIAB1%' ;
SELECT * FROM PATIENTS WHERE
CONDITIONS LIKE '% DIAB1%' OR
CONDITIONS LIKE 'DIAB1%';