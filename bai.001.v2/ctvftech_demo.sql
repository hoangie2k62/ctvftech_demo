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
  `birth_day` date DEFAULT NULL,
  `city` char(30) DEFAULT NULL,
  `country` char(50) DEFAULT NULL,
  `district` char(30) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `first_name` char(30) DEFAULT NULL,
  `gioi_tinh` char(20) DEFAULT NULL,
  `last_name` char(30) DEFAULT NULL,
  `phone` char(10) DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `update_date` datetime(6) DEFAULT NULL,
  `village` char(20) DEFAULT NULL,
  `report_to` char(9) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjt44yt6dkh4u8te1jsw4wkn2w` (`report_to`),
  CONSTRAINT `FKjt44yt6dkh4u8te1jsw4wkn2w` FOREIGN KEY (`report_to`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES ('FTECH0002',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `geneation_id`
--

DROP TABLE IF EXISTS `geneation_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `geneation_id` (
  `idName` varchar(255) NOT NULL,
  `idValue` int DEFAULT NULL,
  PRIMARY KEY (`idName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geneation_id`
--

LOCK TABLES `geneation_id` WRITE;
/*!40000 ALTER TABLE `geneation_id` DISABLE KEYS */;
/*!40000 ALTER TABLE `geneation_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generation_id`
--

DROP TABLE IF EXISTS `generation_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `generation_id` (
  `id_name` varchar(255) NOT NULL,
  `id_value` bigint DEFAULT NULL,
  PRIMARY KEY (`id_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generation_id`
--

LOCK TABLES `generation_id` WRITE;
/*!40000 ALTER TABLE `generation_id` DISABLE KEYS */;
INSERT INTO `generation_id` VALUES ('id',0);
/*!40000 ALTER TABLE `generation_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_infos`
--

DROP TABLE IF EXISTS `login_infos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_infos` (
  `username` char(20) NOT NULL,
  `password` char(16) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `employee_id` char(9) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `FKf9u5h3aqtq46os82exrpamwld` (`employee_id`),
  CONSTRAINT `FKf9u5h3aqtq46os82exrpamwld` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_infos`
--

LOCK TABLES `login_infos` WRITE;
/*!40000 ALTER TABLE `login_infos` DISABLE KEYS */;
/*!40000 ALTER TABLE `login_infos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offices`
--

DROP TABLE IF EXISTS `offices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offices` (
  `id` char(9) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `office_name` char(50) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
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
  `begined_date` datetime(6) DEFAULT NULL,
  `ended_date` datetime(6) DEFAULT NULL,
  `job_title` char(30) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
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
  `updated_date` datetime(6) DEFAULT NULL,
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
INSERT INTO `works` VALUES ('2','2022-02-28 07:00:00.000000','hoàng','2022-03-02 04:18:32.132000','2022-03-15 07:00:00.000000',NULL,'ctv hoàng chờ','đang chờ','2022-03-02 04:18:32.132000','FTECH0002'),('WFTECH00000001','2022-02-28 07:00:00.000000','hoàng','2022-03-02 04:03:11.474000','2022-03-15 07:00:00.000000',NULL,'ctv hoàng chờ','đang chờ','2022-03-02 04:03:11.474000','FTECH0002');
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

-- Dump completed on 2022-03-02  5:11:44
