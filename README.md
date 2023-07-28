This is a Student Portal project.



Creating necessary tables after pulling the project(customize them by demand):
```mysql
CREATE TABLE `course` (
`id` int NOT NULL,
`maxStudent` int DEFAULT NULL,
`enrollment` int DEFAULT NULL,
`location` varchar(255) DEFAULT NULL,
`start_date` varchar(20) DEFAULT NULL,
`showEnable` int DEFAULT NULL,
`description` varchar(255) DEFAULT NULL,
`end_date` varchar(20) DEFAULT NULL,
`name` varchar(255) DEFAULT NULL,
`price` double DEFAULT NULL,
`mode` varchar(50) DEFAULT NULL,
`instructor` varchar(255) DEFAULT NULL,
`week_days` varchar(8) DEFAULT NULL,
`time_interval` varchar(30) DEFAULT NULL,
`num_of_weeks` int DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `users` (
`id` int NOT NULL AUTO_INCREMENT,
`username` varchar(255) DEFAULT NULL,
`password` varchar(255) DEFAULT NULL,
`user_id` int DEFAULT NULL,
PRIMARY KEY (`id`),
UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `student_course` (
`student_id` int NOT NULL,
`course_id` int NOT NULL,
PRIMARY KEY (`student_id`,`course_id`),
KEY `course_id` (`course_id`),
CONSTRAINT `student_course_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`),
CONSTRAINT `student_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```
For administrator:

Register a new account and manually alter the user_id in database to 1 to become an administrator and acquire authority of accessing adminMainPage to manage course and student.

For student:

Register a new account and the user_id will automatically be 2.

Once login, student account will be lead to studentMainPage
