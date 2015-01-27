-- MySQL dump 10.13  Distrib 5.6.22, for Win64 (x86_64)
--
-- Host: localhost    Database: vpn
-- ------------------------------------------------------
-- Server version	5.6.22-log

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
-- Current Database: `vpn`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `vpn` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `vpn`;

--
-- Table structure for table `sequences`
--

DROP TABLE IF EXISTS `sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequences` (
  `SEQUENCE_ID` int(6) NOT NULL AUTO_INCREMENT,
  `SEQUENCE_NAME` varchar(255) NOT NULL,
  `SEQUENCE_VALUE` int(10) NOT NULL,
  PRIMARY KEY (`SEQUENCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequences`
--

LOCK TABLES `sequences` WRITE;
/*!40000 ALTER TABLE `sequences` DISABLE KEYS */;
INSERT INTO `sequences` VALUES (1,'TABLE_GEN_100',0),(2,'TABLE_GEN_10',0),(3,'TABLE_GEN_5',0),(4,'TABLE_GEN_1',8);
/*!40000 ALTER TABLE `sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vpn_auth_list`
--

DROP TABLE IF EXISTS `vpn_auth_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vpn_auth_list` (
  `AUTH_LIST_ID` int(10) NOT NULL AUTO_INCREMENT,
  `SERVICE_ID` int(2) NOT NULL,
  `USER_ID` int(10) NOT NULL,
  PRIMARY KEY (`AUTH_LIST_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vpn_auth_list`
--

LOCK TABLES `vpn_auth_list` WRITE;
/*!40000 ALTER TABLE `vpn_auth_list` DISABLE KEYS */;
INSERT INTO `vpn_auth_list` VALUES (1,1,1),(2,1,2);
/*!40000 ALTER TABLE `vpn_auth_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vpn_service`
--

DROP TABLE IF EXISTS `vpn_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vpn_service` (
  `SERVICE_ID` int(2) NOT NULL AUTO_INCREMENT,
  `SERVICE_URL` varchar(255) NOT NULL,
  `SERVICE_PROTOCOL` varchar(10) NOT NULL,
  `SERVICE_IP` varchar(30) NOT NULL,
  `SERVICE_PORT` int(8) NOT NULL,
  `IS_ACTIVE` int(1) NOT NULL DEFAULT '0',
  `UP_TIME` date DEFAULT NULL,
  `DOWN_TIME` date DEFAULT NULL,
  PRIMARY KEY (`SERVICE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vpn_service`
--

LOCK TABLES `vpn_service` WRITE;
/*!40000 ALTER TABLE `vpn_service` DISABLE KEYS */;
INSERT INTO `vpn_service` VALUES (1,'aws.faizalsidek.com','openvpn','54.251.156.96',1194,0,NULL,NULL);
/*!40000 ALTER TABLE `vpn_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vpn_session`
--

DROP TABLE IF EXISTS `vpn_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vpn_session` (
  `SESSION_ID` int(10) NOT NULL AUTO_INCREMENT,
  `VPN_USER_ID` int(10) NOT NULL,
  `VPN_SERVICE_ID` int(5) NOT NULL,
  `SESSION_START` date DEFAULT NULL,
  `SESSION_DROP` date DEFAULT NULL,
  `IS_ACTIVE` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`SESSION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vpn_session`
--

LOCK TABLES `vpn_session` WRITE;
/*!40000 ALTER TABLE `vpn_session` DISABLE KEYS */;
INSERT INTO `vpn_session` VALUES (3,2,1,'2015-01-27','2015-01-27',0),(4,2,1,'2015-01-27',NULL,1),(5,1,1,'2015-01-27','2015-01-27',0),(6,1,1,'2015-01-27','2015-01-27',0),(7,1,1,'2015-01-27',NULL,1);
/*!40000 ALTER TABLE `vpn_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vpn_user`
--

DROP TABLE IF EXISTS `vpn_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vpn_user` (
  `USER_ID` int(5) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `IS_DISABLED` smallint(1) NOT NULL,
  `DISABLED_UNTIL` datetime DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vpn_user`
--

LOCK TABLES `vpn_user` WRITE;
/*!40000 ALTER TABLE `vpn_user` DISABLE KEYS */;
INSERT INTO `vpn_user` VALUES (1,'faizal','sayabaik',0,NULL),(2,'mariam','sayabaik87',0,NULL);
/*!40000 ALTER TABLE `vpn_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-28  1:21:30
