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
-- Table structure for table `huespedes`
--

DROP TABLE IF EXISTS `huespedes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `huespedes` (
  `idHuesped` int NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apaterno` varchar(50) NOT NULL,
  `amaterno` varchar(50) DEFAULT NULL,
  `tipo_documento` varchar(20) DEFAULT NULL,
  `num_documento` varchar(50) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `pais` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idHuesped`),
  UNIQUE KEY `num_documento` (`num_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huespedes`
--

LOCK TABLES `huespedes` WRITE;
/*!40000 ALTER TABLE `huespedes` DISABLE KEYS */;
INSERT INTO `huespedes` VALUES (1,'Carlos','Pérez','López','Pasaporte','P1234567','1980-05-15','+34 600123456','España'),(2,'Ana','García',NULL,'DNI','DNI98765432','1992-11-22','+54 91123456789','Argentina'),(3,'John','Smith','Doe','Driver License','DLUSA1234','1978-08-05','+1 3051234567','EEUU'),(4,'Keiko','Tanaka',NULL,'Pasaporte','JPN87654321','1995-03-14','+81 901234567','Japón'),(5,'Luisa','Mendes','Santos','CC','CC123456789','1987-12-30','+351 912345678','Portugal'),(6,'Sofia','Martínez','Reyes','Pasaporte','P2345678','1990-07-12','+34 650123456','España'),(7,'Miguel','Rodríguez',NULL,'DNI','DNI56789012','1985-09-19','+54 91198765432','Argentina'),(8,'Emily','Johnson','Smith','Driver License','DLUSA5678','1993-04-15','+1 3059876543','EEUU'),(9,'Akira','Suzuki',NULL,'Pasaporte','JPN12345678','1988-01-20','+81 903456789','Japón'),(10,'Pedro','Costa','Almeida','CC','CC987654321','1992-11-02','+351 910987654','Portugal'),(11,'Laura','Fernández','López','DNI','DNI11122334','1995-05-05','+34 611223344','España'),(12,'Andrés','Pinto',NULL,'Pasaporte','P87654321','1989-03-23','+54 91123455678','Chile'),(13,'Jessica','Davis','Brown','Driver License','DLUSA8765','1990-06-18','+1 3103456789','EEUU'),(14,'Hiroshi','Yamada',NULL,'Pasaporte','JPN87654324','1997-07-25','+81 904567890','Japón'),(15,'Mariana','Silva','Sousa','CC','CC112233445','1994-08-08','+351 912345667','Portugal');
/*!40000 ALTER TABLE `huespedes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-04 21:19:29
