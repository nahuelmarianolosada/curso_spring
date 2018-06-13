-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: school_schema
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

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
-- Table structure for table `COURSE`
--

DROP TABLE IF EXISTS `COURSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COURSE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `signature` varchar(50) DEFAULT NULL,
  `place` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COURSE`
--

LOCK TABLES `COURSE` WRITE;
/*!40000 ALTER TABLE `COURSE` DISABLE KEYS */;
INSERT INTO `COURSE` VALUES (1,'Literatura','Aula 5'),(2,'Quimica','Aula 12'),(3,'Informatica','Aula 256'),(4,'Fisica','Aula 8'),(5,'Filosofia','Aula 2');
/*!40000 ALTER TABLE `COURSE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COURSE_PROFESSOR`
--

DROP TABLE IF EXISTS `COURSE_PROFESSOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COURSE_PROFESSOR` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_course` int(11) DEFAULT NULL,
  `id_professor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `COURSE_PROFESSOR_course_fk` (`id_course`),
  KEY `COURSE_PROFESSOR_pro_fk` (`id_professor`),
  CONSTRAINT `COURSE_PROFESSOR_course_fk` FOREIGN KEY (`id_course`) REFERENCES `COURSE` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `COURSE_PROFESSOR_pro_fk` FOREIGN KEY (`id_professor`) REFERENCES `PROFESSOR` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COURSE_PROFESSOR`
--

LOCK TABLES `COURSE_PROFESSOR` WRITE;
/*!40000 ALTER TABLE `COURSE_PROFESSOR` DISABLE KEYS */;
INSERT INTO `COURSE_PROFESSOR` VALUES (1,1,5),(2,2,2),(3,3,3),(4,4,2),(5,5,1);
/*!40000 ALTER TABLE `COURSE_PROFESSOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROFESSOR`
--

DROP TABLE IF EXISTS `PROFESSOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROFESSOR` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `job_title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROFESSOR`
--

LOCK TABLES `PROFESSOR` WRITE;
/*!40000 ALTER TABLE `PROFESSOR` DISABLE KEYS */;
INSERT INTO `PROFESSOR` VALUES (1,'Jesus','De Nazaret','2018-06-13','Carpintero'),(2,'Albert','Einstein','2018-06-13','Fisico'),(3,'Dennis','Ritchie','2018-06-13','Ingeniero'),(4,'Michael','Phelps','2018-06-13','Educacion Fisica'),(5,'Jorge Luis','Borges','2018-06-13','Literatura'),(6,'Jimmy','Page',NULL,'Musico');
/*!40000 ALTER TABLE `PROFESSOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STUDENT`
--

DROP TABLE IF EXISTS `STUDENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STUDENT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STUDENT`
--

LOCK TABLES `STUDENT` WRITE;
/*!40000 ALTER TABLE `STUDENT` DISABLE KEYS */;
INSERT INTO `STUDENT` VALUES (1,'Antonella','Lanus','2018-06-05'),(2,'Ohgnab','Striveders','2018-06-05'),(3,'Alberto','Rodriguez','2018-06-05'),(4,'Marcos','Urzagasti','2000-10-01'),(5,'Tomas','Jaime','1990-06-28'),(6,'Alfonso','Cambidades','1992-05-23'),(15,'Ramon','Valdez','1987-12-12'),(16,'Oliver','Stoned','1992-06-28'),(17,'Roger','Waters','1952-08-15');
/*!40000 ALTER TABLE `STUDENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STUDENT_COURSE`
--

DROP TABLE IF EXISTS `STUDENT_COURSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STUDENT_COURSE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_course` int(11) DEFAULT NULL,
  `id_student` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `STUDENT_COURSE_course_fk` (`id_course`),
  KEY `STUDENT_COURSE_student_fk` (`id_student`),
  CONSTRAINT `STUDENT_COURSE_course_fk` FOREIGN KEY (`id_course`) REFERENCES `COURSE` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `STUDENT_COURSE_student_fk` FOREIGN KEY (`id_student`) REFERENCES `STUDENT` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STUDENT_COURSE`
--

LOCK TABLES `STUDENT_COURSE` WRITE;
/*!40000 ALTER TABLE `STUDENT_COURSE` DISABLE KEYS */;
INSERT INTO `STUDENT_COURSE` VALUES (1,1,2),(2,1,3),(3,1,5),(4,1,6),(5,2,1),(6,2,3),(7,2,15),(8,2,6),(9,3,2),(10,3,15),(11,3,6);
/*!40000 ALTER TABLE `STUDENT_COURSE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-13 18:40:33
