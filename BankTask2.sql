-- Insertion Statements:

INSERT INTO Customers (customer_id, first_name, last_name, date_of_birth, address, phone_number) VALUES (1001, 'John', 'Doe', '1990-05-15', '123 Main St', '555-1234');
INSERT INTO Accounts (account_id, customer_id, account_type, balance, date_opened) VALUES (2001, 1001, 'Savings', 1000.00, '2023-01-01');
INSERT INTO Transactions (transaction_id, account_id, transaction_type, amount, transaction_date) VALUES (3001, 2001, 'Deposit', 500.00, '2023-01-05');
INSERT INTO Branches (branch_id, branch_name, branch_address, manager_id) VALUES (4001, 'Main Branch', '456 Elm St', 1001);
INSERT INTO Employees (employee_id, first_name, last_name, date_of_birth, address, phone_number, position, salary, date_hired, branch_id) VALUES (5001, 'Jane', 'Smith', '1985-08-20', '789 Oak Ave', '555-5678', 'Manager', 5000.00, '2022-01-01', 4001);
INSERT INTO Loans (loan_id, account_id, loan_amount, interest_rate, loan_duration) VALUES (6001, 2001, 10000.00, 5.5, 36);
INSERT INTO Loan_Payments (payment_id, loan_id, payment_amount, payment_date) VALUES (7001, 6001, 500.00, '2023-02-01');
INSERT INTO Cards (card_id, account_id, card_number, card_type, expiration_date) VALUES (8001, 2001, '1234567812345678', 'Visa', '2025-12-31');
INSERT INTO Transfers (transfer_id, sender_account_id, receiver_account_id, amount, transfer_date) VALUES (10001, 2001, 3001, 200.00, '2023-03-01');

-- Updating Statements:


UPDATE Customers SET phone_number = '555-4321' WHERE customer_id = 1001;
UPDATE Accounts SET balance = balance + 100.00 WHERE account_id = 2001;
UPDATE Transactions SET amount = 200.00 WHERE transaction_id = 3001;
UPDATE Branches SET branch_address = '789 Maple Ave' WHERE branch_id = 4001;
UPDATE Employees SET position = 'Senior Manager' WHERE employee_id = 5001;
UPDATE Loans SET loan_amount = loan_amount + 5000.00 WHERE loan_id = 6001;
UPDATE Loan_Payments SET payment_amount = 100.00 WHERE payment_id = 7001;
UPDATE Cards SET card_type = 'MasterCard' WHERE card_id = 8001;
UPDATE Transfers SET amount = 300.00 WHERE transfer_id = 10001;


-- Deletion Statements:


DELETE FROM Customers WHERE customer_id = 1001;
DELETE FROM Accounts WHERE account_id = 2001;
DELETE FROM Transactions WHERE transaction_id = 3001;
DELETE FROM Branches WHERE branch_id = 4001;
DELETE FROM Employees WHERE employee_id = 5001;
DELETE FROM Loans WHERE loan_id = 6001;
DELETE FROM Loan_Payments WHERE payment_id = 7001;
DELETE FROM Cards WHERE card_id = 8001;
DELETE FROM Transfers WHERE transfer_id = 10001;



-- Alter Table Statements:

ALTER TABLE Customers ADD email VARCHAR(255);
ALTER TABLE Accounts MODIFY balance DECIMAL(10, 2);
ALTER TABLE Branches DROP COLUMN manager_id;
ALTER TABLE Employees ADD CONSTRAINT fk_branch FOREIGN KEY (branch_id) REFERENCES Branch(branch_id) ON DELETE CASCADE;
ALTER TABLE Loan_Payments CHANGE COLUMN payment_date payment_date DATE NOT NULL;

-- Join Statement:


SELECT * FROM Customers
JOIN Account ON Customers.customer_id = Accounts.customer_id
JOIN Transactions ON Accounts.account_id = Transactions.account_id
JOIN Branches ON Transactions.branch_id = Branches.branch_id
JOIN Employee ON Branches.branch_id = Employees.branch_id
JOIN Loan ON Accounta.account_id = Loans.account_id
JOIN Loan_Payments ON Loans.loan_id = Loan_Payments.loan_id
JOIN Card ON Accounts.account_id = Cards.account_id
JOIN Transfers ON Accounts.account_id = Transfers.sender_account_id
JOIN Appointments ON Customers.customer_id = Appointments.customer_id
JOIN ATM ON Branches.branch_id = ATM.branch_id;


-- Join Statements with Different Types of Joins:



SELECT * FROM Customers LEFT JOIN Accounts ON Customers.customer_id = Accounts.customer_id;
SELECT * FROM Employees RIGHT JOIN Branches ON Employees.branch_id = Branches.branch_id;
SELECT * FROM Accounts INNER JOIN Transactions ON Accounts.account_id = Transactions.account_id;
SELECT * FROM Loan_Payments LEFT JOIN Loans ON Loan_Payments.loan_id = Loans.loan_id;


-- Aggregate Function Statements with GROUP BY and without HAVING:


SELECT account_id, COUNT(*) FROM Transactions GROUP BY account_id;
SELECT branch_id, SUM(balance) FROM Accounts GROUP BY branch_id;
SELECT employee_id, AVG(salary) FROM Employeez GROUP BY employee_id;
SELECT card_type, MAX(balance) FROM Accounts JOIN Cards ON Accounts.account_id = Cards.account_id GROUP BY card_type;
SELECT account_type, MIN(balance) FROM Accounts GROUP BY account_type;

-- Aggregate Function Statements with GROUP BY and HAVING:

SELECT account_id, SUM(amount) FROM Transactions GROUP BY account_id HAVING SUM(amount) > 1000;
SELECT card_type, AVG(balance) FROM Accounts JOIN Card ON Account.account_id = Card.account_id GROUP BY card_type HAVING AVG(balance) > 5000;
SELECT loan_id, MAX(loan_amount) FROM Loans GROUP BY loan_id HAVING MAX(loan_amount) < 50000;
SELECT branch_id, MIN(salary) FROM Employees GROUP BY branch_id HAVING MIN(salary) > 3000;





