-- MySQL dump 10.13  Distrib 5.6.12, for Win64 (x86_64)
--
-- Host: localhost    Database: d_travel_system
-- ------------------------------------------------------
-- Server version	5.6.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_activity_arrangement`
--

DROP TABLE IF EXISTS `t_activity_arrangement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_activity_arrangement` (
  `produce_id` int(10) unsigned NOT NULL,
  `activity_arrangement_id` int(10) unsigned NOT NULL,
  `activity_arrangement_sequence` int(3) NOT NULL,
  `arrangement_gmt_create` datetime NOT NULL,
  `arrangement_gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`activity_arrangement_id`),
  KEY `produce_id` (`produce_id`),
  CONSTRAINT `t_activity_arrangement_ibfk_1` FOREIGN KEY (`produce_id`) REFERENCES `t_produce` (`produce_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_activity_arrangement`
--

LOCK TABLES `t_activity_arrangement` WRITE;
/*!40000 ALTER TABLE `t_activity_arrangement` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_activity_arrangement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_arrangement_content`
--

DROP TABLE IF EXISTS `t_arrangement_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_arrangement_content` (
  `activity_arrangement_id` int(10) unsigned NOT NULL,
  `arrangement_content_type` varchar(3) NOT NULL,
  `arrangement_content_text` varchar(300) DEFAULT NULL,
  `arrangement_content_image` varchar(2083) DEFAULT NULL,
  `content_gmt_create` datetime NOT NULL,
  `content_gmt_modified` datetime DEFAULT NULL,
  KEY `activity_arrangement_id` (`activity_arrangement_id`),
  CONSTRAINT `t_arrangement_content_ibfk_1` FOREIGN KEY (`activity_arrangement_id`) REFERENCES `t_activity_arrangement` (`activity_arrangement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_arrangement_content`
--

LOCK TABLES `t_arrangement_content` WRITE;
/*!40000 ALTER TABLE `t_arrangement_content` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_arrangement_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cost_content`
--

DROP TABLE IF EXISTS `t_cost_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cost_content` (
  `cost_id` int(10) unsigned NOT NULL,
  `cost_content` varchar(100) NOT NULL,
  `produce_cost_type` varchar(10) NOT NULL,
  `content_gmt_create` datetime NOT NULL,
  `content_gmt_modified` datetime DEFAULT NULL,
  KEY `cost_id` (`cost_id`),
  CONSTRAINT `t_cost_content_ibfk_1` FOREIGN KEY (`cost_id`) REFERENCES `t_produce_cost` (`cost_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cost_content`
--

LOCK TABLES `t_cost_content` WRITE;
/*!40000 ALTER TABLE `t_cost_content` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_cost_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_graphic_introduction`
--

DROP TABLE IF EXISTS `t_graphic_introduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_graphic_introduction` (
  `produce_id` int(10) unsigned NOT NULL,
  `graphic_introduction_content` varchar(2083) NOT NULL,
  `introduction_gmt_create` datetime NOT NULL,
  `introduction_gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`produce_id`),
  CONSTRAINT `t_graphic_introduction_ibfk_1` FOREIGN KEY (`produce_id`) REFERENCES `t_produce` (`produce_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_graphic_introduction`
--

LOCK TABLES `t_graphic_introduction` WRITE;
/*!40000 ALTER TABLE `t_graphic_introduction` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_graphic_introduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_produce`
--

DROP TABLE IF EXISTS `t_produce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_produce` (
  `produce_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `produce_title` varchar(40) NOT NULL,
  `produce_type` varchar(10) NOT NULL,
  `produce_lindisfarne` varchar(10) NOT NULL,
  `produce_cost_time` int(3) NOT NULL,
  `produce_gmt_create` datetime NOT NULL,
  `produce_gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`produce_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_produce`
--

LOCK TABLES `t_produce` WRITE;
/*!40000 ALTER TABLE `t_produce` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_produce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_produce_cost`
--

DROP TABLE IF EXISTS `t_produce_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_produce_cost` (
  `produce_id` int(10) unsigned NOT NULL,
  `cost_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cost_gmt_create` datetime NOT NULL,
  `cost_gmt_modified` datetime DEFAULT NULL,
  `is_in_total` enum('true','flase') NOT NULL DEFAULT 'true',
  PRIMARY KEY (`cost_id`),
  KEY `produce_id` (`produce_id`),
  CONSTRAINT `t_produce_cost_ibfk_1` FOREIGN KEY (`produce_id`) REFERENCES `t_produce` (`produce_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_produce_cost`
--

LOCK TABLES `t_produce_cost` WRITE;
/*!40000 ALTER TABLE `t_produce_cost` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_produce_cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_produce_status`
--

DROP TABLE IF EXISTS `t_produce_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_produce_status` (
  `produce_id` int(10) unsigned NOT NULL,
  `produce_is_appring` enum('unchecked','pass','nopass') NOT NULL DEFAULT 'unchecked',
  KEY `produce_id` (`produce_id`),
  CONSTRAINT `t_produce_status_ibfk_1` FOREIGN KEY (`produce_id`) REFERENCES `t_produce` (`produce_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_produce_status`
--

LOCK TABLES `t_produce_status` WRITE;
/*!40000 ALTER TABLE `t_produce_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_produce_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-13 23:11:31
