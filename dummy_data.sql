use with_localhost;

-- region 데이터 넣기
INSERT INTO region (region_name)
VALUES 
    ('서울특별시'),
    ('부산광역시'),
    ('대구광역시'),
    ('인천광역시'),
    ('광주광역시'),
    ('대전광역시'),
    ('울산광역시'),
    ('세종특별자치시'),
    ('경기도'),
    ('강원도'),
    ('충청북도'),
    ('충청남도'),
    ('전라북도'),
    ('전라남도'),
    ('경상북도'),
    ('경상남도'),
    ('제주특별자치도');
    
-- 시 데이터 넣기    
INSERT INTO city (city_name, region_id)
VALUES 
    -- 서울특별시 (region_id: 1)
    ('서울', 1),

    -- 부산광역시 (region_id: 2)
    ('부산', 2),

    -- 대구광역시 (region_id: 3)
    ('대구', 3),

    -- 인천광역시 (region_id: 4)
    ('인천', 4),

    -- 광주광역시 (region_id: 5)
    ('광주', 5),

    -- 대전광역시 (region_id: 6)
    ('대전', 6),

    -- 울산광역시 (region_id: 7)
    ('울산', 7),

    -- 세종특별자치시 (region_id: 8)
    ('세종', 8),

    -- 경기도 (region_id: 9)
    ('수원시', 9), ('고양시', 9), ('용인시', 9), ('성남시', 9), 
    ('부천시', 9), ('화성시', 9), ('남양주시', 9), ('안산시', 9), 
    ('안양시', 9), ('평택시', 9), ('의정부시', 9), ('파주시', 9), 
    ('시흥시', 9), ('김포시', 9), ('광명시', 9), ('광주시', 9), 
    ('군포시', 9), ('오산시', 9), ('이천시', 9), ('하남시', 9),
    ('안성시', 9), ('양주시', 9), ('구리시', 9), ('포천시', 9),
    ('의왕시', 9), ('여주시', 9), ('동두천시', 9), ('과천시', 9),

    -- 강원도 (region_id: 10)
    ('춘천시', 10), ('원주시', 10), ('강릉시', 10), ('동해시', 10),
    ('속초시', 10), ('삼척시', 10), ('홍천군', 10), ('태백시', 10),
    ('철원군', 10), ('화천군', 10), ('양구군', 10), ('인제군', 10),
    ('고성군', 10), ('양양군', 10),

    -- 충청북도 (region_id: 11)
    ('청주시', 11), ('충주시', 11), ('제천시', 11), ('보은군', 11),
    ('옥천군', 11), ('영동군', 11), ('증평군', 11), ('진천군', 11),
    ('괴산군', 11), ('음성군', 11), ('단양군', 11),

    -- 충청남도 (region_id: 12)
    ('천안시', 12), ('공주시', 12), ('보령시', 12), ('아산시', 12),
    ('서산시', 12), ('논산시', 12), ('계룡시', 12), ('당진시', 12),
    ('금산군', 12), ('부여군', 12), ('서천군', 12), ('청양군', 12),
    ('홍성군', 12), ('예산군', 12), ('태안군', 12),

    -- 전라북도 (region_id: 13)
    ('전주시', 13), ('군산시', 13), ('익산시', 13), ('정읍시', 13),
    ('남원시', 13), ('김제시', 13), ('완주군', 13), ('진안군', 13),
    ('무주군', 13), ('장수군', 13), ('임실군', 13), ('순창군', 13),
    ('고창군', 13), ('부안군', 13),

    -- 전라남도 (region_id: 14)
    ('목포시', 14), ('여수시', 14), ('순천시', 14), ('나주시', 14),
    ('광양시', 14), ('담양군', 14), ('곡성군', 14), ('구례군', 14),
    ('고흥군', 14), ('보성군', 14), ('화순군', 14), ('장흥군', 14),
    ('강진군', 14), ('해남군', 14), ('영암군', 14), ('무안군', 14),
    ('함평군', 14), ('영광군', 14), ('장성군', 14), ('완도군', 14),
    ('진도군', 14), ('신안군', 14),

    -- 경상북도 (region_id: 15)
    ('포항시', 15), ('경주시', 15), ('김천시', 15), ('안동시', 15),
    ('구미시', 15), ('영주시', 15), ('영천시', 15), ('상주시', 15),
    ('문경시', 15), ('경산시', 15), ('군위군', 15), ('의성군', 15),
    ('청송군', 15), ('영양군', 15), ('영덕군', 15), ('청도군', 15),
    ('고령군', 15), ('성주군', 15), ('칠곡군', 15), ('예천군', 15),
    ('봉화군', 15), ('울진군', 15), ('울릉군', 15),

    -- 경상남도 (region_id: 16)
    ('창원시', 16), ('김해시', 16), ('진주시', 16), ('양산시', 16),
    ('거제시', 16), ('통영시', 16), ('사천시', 16), ('밀양시', 16),
    ('함안군', 16), ('창녕군', 16), ('의령군', 16), ('고성군', 16),
    ('하동군', 16), ('남해군', 16), ('산청군', 16), ('함양군', 16),
    ('거창군', 16), ('합천군', 16),

    -- 제주특별자치도 (region_id: 17)
    ('제주시', 17), ('서귀포시', 17);


-- 카테고리 더미 데이터
INSERT INTO category (category_name, category_type)
VALUES 
    -- O: 옵션
    ('차량여부', 'O'), ('외국어 사용가능 여부', 'O'), ('Wi-Fi 가능 여부', 'O'), 
    ('에어컨 유무', 'O'), ('음식 반입 가능 여부', 'O'), ('주차 가능 여부', 'O'), 
    ('장애인 편의시설 유무', 'O'), ('반려동물 동반 가능 여부', 'O'), ('야외 활동 가능 여부', 'O'), 
    ('지정 좌석 여부', 'O'), ('사진 촬영 가능 여부', 'O'), ('음악 제공 여부', 'O'), 
    ('무료 이용 여부', 'O'), ('VIP 서비스 제공 여부', 'O'), ('스포츠 장비 대여 가능 여부', 'O'), 
    ('가이드 포함 여부', 'O'), ('고급 옵션 제공 여부', 'O'), ('현장 결제 가능 여부', 'O'), 
    ('미리 예약 필요 여부', 'O'), ('단체 할인 가능 여부', 'O'),

    -- C: 카테고리
    ('여행', 'C'), ('관광', 'C'), ('먹방', 'C'), ('레저', 'C'), ('휴양', 'C'), 
    ('체험', 'C'), ('문화', 'C'), ('스포츠', 'C'), ('자연', 'C'), ('쇼핑', 'C'), 
    ('유적지 탐방', 'C'), ('테마파크', 'C'), ('낚시', 'C'), ('온천', 'C'), ('캠핑', 'C'), 
    ('등산', 'C'), ('바다 여행', 'C'), ('도심 여행', 'C'), ('역사 탐방', 'C'), ('축제 참여', 'C'),

    -- A: 패키지
    ('식사', 'A'), ('산책', 'A'), ('드라이브', 'A'), ('카페 방문', 'A'), ('스파', 'A'), 
    ('테마파크 입장', 'A'), ('레저 활동', 'A'), ('공연 관람', 'A'), ('유람선 여행', 'A'), 
    ('박물관 관람', 'A'), ('마을 투어', 'A'), ('야외 바비큐', 'A'), ('자전거 투어', 'A'), 
    ('아침 식사 제공', 'A'), ('저녁 식사 포함', 'A'), ('럭셔리 호텔 숙박', 'A'), 
    ('와인 시음', 'A'), ('특산물 체험', 'A'), ('미술관 탐방', 'A'), ('쿠킹 클래스', 'A');




select * from city order by city_id asc;
select * from user;
    
INSERT INTO user (user_id, user_nickname, user_email, user_phone_number, user_gender, user_birth, user_age_group)
VALUES 
    ('johndoe91', '이준호', 'johndoe91@example.com', '010-1111-2222', 'M', '1991-04-12', '30대'),
    ('minji123', '김민지', 'minji123@example.com', '010-2233-3344', 'F', '1987-08-25', '30대'),
    ('hansolo97', '박한솔', 'hansolo97@example.com', '010-3344-4455', 'M', '1997-02-03', '20대'),
    ('suji0210', '이수지', 'suji0210@example.com', '010-4455-5566', 'F', '1993-12-22', '20대'),
    ('david1980', '김대일', 'david1980@example.com', '010-5566-6677', 'M', '1980-05-14', '40대');


-- 투어 데이터 삽입
INSERT INTO tour (guid_name, title, people_cnt, pay, notice, meet_address, meet_latitude, meet_longitude, main_img_url, city_id, region_id, need_date)
VALUES
('david1980', '서울 시내 투어', 10, 50000, '편안한 복장 착용 권장', '서울시 중구', '37.5665', '126.9780', 'http://example.com/img1.jpg', 1, 1, 3),
('hansolo97', '강릉 해변 투어', 15, 70000, '수영복 준비 필수', '강릉시', '37.7518', '128.8760', 'http://example.com/img2.jpg', 2, 2, 2),
('johndoe91', '제주도 자연 탐방', 8, 90000, '장비는 가이드가 준비합니다', '제주시', '33.4996', '126.5312', 'http://example.com/img3.jpg', 3, 3, 5),
('minji123', '부산 야경 투어', 20, 40000, '따뜻한 옷을 준비하세요', '부산시 해운대구', '35.1796', '129.0756', 'http://example.com/img4.jpg', 4, 4, 4);

-- 투어 옵션 중간 테이블에 데이터 삽입
INSERT INTO tour_option (tour_id, category_id)
VALUES
(1, 1),  -- 서울 시내 투어와 차량여부
(1, 3),  -- 서울 시내 투어와 Wi-Fi 가능 여부
(2, 5),  -- 강릉 해변 투어와 음식 반입 가능 여부
(2, 8),  -- 강릉 해변 투어와 반려동물 동반 가능 여부
(3, 7),  -- 제주도 자연 탐방과 장애인 편의시설 유무
(3, 9),  -- 제주도 자연 탐방과 야외 활동 가능 여부
(4, 4),  -- 부산 야경 투어와 에어컨 유무
(4, 12);  -- 부산 야경 투어와 음악 제공 여부

-- 투어 카테고리 데이터 삽입
INSERT INTO tour_category (tour_id, category_id)
VALUES
(1, 21),  -- 서울 시내 투어와 여행
(1, 22),  -- 서울 시내 투어와 관광
(2, 37),  -- 강릉 해변 투어와 바다 여행
(2, 23),  -- 강릉 해변 투어와 먹방
(3, 29),  -- 제주도 자연 탐방과 자연
(3, 27),  -- 제주도 자연 탐방과 문화
(4, 38),  -- 부산 야경 투어와 도심 여행
(4, 40);  -- 부산 야경 투어와 축제 참여

-- 투어 활동 데이터 삽입
INSERT INTO tour_activity (tour_id, category_id, act_name, act_contents, act_address, act_latitude, act_longitude)
VALUES
(1, 21, '서울 한강 자전거 투어', '한강 자전거 도로를 따라 서울을 탐방하는 활동', '서울시 한강', '37.5145', '127.0246'),
(2, 37, '강릉 해변 산책', '해변을 따라 산책하며 경치를 즐기는 활동', '강릉 해변', '37.7518', '128.8760'),
(3, 29, '제주도 한라산 등반', '한라산을 오르며 제주도의 자연을 체험하는 활동', '제주 한라산', '33.3634', '126.5292'),
(4, 38, '부산 광안리 야경 감상', '광안리 해수욕장에서 부산의 야경을 즐기는 활동', '부산 광안리', '35.1540', '129.1180');
    
    INSERT INTO user (user_id, user_nickname, user_email, user_phone_number, user_gender, user_birth, user_age_group)
VALUES 
    ('johndoe91', '이준호', 'johndoe91@example.com', '010-1111-2222', 'M', '1991-04-12', '30대'),
    ('minji123', '김민지', 'minji123@example.com', '010-2233-3344', 'F', '1987-08-25', '30대'),
    ('hansolo97', '박한솔', 'hansolo97@example.com', '010-3344-4455', 'M', '1997-02-03', '20대'),
    ('suji0210', '이수지', 'suji0210@example.com', '010-4455-5566', 'F', '1993-12-22', '20대'),
    ('david1980', '김대일', 'david1980@example.com', '010-5566-6677', 'M', '1980-05-14', '40대');

    
    
    -- 예약 데이터 삽입
INSERT INTO reservation (tour_id, reservater, start_date, end_date, reservation_people, reservation_pay, reservation_status)
VALUES
(1, 'minji123', '2024-11-25', '2024-11-27', 4, 200000, 'A'), -- 서울 시내 투어 예약
(1, 'hansolo97', '2024-12-01', '2024-12-03', 3, 150000, 'A'),
(1, 'suji0210', '2024-12-10', '2024-12-12', 2, 100000, 'A'),

(2, 'hansolo97', '2024-11-20', '2024-11-22', 6, 420000, 'A'), -- 강릉 해변 투어 예약
(2, 'suji0210', '2024-12-05', '2024-12-07', 5, 350000, 'A'),
(2, 'david1980', '2024-12-15', '2024-12-17', 4, 280000, 'A'),

(3, 'minji123', '2024-11-22', '2024-11-24', 3, 270000, 'A'), -- 제주도 자연 탐방 예약
(3, 'johndoe91', '2024-12-03', '2024-12-05', 2, 180000, 'A'),
(3, 'david1980', '2024-12-12', '2024-12-14', 5, 450000, 'A'),

(4, 'david1980', '2024-11-28', '2024-11-30', 8, 320000, 'A'), -- 부산 야경 투어 예약
(4, 'hansolo97', '2024-12-08', '2024-12-10', 7, 280000, 'A'),
(4, 'minji123', '2024-12-18', '2024-12-20', 6, 240000, 'A');


select * from reservation;
select * from review;
-- 리뷰 데이터 삽입
-- 리뷰 데이터 삽입
INSERT INTO review (reservation_id, review_content, review_score)
VALUES
(13, '서울 시내 투어 아주 좋았어요', 5), -- 예약 ID 13
(14, '강릉 해변 투어 매우 만족', 4), -- 예약 ID 14
(15, '제주도 자연 탐방 좋았어요', 4), -- 예약 ID 15
(16, '부산 야경 투어 정말 멋졌습니다', 5), -- 예약 ID 16

(17, '서울 시내 투어 재밌었어요', 4), -- 예약 ID 17
(18, '강릉 해변 투어 너무 좋았어요', 5), -- 예약 ID 18
(19, '제주도 자연 탐방 기대 이상이었어요', 5), -- 예약 ID 19
(20, '부산 야경 투어 조금 아쉬웠어요', 3), -- 예약 ID 20

(21, '서울 시내 투어 아쉬운 점이 있었습니다', 3), -- 예약 ID 21
(22, '강릉 해변 투어 너무 좋았습니다', 4), -- 예약 ID 22
(23, '제주도 자연 탐방 좀 더 보고 싶었어요', 4), -- 예약 ID 23
(24, '부산 야경 투어 기대 이상이었어요', 5), -- 예약 ID 24

(25, '서울 시내 투어 훌륭한 경험이었습니다', 5), -- 예약 ID 25
(26, '강릉 해변 투어 아쉽지만 좋았어요', 4), -- 예약 ID 26
(27, '제주도 자연 탐방 정말 즐거웠어요', 5), -- 예약 ID 27
(28, '부산 야경 투어 최고였어요', 5), -- 예약 ID 28

(29, '서울 시내 투어 좋은 경험이었습니다', 4), -- 예약 ID 29
(30, '강릉 해변 투어 좋았지만 더 좋을 수 있었어요', 3), -- 예약 ID 30
(31, '제주도 자연 탐방 아쉽네요', 3), -- 예약 ID 31
(32, '부산 야경 투어 멋진 야경을 봤습니다', 5), -- 예약 ID 32

(33, '서울 시내 투어 재밌었어요', 4), -- 예약 ID 33
(34, '강릉 해변 투어 정말 좋았어요', 5), -- 예약 ID 34
(35, '제주도 자연 탐방 기대 이상이었어요', 5), -- 예약 ID 35
(36, '부산 야경 투어 멋졌어요', 4); -- 예약 ID 36





INSERT INTO tour_activity (tour_id, category_id, act_name, act_contents, act_address, act_latitude, act_longitude) VALUES
(1, 41, '전통 한식 식사', '맛있는 전통 한식을 제공', '서울시 강남구', '37.5665', '126.9780'),
(1, 42, '도심 산책', '서울의 공원에서 산책을 즐겨보세요', '서울시 여의도', '37.5245', '126.9470'),
(1, 43, '드라이브 코스', '한적한 도로에서의 드라이브', '서울시 강동구', '37.5295', '127.1380'),
(2, 44, '카페 방문', '서울의 유명 카페에서 차 한잔', '서울시 홍대', '37.5500', '126.9220'),
(2, 45, '스파 체험', '편안한 스파로 힐링 시간', '서울시 신사동', '37.5145', '127.0270'),
(2, 46, '테마파크 입장', '가족과 함께 테마파크에서 즐거운 시간', '경기도 용인시', '37.2410', '127.0550'),
(3, 47, '레저 활동', '스릴 넘치는 레저 활동', '경기도 양평군', '37.4610', '127.5250'),
(3, 48, '공연 관람', '서울의 유명 공연장에서 공연을 즐기세요', '서울시 종로구', '37.5720', '126.9785'),
(3, 49, '유람선 여행', '한강에서 유람선 여행을 즐겨보세요', '서울시 여의도', '37.5240', '126.9700'),
(4, 50, '박물관 관람', '서울의 역사적인 박물관을 탐방', '서울시 용산구', '37.5310', '126.9800'),
(4, 51, '마을 투어', '전통 마을에서의 문화 탐방', '경기도 안성시', '37.0355', '127.2750'),
(4, 52, '야외 바비큐', '자연 속에서 즐기는 바비큐 파티', '서울시 송파구', '37.5120', '127.1065');
