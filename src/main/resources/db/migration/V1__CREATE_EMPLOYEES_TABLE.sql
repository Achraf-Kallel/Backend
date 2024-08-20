CREATE SEQUENCE employees_table_id_seq;

CREATE TABLE employeees (
    id INT PRIMARY KEY DEFAULT nextval('employees_table_id_seq'),
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    email VARCHAR(255),
    salary INT NOT NULL
);

--add new row when new employee is added
ALTER SEQUENCE employees_table_id_seq OWNED BY employeees.id;