//source :: https://www.w3resource.com/mysql-exercises/create-table-exercises/
use practice;

create table if not exists countries(country_id varchar(2), country_name varchar(40), region_id decimal(10, 0))

CREATE TABLE IF NOT EXISTS dup_countries
AS SELECT * FROM  countries;


select * from dup_countries;

/*Write a SQL statement to create a table named jobs including columns job_id, 
  job_title, min_salary, max_salary and check whether the max_salary amount exceeding the upper limit 25000 */
  
CREATE TABLE IF NOT EXISTS jobs ( 
JOB_ID varchar(10) NOT NULL , 
JOB_TITLE varchar(35) NOT NULL, 
MIN_SALARY decimal(6,0), 
MAX_SALARY decimal(6,0) 
CHECK(MAX_SALARY<=25000)
);

CREATE 
	TRIGGER myTrigger BEFORE INSERT ON jobs 
	FOR EACH ROW BEGIN
		IF NEW.MAX_SALARY <= 25000 THEN 
			SIGNAL SQLSTATE '02000' 
            SET MESSAGE_TEXT = 'Could not insert value didnt match';
        END IF;
        insert into jobs(job_id, job_title, min_salary, max_salary) values('kt201', 'sse', 2500, 25100)
END;







select * from jobs;


drop table countries;

/*
	Write a SQL statement to create a table named countries including columns country_id, country_name and region_id and make sure 
	that no countries except Italy, India and China will be entered in the table.
*/

create table countries(country_id varchar(2), country_name ENUM ('India','Italy','China'), region_id decimal(10,0));

insert into countries values('IT',4,13);
