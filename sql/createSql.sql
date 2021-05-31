CREATE TABLE `magic_api_file`
(
    `id`           bigint(255) NOT NULL AUTO_INCREMENT,
    `file_path`    varchar(255) DEFAULT NULL,
    `file_content` text,
    PRIMARY KEY (`id`)
)

CREATE TABLE `pms_brand` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `big_pic` varchar(255) DEFAULT NULL,
                             `brand_story` varchar(255) DEFAULT NULL,
                             `factory_status` bit(1) DEFAULT NULL,
                             `first_letter` varchar(255) DEFAULT NULL,
                             `logo` varchar(255) DEFAULT NULL,
                             `name` varchar(255) DEFAULT NULL,
                             `product_comment_count` int(11) DEFAULT NULL,
                             `product_count` int(11) DEFAULT NULL,
                             `show_status` bit(1) DEFAULT NULL,
                             `sort` int(11) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;