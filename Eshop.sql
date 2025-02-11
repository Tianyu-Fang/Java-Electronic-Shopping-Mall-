CREATE DATABASE  IF NOT EXISTS `esmdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `esmdb`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: esmdb
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `esm_address`
--

DROP TABLE IF EXISTS `esm_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `esm_address` (
  `ADDRESS_ID` int NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(32) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `PHONE` varchar(45) NOT NULL,
  `STATE` varchar(45) NOT NULL,
  `COUNTY` varchar(45) NOT NULL,
  `CODE` varchar(5) NOT NULL,
  `COMMENT` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`ADDRESS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `esm_address`
--

LOCK TABLES `esm_address` WRITE;
/*!40000 ALTER TABLE `esm_address` DISABLE KEYS */;
INSERT INTO `esm_address` VALUES (18,'admin','Jiacheng Tang','18257410407','WP Kuala Lumpur','Kuala Lumpur','50000',''),(20,'dreamy','Jiacheng Tang','18257410407','WP Kuala Lumpur','Kuala Lumpur','50000','university address'),(21,'admin','Tang jicheng','18257410407','Johor','Subang Jaya','50150','home'),(22,'dreamy','dreamy','18257410407','Kelaka','Pulau Indah','50088','home');
/*!40000 ALTER TABLE `esm_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `esm_cart`
--

DROP TABLE IF EXISTS `esm_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `esm_cart` (
  `CART_ID` int NOT NULL AUTO_INCREMENT,
  `CART_P_FILENAME` varchar(128) DEFAULT NULL,
  `CART_P_NAME` varchar(64) DEFAULT NULL,
  `CART_P_PRICE` decimal(10,2) DEFAULT NULL,
  `CART_QUANTITY` int DEFAULT NULL,
  `CART_P_STOCK` int DEFAULT NULL,
  `CART_P_ID` int DEFAULT NULL,
  `CART_U_ID` varchar(64) DEFAULT NULL,
  `CART_VALID` int DEFAULT NULL,
  PRIMARY KEY (`CART_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `esm_cart`
--

LOCK TABLES `esm_cart` WRITE;
/*!40000 ALTER TABLE `esm_cart` DISABLE KEYS */;
INSERT INTO `esm_cart` VALUES (65,'bootstrap_2.jpg','Learning Bootstrap 4 by Building Projects',39.00,2,99,10,'admin',1),(69,'jQuery_2.jpg','jQuery in easy steps',9.00,3,166,18,'admin',1),(78,'htmlcss_4.jpg','HTML and CSS: Design and Build Websites',13.00,3,128,4,'dreamy',1);
/*!40000 ALTER TABLE `esm_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `esm_category`
--

DROP TABLE IF EXISTS `esm_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `esm_category` (
  `CATE_ID` int NOT NULL AUTO_INCREMENT,
  `CATE_NAME` varchar(20) NOT NULL,
  `CATE_PARENT_ID` decimal(10,0) NOT NULL,
  PRIMARY KEY (`CATE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `esm_category`
--

LOCK TABLES `esm_category` WRITE;
/*!40000 ALTER TABLE `esm_category` DISABLE KEYS */;
INSERT INTO `esm_category` VALUES (1,'HTML/CSS',0),(2,'JavaScript',0),(3,'Server',0),(4,'Database',0),(5,'Tool',0),(6,'HTML',1),(7,'CSS',1),(8,'Bootstrap',1),(9,'JavaScript',2),(10,'jQuery',2),(11,'Vue',2),(12,'PHP',3),(13,'Django',3),(14,'JSP',3),(15,'Servlet',3),(16,'MySQL',4),(17,'Redis',4),(18,'Eclipse',5),(19,'Git',5),(20,'Markdown',5);
/*!40000 ALTER TABLE `esm_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `esm_order`
--

DROP TABLE IF EXISTS `esm_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `esm_order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT 'payed',
  `order_time` datetime NOT NULL,
  `total_price` decimal(12,0) NOT NULL,
  `address_id` decimal(10,0) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2078926106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `esm_order`
--

LOCK TABLES `esm_order` WRITE;
/*!40000 ALTER TABLE `esm_order` DISABLE KEYS */;
INSERT INTO `esm_order` VALUES (52454450,'dreamy','payed','2021-12-26 19:19:27',24,20,''),(314595253,'dreamy','payed','2021-12-26 19:20:06',195,22,''),(320312340,'dreamy','payed','2021-12-26 19:19:09',235,22,''),(706249922,'admin','payed','2021-12-26 19:15:53',239,21,''),(993473325,'dreamy','payed','2021-12-26 19:19:46',378,20,''),(1204884457,'admin','received','2021-12-26 19:16:20',123,18,''),(1599686863,'dreamy','received','2021-12-26 19:18:08',205,20,''),(1757438934,'admin','payed','2021-12-26 19:16:49',24,21,'');
/*!40000 ALTER TABLE `esm_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `esm_orderitem`
--

DROP TABLE IF EXISTS `esm_orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `esm_orderitem` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `product_num` int NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `esm_orderitem`
--

LOCK TABLES `esm_orderitem` WRITE;
/*!40000 ALTER TABLE `esm_orderitem` DISABLE KEYS */;
INSERT INTO `esm_orderitem` VALUES (56,706249922,51,3),(57,706249922,47,3),(58,706249922,43,1),(59,1204884457,59,3),(60,1204884457,23,2),(61,1757438934,6,3),(62,1599686863,10,3),(63,1599686863,46,2),(64,320312340,30,3),(65,320312340,15,5),(66,52454450,48,2),(67,993473325,44,4),(68,993473325,5,3),(69,314595253,2,3),(70,314595253,11,3);
/*!40000 ALTER TABLE `esm_orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `esm_product`
--

DROP TABLE IF EXISTS `esm_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `esm_product` (
  `PRODUCT_ID` int NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(128) NOT NULL,
  `PRODUCT_DESCRIPTION` varchar(512) DEFAULT NULL,
  `PRODUCT_PRICE` decimal(10,2) NOT NULL,
  `PRODUCT_STOCK` decimal(10,0) DEFAULT NULL,
  `PRODUCT_FID` decimal(10,0) DEFAULT NULL,
  `PRODUCT_CID` decimal(10,0) DEFAULT NULL,
  `PRODUCT_FILENAME` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `esm_product`
--

LOCK TABLES `esm_product` WRITE;
/*!40000 ALTER TABLE `esm_product` DISABLE KEYS */;
INSERT INTO `esm_product` VALUES (1,'Head First HTML and CSS',' If you\'ve read a Head First book, you know what to expect: a visually-rich format designed for the way your brain works. ',37.00,200,1,6,'htmlcss_1.jpg'),(2,'HTML and CSS QuickStart Guide','The best book on the market for modern web design fundamentals for 2021 and beyond!In HTML & CSS QuickStart Guide author, instructor.',20.00,186,1,6,'htmlcss_2.jpg'),(3,'HTML Awesomeness Book','The ideal student for this book is anybody who wants to expand their knowledge of HTML or get a leg up in the web developer world.',15.00,220,1,6,'htmlcss_3.jpg'),(4,'HTML and CSS: Design and Build Websites','This book introduces HTML and CSS in a way that makes them accessible to everyone, students, and professionals.',13.00,128,1,6,'htmlcss_4.jpg'),(5,'Responsive Web Design with HTML 5 & CSS','Packed with best practices and tips from the pros, the text gives you a solid foundation in HTML, CSS and responsive web design.',110.00,230,1,7,'css_1.jpg'),(6,'Learn CSS in One Day and Learn It Well','You no longer have to waste your time and money learning HTML and CSS from lengthy books, expensive online courses or complicated tutorials.',8.00,106,1,7,'css_2.jpg'),(7,'CSS Secrets','In this practical guide, CSS expert Lea Verou provides 47 undocumented techniques and tips to help intermediate-to advanced CSS developers devise elegant solutions to a wide range of everyday web design problems. ',27.00,89,1,7,'css_3.jpg'),(8,'CSS: The Definitive Guide','If you are a web designer or app developer interested in sophisticated page styling, improved accessibility, and saving time and effort, this book is for you. ',16.00,100,1,7,'css_4.jpg'),(9,'Bootstrap 4 Quick Start','In this book you will become familiar with the new cards component, setting up the new flexbox grid layout, customizing the look and feel, how to follow the mobile-first development workflow, and more!',25.00,96,1,8,'bootstrap_1.jpg'),(10,'Learning Bootstrap 4 by Building Projects','The book begins by introducing you to the latest features of Bootstrap 4. You will learn different elements and components of Bootstrap, such as the strict grid system, Sass, which replaced Less, flexbox, Font Awesome, and cards.',39.00,99,1,8,'bootstrap_2.jpg'),(11,'Mastering Bootstrap 4','This book targets intermediate-level front-end web-developers. The book is not intended to be an introduction to web development.',45.00,95,1,8,'bootstrap_3.jpg'),(12,'Jump Start Bootstrap','In just one weekend with this hands-on tutorial.',14.00,88,1,8,'bootstrap_4.jpg'),(13,'JavaScript: The Definitive Guide','This book is for programmers who want to learn JavaScript and for web developers who want to take their understanding and mastery to the next level.  ',47.00,88,2,9,'jsp_1.jpg'),(14,'Learn JavaScript Quickly','In Learn JavaScript Quickly, you will discover:A full beginner guide on programming, including the simplest, most basic things all newbies should know before getting started with JavaScript.',14.00,66,2,9,'javascript_2.jpg'),(15,'Eloquent JavaScript, 3rd Edition','This much anticipated and thoroughly revised third edition of Eloquent JavaScript dives deep into the JavaScript language to show you how to write beautiful, effective code. ',20.00,90,2,9,'javascript_3.jpg'),(16,'A Smarter Way to Learn JavaScript','Written especially for beginners.',15.00,210,2,9,'javascript_4.jpg'),(17,'Learning jQuery 3 - Fifth Edition','This book is ideal for client-side JavaScript developers. You do need to have any previous experience with jQuery, although basic JavaScript programming knowledge is necessary.',20.00,163,2,10,'jQuery_1.jpg'),(18,'jQuery in easy steps','jQuery in Easy Steps assumes readers will already have some basic knowledge of HTML, CSS, and JavaScript and are now ready to embrace the jQuery philosophy of \"write less - do more\" to enhance their web pages.',9.00,166,2,10,'jQuery_2.jpg'),(19,'A Smarter Way to Learn jQuery','Using the Smarter Way to Learn method, you actually learn jQuery, you don\'t just read about it. ',18.00,168,2,10,'jQuery_3.jpg'),(20,'jQuery Pocket Reference','jQuery is the \"write less, do more\" JavaScript library.This book is jQuery\'s trusty companion: the definitive \"read less, learn more\" guide to the library.',6.00,190,2,10,'jQuery_4.jpg'),(21,'Vue.js 3 By Example','This book will help you understand how you can leverage Vue effectively to develop impressive apps quickly using its latest version  Vue 3.0.',43.00,99,2,11,'vue_1.jpg'),(22,'Fullstack Vue: The Complete Guide to Vue.js','Another must read from the team! Going through the book\'s real-world apps is like growing your dev superpowers one concept at a time.',35.00,102,2,11,'vue_2.jpg'),(23,'Vue.js 3 Cookbook','The book is for both new and experienced Vue.js developers looking to overcome challenges in building dynamic web applications with Vue.js 3. Knowledge of JavaScript and TypeScript is assumed. ',45.00,111,2,11,'vue_3.jpg'),(24,'Vue.js in Action 1st Edition','Vue.js in Action teaches readers to build fast, flowing web UI with the Vue.js framework. ',37.00,76,2,11,'vue_4.jpg'),(25,' Learn PHP in One Day and Learn It Well','This book covers all the major topics in PHP and is written in a concise and to the point manner.',13.00,79,3,12,'php_1.jpg'),(26,'Programming PHP',' This updated edition teaches everything you need to know to create effective web applications using the latest features in PHP 7.4. ',46.00,157,3,12,'php_2.jpg'),(27,'The Art of Modern PHP 8','The book is for existing PHP developers and CTO-level professionals who are working with PHP technologies, including legacy PHP, in production.',54.00,112,3,12,'php_3.jpg'),(28,'PHP Objects, Patterns, and Practice ','The 5th edition of this popular book has been fully updated for PHP 7, including replacing the PEAR package manager with Composer, and new material on Vagrant and PHP standards. ',40.00,82,3,12,'php_4.jpg'),(29,'Web Development with Django','Starting with the essential concepts of Django, you\'ll cover its major features by building a website called Book a repository for book reviews.',54.00,123,3,13,'Django_1.jpg'),(30,'Django for Professionals','Django for Professionals takes your web development skills to the next level, teaching you how to build production-ready websites with Python and Django.',45.00,135,3,13,'Django_2.jpg'),(31,'Django 3 By Example','If you want to learn the entire process of developing professional web applications with Python and Django, then this book is for you. ',56.00,145,3,13,'Django_3.jpg'),(32,'Mastering Django','Mastering Django is not just a revision of the original book. It has been completely rewritten from the ground up to meet the needs of modern Django programmers.',49.00,167,3,13,'Django_4.jpg'),(33,'Murach\'s Java Servlets and JSP','This new edition of Murach\'s Java Servlets and JSP makes it easier than ever for Java developers to master web programming. A great read for any Java developer.',31.00,179,3,14,'jsp_1.jpg'),(34,'Servlet & JSP: A Beginner\'s Tutorial','Covering Servlet 3.1 and JSP 2.3, this book explains the important programming concepts and design models in Java web development as well as related technologies and new features in the latest versions of Servlet and JSP. ',20.00,162,3,14,'jsp_2.jpg'),(35,'Java Servlet & JSP Cookbook','With literally hundreds of examples and thousands of lines of code, the Java Servlet and JSP Cookbook yields tips and techniques that any Java web developer who uses JavaServer Pages or servlets will use every day.',22.00,111,3,14,'jsp_3.jpg'),(36,'JavaServer Pages','The only visual guide to JSP, JavaServer Pages: Your visual blueprint for designing dynamic content with JSP offers you a visual alternative to learning to write JSP documents.',10.00,135,3,14,'jsp_4.jpg'),(37,'Instant Java Servlets','A techniques-oriented cookbook for Java servlet programming furnishes a variety of ready-to-use solutions to hundreds of common programming problems and includes more than two hundred working samples.',32.00,156,3,15,'servlet_1.jpg'),(38,'Java Servlet Programming','Readers can use the book\'s numerous real-world examples as the basis for their own servlets.The second edition has been completely updated to cover the new features of Version 2.2 of the Java Servlet API.',24.00,45,3,15,'servlet_2.jpg'),(39,'Inside Servlets','This second edition of this bestselling guide is updated to reflect the Servlet API 2.2, how to effectively deploy a servlet-based application, security and user authentication, and explain the new JSP technology and new information on databases and JDBC.',45.00,88,3,15,'servlet_3.jpg'),(40,'Professional Java Servlets 2.3','The book reveals how and where servlets fit into an enterprise solution, and addresses issues such as security, scalability, performance and design. It walks you through the API covering the role of all the classes and interfaces.',13.00,68,3,15,'servlet_4.jpg'),(41,'Learning MySQL','Authors Vinicius Grippa and Sergey Kuzmichev from Percona show developers and DBAs methods for minimizing costs and maximizing availability and performance.',45.00,104,4,16,'mysql_1.jpg'),(42,'Murach\'s MySQL (3rd Edition)','As you would expect, this book shows how to code all the essential SQL statements for working with a MySQL database. You\'ll use these statements every day to have MySQL do more of your work for you.',21.00,125,4,16,'mysql_2.jpg'),(43,'Learn SQL in One Day and Learn It Well','The best way to learn SQL is by doing. This book provides examples for all concepts taught so that you can try out the different SQL commands yourself.',17.00,146,4,16,'mysql_3.jpg'),(44,'MySQL in a Nutshell','The new edition contains all the commands and programming information for version 5.1, including new features and language interfaces.',12.00,174,4,16,'mysql_4.jpg'),(45,'Redis Essentials','Redis Essentials is a fast-paced guide that teaches the fundamentals on data types, explains how to manage data through commands, and shares experiences from big players in the industry.',34.00,126,4,17,'redis_1.jpg'),(46,'Redis 4.x Cookbook','This book is for database administrators, developers and architects who want to tackle the common and not so common problems associated with the different development and administration-related tasks in Redis. ',44.00,205,4,17,'redis_2.jpg'),(47,'Mastering Redis','If you are a software developer with some experience with Redis and would now like to elevate your Redis knowledge and skills even further, then this book is for you.',42.00,133,4,17,'redis_3.jpg'),(48,'Redis Cookbook','If you\'re using Redis, or considering it, this concise cookbook provides recipes for a variety of issues you\'re likely to face.',12.00,126,4,17,'redis_4.jpg'),(49,'Eclipse IDE','This book gives an introduction into using the Eclipse IDE for Java development. It assumes no previous knowledge of the Eclipse IDE and can be used by a new user to learn the Eclipse IDE. ',13.00,99,5,18,'eclipse_1.jpg'),(50,'Contributing to the Eclipse IDE Project','This book gives a practical introduction how you can access the source code of Eclipse IDE projects and contribute features and fixes back to these open source projects.',59.00,30,5,18,'eclipse_2.jpg'),(51,'Java and Eclipse for Computer Science','This textbook combines Java programming, Computer Science, and a popular development tool that not only prepares you for the Computer Science curriculum but also beyond the classroom into your professional career. ',32.00,80,5,18,'eclipse_3.jpg'),(52,'Eclipse IDE Pocket Guide','The Eclipse IDE Pocket Guide is just the resource you need for using Eclipse, whether it\'s on a daily, weekly, or monthly basis. Put it in your back pocket, or just throw it in your backpack.',7.00,60,5,18,'eclipse_4.jpg'),(53,'Version Control with Git','This thoroughly revised edition also includes tips for manipulating trees, extended coverage of the reflog and stash, and a complete introduction to the GitHub repository. ',22.00,45,5,19,'git_1.jpg'),(54,'GIT: The Ultimate Guide for Beginners','This book is designed to cut academic theory to just the key concepts and focus on basics tasks in Git in order to be productive quickly. Students can expect to learn the minimum needed to start using Git in less than an hour.',16.00,54,5,19,'git_2.jpg'),(55,'Pro Git 2nd Edition','Effective and well-implemented version control is a necessity for successful web projects, whether large or small. ',38.00,208,5,19,'git_3.jpg'),(56,'Git for Programmers','The book begins with a quick history of Git and instructions on how to get it and install it, after which you\'ll dive into the creation and cloning of your repository.',50.00,101,5,19,'git_4.jpg'),(57,'R Markdown Cookbook','Those new to R Markdown will appreciate the short, practical examples that address the most common issues users encounter.',45.00,104,5,20,'markdown_1.jpg'),(58,'The Little Markdown Syntax Book','This is the printed version of the tutorial found at markdownsyntax.com This short book gives a complete and concise tutorial about Markdown. ',6.00,119,5,20,'markdown_2.jpg'),(59,'The Markdown Guide',' Learn the Markdown syntax in 60 pages with the book that\'s been called \"the best Markdown reference.\"',11.00,120,5,20,'markdown_3.jpg'),(60,'Using Markdown: A Short Instruction Guide','This book is an introduction to basic Markdown. Knowing how to use basic Markdown will carry over into the use of extended packages such as CommonMark and Pandoc.',20.00,91,5,20,'markdown_4.jpg');
/*!40000 ALTER TABLE `esm_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `esm_user`
--

DROP TABLE IF EXISTS `esm_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `esm_user` (
  `USER_ID` varchar(32) NOT NULL,
  `USER_NAME` varchar(20) NOT NULL,
  `USER_PASSWORD` varchar(20) NOT NULL,
  `USER_SEX` varchar(1) NOT NULL,
  `USER_BIRTHDAY` datetime DEFAULT NULL,
  `USER_IDENTITY_CODE` varchar(60) DEFAULT NULL,
  `USER_EMAIL` varchar(60) DEFAULT NULL,
  `USER_MOBILE` varchar(11) DEFAULT NULL,
  `USER_ADDRESS` varchar(200) NOT NULL,
  `USER_STATUS` decimal(6,0) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `esm_user`
--

LOCK TABLES `esm_user` WRITE;
/*!40000 ALTER TABLE `esm_user` DISABLE KEYS */;
INSERT INTO `esm_user` VALUES ('admin','administor','727401','T','2001-08-22 00:00:00',NULL,'dmt1909196@xmu.edu.my','18257410407','xmum',2),('dreamy','tang','727401','T','2021-12-30 00:00:00',NULL,'dmt1909196@xmu.edu.my','18257410407','LiRen garden',1);
/*!40000 ALTER TABLE `esm_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-26 19:21:19
