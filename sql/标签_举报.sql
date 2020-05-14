create database travel_system;

CREATE  TABLE IF NOT EXISTS `travel_system`.`t_label_detail` (
  `id_id` INT NOT NULL ,
  `id_content` VARCHAR(20) NULL ,
  PRIMARY KEY (`id_id`) 
)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `travel_system`.`t_lable_scenery` (
  `scenery_content_id` INT NOT NULL ,
  `id_id` INT NULL ,
  PRIMARY KEY (`scenery_content_id`)
-- Foreign Key (`scenery_content_id`) references `t_scenery_content`(`scenery_content_id`)
)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `travel_system`.`t_feed` (
  `user_id` INT NOT NULL ,
  `beuser_id` INT NOT NULL ,
  `feed_content` varchar(40) null,
  PRIMARY KEY (`user_id`) 
)
ENGINE = InnoDB;
