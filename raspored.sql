-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: raspored
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.28-MariaDB

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
-- Table structure for table `godina`
--

DROP TABLE IF EXISTS `godina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `godina` (
  `idGodina` int(11) NOT NULL,
  `brojGodine` varchar(255) DEFAULT NULL,
  `smjer_idSmjer` int(11) DEFAULT NULL,
  PRIMARY KEY (`idGodina`),
  KEY `FK7aba434je8ugxs4p53ley3n8o` (`smjer_idSmjer`),
  CONSTRAINT `FK7aba434je8ugxs4p53ley3n8o` FOREIGN KEY (`smjer_idSmjer`) REFERENCES `smjer` (`idSmjer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `godina`
--

LOCK TABLES `godina` WRITE;
/*!40000 ALTER TABLE `godina` DISABLE KEYS */;
INSERT INTO `godina` VALUES (3,'1.Godina',1),(4,'2.Godina',2);
/*!40000 ALTER TABLE `godina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (7),(7),(7),(7),(7);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `predmet`
--

DROP TABLE IF EXISTS `predmet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `predmet` (
  `idPredmet` int(11) NOT NULL,
  `brojSati` int(11) NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `godina_idGodina` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPredmet`),
  KEY `FKmnb9s6tlc9cfo5n90htdf2hyl` (`godina_idGodina`),
  CONSTRAINT `FKmnb9s6tlc9cfo5n90htdf2hyl` FOREIGN KEY (`godina_idGodina`) REFERENCES `godina` (`idGodina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `predmet`
--

LOCK TABLES `predmet` WRITE;
/*!40000 ALTER TABLE `predmet` DISABLE KEYS */;
INSERT INTO `predmet` VALUES (5,60,'Matematika',3),(6,60,'Fizika',4);
/*!40000 ALTER TABLE `predmet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `predmet_profesor`
--

DROP TABLE IF EXISTS `predmet_profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `predmet_profesor` (
  `predmeti_idPredmet` int(11) NOT NULL,
  `profesori_idProfesor` int(11) NOT NULL,
  KEY `FK2e7101feavywh066bfo1jsb26` (`profesori_idProfesor`),
  KEY `FKl8l1hsu7g3fqvf0ajolp4v4gj` (`predmeti_idPredmet`),
  CONSTRAINT `FK2e7101feavywh066bfo1jsb26` FOREIGN KEY (`profesori_idProfesor`) REFERENCES `profesor` (`idProfesor`),
  CONSTRAINT `FKl8l1hsu7g3fqvf0ajolp4v4gj` FOREIGN KEY (`predmeti_idPredmet`) REFERENCES `predmet` (`idPredmet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `predmet_profesor`
--

LOCK TABLES `predmet_profesor` WRITE;
/*!40000 ALTER TABLE `predmet_profesor` DISABLE KEYS */;
/*!40000 ALTER TABLE `predmet_profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `predmet_student`
--

DROP TABLE IF EXISTS `predmet_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `predmet_student` (
  `predmeti_idPredmet` int(11) NOT NULL,
  `studenti_idStudent` int(11) NOT NULL,
  KEY `FKeqhbipcsybipq3hkeetd0ddk8` (`studenti_idStudent`),
  KEY `FKejeceua5tpsxoysnekaueaeyv` (`predmeti_idPredmet`),
  CONSTRAINT `FKejeceua5tpsxoysnekaueaeyv` FOREIGN KEY (`predmeti_idPredmet`) REFERENCES `predmet` (`idPredmet`),
  CONSTRAINT `FKeqhbipcsybipq3hkeetd0ddk8` FOREIGN KEY (`studenti_idStudent`) REFERENCES `student` (`idStudent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `predmet_student`
--

LOCK TABLES `predmet_student` WRITE;
/*!40000 ALTER TABLE `predmet_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `predmet_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `idProfesor` int(11) NOT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `oib` int(11) NOT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idProfesor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `smjer`
--

DROP TABLE IF EXISTS `smjer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `smjer` (
  `idSmjer` int(11) NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `opis` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idSmjer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `smjer`
--

LOCK TABLES `smjer` WRITE;
/*!40000 ALTER TABLE `smjer` DISABLE KEYS */;
INSERT INTO `smjer` VALUES (1,'Informatika','Stručni Studij'),(2,'Računarstvo','Preddiplomski Studij');
/*!40000 ALTER TABLE `smjer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `idStudent` int(11) NOT NULL,
  `brojDolaznosti` int(11) NOT NULL,
  `brojIndexa` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `postotak` decimal(19,2) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idStudent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-07 12:13:45
