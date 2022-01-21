
SELECT first_name, middle_name,last_name FROM employees
ORDER BY `employee_id`; 

SELECT CONCAT(first_name,'.',last_name,'@softuni.bg') AS full_email_address FROM employees;

SELECT DISTINCT`salary` FROM `employees`; /* връща само уникални резултати, без да се повтарят */

/*find all information about the employees whose
job title is "Sales Representative". Sort the information by id. 
*/
SELECT * FROM `employees` WHERE `job_title` = 'Sales Representative'
ORDER BY `employee_id`;

/* find the first name, last name and job title of all employees
whose salary is in the range [20000, 30000]. Sort the information by id */

SELECT first_name, last_name, job_title FROM `employees`
WHERE `salary` >= 20000 AND `salary` <= 30000
ORDER BY `employee_id`;

/* to find the full name of all employees whose salary is 25000, 14000, 12500 or 23600.
Full Name is combination of first, middle and last name (separated with single space) and they should be in one column called "Full Name". 
*/

SELECT CONCAT_WS(' ',first_name, middle_name, last_name) AS 'Full Name' FROM `employees`
WHERE `salary` IN(25000,14000,12500,23600);

/* find first and last names about those employees that does not have a manager. */

SELECT first_name, last_name FROM `employees`
WHERE `manager_id` IS NULL; /* с null не се използва = */

/* find first name, last name and salary of those employees who has salary more than 50000.Order them in decreasing order by salary. */

SELECT first_name, last_name, salary FROM `employees`
WHERE `salary` > 50000
ORDER BY `salary` DESC;

/* find first and last names about 5 best paid Employees ordered descending by their salary. */

SELECT first_name, last_name, salary FROM `employees`
ORDER BY `salary` DESC
LIMIT 5;

/* find the first and last names of all employees whose department ID is different from 4 */
SELECT first_name, last_name, salary FROM `employees`
WHERE `department_id` != 4;
# or if when more than one option -> WHERE `department_id` NOT IN (4,5,6.....)

/* sort all records in the еmployees table by the following criteria:  
•	First by salary in decreasing order 
•	Then by first name alphabetically 
•	Then by last name descending 
•	Then by middle name alphabetically 
*/

SELECT * FROM `employees`
ORDER BY `salary` DESC, `first_name`,`last_name` DESC,`middle_name`;

/* create a view v_employees_salaries with first name, last name and salary for each employee */

CREATE VIEW v_employees_salaries AS
SELECT first_name, last_name, salary FROM employees;

/* create view v_employees_job_titles with full employee name and job title. When middle name is NULL replace it with empty string ('').  */

CREATE VIEW v_employees_job_titles AS
SELECT CONCAT_WS(' ', first_name, middle_name, last_name) AS full_name, job_title FROM employees;

/* to find all distinct job titles. Sort the result by job title alphabetically */

SELECT DISTINCT job_title FROM employees;

/* find first 10 started projects. Select all information about them and sort them by start date, then by name. Sort the information by id */

SELECT * FROM `projects`
ORDER BY start_date, `name`
LIMIT 10;

/*find last 7 hired employees. Select their first, last name and their hire date.  */

SELECT first_name,last_name,hire_date FROM employees
ORDER BY hire_date DESC
LIMIT 7;

/* increase salaries of all employees that are in the Engineering, Tool Design, Marketing or Information Services department by 12%.
Then select Salaries column from the Employees table */

UPDATE `employees`
SET `salary` = `salary` * 1.12
WHERE `department_id` IN (1,2,4,11);
SELECT `salary` FROM `employees`;



