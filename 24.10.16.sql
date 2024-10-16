-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: tarifdb
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `kategoriler`
--

DROP TABLE IF EXISTS `kategoriler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kategoriler` (
  `KategoriID` int NOT NULL AUTO_INCREMENT,
  `KategoriAdi` varchar(100) NOT NULL,
  PRIMARY KEY (`KategoriID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategoriler`
--

LOCK TABLES `kategoriler` WRITE;
/*!40000 ALTER TABLE `kategoriler` DISABLE KEYS */;
INSERT INTO `kategoriler` VALUES (1,'Ana Yemekler'),(2,'Çorbalar'),(3,'Tatlılar'),(4,'Salatalar'),(5,'İçecekler');
/*!40000 ALTER TABLE `kategoriler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `malzemeler`
--

DROP TABLE IF EXISTS `malzemeler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `malzemeler` (
  `MalzemeID` int NOT NULL AUTO_INCREMENT,
  `MalzemeAdi` varchar(255) NOT NULL,
  `ToplamMiktar` varchar(100) DEFAULT NULL,
  `MalzemeBirim` varchar(50) DEFAULT NULL,
  `BirimFiyat` float DEFAULT NULL,
  PRIMARY KEY (`MalzemeID`),
  UNIQUE KEY `MalzemeAdi` (`MalzemeAdi`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `malzemeler`
--

LOCK TABLES `malzemeler` WRITE;
/*!40000 ALTER TABLE `malzemeler` DISABLE KEYS */;
INSERT INTO `malzemeler` VALUES (1,'Patlıcan','2','kilo',15),(2,'Kıyma','1','kilo',120),(3,'Soğan','4','kilo',10),(4,'Domates','6','kilo',12),(5,'Biber','2','kilo',8),(6,'Zeytinyağı','2','litre',60),(7,'Tuz','5','kilo',2),(8,'Karabiber','2','kilo',50),(9,'Tavuk Göğsü','3','kilo',30),(10,'Kuru Fasulye','4','kilo',25),(11,'Domates Salçası','1','kilo',40),(12,'Galeta Unu','2','kilo',12),(13,'Kimyon','1','kilo',40),(14,'Un','5','kilo',5),(15,'Yoğurt','5','kilo',20),(16,'Sarımsak','1','kilo',15),(17,'Tereyağı','2','kilo',80),(18,'Süt','5','litre',7),(19,'Patates','5','kilo',6),(20,'Maydanoz','2','demet',2),(21,'Domates Sosu','4','litre',15),(22,'Kaşar Peyniri','2','kilo',80),(23,'Salam','2','kilo',60),(24,'Zeytin','2','kilo',40),(25,'Mantar','2','kilo',30),(26,'Havuç','4','kilo',5),(27,'Kırmızı Mercimek','6','kilo',20),(28,'Bulgur','4','kilo',8),(29,'Pirinç','6','kilo',10),(30,'Yumurta','10','adet',1.5),(31,'Tel Şehriye','4','kilo',15),(32,'Brokoli','2','kilo',12),(33,'Pırasa','2','kilo',10),(34,'Tarhana','2','kilo',25),(35,'Ceviz','4','kilo',80),(36,'Şeker','10','kilo',5),(37,'Nişasta','4','kilo',10),(38,'İrmik','5','kilo',12),(39,'Kabartma Tozu','1','kilo',20),(40,'Limon','5','adet',0.5),(41,'Pirinç Unu','1','kilo',15),(42,'Vanilya','2','kilo',50),(43,'Güllaç Yaprağı','2','kilo',100),(44,'Buğday','6','kilo',5),(45,'Nohut','5','kilo',8),(46,'Fındık','4','kilo',90),(47,'Fıstık','2','kilo',120),(48,'Kuru Üzüm','4','kilo',30),(49,'Kuru Kayısı','4','kilo',35),(50,'Salatalık','5','kilo',8),(51,'Marul','3','kilo',5),(52,'Turp','2','kilo',6),(53,'Roka','2','demet',3),(54,'Pancar','2','kilo',7),(55,'Bezelye','3','kilo',10),(56,'Mayonez','1','kilo',30),(57,'Mısır','3','kilo',12),(58,'Semizotu','1','kilo',10),(59,'Ihlamur','1','kilo',100),(60,'Bal','2','kilo',120),(61,'Çay','5','kilo',40),(62,'Kahve','3','kilo',80),(63,'Salep','1','kilo',150),(64,'Tarçın','1','kilo',50),(65,'Muz','3','kilo',15),(66,'Çilek','2','kilo',20),(67,'Portakal','5','kilo',10),(68,'Elma','5','kilo',8),(69,'Dondurma','2','kilo',60),(70,'Su','10','litre',0);
/*!40000 ALTER TABLE `malzemeler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarif_malzeme`
--

DROP TABLE IF EXISTS `tarif_malzeme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarif_malzeme` (
  `TarifID` int NOT NULL,
  `MalzemeID` int NOT NULL,
  `MalzemeMiktar` float DEFAULT NULL,
  PRIMARY KEY (`TarifID`,`MalzemeID`),
  KEY `MalzemeID` (`MalzemeID`),
  CONSTRAINT `tarif_malzeme_ibfk_1` FOREIGN KEY (`TarifID`) REFERENCES `tarifler` (`TarifID`) ON DELETE CASCADE,
  CONSTRAINT `tarif_malzeme_ibfk_2` FOREIGN KEY (`MalzemeID`) REFERENCES `malzemeler` (`MalzemeID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarif_malzeme`
--

LOCK TABLES `tarif_malzeme` WRITE;
/*!40000 ALTER TABLE `tarif_malzeme` DISABLE KEYS */;
INSERT INTO `tarif_malzeme` VALUES (1,1,1.5),(1,2,0.5),(1,3,0.2),(1,4,0.3),(1,5,0.1),(1,6,0.1),(1,7,0.02),(1,8,0.01),(2,3,0.2),(2,4,0.3),(2,5,0.1),(2,6,0.05),(2,7,0.02),(2,8,0.01),(2,9,0.6),(3,3,0.2),(3,6,0.05),(3,7,0.02),(3,8,0.01),(3,10,0.4),(3,11,0.1),(4,2,0.5),(4,3,0.1),(4,7,0.02),(4,8,0.01),(4,12,0.05),(4,13,0.01),(5,2,0.3),(5,3,0.1),(5,7,0.02),(5,8,0.01),(5,14,0.5),(5,15,0.4),(5,16,0.02),(5,17,0.05),(6,2,0.5),(6,7,0.02),(6,8,0.01),(6,17,0.1),(6,18,0.2),(6,19,0.4),(7,2,0.4),(7,3,0.1),(7,4,0.2),(7,5,0.1),(7,6,0.05),(7,7,0.02),(7,8,0.01),(7,14,0.5),(7,20,0.1),(8,6,0.05),(8,7,0.02),(8,14,0.5),(8,21,0.3),(8,22,0.4),(8,23,0.2),(8,24,0.2),(8,25,0.3),(9,3,0.1),(9,5,0.2),(9,6,0.05),(9,7,0.02),(9,8,0.01),(9,9,0.6),(9,19,0.3),(9,26,0.2),(10,7,0.02),(10,8,0.01),(10,9,0.6),(10,14,0.05),(10,17,0.1),(10,18,0.2),(11,3,0.1),(11,6,0.05),(11,7,0.02),(11,8,0.01),(11,26,0.1),(11,27,0.2),(12,3,0.1),(12,6,0.05),(12,7,0.02),(12,8,0.01),(12,11,0.05),(12,27,0.2),(12,28,0.1),(12,29,0.1),(13,3,0.1),(13,7,0.02),(13,8,0.01),(13,9,0.5),(13,70,1),(14,4,0.3),(14,6,0.05),(14,7,0.02),(14,8,0.01),(14,11,0.05),(14,14,0.05),(15,7,0.02),(15,8,0.01),(15,14,0.05),(15,15,0.2),(15,29,0.1),(15,30,1),(16,6,0.05),(16,7,0.02),(16,34,0.1),(16,70,1),(17,3,0.1),(17,6,0.05),(17,7,0.02),(17,8,0.01),(17,14,0.05),(17,18,0.2),(17,25,0.3),(18,3,0.1),(18,4,0.2),(18,6,0.05),(18,7,0.02),(18,8,0.01),(18,31,0.1),(19,3,0.1),(19,6,0.05),(19,7,0.02),(19,8,0.01),(19,18,0.2),(19,32,0.3),(20,3,0.1),(20,6,0.05),(20,7,0.02),(20,8,0.01),(20,19,0.2),(20,33,0.3),(21,14,0.5),(21,17,0.3),(21,35,0.2),(21,36,0.5),(21,37,0.1),(21,70,1),(22,14,0.3),(22,15,0.2),(22,30,3),(22,36,0.5),(22,38,0.3),(22,39,0.01),(22,40,0.1),(23,17,0.05),(23,18,1),(23,36,0.5),(23,37,0.1),(23,41,0.1),(24,18,1),(24,29,0.2),(24,36,0.4),(24,42,0.01),(25,14,0.3),(25,17,0.2),(25,30,2),(25,36,0.4),(25,38,0.2),(25,39,0.01),(25,40,0.05),(26,18,1),(26,35,0.2),(26,36,0.5),(26,43,0.5),(27,18,1),(27,29,0.2),(27,30,2),(27,36,0.4),(27,42,0.01),(28,10,0.2),(28,36,0.5),(28,44,0.5),(28,45,0.2),(28,46,0.1),(28,47,0.1),(28,48,0.1),(28,49,0.1),(29,18,1),(29,36,0.5),(29,37,0.1),(29,42,0.01),(30,17,0.2),(30,36,0.5),(30,38,0.5),(30,70,1),(31,3,0.1),(31,4,0.2),(31,6,0.05),(31,7,0.02),(31,20,0.1),(31,40,0.05),(31,50,0.2),(32,6,0.05),(32,7,0.02),(32,26,0.1),(32,40,0.05),(32,51,0.2),(32,52,0.1),(33,6,0.05),(33,7,0.02),(33,40,0.05),(33,53,0.2),(34,3,0.1),(34,6,0.05),(34,7,0.02),(34,19,0.3),(34,20,0.1),(34,40,0.05),(35,6,0.05),(35,7,0.02),(35,40,0.05),(35,54,0.3),(36,4,0.2),(36,6,0.05),(36,7,0.02),(36,40,0.05),(36,45,0.3),(36,51,0.2),(37,6,0.05),(37,7,0.02),(37,11,0.05),(37,20,0.1),(37,28,0.2),(37,40,0.05),(38,7,0.02),(38,19,0.2),(38,26,0.1),(38,55,0.1),(38,56,0.1),(39,6,0.05),(39,7,0.02),(39,40,0.05),(39,51,0.2),(39,57,0.2),(40,7,0.02),(40,15,0.4),(40,16,0.05),(40,58,0.2),(41,36,0.2),(41,40,0.5),(41,70,1),(42,7,0.01),(42,15,0.4),(42,70,0.6),(43,59,0.02),(43,60,0.05),(43,70,1),(44,36,0.1),(44,61,0.05),(44,70,1),(45,36,0.1),(45,62,0.05),(45,70,1),(46,18,1),(46,36,0.2),(46,63,0.05),(46,64,0.01),(47,18,0.4),(47,60,0.05),(47,65,0.3),(47,66,0.3),(48,36,0.2),(48,67,0.3),(48,68,0.3),(49,36,0.2),(49,40,0.2),(49,61,0.05),(49,70,1),(50,18,0.6),(50,36,0.1),(50,69,0.4);
/*!40000 ALTER TABLE `tarif_malzeme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarifler`
--

DROP TABLE IF EXISTS `tarifler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarifler` (
  `TarifID` int NOT NULL AUTO_INCREMENT,
  `TarifAdi` varchar(255) NOT NULL,
  `KategoriID` int DEFAULT NULL,
  `HazirlamaSuresi` int DEFAULT NULL,
  `Talimatlar` text,
  PRIMARY KEY (`TarifID`),
  UNIQUE KEY `TarifAdi` (`TarifAdi`),
  KEY `KategoriID` (`KategoriID`),
  CONSTRAINT `tarifler_ibfk_1` FOREIGN KEY (`KategoriID`) REFERENCES `kategoriler` (`KategoriID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarifler`
--

LOCK TABLES `tarifler` WRITE;
/*!40000 ALTER TABLE `tarifler` DISABLE KEYS */;
INSERT INTO `tarifler` VALUES (1,'Karnıyarık',1,45,'Patlıcanları kızartın, kıymayı kavurun...'),(2,'Tavuk Sote',1,30,'Tavukları doğrayın, sebzeleri ekleyin...'),(3,'Kuru Fasulye',1,60,'Fasulyeleri haşlayın, sosu hazırlayın...'),(4,'Izgara Köfte',1,35,'Kıymayı baharatlayın, köfteleri ızgarada pişirin...'),(5,'Mantı',1,90,'Hamuru açın, iç harcı hazırlayın...'),(6,'Patates Püreli Et',1,50,'Patatesleri haşlayın, eti pişirin...'),(7,'Lahmacun',1,40,'Hamuru hazırlayın, iç harcı ekleyin...'),(8,'Pizza',1,60,'Hamuru yoğurun, malzemeleri dizin...'),(9,'Sebzeli Tavuk',1,40,'Tavuk ve sebzeleri soteleyin...'),(10,'Beşamel Soslu Tavuk',1,50,'Beşamel sosu hazırlayın, tavukları ekleyin...'),(11,'Mercimek Çorbası',2,25,'Mercimeği haşlayın, baharatları ekleyin...'),(12,'Ezogelin Çorbası',2,30,'Mercimek, bulgur ve pirinci haşlayın...'),(13,'Tavuk Suyu Çorba',2,40,'Tavukları haşlayın, suyunu kullanın...'),(14,'Domates Çorbası',2,20,'Domatesleri rendeleyin, kavurun...'),(15,'Yayla Çorbası',2,25,'Yoğurt ve yumurtayı çırpın, pirinç ekleyin...'),(16,'Tarhana Çorbası',2,15,'Tarhanayı suyla karıştırın, pişirin...'),(17,'Mantar Çorbası',2,35,'Mantarları doğrayın, çorbayı hazırlayın...'),(18,'Şehriye Çorbası',2,20,'Şehriyeleri haşlayın, baharatları ekleyin...'),(19,'Brokoli Çorbası',2,30,'Brokoliyi haşlayın, blenderdan geçirin...'),(20,'Pırasa Çorbası',2,30,'Pırasaları doğrayın, kavurun...'),(21,'Baklava',3,120,'Hamuru ince açın, şerbeti hazırlayın...'),(22,'Revani',3,45,'Revani hamurunu hazırlayın, fırına verin...'),(23,'Kazandibi',3,60,'Sütü kaynatın, tatlıyı pişirin...'),(24,'Sütlaç',3,50,'Pirinçleri haşlayın, sütle pişirin...'),(25,'Şekerpare',3,40,'Hamuru hazırlayın, şerbeti dökün...'),(26,'Güllaç',3,30,'Güllaç yapraklarını sütle ıslatın...'),(27,'Fırın Sütlaç',3,60,'Sütlaçı fırınlayın...'),(28,'Aşure',3,120,'Tüm malzemeleri haşlayın, karıştırın...'),(29,'Muhallebi',3,35,'Süt ve nişastayı karıştırın, pişirin...'),(30,'İrmik Helvası',3,40,'İrmiği kavurun, sütü ekleyin...'),(31,'Çoban Salata',4,15,'Domates, salatalık ve biberleri doğrayın...'),(32,'Mevsim Salata',4,10,'Marul, havuç ve turpu doğrayın...'),(33,'Roka Salatası',4,10,'Rokayı doğrayın, sosu hazırlayın...'),(34,'Patates Salatası',4,30,'Patatesleri haşlayın, doğrayın...'),(35,'Pancar Salatası',4,25,'Pancarları haşlayın, dilimleyin...'),(36,'Nohut Salatası',4,20,'Haşlanmış nohutları yeşilliklerle karıştırın...'),(37,'Kısır',4,30,'Bulguru ıslatın, yeşillikleri ekleyin...'),(38,'Rus Salatası',4,20,'Sebzeleri haşlayın, mayonezle karıştırın...'),(39,'Mısırlı Salata',4,15,'Mısırı ve diğer sebzeleri karıştırın...'),(40,'Yoğurtlu Semizotu',4,10,'Semizotunu yoğurtla karıştırın...'),(41,'Limonata',5,15,'Limonları sıkın, su ve şekerle karıştırın...'),(42,'Ayran',5,5,'Yoğurt, su ve tuzu karıştırın...'),(43,'Ihlamur',5,10,'Ihlamuru demleyin...'),(44,'Çay',5,15,'Çayı demleyin...'),(45,'Kahve',5,10,'Kahveyi pişirin...'),(46,'Salep',5,20,'Salebi sütle pişirin...'),(47,'Smoothie',5,10,'Meyveleri blenderdan geçirin...'),(48,'Meyve Suyu',5,10,'Meyveleri sıkın...'),(49,'Soğuk Çay',5,15,'Çayı demleyin, soğutun...'),(50,'Milkshake',5,10,'Dondurma ve sütü karıştırın...');
/*!40000 ALTER TABLE `tarifler` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-16 13:58:33
