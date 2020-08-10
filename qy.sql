/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.59 : Database - qy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`qy` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `qy`;

/*Table structure for table `qy_query` */

DROP TABLE IF EXISTS `qy_query`;

CREATE TABLE `qy_query` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `power` varchar(10) NOT NULL,
  `powerImagePath` varchar(600) DEFAULT NULL,
  `tempure` varchar(10) NOT NULL,
  `tempureImagePath` varchar(600) DEFAULT NULL,
  `date` date NOT NULL,
  `uId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uId` (`uId`),
  CONSTRAINT `qy_query_ibfk_2` FOREIGN KEY (`uId`) REFERENCES `qy_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `qy_query` */

insert  into `qy_query`(`id`,`power`,`powerImagePath`,`tempure`,`tempureImagePath`,`date`,`uId`) values (11,'正常','http://192.168.0.115:8080/images/e40832cbf0194ee992699cd08330e716.jpeg;','正常','http://192.168.0.115:8080/images/e40832cbf0194ee992699cd08330e716.jpeg;','2020-08-09',1);

/*Table structure for table `qy_queryimage` */

DROP TABLE IF EXISTS `qy_queryimage`;

CREATE TABLE `qy_queryimage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `imagePath` varchar(700) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `qy_queryimage` */

insert  into `qy_queryimage`(`id`,`content`,`imagePath`,`date`) values (7,'一切正常','http://172.252.200.229:8080/images/e40832cbf0194ee992699cd08330e716.jpeg;','2020-08-03'),(8,'一切正常','http://172.252.200.229:8080/images/263f250fad7f4e71b2f7156b32fe0f00.jpg;http://172.252.200.229:8080/images/16e9227ce3f94fd3ae60fcbc25b5aa6d.jpg;http://172.252.200.229:8080/images/34493b575278475eb017122625854fe1.jpg;','2020-08-04');

/*Table structure for table `qy_user` */

DROP TABLE IF EXISTS `qy_user`;

CREATE TABLE `qy_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `qy_user` */

insert  into `qy_user`(`id`,`name`) values (1,'苑凯歌');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
