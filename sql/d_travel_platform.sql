/*
SQLyog Ultimate
MySQL - 8.0.19 : Database - d_travel_platform
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`d_travel_platform` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `d_travel_platform`;

/*Table structure for table `t_activity_arrangement` */

DROP TABLE IF EXISTS `t_activity_arrangement`;

CREATE TABLE `t_activity_arrangement` (
  `produce_id` int unsigned NOT NULL,
  `activity_arrangement_id` int unsigned NOT NULL,
  `activity_arrangement_sequence` int NOT NULL,
  `arrangement_gmt_create` datetime NOT NULL,
  `arrangement_gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`activity_arrangement_id`),
  KEY `produce_id` (`produce_id`),
  CONSTRAINT `t_activity_arrangement_ibfk_1` FOREIGN KEY (`produce_id`) REFERENCES `t_produce` (`produce_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_answer` */

DROP TABLE IF EXISTS `t_answer`;

CREATE TABLE `t_answer` (
  `answer_id` int unsigned NOT NULL,
  `answer_topic` int unsigned NOT NULL,
  `answer_author` int unsigned NOT NULL,
  `vote_count` int NOT NULL DEFAULT '0',
  `favorite_count` int unsigned NOT NULL DEFAULT '0',
  `answer_permission` enum('private','public') CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'public',
  PRIMARY KEY (`answer_id`,`answer_topic`,`answer_author`),
  KEY `answer_topic` (`answer_topic`),
  KEY `answer_creator` (`answer_author`),
  CONSTRAINT `t_answer_ibfk_1` FOREIGN KEY (`answer_topic`) REFERENCES `t_topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Created By 古学懂';

/*Table structure for table `t_answer_dtl` */

DROP TABLE IF EXISTS `t_answer_dtl`;

CREATE TABLE `t_answer_dtl` (
  `answer_id` int unsigned NOT NULL,
  `answer_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`answer_id`),
  CONSTRAINT `t_answer_dtl_ibfk_1` FOREIGN KEY (`answer_id`) REFERENCES `t_answer` (`answer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Created By 古学懂';

/*Table structure for table `t_arrangement_content` */

DROP TABLE IF EXISTS `t_arrangement_content`;

CREATE TABLE `t_arrangement_content` (
  `activity_arrangement_id` int unsigned NOT NULL,
  `arrangement_content_type` varchar(3) NOT NULL,
  `arrangement_content_text` varchar(300) DEFAULT NULL,
  `arrangement_content_image` varchar(2083) DEFAULT NULL,
  `content_gmt_create` datetime NOT NULL,
  `content_gmt_modified` datetime DEFAULT NULL,
  KEY `activity_arrangement_id` (`activity_arrangement_id`),
  CONSTRAINT `t_arrangement_content_ibfk_1` FOREIGN KEY (`activity_arrangement_id`) REFERENCES `t_activity_arrangement` (`activity_arrangement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_background_administrator` */

DROP TABLE IF EXISTS `t_background_administrator`;

CREATE TABLE `t_background_administrator` (
  `administrator_id` int unsigned NOT NULL,
  `administrator_name` varchar(45) NOT NULL,
  `administrator_password` varchar(45) NOT NULL,
  PRIMARY KEY (`administrator_id`),
  UNIQUE KEY `administrator_id_UNIQUE` (`administrator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_cost_content` */

DROP TABLE IF EXISTS `t_cost_content`;

CREATE TABLE `t_cost_content` (
  `cost_id` int unsigned NOT NULL,
  `meals_cost` int NOT NULL,
  `accommodation_fee` int NOT NULL,
  `landmark_ticket` int NOT NULL,
  `car_fare` int NOT NULL,
  `guide_fee` int NOT NULL,
  PRIMARY KEY (`cost_id`),
  CONSTRAINT `t_cost_content_ibfk_1` FOREIGN KEY (`cost_id`) REFERENCES `t_produce_cost` (`cost_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_event` */

DROP TABLE IF EXISTS `t_event`;

CREATE TABLE `t_event` (
  `administrator_id` int unsigned DEFAULT NULL,
  `event _id` int unsigned NOT NULL,
  `event_describe` varchar(45) NOT NULL,
  `event_state` varchar(45) NOT NULL,
  PRIMARY KEY (`event _id`),
  UNIQUE KEY `event _id_UNIQUE` (`event _id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_favorite_scenery` */

DROP TABLE IF EXISTS `t_favorite_scenery`;

CREATE TABLE `t_favorite_scenery` (
  `user_id` int unsigned NOT NULL,
  `favorite_scenery` int unsigned NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  KEY `favorite_scenery` (`favorite_scenery`),
  CONSTRAINT `t_favorite_scenery_ibfk_1` FOREIGN KEY (`favorite_scenery`) REFERENCES `t_scenery` (`scenery_id`),
  CONSTRAINT `t_favorite_scenery_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_favourites` */

DROP TABLE IF EXISTS `t_favourites`;

CREATE TABLE `t_favourites` (
  `favorites_id` int unsigned NOT NULL AUTO_INCREMENT,
  `favorites_ownner` int unsigned NOT NULL,
  `favorites_topic` int unsigned DEFAULT NULL,
  `favorites_answer` int unsigned DEFAULT NULL,
  `favorites_note` int unsigned DEFAULT NULL,
  PRIMARY KEY (`favorites_id`),
  KEY `favorites_ownner` (`favorites_ownner`),
  KEY `favorites_topic` (`favorites_topic`),
  KEY `favorites_answer` (`favorites_answer`),
  KEY `favorites_note` (`favorites_note`),
  CONSTRAINT `t_favourites_ibfk_2` FOREIGN KEY (`favorites_topic`) REFERENCES `t_topic` (`topic_id`),
  CONSTRAINT `t_favourites_ibfk_3` FOREIGN KEY (`favorites_answer`) REFERENCES `t_answer` (`answer_id`),
  CONSTRAINT `t_favourites_ibfk_4` FOREIGN KEY (`favorites_note`) REFERENCES `t_note` (`note_id`),
  CONSTRAINT `t_favourites_ibfk_5` FOREIGN KEY (`favorites_ownner`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Created By 古学懂';

/*Table structure for table `t_footprint` */

DROP TABLE IF EXISTS `t_footprint`;

CREATE TABLE `t_footprint` (
  `footprint_id` int unsigned NOT NULL AUTO_INCREMENT,
  `region_id` int unsigned DEFAULT NULL,
  `footprint_ownner` int unsigned NOT NULL,
  `footprint_permission` enum('private','public') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'public',
  `footprint_trip_date` datetime DEFAULT NULL,
  PRIMARY KEY (`footprint_id`),
  KEY `footprint_ownner` (`footprint_ownner`),
  KEY `region_id` (`region_id`),
  CONSTRAINT `t_footprint_ibfk_2` FOREIGN KEY (`region_id`) REFERENCES `t_region` (`id`),
  CONSTRAINT `t_footprint_ibfk_3` FOREIGN KEY (`footprint_ownner`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Created By 古学懂';

/*Table structure for table `t_footprint_dtl` */

DROP TABLE IF EXISTS `t_footprint_dtl`;

CREATE TABLE `t_footprint_dtl` (
  `footprint_id` int unsigned NOT NULL,
  `footprint_content` text CHARACTER SET utf8 COLLATE utf8_bin,
  `footprint_header` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`footprint_id`),
  CONSTRAINT `t_footprint_dtl_ibfk_1` FOREIGN KEY (`footprint_id`) REFERENCES `t_footprint` (`footprint_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Created By 古学懂';

/*Table structure for table `t_graphic_introduction` */

DROP TABLE IF EXISTS `t_graphic_introduction`;

CREATE TABLE `t_graphic_introduction` (
  `graphic_id` int unsigned NOT NULL AUTO_INCREMENT,
  `produce_id` int unsigned NOT NULL,
  `graphic_introduction_content` varchar(2083) NOT NULL,
  `graphic_type` int NOT NULL,
  PRIMARY KEY (`graphic_id`),
  KEY `t_graphic_introduction_ibfk_1` (`produce_id`),
  CONSTRAINT `t_graphic_introduction_ibfk_1` FOREIGN KEY (`produce_id`) REFERENCES `t_produce` (`produce_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Table structure for table `t_note` */

DROP TABLE IF EXISTS `t_note`;

CREATE TABLE `t_note` (
  `note_id` int unsigned NOT NULL AUTO_INCREMENT,
  `note_author` int unsigned NOT NULL DEFAULT '1000',
  `note_permission` enum('private','public') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'public',
  `note_post_date` datetime NOT NULL DEFAULT '2000-01-01 00:00:00',
  `favorite_count` int unsigned NOT NULL DEFAULT '0',
  `like_count` int unsigned NOT NULL DEFAULT '0',
  `comment_count` int unsigned NOT NULL DEFAULT '0',
  `travel_date` date DEFAULT '2000-01-01' COMMENT '出行日期',
  `applicable` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '适用人群',
  `postDateStr` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `end_date` date DEFAULT '2000-01-01' COMMENT '结束日期',
  `sdf` tinyblob,
  PRIMARY KEY (`note_id`),
  UNIQUE KEY `note_id` (`note_id`),
  KEY `note_author` (`note_author`),
  CONSTRAINT `FKjlj2h9pvo0shyc3wr8xywy9wv` FOREIGN KEY (`note_author`) REFERENCES `t_user` (`user_id`),
  CONSTRAINT `t_note_ibfk_1` FOREIGN KEY (`note_author`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1142 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Created By 古学懂';

/*Table structure for table `t_note_comment` */

DROP TABLE IF EXISTS `t_note_comment`;

CREATE TABLE `t_note_comment` (
  `comment_id` int unsigned NOT NULL AUTO_INCREMENT,
  `comment_content` text CHARACTER SET utf8 COLLATE utf8_bin,
  `note_id` int unsigned NOT NULL,
  `comment_post_date` datetime NOT NULL,
  `comment_author` int unsigned NOT NULL,
  PRIMARY KEY (`comment_id`,`note_id`),
  KEY `comment_note_id` (`note_id`),
  KEY `comment_author` (`comment_author`),
  CONSTRAINT `t_note_comment_ibfk_1` FOREIGN KEY (`note_id`) REFERENCES `t_note` (`note_id`),
  CONSTRAINT `t_note_comment_ibfk_2` FOREIGN KEY (`comment_author`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Created By 古学懂';

/*Table structure for table `t_note_dtl` */

DROP TABLE IF EXISTS `t_note_dtl`;

CREATE TABLE `t_note_dtl` (
  `note_id` int NOT NULL,
  `note_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `note_header` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `note_toppic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`note_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Table structure for table `t_note_region` */

DROP TABLE IF EXISTS `t_note_region`;

CREATE TABLE `t_note_region` (
  `region_id` int NOT NULL,
  `note_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Created By 古学懂';

/*Table structure for table `t_produce` */

DROP TABLE IF EXISTS `t_produce`;

CREATE TABLE `t_produce` (
  `produce_id` int unsigned NOT NULL AUTO_INCREMENT,
  `produce_title` varchar(100) NOT NULL,
  `produce_telephone` bigint NOT NULL,
  `produce_lindisfarne` varchar(10) NOT NULL,
  `produce_cost_day` int NOT NULL,
  `produce_min_price` int NOT NULL,
  `produce_max_price` int NOT NULL,
  PRIMARY KEY (`produce_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `t_produce_cost` */

DROP TABLE IF EXISTS `t_produce_cost`;

CREATE TABLE `t_produce_cost` (
  `produce_id` int unsigned NOT NULL,
  `cost_id` int unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cost_id`),
  KEY `t_produce_cost_ibfk_1` (`produce_id`),
  CONSTRAINT `t_produce_cost_ibfk_1` FOREIGN KEY (`produce_id`) REFERENCES `t_produce` (`produce_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `t_produce_status` */

DROP TABLE IF EXISTS `t_produce_status`;

CREATE TABLE `t_produce_status` (
  `produce_id` int unsigned NOT NULL,
  `produce_is_appring` enum('unchecked','pass','nopass') NOT NULL DEFAULT 'unchecked',
  KEY `produce_id` (`produce_id`),
  CONSTRAINT `t_produce_status_ibfk_1` FOREIGN KEY (`produce_id`) REFERENCES `t_produce` (`produce_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_region` */

DROP TABLE IF EXISTS `t_region`;

CREATE TABLE `t_region` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` int unsigned DEFAULT '0' COMMENT '父ID',
  `path` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '路径',
  `level` int unsigned DEFAULT NULL COMMENT '层级',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '中文名称',
  `name_en` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '英文名称',
  `name_pinyin` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '中文拼音',
  `code` varchar(50) DEFAULT NULL COMMENT '代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4170 DEFAULT CHARSET=utf8 COMMENT='全球地区库，采集自腾讯QQ国内+国际版.ADD.JENA.20141221';

/*Table structure for table `t_scenery` */

DROP TABLE IF EXISTS `t_scenery`;

CREATE TABLE `t_scenery` (
  `scenery_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '景点id（主键）',
  `scenery_pid` int unsigned DEFAULT NULL COMMENT '父景点id',
  `scenery_author` int unsigned NOT NULL COMMENT '发布者id【用户id】',
  `scenery_region` int unsigned NOT NULL COMMENT '所在地区id*【地区id】',
  `scenery_ispublish` enum('true','false') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT 'false' COMMENT '是否发布标识',
  `scenery_ischecked` enum('unchecked','pass','nopass') COLLATE utf8mb4_bin NOT NULL DEFAULT 'unchecked',
  `scenery_publish_time` datetime NOT NULL COMMENT '最新发布时间',
  `scenery_click` int unsigned NOT NULL DEFAULT '0' COMMENT '景点点击量',
  PRIMARY KEY (`scenery_id`),
  KEY `fk_scenery_pid` (`scenery_pid`),
  KEY `fk_scenery_author` (`scenery_author`),
  KEY `fk_scenery_region` (`scenery_region`),
  CONSTRAINT `fk_scenery_pid` FOREIGN KEY (`scenery_pid`) REFERENCES `t_scenery` (`scenery_id`),
  CONSTRAINT `fk_scenery_region` FOREIGN KEY (`scenery_region`) REFERENCES `t_region` (`id`),
  CONSTRAINT `t_scenery_ibfk_1` FOREIGN KEY (`scenery_author`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='景点表';

/*Table structure for table `t_scenery_content` */

DROP TABLE IF EXISTS `t_scenery_content`;

CREATE TABLE `t_scenery_content` (
  `scenery_content_id` int unsigned NOT NULL COMMENT '景点内容id（主键）【景点id】',
  `scenery_content_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '景点名称',
  `scenery_content_dtl` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '景点内容信息',
  `scenery_content_location` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '景点地址',
  `scenery_content_email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '景点邮箱',
  `scenery_content_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '景点电话',
  PRIMARY KEY (`scenery_content_id`),
  CONSTRAINT `fk_scenery_content_id` FOREIGN KEY (`scenery_content_id`) REFERENCES `t_scenery` (`scenery_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='景点内容表';

/*Table structure for table `t_scenery_review` */

DROP TABLE IF EXISTS `t_scenery_review`;

CREATE TABLE `t_scenery_review` (
  `scenery_review_id` int unsigned NOT NULL COMMENT '景点id（主键）【景点id】',
  `user_review_id` int unsigned NOT NULL COMMENT '评分者id（主键）【用户id】',
  `scenery_review_score` enum('1','2','3','4','5') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '评分',
  `scenery_review_dtl` datetime NOT NULL COMMENT '点评内容',
  `scenery_review_time` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '点评时间',
  `scenery_review_author` int DEFAULT NULL,
  PRIMARY KEY (`scenery_review_id`,`user_review_id`),
  KEY `fk_user_score_id` (`user_review_id`),
  CONSTRAINT `fk_scenery_review` FOREIGN KEY (`user_review_id`) REFERENCES `t_user` (`user_id`),
  CONSTRAINT `fk_scenery_score_id` FOREIGN KEY (`scenery_review_id`) REFERENCES `t_scenery` (`scenery_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='景点点评表';

/*Table structure for table `t_topic` */

DROP TABLE IF EXISTS `t_topic`;

CREATE TABLE `t_topic` (
  `topic_id` int unsigned NOT NULL AUTO_INCREMENT,
  `interest_count` int NOT NULL DEFAULT '0',
  `topic_creator` int unsigned NOT NULL,
  PRIMARY KEY (`topic_id`),
  KEY `topic_creator` (`topic_creator`),
  CONSTRAINT `t_topic_ibfk_1` FOREIGN KEY (`topic_creator`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Created By 古学懂';

/*Table structure for table `t_topic_dtl` */

DROP TABLE IF EXISTS `t_topic_dtl`;

CREATE TABLE `t_topic_dtl` (
  `topic_id` int unsigned NOT NULL,
  `topic_header` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `topic_content` text CHARACTER SET utf8 COLLATE utf8_bin,
  PRIMARY KEY (`topic_id`),
  CONSTRAINT `t_topic_dtl_ibfk_1` FOREIGN KEY (`topic_id`) REFERENCES `t_topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Created By 古学懂';

/*Table structure for table `t_trader_apply` */

DROP TABLE IF EXISTS `t_trader_apply`;

CREATE TABLE `t_trader_apply` (
  `t_trader_id` int unsigned NOT NULL AUTO_INCREMENT,
  `t_trader_username` varchar(100) DEFAULT NULL,
  `t_trader_company` varchar(255) DEFAULT NULL COMMENT '公司',
  `t_trader_phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `t_trader_status` tinyint DEFAULT '0' COMMENT '状态(0正常/1禁言/2待审核)',
  PRIMARY KEY (`t_trader_id`),
  UNIQUE KEY `t_trader_id_UNIQUE` (`t_trader_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_emile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8;

/*Table structure for table `t_user_info` */

DROP TABLE IF EXISTS `t_user_info`;

CREATE TABLE `t_user_info` (
  `user_id` int unsigned NOT NULL,
  `user_birth` date DEFAULT NULL,
  `user_sex` enum('male','female','unknown','other') CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_intro` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  CONSTRAINT `t_user_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_user_permissions` */

DROP TABLE IF EXISTS `t_user_permissions`;

CREATE TABLE `t_user_permissions` (
  `user_id` int unsigned NOT NULL,
  `t_user_permissionscol` int unsigned NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_vote` */

DROP TABLE IF EXISTS `t_vote`;

CREATE TABLE `t_vote` (
  `vote_id` int unsigned NOT NULL AUTO_INCREMENT,
  `voter` int unsigned DEFAULT NULL,
  `vote_dtl` enum('up','down','null') CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'null',
  `vote_answer` int unsigned DEFAULT NULL,
  PRIMARY KEY (`vote_id`),
  KEY `voter` (`voter`),
  KEY `vote_answer` (`vote_answer`),
  CONSTRAINT `t_vote_ibfk_2` FOREIGN KEY (`vote_answer`) REFERENCES `t_answer` (`answer_id`),
  CONSTRAINT `t_vote_ibfk_3` FOREIGN KEY (`voter`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Created By 古学懂';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
