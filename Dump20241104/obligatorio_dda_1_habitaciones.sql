-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: obligatorio_dda_1
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `habitaciones`
--

DROP TABLE IF EXISTS `habitaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habitaciones` (
  `idHabitacion` int NOT NULL,
  `idHotel` int NOT NULL,
  `capacidadCamas` int NOT NULL,
  `camasMatrimoniales` int DEFAULT NULL,
  `aireAcondicionado` tinyint(1) DEFAULT NULL,
  `balcon` tinyint(1) DEFAULT NULL,
  `vista` tinyint(1) DEFAULT NULL,
  `amenities` varchar(255) DEFAULT NULL,
  `estado` varchar(10) DEFAULT 'disponible',
  PRIMARY KEY (`idHabitacion`,`idHotel`),
  KEY `idHotel` (`idHotel`),
  CONSTRAINT `habitaciones_ibfk_1` FOREIGN KEY (`idHotel`) REFERENCES `hoteles` (`idHotel`),
  CONSTRAINT `habitaciones_chk_1` CHECK ((`estado` in (_utf8mb4'disponible',_utf8mb4'reservada',_utf8mb4'ocupada')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitaciones`
--

LOCK TABLES `habitaciones` WRITE;
/*!40000 ALTER TABLE `habitaciones` DISABLE KEYS */;
INSERT INTO `habitaciones` VALUES (101,1,2,1,1,1,1,'WiFi, TV, MiniBar','disponible'),(102,1,3,1,1,0,0,'WiFi, TV','disponible'),(103,1,2,1,0,0,1,'WiFi, TV','disponible'),(104,1,3,1,1,1,1,'WiFi, TV, MiniBar','disponible'),(201,2,4,2,1,1,1,'WiFi, TV, Jacuzzi','disponible'),(202,2,2,0,1,0,1,'WiFi, TV','disponible'),(203,2,2,0,1,0,0,'WiFi, TV','disponible'),(204,2,4,2,1,1,1,'WiFi, TV, Jacuzzi','disponible'),(301,3,1,0,0,0,1,'WiFi','disponible'),(302,3,2,1,1,0,0,'WiFi','disponible'),(303,3,1,0,0,1,1,'WiFi','disponible'),(401,4,2,1,1,1,0,'WiFi, TV, MiniBar','disponible'),(402,4,3,1,1,1,1,'WiFi, TV, MiniBar','disponible'),(403,4,2,0,1,0,0,'WiFi, TV','disponible'),(501,5,3,1,1,1,1,'WiFi, TV, Desayuno incluido','disponible'),(502,5,1,0,1,0,1,'WiFi, Desayuno incluido','disponible'),(503,5,3,1,1,1,1,'WiFi, TV, Desayuno incluido','disponible');
/*!40000 ALTER TABLE `habitaciones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-04 21:19:28
