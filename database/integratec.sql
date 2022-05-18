DROP TABLE IF EXISTS Request;
DROP TABLE IF EXISTS Account;
DROP TABLE IF EXISTS RequestCategory;
DROP TABLE IF EXISTS RequestStatus;
DROP TABLE IF EXISTS RequestPriority;
DROP TRIGGER IF EXISTS RequestCategoryTrigger;

CREATE TABLE `Account` (
`user_account_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
`login` varchar(30) NOT NULL,
`password` varchar(60) NOT NULL,
`name` varchar(30) NOT NULL,
`surname` varchar(30) NOT NULL
);

CREATE TABLE `RequestCategory` (
`request_category_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
`request_category` varchar(30) NOT NULL
);

CREATE TABLE `RequestStatus` (
`request_status_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
`request_status` varchar(30) NOT NULL
);

CREATE TABLE `RequestPriority` (
`request_priority_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
`request_priority` varchar(30) NOT NULL
);

CREATE TABLE `Request` (
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
CONSTRAINT `k_request_status` FOREIGN KEY (`request_status_id`) REFERENCES `RequestStatus` (`request_status_id`),
CONSTRAINT `k_request_category` FOREIGN KEY (`request_category_id`) REFERENCES `RequestCategory` (`request_category_id`),
CONSTRAINT `k_request_priority` FOREIGN KEY (`request_priority_id`) REFERENCES `RequestPriority` (`request_priority_id`)
);

DELIMITER // 
CREATE TRIGGER RequestCategoryTrigger
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

insert into Account(login, password, name, surname)
values
("Stanley_Kubirick", "$2a$10$rLQX0KuS9fdOQ3jfxuzN5uBPaWv4HHLptrrf2EQDD9uexBu7SUn3e", "Stan", "Kub"),
("Quentin_Tarantino", "$2a$10$rLQX0KuS9fdOQ3jfxuzN5uBPaWv4HHLptrrf2EQDD9uexBu7SUn3e", "Que", "Tar"),
("Sergio_Leone", "$2a$10$rLQX0KuS9fdOQ3jfxuzN5uBPaWv4HHLptrrf2EQDD9uexBu7SUn3e", "Ser", "Leo");

insert into RequestCategory(request_category)
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

insert into RequestPriority(request_priority)
values
("unspecified"),
("today"),
("this week"),
("this month");

insert into RequestStatus(request_status)
values
("new"),
("done"),
("in progress"),
("to do");

insert into Request(title, sender_id, receiver_id, text, comment, send_date, request_category_id, request_priority_id, request status) 
values ("bulaala", "1", "2", "skonczyly sie ciasteczka:(", "komentarz 1", "2022-04-22", "6", "1", "1"),
("title1", "1", "1", "skonczyly sie ciasteczka:(", "komentarz 1", "2022-04-22", "7", "1", "2"),
("title2", "1", "3", "skonczyly sie ciasteczka:(", "komentarz 1", "2022-04-22", "8", "1", "3"),
("title13", "1", "1", "skonczyly sie ciasteczka:(", "komentarz 1", "2022-04-22", "15", "1", "4")
("ciasteczka", "1", "2", "naprawde skonczyly sie ciasteczka:(", "komentarz 2", "2022-04-10", "1", "2", "3"), 
("karta sportowa", "3", "2", "prosze o karte sportow� od maja", "zrobione", "2022-04-05", "1", "2", "3"),
("owoce", "3", "3", "koncza sie owowce", "komentarz 4", "2022-03-18", "3", "2", "3"),
("faktura", "3", "2", "simple text", "komentarz komentatrz", "2022-04-22", "1", "2", "3"),
("rekrutacja", "1", "3", "zepsuty komputer ", "jutro sie tym zajme", "2022-04-22", "2", "2", "3"),
("wyjazd", "3", "3", "text 2", "jutro sie tym zajme", "2022-04-22", "1", "1", "1");