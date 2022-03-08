-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: ctvftech_demo
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` char(9) NOT NULL,
  `address_extra` varchar(255) DEFAULT NULL,
  `avatar_url` char(12) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `city` char(30) DEFAULT NULL,
  `country` char(50) DEFAULT NULL,
  `district` char(30) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `first_name` char(30) DEFAULT NULL,
  `gioi_tinh` char(20) DEFAULT NULL,
  `job_title` char(50) DEFAULT NULL,
  `last_name` char(30) DEFAULT NULL,
  `password` char(12) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  `phone` char(10) DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `stt` smallint DEFAULT NULL,
  `username` char(20) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  `village` char(20) DEFAULT NULL,
  `report_to` char(9) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3gqbimdf7fckjbwt1kcud141m` (`username`),
  KEY `FKjt44yt6dkh4u8te1jsw4wkn2w` (`report_to`),
  CONSTRAINT `FKjt44yt6dkh4u8te1jsw4wkn2w` FOREIGN KEY (`report_to`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES ('FTECH0001',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,10000,1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs` (
  `stt` int NOT NULL,
  `contents` varchar(255) DEFAULT NULL,
  `edited_date` datetime(6) DEFAULT NULL,
  `entity_id` char(30) DEFAULT NULL,
  `table_name` char(30) DEFAULT NULL,
  `type` char(30) DEFAULT NULL,
  `edited_employee` char(9) DEFAULT NULL,
  PRIMARY KEY (`stt`),
  KEY `FKeyctierjutliq8v82tkeeco8f` (`edited_employee`),
  CONSTRAINT `FKeyctierjutliq8v82tkeeco8f` FOREIGN KEY (`edited_employee`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

LOCK TABLES `logs` WRITE;
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offices`
--

DROP TABLE IF EXISTS `offices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offices` (
  `id` char(9) NOT NULL,
  `date_of_talking_office` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `officeName` char(50) DEFAULT NULL,
  `stt` smallint DEFAULT NULL,
  `manager_id` char(9) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKw1639yegpyf1wpqwhptew7ft` (`manager_id`),
  CONSTRAINT `FKw1639yegpyf1wpqwhptew7ft` FOREIGN KEY (`manager_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offices`
--

LOCK TABLES `offices` WRITE;
/*!40000 ALTER TABLE `offices` DISABLE KEYS */;
/*!40000 ALTER TABLE `offices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_assgin`
--

DROP TABLE IF EXISTS `work_assgin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_assgin` (
  `employee_id` char(9) NOT NULL,
  `office_id` char(9) NOT NULL,
  `work_id` char(14) NOT NULL,
  `beginedDate` datetime(6) DEFAULT NULL,
  `endedDate` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`employee_id`,`office_id`,`work_id`),
  KEY `FKbyo0w6i3l597nsh8j6af95k7u` (`office_id`),
  KEY `FKq1q0npn2ferw7efctnfkh5wqb` (`work_id`),
  CONSTRAINT `FK8jtu8r4jpi9n07yjyqattpba4` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `FKbyo0w6i3l597nsh8j6af95k7u` FOREIGN KEY (`office_id`) REFERENCES `offices` (`id`),
  CONSTRAINT `FKq1q0npn2ferw7efctnfkh5wqb` FOREIGN KEY (`work_id`) REFERENCES `works` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_assgin`
--

LOCK TABLES `work_assgin` WRITE;
/*!40000 ALTER TABLE `work_assgin` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_assgin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `works`
--

DROP TABLE IF EXISTS `works`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `works` (
  `id` char(14) NOT NULL,
  `begined_date` datetime(6) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `ended_date` datetime(6) DEFAULT NULL,
  `heading` char(100) DEFAULT NULL,
  `status` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `stt` int DEFAULT NULL,
  `created_employee` char(9) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlq6a79an1p5kjq0a9bvfx544d` (`created_employee`),
  CONSTRAINT `FKlq6a79an1p5kjq0a9bvfx544d` FOREIGN KEY (`created_employee`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `works`
--

LOCK TABLES `works` WRITE;
/*!40000 ALTER TABLE `works` DISABLE KEYS */;
/*!40000 ALTER TABLE `works` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-08  9:19:58
