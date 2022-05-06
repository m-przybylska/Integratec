DROP TABLE IF EXISTS Request;
DROP TABLE IF EXISTS Account;
DROP TABLE IF EXISTS RequestCategory;
DROP TABLE IF EXISTS RequestStatus;
DROP TABLE IF EXISTS RequestPriority;

CREATE TABLE `Account` (
`user_account_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
`login` varchar(30) NOT NULL,
`password` varchar(30) NOT NULL,
`name` varchar(30),
`surname` varchar(30)
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
`reciver_id` int NOT NULL,
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

insert into Account(login, password, name, surname)
values
("Stanley_Kubirick", "password123", "Stanley", "Kubirick"),
("Quentin_Tarantino", "password123", "Quentin", "Tarantino"),
("Sergio_Leone", "password123", "Sergio", "Leone");

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
  ("received"),
  ("in progress"),
  ("action needed"),
  ("reminder"),
  ("resolved");

insert into Request(title, sender_id, reciver_id, text, comment, send_date, request_status_id, request_category_id, request_priority_id)
values ("ciasteczka", "1", "2", "skonczyly sie ciasteczka:(", "komentarz 1", "2022-04-22", 1, 2, 1),
("ciasteczka", "1", "2", "naprawde skonczyly sie ciasteczka:(", "komentarz 2", "2022-04-10", 1, 2, 1),
("monitor", "2", "4", "", "", "2022-04-19", 1, 2, 1),
("karta sportowa", "3", "2", "prosze o karte sportową od maja", "", "2022-04-05", 1, 2, 1),
("owoce", "5", "6", "koncza sie owowce", "komentarz 4", "2022-03-18", 1, 2, 1),
("faktura", "6", "2", "simple text", "komentarz komentatrz", "2022-04-22", 1, 2, 1),
("rekrutacja", "1", "8", " ", "jutro sie tym zajme", "2022-04-22", 1, 2, 1),
("wyjazd", "4", "3", "text 2", "jutro sie tym zajme", "2022-04-22", 1, 2, 1);
