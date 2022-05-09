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
("John_Kovalsky", "password123", "Stanley", "Kubirick"),
("Sheldon_Cooper", "password123", "Sheldon", "Cooper"),
("Howard_Wolowitz", "password123", "Howard", "Wolowitz"),
("Amy Farah", "password123", "Amy", "Farah"),
("Leonard_Hofstadter", "password123", "Leonard", "Hofstadter"),
("Raj_Koothrappali", "password123", "Raj", "Koothrappali"),
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
       ("ciasteczka", "2", "2", "naprawde skonczyly sie ciasteczka:(", "komentarz 2", "2022-04-10", 3, 1, 2),
       ("monitor", "3", "4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.", "2022-04-19", 6, 2, 1),
       ("karta sportowa", "4", "2", "prosze o karte sportową od maja", "ok", "2022-04-05", 6, 3, 3),
       ("owoce", "5", "6", "koncza sie owowce", "komentarz 4", "2022-03-18", 3, 4, 4),
       ("faktura", "6", "2", "simple text", "komentarz komentatrz", "2022-04-22", 3, 5, 1),
       ("rekrutacja", "7", "8", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.", "jutro sie tym zajme", "2022-04-22", 1, 6, 2),
       ("karta sportowa", "8", "2", "prosze o karte sportową od maja", "", "2022-04-05", 3, 12, 3),
       ("owoce", "9", "6", "koncza sie owowce", "komentarz 4", "2022-03-18", 3, 15, 4),
       ("faktura", "1", "2", "simple text", "komentarz komentatrz", "2022-04-22", 3, 11, 3),
       ("rekrutacja", "2", "8", "Lorem ipsum dolor sit amet", "jutro sie tym zajme", "2022-04-22", 1, 10, 3),
       ("karta sportowa", "3", "2", "prosze o karte sportową od maja", "", "2022-04-05", 2, 9, 2),
       ("owoce", "4", "6", "koncza sie owowce", "komentarz 4", "2022-03-18", 3, 8, 1),
       ("faktura", "5", "2", "simple text", "komentarz komentatrz", "2022-04-22", 3, 8, 2),
       ("rekrutacja", "6", "8", " ", "jutro sie tym zajme", "2022-04-22", 2, 2, 3),
       ("karta sportowa", "7", "2", "prosze o karte sportową od maja", "", "2022-04-05", 1, 7, 4),
       ("owoce", "8", "6", "koncza sie owowce", "komentarz 4", "2022-03-18", 3, 2, 1),
       ("faktura", "9", "2", "simple text", "komentarz komentatrz", "2022-04-22", 3, 14, 2),
       ("rekrutacja", "1", "8", " ", "jutro sie tym zajme", "2022-04-22", 6, 13, 1),
       ("wyjazd", "2", "3", "text 2", "jutro sie tym zajme", "2022-04-22", 3, 2, 1);
