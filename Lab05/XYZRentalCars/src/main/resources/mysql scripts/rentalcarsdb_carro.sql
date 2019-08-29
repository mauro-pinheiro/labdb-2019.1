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
-- Table structure for table `carro`
--

DROP TABLE IF EXISTS `carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ano` year(4) DEFAULT NULL,
  `classe` varchar(20) NOT NULL,
  `cor` varchar(20) DEFAULT NULL,
  `descricao` text,
  `modelo` varchar(30) DEFAULT NULL,
  `placa` varchar(10) DEFAULT NULL,
  `quilometragem` int(11) DEFAULT NULL,
  `situacao` varchar(20) NOT NULL,
  `valor_diaria` decimal(19,2) DEFAULT NULL,
  `id_sede_atual` int(11) DEFAULT NULL,
  `id_sede_de_origem` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe3f429tvqu0yjqfhjageshtpd` (`id_sede_atual`),
  KEY `FKj3sm4fsgcwg18vim0eb8k8xaa` (`id_sede_de_origem`),
  CONSTRAINT `FKe3f429tvqu0yjqfhjageshtpd` FOREIGN KEY (`id_sede_atual`) REFERENCES `sede` (`id`),
  CONSTRAINT `FKj3sm4fsgcwg18vim0eb8k8xaa` FOREIGN KEY (`id_sede_de_origem`) REFERENCES `sede` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro`
--

LOCK TABLES `carro` WRITE;
/*!40000 ALTER TABLE `carro` DISABLE KEYS */;
INSERT INTO `carro` VALUES (1,2012,'Grande','indigo','feugiat.','auctor,','UFA 8087',2,'Alugado',6.83,2,1),(2,2002,'Luxo','indigo','dolor egestas rhoncus. Proin','enim','YCJ 3718',1,'Alugado',5.60,2,1),(3,2004,'Luxo','green','purus. Maecenas libero est,','amet','EMB 5279',6,'ForaDaSedeDeOrigem',3.10,2,1),(4,2012,'Medio','blue','semper','ac','FHJ 3850',2,'ForaDaSedeDeOrigem',3.55,2,1),(5,2002,'Medio','indigo','egestas. Aliquam nec enim.','faucibus','FAL 8667',2,'Alugado',3.90,1,1),(6,2006,'Compacto','red','sagittis lobortis','Suspendisse','FXR 8425',4,'Disponível',9.91,1,1),(7,2007,'Luxo','blue','et tristique pellentesque, tellus','nunc','GNR 1481',5,'Disponível',1.49,2,1),(8,2017,'Grande','violet','lectus, a sollicitudin orci','iaculis','HRN 0294',1,'Disponível',3.96,2,1),(9,2007,'SubCompacto','yellow','vitae odio sagittis','mauris','AOD 8542',5,'ForaDaSedeDeOrigem',9.67,2,2),(10,2000,'SubCompacto','green','dui, nec','aliquet,','PDJ 5433',10,'Alugado',6.69,2,2),(11,2009,'SubCompacto','yellow','Aenean eget magna. Suspendisse','augue','ZTH 2111',2,'ForaDaSedeDeOrigem',7.03,1,2),(12,2017,'SubCompacto','blue','sed','felis','PGX 1870',8,'Disponível',3.71,1,1),(13,2014,'Luxo','indigo','faucibus.','ullamcorper','JEU 0158',2,'ForaDaSedeDeOrigem',2.08,2,2),(14,2005,'Compacto','indigo','dolor elit, pellentesque a,','consectetuer','ATR 5722',0,'Alugado',5.39,2,1),(15,2003,'SubCompacto','green','a, magna. Lorem','ut,','NEA 8245',9,'ForaDaSedeDeOrigem',5.48,1,2),(16,2000,'Medio','indigo','condimentum eget,','Fusce','OGH 0011',3,'ForaDaSedeDeOrigem',4.49,1,2),(17,2002,'Medio','yellow','ornare, elit elit fermentum','enim,','XAS 9367',4,'Alugado',2.29,1,2),(18,2002,'Grande','green','Phasellus vitae mauris sit','ultrices','RUD 2136',1,'Alugado',9.63,2,1),(19,2004,'SubCompacto','blue','Sed diam','varius','DDM 2538',8,'Alugado',2.31,1,1),(20,2006,'SubCompacto','orange','velit.','mollis','NGL 3631',2,'Disponível',2.14,2,2),(21,2015,'Grande','blue','Fusce','neque','KFO 2244',1,'Alugado',9.59,2,1),(22,2007,'Grande','indigo','primis in','Suspendisse','EWT 7840',8,'ForaDaSedeDeOrigem',5.75,2,2),(23,2015,'Luxo','green','eu neque pellentesque','lorem,','JGK 3524',0,'Disponível',6.97,2,2),(24,2011,'SubCompacto','green','nec enim. Nunc ut','sed,','PBA 4865',3,'Disponível',8.16,1,1),(25,2010,'Compacto','violet','Morbi','mi.','EDB 0944',0,'Disponível',2.15,1,1),(26,2016,'Medio','blue','Praesent luctus.','consectetuer','RLD 9739',9,'Alugado',9.65,1,2),(27,2000,'Medio','orange','nisi','ligula','OJA 4850',8,'ForaDaSedeDeOrigem',9.91,2,1),(28,2006,'Grande','violet','Vivamus nibh dolor, nonummy','ac','FYX 2391',8,'Alugado',7.36,1,2),(29,2000,'Compacto','orange','Integer','quis','QPT 4453',9,'Alugado',9.50,1,1),(30,2015,'SubCompacto','indigo','leo elementum sem, vitae','ante','IFW 8204',7,'Disponível',2.23,1,1),(31,2016,'Grande','red','cursus','morbi','MHF 6591',4,'Disponível',4.39,1,1),(32,2004,'Luxo','blue','erat vitae risus. Duis','mi','NSQ 0984',1,'ForaDaSedeDeOrigem',7.67,1,1),(33,2016,'Luxo','yellow','at pretium aliquet,','dapibus','BBT 6021',2,'Alugado',4.09,1,2),(34,2002,'SubCompacto','orange','mi fringilla mi','auctor,','UKC 6369',5,'Alugado',0.92,1,1),(35,2010,'Compacto','blue','Suspendisse sagittis.','adipiscing','DZS 7042',2,'Disponível',0.01,1,1),(36,2002,'SubCompacto','yellow','malesuada malesuada. Integer id','sagittis','ZGX 4121',5,'ForaDaSedeDeOrigem',4.23,2,2),(37,2002,'SubCompacto','red','lectus pede, ultrices','parturient','KHL 7338',5,'Disponível',3.55,2,2),(38,2004,'Medio','indigo','Suspendisse dui. Fusce','non,','QNZ 8671',10,'Disponível',7.97,2,2),(39,2004,'SubCompacto','violet','sed,','arcu','SHY 8501',6,'Disponível',3.98,2,1),(40,2003,'Luxo','red','accumsan laoreet','adipiscing,','GGD 9287',1,'Disponível',3.21,2,1),(41,2007,'Luxo','indigo','scelerisque','magna.','NHZ 7478',5,'ForaDaSedeDeOrigem',2.38,1,1),(42,2005,'Luxo','indigo','lorem ac','laoreet','DPZ 3244',9,'Alugado',7.15,2,2),(43,2013,'Grande','yellow','eu, euismod ac, fermentum','purus','IVB 2506',5,'ForaDaSedeDeOrigem',1.33,2,2),(44,2000,'Compacto','yellow','urna. Vivamus molestie dapibus','eget','SSS 9014',9,'Alugado',6.18,1,1),(45,2013,'Compacto','red','nisi.','porta','LVK 7501',9,'Disponível',4.51,2,2),(46,2004,'SubCompacto','red','libero mauris, aliquam eu,','magna.','FUF 0345',9,'Alugado',5.55,2,1),(47,2009,'Medio','blue','Nulla eget','Nullam','FLX 2894',5,'Alugado',6.30,2,1),(48,2003,'Medio','violet','ut, pharetra sed,','nec','PXT 8372',8,'ForaDaSedeDeOrigem',9.02,2,1),(49,2006,'Compacto','green','libero dui','euismod','FGC 7679',5,'Disponível',3.31,2,2),(50,2015,'Compacto','red','orci, in consequat enim','Etiam','QPO 1495',3,'Disponível',0.28,1,2),(51,2009,'Luxo','indigo','conubia nostra, per','massa.','NBL 6086',7,'ForaDaSedeDeOrigem',2.39,2,1),(52,2010,'SubCompacto','violet','a,','feugiat','HBP 6467',8,'Alugado',8.52,1,1),(53,2009,'Grande','yellow','venenatis vel, faucibus id,','metus.','MTB 7394',3,'Alugado',6.33,2,2),(54,2002,'Luxo','violet','sed consequat auctor,','Donec','LPJ 7564',1,'ForaDaSedeDeOrigem',9.05,1,1),(55,2013,'SubCompacto','red','Sed','lobortis.','TRV 1084',0,'Disponível',9.30,2,1),(56,2014,'SubCompacto','yellow','fermentum convallis ligula.','mi','YXC 7187',8,'Disponível',0.79,2,2),(57,2003,'Luxo','yellow','tincidunt orci quis','erat.','NPY 3354',9,'ForaDaSedeDeOrigem',6.19,2,1),(58,2009,'Grande','blue','consectetuer adipiscing','eleifend','YLT 3872',1,'Disponível',2.43,1,2),(59,2018,'Compacto','red','sapien. Cras dolor','nisl','TIG 2771',3,'ForaDaSedeDeOrigem',5.62,2,2),(60,2014,'Compacto','yellow','vitae,','lorem','NNT 1698',5,'Disponível',9.89,2,1),(61,2007,'Compacto','yellow','facilisis facilisis, magna tellus','nunc','TSG 3758',2,'Disponível',2.08,2,2),(62,2010,'Luxo','blue','vitae nibh. Donec','Proin','WVT 2404',8,'Disponível',1.48,2,2),(63,2017,'Medio','yellow','volutpat. Nulla facilisis. Suspendisse','Etiam','ETV 9798',8,'Alugado',9.69,2,2),(64,2002,'Medio','yellow','dolor. Fusce','senectus','PAH 1117',6,'Alugado',3.61,1,2),(65,2009,'Grande','orange','Aenean massa. Integer vitae','neque.','YRE 5611',6,'Disponível',8.93,1,2),(66,2012,'Compacto','red','pretium','id,','HKW 5544',7,'Alugado',1.99,2,1),(67,2011,'Luxo','blue','hendrerit id, ante.','Fusce','PHP 8797',3,'Disponível',8.03,2,2),(68,2016,'Luxo','red','dui augue','amet','DJA 9978',8,'Disponível',3.93,1,1),(69,2015,'SubCompacto','indigo','vitae, posuere at, velit.','iaculis','BZQ 6097',2,'Disponível',8.45,2,1),(70,2018,'Grande','blue','vel arcu eu odio','dolor.','EBK 8123',2,'ForaDaSedeDeOrigem',6.06,2,2),(71,2016,'Compacto','yellow','eleifend, nunc risus','adipiscing.','RTZ 3270',8,'Disponível',8.57,1,1),(72,2018,'Luxo','yellow','Donec','ac','VPE 0961',3,'ForaDaSedeDeOrigem',4.83,2,2),(73,2010,'Compacto','green','morbi tristique','vehicula','BIC 9838',9,'ForaDaSedeDeOrigem',3.63,2,2),(74,2001,'Luxo','blue','pede. Nunc sed','In','HIK 1208',6,'ForaDaSedeDeOrigem',7.10,1,2),(75,2005,'SubCompacto','yellow','enim. Mauris','neque.','ADQ 8057',8,'Disponível',2.94,2,2),(76,2015,'Compacto','indigo','consectetuer adipiscing elit. Etiam','ac,','ZIJ 9886',2,'ForaDaSedeDeOrigem',4.65,1,1),(77,2016,'Luxo','indigo','cursus, diam at','porttitor','RRT 1322',6,'ForaDaSedeDeOrigem',3.71,2,2),(78,2015,'SubCompacto','indigo','sit','Sed','VSL 5355',10,'Disponível',2.82,1,1),(79,2000,'Grande','indigo','dictum eu, placerat','egestas,','UPL 2075',7,'Disponível',4.12,2,1),(80,2014,'SubCompacto','orange','laoreet posuere, enim','nascetur','OLH 2713',7,'Disponível',3.31,2,1),(81,2006,'Medio','violet','morbi tristique senectus','consectetuer','CWE 1140',5,'ForaDaSedeDeOrigem',4.71,1,1),(82,2005,'Luxo','violet','iaculis,','lacinia','TIU 2226',3,'Alugado',4.22,1,1),(83,2005,'Luxo','orange','Integer id magna','non','IXQ 5561',8,'Disponível',7.12,2,1),(84,2016,'SubCompacto','indigo','Sed et libero.','risus','KUN 8501',1,'Alugado',6.92,1,2),(85,2018,'Compacto','violet','vehicula','interdum','JVX 6042',8,'ForaDaSedeDeOrigem',0.93,1,1),(86,2015,'Medio','orange','faucibus','sociis','ODX 2443',8,'Disponível',0.21,1,1),(87,2015,'Luxo','green','mi','dignissim.','TBG 0255',8,'Disponível',9.11,1,1),(88,2015,'Medio','green','feugiat tellus','vel,','JAM 6027',0,'Alugado',9.08,2,2),(89,2013,'Compacto','blue','Vivamus non lorem','magna.','GXB 9543',8,'Alugado',6.30,2,1),(90,2014,'Grande','yellow','id','velit','TNI 3073',6,'ForaDaSedeDeOrigem',3.56,2,2),(91,2016,'Grande','blue','iaculis odio.','ligula.','EIZ 4463',6,'Alugado',2.69,2,1),(92,2004,'Luxo','yellow','nec ante blandit viverra.','suscipit','YPM 1281',1,'ForaDaSedeDeOrigem',3.93,1,2),(93,2008,'SubCompacto','red','magna sed','orci,','KLE 8001',6,'Disponível',9.57,2,1),(94,2001,'Grande','green','fringilla cursus purus. Nullam','sed','GAG 7760',6,'Alugado',2.78,2,2),(95,2017,'Medio','orange','amet risus. Donec','tortor.','JPK 4841',6,'ForaDaSedeDeOrigem',6.40,2,2),(96,2012,'Grande','red','sem, vitae','fringilla.','BPG 8335',2,'Alugado',1.09,1,1),(97,2005,'Luxo','indigo','eget, dictum placerat,','est,','TDQ 1417',4,'Disponível',6.37,2,1),(98,2017,'Grande','indigo','tincidunt.','ac','CPI 6968',10,'Disponível',0.72,2,2),(99,2009,'Grande','green','nec,','penatibus','ZLN 9053',6,'ForaDaSedeDeOrigem',4.70,1,2),(100,2012,'SubCompacto','yellow','imperdiet, erat','ante','BJP 4410',0,'ForaDaSedeDeOrigem',3.02,1,2);
/*!40000 ALTER TABLE `carro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-29  8:48:39
