CREATE TABLE `chorusbot`.`member` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `chorusbot`.`group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `group` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `chorusbot`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time` DATETIME NOT NULL,
  `content` VARCHAR(45) NOT NULL,
  `event_type_id` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `chorusbot`.`position` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `position` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `chorusbot`.`type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `chorusbot`.`status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `chorusbot`.`event_group` (
  `event_id` INT NOT NULL,
  `group_id` INT NOT NULL,
  INDEX `event_id_idx` (`event_id` ASC),
  INDEX `group_id_idx` (`group_id` ASC),
  CONSTRAINT `id_event`
    FOREIGN KEY (`event_id`)
    REFERENCES `chorusbot`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_group`
    FOREIGN KEY (`group_id`)
    REFERENCES `chorusbot`.`group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `chorusbot`.`member_group` (
  `member_id` INT NOT NULL,
  `group_id` INT NOT NULL,
  INDEX `member_id_idx` (`member_id` ASC),
  INDEX `group_id_idx` (`group_id` ASC),
  CONSTRAINT `member_id`
    FOREIGN KEY (`member_id`)
    REFERENCES `chorusbot`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `group_id`
    FOREIGN KEY (`group_id`)
    REFERENCES `chorusbot`.`group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `chorusbot`.`member_status` (
  `member_id` INT NOT NULL,
  `status_id` INT NOT NULL,
  INDEX `member_id_idx` (`member_id` ASC),
  INDEX `status_id_idx` (`status_id` ASC),
  CONSTRAINT `id_member`
    FOREIGN KEY (`member_id`)
    REFERENCES `chorusbot`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_status`
    FOREIGN KEY (`status_id`)
    REFERENCES `chorusbot`.`status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `chorusbot`.`position_member` (
  `member_id` INT NOT NULL,
  `position_id` INT NOT NULL,
  INDEX `id_position_idx` (`member_id` ASC),
  INDEX `id_member_idx` (`position_id` ASC),
  CONSTRAINT `position`
    FOREIGN KEY (`member_id`)
    REFERENCES `chorusbot`.`position` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `member`
    FOREIGN KEY (`position_id`)
    REFERENCES `chorusbot`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);





