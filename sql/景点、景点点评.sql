CREATE DATABASE `travel_system` ;
USE `travel_system`;

DROP TABLE IF EXISTS `t_scenery`;
DROP TABLE IF EXISTS `t_scenery_content`;
DROP TABLE IF EXISTS `t_scenery_comment`;

/*
create table `t_user`(
	`user_id` int unsigned NOT NULL primary key,
    `user_name` varchar(20)
);#测试用用户表
*/

/*
create table `t_region`(
	`region_id` int unsigned NOT NULL primary key,
    `region_name` varchar(20)
);#测试用地区表测试
*/

create table `t_scenery`(/*景点表*/
	`scenery_id` int unsigned NOT NULL AUTO_INCREMENT,/*景点id（主键）*/
    `scenery_pid` int unsigned default NULL,/*父景点id*/
    `scenery_author` int unsigned NOT NULL,/*发布者id【用户id】*/
    `scenery_region` int unsigned NOT NULL,/*所在地区id*【地区id】*/
    `scenery_ispublish` enum('true','false') NOT NULL default 'false',/*是否发布标识*/
    `sceenry_ischecked` enum('unchecked','pass','nopass') NOT NULL default 'unchecked',
    `scenery_publish_time` datetime NOT NULL,/*最新发布时间*/
    `scenery_click` int unsigned NOT NULL default 0,/*景点点击量*/

    constraint pk_scenery_id primary key (`scenery_id`),

	constraint fk_scenery_pid foreign key (`scenery_pid`) references t_scenery(`scenery_id`),
    constraint fk_scenery_author foreign key (`scenery_author`) references t_user(`user_id`),
    constraint fk_scenery_region foreign key (`scenery_region`) references t_region(`region_id`)
    
);

create table `t_scenery_content`(/*景点内容表*/
	`scenery_content_id` int unsigned NOT NULL,/*景点内容id（主键）【景点id】*/
    `scenery_content_name` varchar(45),/*景点名称*/
    `scenery_content_dtl` text NOT NULL collate utf8_bin,/*景点内容信息*/
    `scenery_content_location` text NOT NULL collate utf8_bin,/*景点地址*/
    `scenery_content_email` varchar(45),/*景点邮箱*/
    `scenery_content_phone` varchar(20),/*景点电话*/

    constraint pk_scenery_content_id primary key (`scenery_content_id`),

    constraint fk_scenery_content_id foreign key (`scenery_content_id`) references t_scenery(`scenery_id`)

);

create table `t_scenery_review`(/*景点点评表*/
	`scenery_review_id` int unsigned NOT NULL,/*景点id（主键）【景点id】*/
    `user_review_id` int unsigned NOT NULL,/*评分者id（主键）【用户id】*/
    `scenery_review_score` enum('1','2','3','4','5') NOT NULL,/*评分*/
    `scenery_review_dtl` datetime NOT NULL,/*点评内容*/
    `scenery_review_time` text NOT NULL collate utf8_bin,/*点评时间*/

    constraint pk_scenery_score_id primary key (`scenery_review_id`,`user_review_id`),

    constraint fk_scenery_score_id foreign key (`scenery_review_id`) references t_scenery(`scenery_id`),
    constraint fk_user_score_id foreign key (`user_review_id`) references t_user(`user_id`)

);
