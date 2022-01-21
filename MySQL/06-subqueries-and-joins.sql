
-- subqueries and joins 

-- 1

SELECT e.employee_id,e.job_title,e.address_id, t.address_text FROM employees AS e
JOIN addresses AS t ON e.address_id = t.address_id
ORDER BY t.address_id
LIMIT 5;

/* Write a query that selects:
•	first_name
•	last_name
•	town
•	address_text
Sort the result by first_name in ascending order then by last_name. Select first 5 employees.
*/

SELECT e.first_name,e.last_name, t.name, a.address_text FROM employees AS e
JOIN addresses AS a ON e.address_id = a.address_id
JOIN towns AS t ON a.town_id = t.town_id
ORDER BY first_name,last_name
LIMIT 5;

/* Write a query that selects:
•	employee_id
•	first_name
•	last_name
•	department_name
Sort the result by employee_id in descending order. Select only employees from the "Sales" department. */

SELECT e.employee_id,e.first_name,e.last_name,d.name AS department_name FROM employees AS e
JOIN departments AS d ON e.department_id = d.department_id
WHERE d.name = 'Sales'
ORDER BY employee_id DESC;

/* •	employee_id
•	first_name
•	salary
•	department_name
Filter only employees with salary higher than 15000. Return the first 5 rows sorted by department_id in descending order. */

SELECT e.employee_id, e.first_name,e.salary, d.name AS department_name FROM employees AS e
JOIN departments AS d ON e.department_id = d.department_id
WHERE e.salary > 15000
ORDER BY e.department_id DESC
LIMIT 5;

/* Write a query that selects:
•	employee_id
•	first_name
Filter only employees without a project. Return the first 3 rows sorted by employee_id in descending order. */

SELECT employee_id,first_name FROM employees
-- JOIN employees_projects AS ep ON e.employee_id = ep.employee_id  <<< mistake
WHERE employee_id NOT IN (SELECT employee_id FROM employees_projects)
ORDER BY employee_id DESC
LIMIT 3;

/* Write a query that selects:
•	first_name
•	last_name
•	hire_date
•	dept_name
Filter only employees hired after 1/1/1999 and from either the "Sales" or the "Finance" departments.
Sort the result by hire_date (ascending). */

SELECT e.first_name,e.last_name,e.hire_date,d.name FROM employees AS e
JOIN departments AS d ON e.department_id = d.department_id
WHERE e.hire_date > DATE('1999-1-1') AND d.name IN ('Sales','Finance')
ORDER BY hire_date

/* Write a query that selects:
•	employee_id
•	first_name
•	project_name
Filter only employees with a project, which has started after 13.08.2002 and it is still ongoing (no end date).
Return the first 5 rows sorted by first_name then by project_name both in ascending order. */

SELECT e.employee_id,e.first_name,p.name AS project_name FROM employees AS e
JOIN employees_projects AS ep ON e.employee_id = ep.employee_id
JOIN projects AS p ON ep.project_id = p.project_id
WHERE e.employee_id IN (SELECT employee_id FROM employees_projects)
AND p.start_date > DATE('2002-08-13') AND p.end_date IS NULL
ORDER BY e.first_name,p.name
LIMIT 5

/* Write a query that selects:
•	employee_id
•	first_name
•	project_name
Filter all the projects of employees with id 24.
If the project has started after 2005 inclusively the return value should be NULL.
Sort the result by project_name alphabetically. */

SELECT e.employee_id,e.first_name,(SELECT IF(p.start_date > DATE('2005-01-01'), NULL, p.name)) AS project_name FROM employees AS e
JOIN employees_projects AS ep ON e.employee_id = ep.employee_id
JOIN projects AS p ON ep.project_id = p.project_id
WHERE e.employee_id = 24
ORDER BY project_name;

/* Write a query that selects:
•	employee_id
•	first_name
•	manager_id
•	manager_name
Filter all employees with a manager who has id equal to 3 or 7. Return all rows sorted by employee first_name in ascending order. */

SELECT e.employee_id, e.first_name, (SELECT employee_id FROM employees WHERE e.manager_id = employee_id) AS manager_id, (SELECT first_name FROM employees WHERE e.manager_id = employee_id) AS manager_name FROM employees AS e
WHERE e.manager_id IN(3,7)
ORDER BY e.first_name;

/* Write a query that selects:
•	employee_id
•	employee_name
•	manager_name		
•	department_name
Show the first 5 employees (only for employees who have a manager)
with their managers and the departments they are in (show the departments of the employees). Order by employee_id. */

SELECT e.employee_id, e.first_name,
(SELECT first_name FROM employees WHERE e.manager_id = employee_id) AS manager_name,  -- не знам защо връща null
d.name AS department_name FROM employees AS e
JOIN departments AS d ON e.department_id = d.department_id
ORDER BY e.employee_id
LIMIT 5;


-- Write a query that returns the value of the lowest average salary of all departments.

SELECT AVG(salary) FROM employees
GROUP BY department_id
ORDER BY department_id DESC
limit 3; -- минималната в софтуни е 10866.6666

/* Write a query that selects:
•	country_code	
•	mountain_range
•	peak_name
•	elevation
Filter all peaks in Bulgaria with elevation over 2835. Return all rows sorted by elevation in descending order. */

SELECT mc.country_code, m.mountain_range,p.peak_name, p.elevation FROM mountains AS m
JOIN peaks AS p ON p.mountain_id = m.id
JOIN mountains_countries AS mc ON mc.mountain_id = m.id
WHERE p.elevation > 2835 AND mc.country_code = 'BG'
ORDER BY p.elevation DESC;

/* Write a query that selects:
•	country_code
•	mountain_range
Filter the count of the mountain ranges in the United States, Russia and Bulgaria.
Sort result by mountain_range count in decreasing order. */

SELECT country_code,COUNT(m.mountain_range) as mountain_range FROM mountains AS m
JOIN mountains_countries AS mc ON mc.mountain_id = m.id
WHERE mc.country_code IN ('US','RU','BG')
GROUP BY country_code
ORDER BY mountain_range DESC;

/* Write a query that selects:
•	country_name
•	river_name
Find the first 5 countries with or without rivers in Africa. Sort them by country_name in ascending order. */

SELECT c.country_name, r.river_name FROM countries AS c
JOIN countries_rivers AS cr ON cr.country_code = c.country_code
JOIN rivers AS r ON r.id =  cr.river_id 
WHERE c.continent_code = 'AF'
GROUP BY country_name
ORDER BY country_name
LIMIT 5;

/* Write a query that selects:
•	continent_code
•	currency_code
•	currency_usage
Find all continents and their most used currency. Filter any currency that is used in only one country.
Sort the result by continent_code and currency_code. */

SELECT d1.continent_code, d1.currency_code, d1.currency_usage FROM 
	(SELECT `c`.`continent_code`, `c`.`currency_code`,
    COUNT(`c`.`currency_code`) AS `currency_usage` FROM countries as c
	GROUP BY c.currency_code, c.continent_code HAVING currency_usage > 1) as d1
LEFT JOIN 
	(SELECT `c`.`continent_code`,`c`.`currency_code`,
    COUNT(`c`.`currency_code`) AS `currency_usage` FROM countries as c
	 GROUP BY c.currency_code, c.continent_code HAVING currency_usage > 1) as d2
ON d1.continent_code = d2.continent_code AND d2.currency_usage > d1.currency_usage
 
WHERE d2.currency_usage IS NULL
ORDER BY d1.continent_code, d1.currency_code;

-- Find the count of all countries which don't have a mountain

SELECT COUNT(c.country_code) as country_count FROM countries as c
LEFT JOIN mountains_countries as m_c ON c.country_code = m_c.country_code
WHERE m_c.mountain_id IS NULL;

/* For each country, find the elevation of the highest peak and the length of the longest river,
sorted by the highest peak_elevation (from highest to lowest), then by the longest river_length
from longest to smallest), then by country_name (alphabetically). Display NULL when no data is available
in some of the columns. Limit only the first 5 rows.
--country_name	highest_peak_elevation	longest_river_length */

SELECT c.country_name, (SELECT MAX(elevation) FROM peaks 
JOIN mountains_countries AS mc ON mc.mountain_id = peaks.mountain_id
WHERE mc.country_code = c.country_code) AS highest_peak_elevation, (SELECT MAX(length) FROM rivers AS r
JOIN countries_rivers AS cr ON cr.river_id = r.id
WHERE cr.country_code = c.country_code) AS longest_river_length FROM countries AS c
ORDER BY highest_peak_elevation DESC ,longest_river_length DESC, c.country_name
LIMIT 5;





