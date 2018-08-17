-- ----------------------------
-- Table structure for `coverage`
-- ----------------------------
DROP TABLE IF EXISTS `coverage`;
CREATE TABLE `coverage` (
    `id` int(11) NOT NULL AUTO_INCREMENT, 
    `pro_name` varchar(255) NOT NULL, 
    `pro_version` varchar(255) NOT NULL, 
    `is_increment` int(11) NOT NULL, -- 是否增量，1为增量，0为全量
    `base_version` varchar(255) DEFAULT NULL,
    `createtimestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `bundle`
-- ----------------------------
DROP TABLE IF EXISTS `bundle`;
CREATE TABLE `bundle` (
    `id` int(11) NOT NULL AUTO_INCREMENT, 
    `coverage_id` int(11) DEFAULT NULL, 
    `bundle_name` varchar(255) DEFAULT NULL, 
    `instruction_coverd` int(11) DEFAULT NULL,
    `instruction_notcoverd` int(11) DEFAULT NULL,
    `instruction_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `instruction_percent` DOUBLE(5,2) DEFAULT NULL,
    `branch_coverd` int(11) DEFAULT NULL,
    `branch_notcoverd` int(11) DEFAULT NULL,
    `branch_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `branch_percent` DOUBLE(5,2) DEFAULT NULL,
    `complexity_coverd` int(11) DEFAULT NULL,
    `complexity_notcoverd` int(11) DEFAULT NULL,
    `complexity_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `line_coverd` int(11) DEFAULT NULL,
    `line_notcoverd` int(11) DEFAULT NULL,
    `line_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `method_coverd` int(11) DEFAULT NULL,
    `method_notcoverd` int(11) DEFAULT NULL,
    `method_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `class_coverd` int(11) DEFAULT NULL,
    `class_notcoverd` int(11) DEFAULT NULL,
    `class_coverdradio` DOUBLE(5,2) DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `fk_bundle_coverage` (`coverage_id`),
CONSTRAINT `fk_bundle_coverage` FOREIGN KEY (`coverage_id`) REFERENCES `coverage` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `session`
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session` (
    `id` int(11) NOT NULL AUTO_INCREMENT, 
    `coverage_id` int(11) NOT NULL,
    `session_id` varchar(255) NOT NULL,
    `starttimestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `dumptimestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
KEY `fk_session_coverage` (`coverage_id`),
CONSTRAINT `fk_session_coverage` FOREIGN KEY (`coverage_id`) REFERENCES `coverage` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `package`
-- ----------------------------
DROP TABLE IF EXISTS `package`;
CREATE TABLE `package` (
    `id` int(11) NOT NULL AUTO_INCREMENT, 
    `bundle_id` int(11) NOT NULL,
    `package_name` varchar(255) NOT NULL, 
    `instruction_coverd` int(11) NOT NULL,
    `instruction_notcoverd` int(11) NOT NULL,
    `instruction_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `instruction_percent` DOUBLE(5,2) DEFAULT NULL,
    `branch_coverd` int(11) NOT NULL,
    `branch_notcoverd` int(11) NOT NULL,
    `branch_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `branch_percent` DOUBLE(5,2) DEFAULT NULL,
    `complexity_coverd` int(11) NOT NULL,
    `complexity_notcoverd` int(11) NOT NULL,
    `complexity_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `line_coverd` int(11) NOT NULL,
    `line_notcoverd` int(11) NOT NULL,
    `line_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `method_coverd` int(11) NOT NULL,
    `method_notcoverd` int(11) NOT NULL,
    `method_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `class_coverd` int(11) NOT NULL,
    `class_notcoverd` int(11) NOT NULL,
    `class_coverdradio` DOUBLE(5,2) DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `fk_package_bundle` (`bundle_id`),
CONSTRAINT `fk_package_bundle` FOREIGN KEY (`bundle_id`) REFERENCES `bundle` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
    `id` int(11) NOT NULL AUTO_INCREMENT, 
    `package_id` int(11) NOT NULL,
    `class_name` varchar(255) NOT NULL, 
    `instruction_coverd` int(11) NOT NULL,
    `instruction_notcoverd` int(11) NOT NULL,
    `instruction_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `instruction_percent` DOUBLE(5,2) DEFAULT NULL,
    `branch_coverd` int(11) NOT NULL,
    `branch_notcoverd` int(11) NOT NULL,
    `branch_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `branch_percent` DOUBLE(5,2) DEFAULT NULL,
    `complexity_coverd` int(11) NOT NULL,
    `complexity_notcoverd` int(11) NOT NULL,
    `complexity_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `line_coverd` int(11) NOT NULL,
    `line_notcoverd` int(11) NOT NULL,
    `line_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `method_coverd` int(11) NOT NULL,
    `method_notcoverd` int(11) NOT NULL,
    `method_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `class_coverd` int(11) NOT NULL,
    `class_notcoverd` int(11) NOT NULL,
    `class_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `class_content` longtext NOT NULL,
PRIMARY KEY (`id`),
KEY `fk_class_package` (`package_id`),
CONSTRAINT `fk_class_package` FOREIGN KEY (`package_id`) REFERENCES `package` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `method`
-- ----------------------------
DROP TABLE IF EXISTS `method`;
CREATE TABLE `method` (
    `id` int(11) NOT NULL AUTO_INCREMENT, 
    `class_id` int(11) NOT NULL,
    `method_name` varchar(255) NOT NULL, 
    `instruction_coverd` int(11) NOT NULL,
    `instruction_notcoverd` int(11) NOT NULL,
    `instruction_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `instruction_percent` DOUBLE(5,2) DEFAULT NULL,
    `branch_coverd` int(11) NOT NULL,
    `branch_notcoverd` int(11) NOT NULL,
    `branch_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `branch_percent` DOUBLE(5,2) DEFAULT NULL,
    `complexity_coverd` int(11) NOT NULL,
    `complexity_notcoverd` int(11) NOT NULL,
    `complexity_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `line_coverd` int(11) NOT NULL,
    `line_notcoverd` int(11) NOT NULL,
    `line_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `method_coverd` int(11) NOT NULL,
    `method_notcoverd` int(11) NOT NULL,
    `method_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `class_coverd` int(11) NOT NULL,
    `class_notcoverd` int(11) NOT NULL,
    `class_coverdradio` DOUBLE(5,2) DEFAULT NULL,
    `firstline` int(11) NOT NULL,
    `lastline` int(11) NOT NULL,
PRIMARY KEY (`id`),
KEY `fk_method_class` (`class_id`),
CONSTRAINT `fk_method_class` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;