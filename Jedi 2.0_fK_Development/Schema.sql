use CRS;
DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `userID` varchar(20) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
 
--
-- Dumping data for table `admin`
--
 
LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('ADMIN01'),('ADMIN02');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;
 
--
-- Table structure for table `billing`
--
 
DROP TABLE IF EXISTS `billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billing` (
  `billingID` varchar(50) NOT NULL,
  `studentID` varchar(20) DEFAULT NULL,
  `billAmount` float DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `transactionID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`billingID`),
  KEY `billing_ibfk_1` (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
 
--
-- Dumping data for table `billing`
--
 
LOCK TABLES `billing` WRITE;
/*!40000 ALTER TABLE `billing` DISABLE KEYS */;
INSERT INTO `billing` VALUES ('1','STUDENT02',0,0,NULL),('2','STUDENT03',0,0,NULL);
/*!40000 ALTER TABLE `billing` ENABLE KEYS */;
UNLOCK TABLES;
 
--
-- Table structure for table `catalog`
--
 
DROP TABLE IF EXISTS `catalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalog` (
  `courseID` varchar(20) NOT NULL,
  `courseName` varchar(100) NOT NULL,
  `courseProf` varchar(100) DEFAULT NULL,
  `seats` int NOT NULL,
  `price` float DEFAULT '0',
  PRIMARY KEY (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
 
--
-- Dumping data for table `catalog`
--
 
LOCK TABLES `catalog` WRITE;
/*!40000 ALTER TABLE `catalog` DISABLE KEYS */;
INSERT INTO `catalog` VALUES ('cs10','dbms',NULL,8,0),('cs20','oop','PROFESSOR01',7,0),('cs35','os',NULL,4,0),('cs5','dsa',NULL,5,0),('cs50','comparch',NULL,7,0),('elec10','signals',NULL,1,0),('hum5','phil',NULL,5,0);
/*!40000 ALTER TABLE `catalog` ENABLE KEYS */;
UNLOCK TABLES;
 
--
-- Table structure for table `professor`
--
 
DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor` (
  `userID` varchar(20) NOT NULL,
  `department` varchar(50) DEFAULT NULL,
  `qualification` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
 
--
-- Dumping data for table `professor`
--
 
LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES ('PROFESSOR01','cs','phd'),('PROFESSOR16920493','cs','phd');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;
 
--
-- Table structure for table `registeredCourse`
--
 
DROP TABLE IF EXISTS `registeredCourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registeredCourse` (
  `studentID` varchar(20) NOT NULL,
  `courseID` varchar(20) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`studentID`,`courseID`),
  KEY `course_code` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
 
--
-- Dumping data for table `registeredCourse`
--
 
LOCK TABLES `registeredCourse` WRITE;
/*!40000 ALTER TABLE `registeredCourse` DISABLE KEYS */;
INSERT INTO `registeredCourse` VALUES ('STUDENT01','cs20','2024-08-12'),('STUDENT01','cs35','2024-08-12'),('STUDENT01','cs5','2024-08-12'),('STUDENT01','cs50','2024-08-12'),('STUDENT02','elec10','2024-08-12'),('STUDENT02','hum5','2024-08-12'),('STUDENT03','cs10','2024-08-11'),('STUDENT03','cs20','2024-08-11'),('STUDENT03','elec10','2024-08-11'),('STUDENT03','hum5','2024-08-11');
/*!40000 ALTER TABLE `registeredCourse` ENABLE KEYS */;
UNLOCK TABLES;
 
--
-- Table structure for table `reportCard`
--
 
DROP TABLE IF EXISTS `reportCard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reportCard` (
  `studentID` varchar(20) NOT NULL,
  `courseID` varchar(20) NOT NULL,
  `grade` enum('A','B','C','D','E','F') NOT NULL,
  PRIMARY KEY (`studentID`,`courseID`),
  KEY `reportcard_ibfk_2` (`courseID`),
  CONSTRAINT `reportcard_ibfk_2` FOREIGN KEY (`courseID`) REFERENCES `catalog` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
 
--
-- Dumping data for table `reportCard`
--
 
LOCK TABLES `reportCard` WRITE;
/*!40000 ALTER TABLE `reportCard` DISABLE KEYS */;
INSERT INTO `reportCard` VALUES ('STUDENT03','cs20','A');
/*!40000 ALTER TABLE `reportCard` ENABLE KEYS */;
UNLOCK TABLES;
 
--
-- Table structure for table `student`
--
 
DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `userID` varchar(20) NOT NULL,
  `branch` varchar(50) DEFAULT NULL,
  `rollNum` int DEFAULT NULL,
  `approved` tinyint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
 
--
-- Dumping data for table `student`
--
 
LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('STUDENT01','cs',6,1),('STUDENT01','hum',4,0),('STUDENT02','elec',5,1),('STUDENT03','chotu@chotu',1,1),('STUDENT03','cs',3,0),('STUDENT04','hum',2,1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
 
--
-- Table structure for table `user`
--
 
DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userID` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact` varchar(15) DEFAULT NULL,
  `role` enum('Professor','Student','Admin') NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
 
--
-- Dumping data for table `user`
--
 
LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('ADMIN01','HHHS','flipkart@gmail.com','123456789','Admin','admin1','admin'),('ADMIN02','dwd2e','test.ddd,'123356789','Admin','admin2','admin'),('PROFESSOR01','null','@gmail.com','987261534','Professor','null','prof'),('STUDENT01','STU','STU@gmail.com','987261535','Student','STU','stud'),('STUDENT02','ST2','ST2@gmail.com','9899092788','Student','ST2','stud'),('STUDENT03','s3','s3@gmail','9899092788','Student','s3','stud'),('STUDENT04','s4','s4@g','9899092787','Student','s4','stud');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
 
-- Dump completed on 2024-08-12 14:06:56