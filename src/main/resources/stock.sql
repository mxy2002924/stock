-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: stock
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `day_trade`
--

DROP TABLE IF EXISTS `day_trade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `day_trade` (
  `tid` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `open` decimal(6,3) DEFAULT NULL,
  `high` decimal(6,3) DEFAULT NULL,
  `low` decimal(6,3) DEFAULT NULL,
  `close` decimal(6,3) DEFAULT NULL,
  `volume` int(11) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fund_stock`
--

DROP TABLE IF EXISTS `fund_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fund_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` int(11) DEFAULT NULL COMMENT '证券代码',
  `name` varchar(8) DEFAULT NULL,
  `ename` varchar(5) DEFAULT NULL,
  `dd_index` int(11) DEFAULT NULL COMMENT 'day trade data start index .',
  `dd_date` date DEFAULT NULL COMMENT 'latest day data update date.',
  `dd_clear` tinyint(4) DEFAULT '0' COMMENT '最后一天的是否是完整的，交易日3点前可能不是了',
  `funds` int(5) DEFAULT NULL COMMENT '拥有此股的基金家数',
  `proportion` decimal(5,2) DEFAULT NULL COMMENT '占流通比例',
  `share` decimal(12,4) DEFAULT NULL COMMENT '持有股份数（万股）',
  `sharedrift` decimal(10,2) DEFAULT NULL COMMENT '持股变动',
  `tdays` int(11) DEFAULT NULL COMMENT 'how many days trade has been reocrded.',
  `vip` tinyint(1) DEFAULT NULL COMMENT 'vip setted by ownner',
  `rank` int(11) DEFAULT NULL COMMENT 'funds  rank',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=883 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-03 17:48:09
