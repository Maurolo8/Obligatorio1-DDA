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
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `idReserva` int NOT NULL,
  `idHotel` int NOT NULL,
  `idHabitacion` int NOT NULL,
  `idHuesped` int NOT NULL,
  `cantidad_personas` int DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `fechaRes` date DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `observacion` text,
  `estado_pago` tinyint(1) DEFAULT '0',
  `pagoCompleto` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idReserva`),
  KEY `idHabitacion` (`idHabitacion`,`idHotel`),
  KEY `idHuesped` (`idHuesped`),
  CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`idHabitacion`, `idHotel`) REFERENCES `habitaciones` (`idHabitacion`, `idHotel`),
  CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`idHuesped`) REFERENCES `huespedes` (`idHuesped`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (1,1,101,1,2,'Suite','2024-01-01','2024-01-05','2024-01-10','Huésped solicita cama extra',0,0),(2,2,201,2,4,'Familiar','2024-02-10','2024-02-15','2024-02-20','Incluye desayuno',1,1),(3,3,301,3,1,'Individual','2024-03-05','2024-03-07','2024-03-10',NULL,0,1),(4,4,401,4,2,'Doble','2024-03-15','2024-03-20','2024-03-25','Solicita transporte al aeropuerto',1,0),(5,5,501,5,3,'Deluxe','2024-04-01','2024-04-05','2024-04-10','Check-in temprano solicitado',0,0),(6,1,103,6,2,'Doble','2024-01-15','2024-01-20','2024-01-25','Solicita cuna para bebé',1,0),(7,2,202,7,3,'Triple','2024-02-18','2024-02-22','2024-02-26','Incluye servicio de habitación',1,1),(8,3,303,8,1,'Individual','2024-03-12','2024-03-15','2024-03-19',NULL,0,0),(9,4,402,9,2,'Suite','2024-04-05','2024-04-10','2024-04-14','Vista al mar',1,1),(10,5,503,10,4,'Familiar','2024-04-22','2024-04-27','2024-05-02','Transporte incluido',0,1),(11,1,104,11,3,'Triple','2024-05-01','2024-05-05','2024-05-10','Late check-out solicitado',1,0),(12,2,203,12,2,'Doble','2024-06-15','2024-06-20','2024-06-25',NULL,0,0),(13,3,302,13,2,'Doble','2024-07-10','2024-07-15','2024-07-20','Desayuno incluido',1,1),(14,4,403,14,1,'Individual','2024-08-05','2024-08-10','2024-08-15','Sin observaciones',1,0),(15,5,502,15,3,'Suite','2024-08-18','2024-08-23','2024-08-28','Pedido especial de flores',1,1);
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
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
