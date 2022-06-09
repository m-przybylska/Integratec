DROP TABLE IF EXISTS request;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS request_category;
DROP TABLE IF EXISTS request_status;
DROP TABLE IF EXISTS request_priority;
DROP TRIGGER IF EXISTS request_category_trigger;

CREATE TABLE `account` (
`user_account_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
`login` varchar(30) NOT NULL,
`password` varchar(60) NOT NULL,
`name` varchar(30) NOT NULL,
`surname` varchar(30) NOT NULL
);

CREATE TABLE `request_category` (
`request_category_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
`request_category` varchar(30) NOT NULL
);

CREATE TABLE `request_status` (
`request_status_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
`request_status` varchar(30) NOT NULL
);

CREATE TABLE `request_priority` (
`request_priority_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
`request_priority` varchar(30) NOT NULL
);

CREATE TABLE `request` (
`request_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
`title` varchar(70) NOT NULL,
`sender_id` int NOT NULL,
`receiver_id` int NOT NULL,
`text` varchar(1000),
`comment` varchar(500),
`send_date` date,
`request_status_id` int,
`request_category_id` int,
`request_priority_id` int,
KEY `k_request_status` (`request_status_id`),
KEY `k_request_category` (`request_category_id`),
KEY `k_request_priority` (`request_priority_id`),
CONSTRAINT `k_request_status` FOREIGN KEY (`request_status_id`) REFERENCES `request_status` (`request_status_id`),
CONSTRAINT `k_request_category` FOREIGN KEY (`request_category_id`) REFERENCES `request_category` (`request_category_id`),
CONSTRAINT `k_request_priority` FOREIGN KEY (`request_priority_id`) REFERENCES `request_priority` (`request_priority_id`)
);

DELIMITER //
CREATE TRIGGER request_category_trigger
BEFORE INSERT ON request
FOR EACH ROW
BEGIN
IF NEW.request_category_id = 6 OR NEW.request_category_id = 7
OR NEW.request_category_id = 8 OR NEW.request_category_id = 14
OR NEW.request_category_id = 15 THEN SET NEW.receiver_id = 2;
ELSE
SET NEW.receiver_id = 1;
END IF;
END//
DELIMITER ;

insert into account(login, password, name, surname)
values
("Stanley_Kubirick", "$2a$10$rLQX0KuS9fdOQ3jfxuzN5uBPaWv4HHLptrrf2EQDD9uexBu7SUn3e", "Stanley", "Kubirick"),
("Quentin_Tarantino", "$2a$10$rLQX0KuS9fdOQ3jfxuzN5uBPaWv4HHLptrrf2EQDD9uexBu7SUn3e", "Quentin", "Tarantino"),
("Sheldon_Cooper", "$2a$10$rLQX0KuS9fdOQ3jfxuzN5uBPaWv4HHLptrrf2EQDD9uexBu7SUn3e", "Sheldon", "Cooper"),
("Penny_Hofstadter", "$2a$10$rLQX0KuS9fdOQ3jfxuzN5uBPaWv4HHLptrrf2EQDD9uexBu7SUn3e", "Penny", "Hofstadter"),
("Amy_Farah", "$2a$10$rLQX0KuS9fdOQ3jfxuzN5uBPaWv4HHLptrrf2EQDD9uexBu7SUn3e", "Amy", "Farah"),
("Bernadette_Rostenkowski", "$2a$10$rLQX0KuS9fdOQ3jfxuzN5uBPaWv4HHLptrrf2EQDD9uexBu7SUn3e", "Bernadette", "Rostenkowski-Wolowitz"),
("Leonard_Hofstadter", "$2a$10$rLQX0KuS9fdOQ3jfxuzN5uBPaWv4HHLptrrf2EQDD9uexBu7SUn3e", "Leonard", "Hofstadter"),
("Barry_Kripke", "$2a$10$rLQX0KuS9fdOQ3jfxuzN5uBPaWv4HHLptrrf2EQDD9uexBu7SUn3e", "Barry", "Kripke"),
("Howard_Wolowitz", "$2a$10$rLQX0KuS9fdOQ3jfxuzN5uBPaWv4HHLptrrf2EQDD9uexBu7SUn3e", "Howard", "Wolowitz"),
("Raj_Koothrappali", "$2a$10$rLQX0KuS9fdOQ3jfxuzN5uBPaWv4HHLptrrf2EQDD9uexBu7SUn3e", "Raj", "Koothrappali"),
("Sergio_Leone", "$2a$10$rLQX0KuS9fdOQ3jfxuzN5uBPaWv4HHLptrrf2EQDD9uexBu7SUn3e", "Ser", "Leo");

insert into request_category(request_category)
values
("kitchen"),
("stationery"),
("benefits"),
("documents"),
("trainings"),
("financial matters"),
("recruiting"),
("marketing"),
("time tracking & absences"),
("internal tools"),
("software"),
("hardware"),
("internal events & meetings"),
("business travels"),
("breakdowns & technical matter");

insert into request_priority(request_priority)
values
("unspecified"),
("today"),
("this week"),
("this month");

insert into request_status(request_status)
values
("new"),
("to do"),
("in progress"),
("done");

insert into Request(title, sender_id, receiver_id, text, comment, send_date, request_category_id, request_priority_id, request_status_id)
values ("Ciasteczka", "3", "1", "Skonczyly sie ciasteczka :(", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "2022-04-22", "6", "1", "1"),
       ("Urlop", "4", "2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "2022-04-22", "7", "1", "2"),
       ("Mulitsport", "5", "2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "2022-04-22", "8", "1", "3"),
       ("Wyjazd do Monachium", "6", "1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "2022-04-22", "15", "1", "4"),
       ("Nowy laptop", "7", "1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "2022-04-10", "1", "2", "1"),
       ("Karta benefit", "8", "1", "Prosze o karte sportową od maja", "zrobione", "2022-04-05", "1", "2", "3"),
       ("Owoce", "9", "2", "Koncza sie owowce, moze gruszki tym razem?", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "2022-03-18", "3", "2", "3"),
       ("Faktura", "10", "2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "2022-04-22", "1", "2", "4"),
       ("Rekrutacja", "11", "1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "jutro sie tym zajme", "2022-04-22", "2", "2", "1"),
       ("Karta sportowa", "3", "1", "Prosze o karte sportową od maja", "zrobione", "2022-04-05", "1", "2", "3"),
       ("Szkolenie", "4", "2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "2022-03-18", "3", "2", "2"),
       ("Spotkanie z klientem", "5", "2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "2022-04-22", "1", "2", "3"),
       ("Rekrutacja", "6", "1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "jutro sie tym zajme", "2022-04-22", "2", "2", "4"),
       ("Owoce", "9", "2", "Koncza sie owowce, moze gruszki tym razem?", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "2022-03-18", "3", "2", "3"),
       ("Faktura", "10", "2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "2022-04-22", "1", "2", "4"),
       ("Rekrutacja", "11", "1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "jutro sie tym zajme", "2022-04-22", "2", "2", "1"),
       ("Karta sportowa", "3", "1", "Prosze o karte sportową od maja", "zrobione", "2022-04-05", "1", "2", "3"),
       ("Szkolenie", "4", "2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "2022-03-18", "3", "2", "2"),
       ("Spotkanie z klientem", "5", "2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "2022-04-22", "1", "2", "3"),
       ("Zepsuta Klawiatura", "7", "2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "jutro sie tym zajme", "2022-04-22", "1", "1", "1");