-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: rentalcarsdb
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_cnh` varchar(20) DEFAULT NULL,
  `numero_cnh` varchar(60) NOT NULL,
  `validade_cnh` date NOT NULL,
  `cpf` char(11) NOT NULL,
  `nome` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_62uiuvr9jpnkok8sve9l23dvg` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'A','04819233','2016-12-19','16928064040','Madaline Vinson'),(2,'A','01655474','2024-02-20','11878518440','Jocelyn Elliott'),(3,'B','77891957','2028-03-19','89189784024','Vanna Wilkins'),(4,'B','02310538','2015-05-19','99607729797','Shelley Romero'),(5,'B','46571748','2029-11-19','08675871655','Damon Hutchinson'),(6,'B','28227422','2004-05-20','94456457759','Drake Baldwin'),(7,'A','47512528','2016-12-18','71552327081','Kai Vasquez'),(8,'B','25076089','2027-03-19','98119725882','Yetta Glenn'),(9,'B','26545436','2014-03-19','93181287604','Brock Chen'),(10,'B','41492454','2009-02-19','11258481687','Zephr Warren'),(11,'B','94364155','2013-04-20','35566148875','Elliott Greene'),(12,'A','38070367','2016-03-20','61844930468','Gavin Johns'),(13,'B','72118714','2029-03-20','45001035703','Chadwick Wheeler'),(14,'B','65262926','2002-02-20','95924157413','Michael Branch'),(15,'A','91489841','2009-12-18','45505050524','Allistair Buckner'),(16,'A','94406435','2010-06-20','62345685988','Keely Weeks'),(17,'A','39282681','2018-11-19','13529638204','Wang Mosley'),(18,'A','96864988','2028-09-18','38232620568','Risa Brennan'),(19,'A','38775280','2026-01-19','27521597925','Owen Casey'),(20,'A','09968421','2026-01-19','41813850066','Dennis Johnson'),(21,'B','00550542','2006-09-19','04579119193','Patience Lopez'),(22,'A','77524334','2028-04-19','57293905115','Odysseus Fowler'),(23,'B','23739483','2018-06-19','44489994227','Jacob Hoffman'),(24,'A','14496122','2004-01-20','24471473981','Neil Cobb'),(25,'B','62390317','2001-05-19','44829985847','Heather Stephens'),(26,'B','82799281','2010-08-20','16239724088','Nichole Combs'),(27,'A','41069221','2014-01-19','53581017359','Rafael Holman'),(28,'A','70621769','2020-01-20','12460058011','Sybill Olson'),(29,'A','72477880','2007-05-19','69501393415','Rae Holt'),(30,'A','07063225','2031-10-19','02620503186','Quinn Huber'),(31,'A','86819107','2013-04-19','37947794881','Isaac Gallegos'),(32,'B','08764568','2012-07-20','02244325942','Raven Erickson'),(33,'B','74913356','2016-07-19','99306033962','Nelle Mckay'),(34,'A','76404331','2016-11-18','35399275804','Eden Farley'),(35,'A','15160581','2018-07-20','31366180590','Jamal Boone'),(36,'B','27305328','2018-03-20','60394419209','Philip Riggs'),(37,'A','47147836','2009-08-20','46147635742','Wanda Fleming'),(38,'B','67439454','2016-01-19','09145455959','Thomas Torres'),(39,'B','49949614','2003-06-20','46004892818','Hannah Dickerson'),(40,'B','92681929','2012-07-20','53948432311','Tatum Bright'),(41,'B','20483002','2011-04-20','82372698475','Fiona Ewing'),(42,'A','87632371','2005-10-18','87979548325','Danielle Whitehead'),(43,'B','66762933','2029-04-19','53571777415','Cathleen Alvarez'),(44,'B','89017172','2015-02-20','16891204437','Callum Garner'),(45,'A','10789269','2010-02-19','44836295702','Leila Mcintosh'),(46,'B','80290892','2024-06-20','16180840259','Amanda Clements'),(47,'B','36098648','2023-03-19','33528011514','Candice Branch'),(48,'B','25974572','2004-04-19','24041707848','Joel Mason'),(49,'B','48302530','2001-05-20','39576735037','Rhea Tyler'),(50,'A','69922854','2007-01-20','62605634031','Odysseus Mcmahon'),(51,'B','98276249','2002-11-19','76141549113','Desirae Bartlett'),(52,'B','07882722','2019-12-18','98777603993','Sawyer Espinoza'),(53,'A','76461429','2027-12-18','85279085304','Stella Barber'),(54,'B','51670046','2005-09-18','09266351134','Zena Galloway'),(55,'B','50996535','2011-07-20','99181564239','Lyle Griffin'),(56,'A','83968200','2026-11-19','98105477241','Adrienne Marquez'),(57,'A','48627889','2005-09-19','50777095656','Aladdin Huber'),(58,'A','16828578','2003-07-20','15513478528','Lara Mckenzie'),(59,'B','38998217','2014-07-19','58520101753','Cody Gates'),(60,'B','33366143','2016-11-18','30858829698','Lila Clay'),(61,'B','89493464','2011-01-20','92819661220','Martin Moon'),(62,'A','31319825','2009-03-19','78079548939','Ima Weber'),(63,'A','43693516','2005-10-18','22376249346','Adrian Payne'),(64,'A','88749401','2027-11-18','00238832485','Nevada Ashley'),(65,'A','18744317','2015-12-18','35718199450','Isabelle Macdonald'),(66,'B','77048473','2023-07-19','60236380840','Stewart Christian'),(67,'A','21772895','2026-11-18','75510416843','Cally Kemp'),(68,'B','36863054','2019-07-19','61464578783','James Calhoun'),(69,'B','36754738','2027-11-18','26989469601','Denise Mcknight'),(70,'B','43846266','2012-03-19','59125928081','Louis Jacobs'),(71,'A','77221487','2006-02-19','96241594062','Yvette Cannon'),(72,'A','69509461','2027-01-20','88405451561','TaShya Bean'),(73,'B','64430369','2010-05-19','36592448864','Owen Ellis'),(74,'B','49714933','2013-04-20','81559356438','Madison Harrison'),(75,'A','29598267','2022-08-20','66470684573','Elaine Bowen'),(76,'A','43737423','2008-08-20','54822549451','Hu Conrad'),(77,'B','64299971','2023-02-20','41912967664','Neville Wynn'),(78,'A','07785004','2013-02-19','78943869278','Jack Carrillo'),(79,'B','06249568','2015-10-19','88968169746','Octavius King'),(80,'B','76744074','2027-06-20','59809412760','Basil Torres'),(81,'A','58258231','2010-11-18','69650505141','Geraldine Nixon'),(82,'B','48989967','2004-07-20','68510902655','Claire Marsh'),(83,'A','78580490','2003-07-19','31752378013','Charlotte Roth'),(84,'A','41698799','2002-07-20','07468419663','Keefe Mack'),(85,'B','70334639','2004-08-19','72554305983','Stella Meyer'),(86,'B','56026482','2008-03-20','80773652801','Christian French'),(87,'B','87680539','2031-01-20','71260128864','Oscar Cooper'),(88,'B','20614835','2013-03-20','55858946997','Mia Hall'),(89,'A','50315614','2022-01-20','60043235947','Aline Dale'),(90,'A','46108319','2011-08-19','35116941790','Molly Kinney'),(91,'B','73879991','2016-03-19','02218484273','Cooper Finch'),(92,'B','86662873','2026-06-19','46397116672','Quinlan Frazier'),(93,'B','48698948','2021-07-20','70132794247','Cailin Mcdowell'),(94,'A','42272069','2017-05-19','05414948025','Nita Richards'),(95,'B','38545773','2020-05-19','34816372564','Melinda Mccarty'),(96,'B','70293172','2030-03-19','92564451814','Hop Powell'),(97,'A','21049121','2004-12-19','82745710894','Amela Henson'),(98,'A','61638519','2024-11-18','57787518517','Mary Woodward'),(99,'B','43087607','2003-06-20','20206439328','Neve Smith'),(100,'B','65346783','2022-11-18','80181401889','Keely Olsen');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-29  8:48:38
