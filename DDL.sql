-- category;
CREATE TABLE `category` (
   `category_id` int NOT NULL AUTO_INCREMENT COMMENT '카테고리 id',
   `category_name` varchar(20) NOT NULL COMMENT '카테고리 명',
   `category_type` varchar(1) NOT NULL COMMENT 'O:옵션, A:패키지, C:카테고리',
   PRIMARY KEY (`category_id`),
   KEY `idx_category_type` (`category_type`)
 ) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 
-- chat_message;
CREATE TABLE `chat_message` (
   `msg_id` int NOT NULL AUTO_INCREMENT COMMENT '채팅 id',
   `send_id` varchar(50) NOT NULL COMMENT '전송자 id',
   `chat_room_id` int NOT NULL COMMENT '채팅방 id',
   `msg_content` varchar(100) NOT NULL COMMENT '채팅 내용',
   `msg_send_date` date NOT NULL COMMENT '전송일자',
   `msg_status` varchar(1) DEFAULT 'U' COMMENT 'U:안읽음, R:읽음, S:전송됨',
   PRIMARY KEY (`msg_id`),
   KEY `idx_chat_message_send_id` (`send_id`),
   KEY `idx_chat_message_chat_room_id` (`chat_room_id`),
   CONSTRAINT `fk_msg_chat_room` FOREIGN KEY (`chat_room_id`) REFERENCES `chat_room` (`chat_room_id`),
   CONSTRAINT `fk_msg_send_id` FOREIGN KEY (`send_id`) REFERENCES `user` (`user_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 
-- chat_room;
CREATE TABLE `chat_room` (
   `chat_room_id` int NOT NULL AUTO_INCREMENT COMMENT '채팅방 id',
   `chat_guid_id` varchar(50) NOT NULL COMMENT '가이드 id',
   `chat_guest_id` varchar(50) NOT NULL COMMENT '손님 id',
   PRIMARY KEY (`chat_room_id`),
   KEY `idx_chat_room_chat_guest_id` (`chat_guest_id`),
   KEY `idx_chat_room_chat_guid_id` (`chat_guid_id`),
   CONSTRAINT `fk_chat_guest_id` FOREIGN KEY (`chat_guest_id`) REFERENCES `user` (`user_id`),
   CONSTRAINT `fk_chat_guid_id` FOREIGN KEY (`chat_guid_id`) REFERENCES `user` (`user_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 
-- city;
CREATE TABLE `city` (
   `city_id` int NOT NULL AUTO_INCREMENT COMMENT '시 id',
   `city_name` varchar(10) NOT NULL COMMENT '시 명',
   `region_id` int NOT NULL COMMENT '도 id',
   PRIMARY KEY (`city_id`,`region_id`),
   KEY `idx_city_name` (`city_name`),
   KEY `idx_city_region_id` (`region_id`),
   CONSTRAINT `city_ibfk_1` FOREIGN KEY (`region_id`) REFERENCES `region` (`region_id`) ON DELETE CASCADE
 ) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 
-- region;
CREATE TABLE `region` (
   `region_id` int NOT NULL AUTO_INCREMENT COMMENT '도 id',
   `region_name` varchar(10) NOT NULL COMMENT '도 명',
   PRIMARY KEY (`region_id`),
   KEY `idx_region_name` (`region_name`)
 ) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 
-- reservation;
CREATE TABLE `reservation` (
   `reservation_id` int NOT NULL AUTO_INCREMENT COMMENT '예약 id',
   `tour_id` int NOT NULL COMMENT '투어 id',
   `reservater` varchar(50) NOT NULL COMMENT '예약자 id',
   `start_date` date NOT NULL COMMENT '예약 시작일',
   `end_date` date NOT NULL COMMENT '예약 종료일',
   `reservation_people` int NOT NULL COMMENT '예약 인원',
   `reservation_pay` int NOT NULL COMMENT '예약 가격',
   `reservation_status` varchar(1) DEFAULT 'P' COMMENT 'P:대기, A:승인, C:취소',
   PRIMARY KEY (`reservation_id`),
   KEY `idx_reservation_tour_id` (`tour_id`),
   KEY `idx_reservation_user_id` (`reservater`),
   CONSTRAINT `fk_reservation_tour_id` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`tour_id`),
   CONSTRAINT `fk_reservation_user_id` FOREIGN KEY (`reservater`) REFERENCES `user` (`user_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 
-- review;
CREATE TABLE `review` (
   `reservation_id` int NOT NULL COMMENT '예약 id',
   `review_content` varchar(50) DEFAULT NULL COMMENT '리뷰 내용',
   `review_score` int DEFAULT NULL COMMENT '리뷰 점수',
   PRIMARY KEY (`reservation_id`),
   KEY `idx_review_reservation_id` (`reservation_id`),
   CONSTRAINT `fk_review_reservation_id` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 
-- tour;
CREATE TABLE `tour` (
   `tour_id` int NOT NULL AUTO_INCREMENT COMMENT '투어 id',
   `guid_name` varchar(50) NOT NULL COMMENT '가이드 id',
   `title` varchar(30) NOT NULL COMMENT '투어 명',
   `people_cnt` int NOT NULL COMMENT '투어 인원',
   `pay` int NOT NULL COMMENT '투어 가격',
   `notice` varchar(30) DEFAULT NULL COMMENT '투어 주의사항',
   `meet_address` varchar(50) DEFAULT NULL COMMENT '투어 만남 장소',
   `meet_latitude` varchar(30) DEFAULT NULL COMMENT '투어 만남 위도',
   `meet_longitude` varchar(30) DEFAULT NULL COMMENT '투어 만남 경도',
   `main_img_url` varchar(100) DEFAULT NULL COMMENT '투어 메인 이미지 URL',
   `city_id` int DEFAULT NULL COMMENT '시 id',
   `region_id` int DEFAULT NULL COMMENT '도 id',
   `need_date` int DEFAULT NULL COMMENT '투어 기간',
   `tour_content` varchar(500) DEFAULT NULL COMMENT '투어 내용',
   PRIMARY KEY (`tour_id`,`guid_name`),
   KEY `idx_tour_guid_name` (`guid_name`),
   KEY `idx_tour_city_id` (`city_id`),
   KEY `idx_tour_region_id` (`region_id`),
   CONSTRAINT `fk_tour_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`),
   CONSTRAINT `fk_tour_guid_id` FOREIGN KEY (`guid_name`) REFERENCES `user` (`user_id`),
   CONSTRAINT `fk_tour_region` FOREIGN KEY (`region_id`) REFERENCES `region` (`region_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 
-- tour_activity;
CREATE TABLE `tour_activity` (
   `act_id` int NOT NULL AUTO_INCREMENT COMMENT '활동 id',
   `tour_id` int NOT NULL COMMENT '투어 id',
   `category_id` int NOT NULL COMMENT '카테고리 id',
   `act_name` varchar(50) NOT NULL COMMENT '활동 명',
   `act_contents` varchar(100) NOT NULL COMMENT '활동 내용',
   `act_address` varchar(50) NOT NULL COMMENT '활동 장소',
   `act_latitude` varchar(30) NOT NULL COMMENT '활동 위도',
   `act_longitude` varchar(30) NOT NULL COMMENT '활동 경도',
   `act_img_url` varchar(100) DEFAULT NULL COMMENT '활동 이미지 URL',
   PRIMARY KEY (`act_id`,`category_id`,`tour_id`),
   KEY `idx_tour_activity_tour_id` (`tour_id`),
   KEY `idx_tour_activity_category_id` (`category_id`),
   CONSTRAINT `fk_activity_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
   CONSTRAINT `fk_activity_tour` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`tour_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 
-- tour_category;
CREATE TABLE `tour_category` (
   `tour_id` int NOT NULL COMMENT '투어 id',
   `category_id` int NOT NULL COMMENT '카테고리 id',
   PRIMARY KEY (`category_id`,`tour_id`),
   KEY `fk_category_tour_id` (`tour_id`),
   CONSTRAINT `fk_category_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
   CONSTRAINT `fk_category_tour_id` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`tour_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 
-- tour_option;
CREATE TABLE `tour_option` (
   `tour_id` int NOT NULL COMMENT '투어 id',
   `category_id` int NOT NULL COMMENT '카테고리 id',
   PRIMARY KEY (`category_id`,`tour_id`),
   KEY `idx_tour_option_tour_id` (`tour_id`),
   KEY `idx_tour_option_category_id` (`category_id`),
   CONSTRAINT `fk_option_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
   CONSTRAINT `fk_option_tour` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`tour_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 
-- user;
CREATE TABLE `user` (
   `user_id` varchar(50) NOT NULL COMMENT '사용자 id',
   `user_nickname` varchar(30) NOT NULL COMMENT '사용자 닉네임',
   `user_email` varchar(50) NOT NULL COMMENT '사용자 이메일',
   `user_phone_number` varchar(30) NOT NULL COMMENT '사용자 전화번호',
   `user_gender` varchar(1) NOT NULL COMMENT '사용자 성별',
   `user_birth` varchar(10) NOT NULL COMMENT '사용자 생년월일',
   `user_age_group` varchar(10) NOT NULL COMMENT '사용자 연령대',
   PRIMARY KEY (`user_id`),
   KEY `idx_user_email` (`user_email`),
   KEY `idx_user_phone_number` (`user_phone_number`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 
-- user_fcm_token;
CREATE TABLE `user_fcm_token` (
   `user_id` varchar(50) NOT NULL COMMENT '사용자 id',
   `fcm_token` varchar(100) NOT NULL COMMENT 'fcm 토큰',
   `is_active` varchar(1) NOT NULL DEFAULT 'F' COMMENT '알림 활성화 여부',
   PRIMARY KEY (`user_id`),
   KEY `idx_user_fcm_token_is_active` (`is_active`),
   CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 

-- tour_option_view;
CREATE ALGORITHM=UNDEFINED DEFINER=`ssafy`@`%` SQL SECURITY DEFINER VIEW `tour_option_view` AS select `tc`.`tour_id` AS `tour_id`,`tc`.`category_id` AS `category_id`,`c`.`category_name` AS `option_name`,`c`.`category_type` AS `option_type` from (`tour_option` `tc` left join `category` `c` on((`tc`.`category_id` = `c`.`category_id`))) where (`c`.`category_type` = 'O');

-- tour_category_view;
CREATE ALGORITHM=UNDEFINED DEFINER=`ssafy`@`%` SQL SECURITY DEFINER VIEW `tour_category_view` AS select `tc`.`tour_id` AS `tour_id`,`tc`.`category_id` AS `category_id`,`c`.`category_name` AS `category_name`,`c`.`category_type` AS `category_type` from (`tour_category` `tc` left join `category` `c` on((`tc`.`category_id` = `c`.`category_id`))) where (`c`.`category_type` = 'C');

-- tour_activity_view;
CREATE ALGORITHM=UNDEFINED DEFINER=`ssafy`@`%` SQL SECURITY DEFINER VIEW `tour_activity_view` AS select `ta`.`act_id` AS `act_id`,`ta`.`tour_id` AS `tour_id`,`ta`.`category_id` AS `category_id`,`ta`.`act_name` AS `act_name`,`ta`.`act_contents` AS `act_contents`,`ta`.`act_address` AS `act_address`,`ta`.`act_latitude` AS `act_latitude`,`ta`.`act_longitude` AS `act_longitude`,`ta`.`act_img_url` AS `act_img_url`,`c`.`category_name` AS `activity_name`,`c`.`category_type` AS `activity_type` from (`tour_activity` `ta` left join `category` `c` on((`ta`.`category_id` = `c`.`category_id`))) where (`c`.`category_type` = 'A');

-- tour_review_summary;
CREATE ALGORITHM=UNDEFINED DEFINER=`ssafy`@`%` SQL SECURITY DEFINER VIEW `tour_review_summary` AS select `rs`.`tour_id` AS `tour_id`,`rs`.`reservation_id` AS `reservation_id`,`rs`.`reservater` AS `reservater`,`rs`.`start_date` AS `start_date`,`rs`.`end_date` AS `end_date`,`rs`.`reservation_people` AS `reservation_people`,`rs`.`reservation_pay` AS `reservation_pay`,`rs`.`reservation_status` AS `reservation_status`,`rv`.`review_content` AS `review_content`,`rv`.`review_score` AS `review_score`,(select round(avg(`rv_inner`.`review_score`),1) from (`review` `rv_inner` join `reservation` `rs_inner` on((`rv_inner`.`reservation_id` = `rs_inner`.`reservation_id`))) where (`rs_inner`.`tour_id` = `rs`.`tour_id`)) AS `average_review_score` from (`reservation` `rs` left join `review` `rv` on((`rs`.`reservation_id` = `rv`.`reservation_id`)));



