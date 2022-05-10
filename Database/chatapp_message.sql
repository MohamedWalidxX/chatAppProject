-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: chatapp
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `id` int NOT NULL AUTO_INCREMENT,
  `senderId` int DEFAULT NULL,
  `chatId` int DEFAULT NULL,
  `messageText` varchar(300) DEFAULT NULL,
  `date` date NOT NULL DEFAULT (cast(now() as date)),
  `time` time NOT NULL DEFAULT (cast(curtime() as time)),
  `seenStatus` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_senderId` (`senderId`),
  KEY `fk_chatId` (`chatId`),
  CONSTRAINT `fk_chatId` FOREIGN KEY (`chatId`) REFERENCES `chatroom` (`id`),
  CONSTRAINT `fk_senderId` FOREIGN KEY (`senderId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,1,4,'Text MIC TEST TEST','2022-05-03','10:21:47',0),(2,2,4,'Hello guys!!','2022-05-03','10:21:47',0),(3,2,4,'I was solving some problems on CF BTW :D','2022-05-03','10:21:47',0),(4,1,4,'IK NERD HEHE XDDD','2022-05-03','10:30:15',0),(5,1,4,'new day no news','2022-05-04','10:31:38',0),(6,1,4,'IK NERD HEHE XDDD','2022-05-03','10:31:44',0),(7,2,4,'Yehia not here yet :\'( ','2022-05-04','10:34:00',0),(8,1,4,'IK NERD HEHE XDDD','2022-05-03','10:34:04',0),(9,1,1,'This is private between me and you friendo :D ','2022-05-03','10:53:32',0),(10,2,1,'YES, my friend i agree with you :D','2022-05-03','10:55:12',0),(11,1,4,'new day new hope :D','2022-05-10','10:45:30',0),(12,2,4,'YES YES YES YES YES YES YES YES YES YES YES YSEYESSEYEY','2022-05-10','10:46:28',0),(13,2,4,'abcbabababab','2022-05-10','10:46:38',0);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-10 11:29:23
