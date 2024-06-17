-- Active: 1717080256825@@127.0.0.1@3306@joeun
CREATE TABLE product (
    no     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id     CHAR(36) NOT NULL DEFAULT (UUID()),
    name   VARCHAR(100) NOT NULL,
    price  INT NOT NULL DEFAULT 0,
    img    TEXT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);




CREATE TABLE board(
  no        INT             NOT NULL AUTO_INCREMENT COMMENT '게시판 번호',
  title     VARCHAR(100)    NOT NULL COMMENT '게시판 제목',
  writer    VARCHAR(100)    NOT NULL  COMMENT '게시판 작성자',
  content   TEXT            NULL COMMENT '게시판 내용',
  reg_date  TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '게시판 등록일자',
  upd_date  TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '게시판 수정일자',
  PRIMARY KEY (no)
) COMMENT '게시판';

INSERT INTO board (title, writer, content)
VALUES
('첫 번째 게시물', '작성자1', '이것은 첫 번째 게시물의 내용입니다.'),
('두 번째 게시물', '작성자2', '이것은 두 번째 게시물의 내용입니다.'),
('세 번째 게시물', '작성자3', '이것은 세 번째 게시물의 내용입니다.'),
('네 번째 게시물', '작성자4', '이것은 네 번째 게시물의 내용입니다.'),
('다섯 번째 게시물', '작성자5', '이것은 다섯 번째 게시물의 내용입니다.'),
('여섯 번째 게시물', '작성자6', '이것은 여섯 번째 게시물의 내용입니다.'),
('일곱 번째 게시물', '작성자7', '이것은 일곱 번째 게시물의 내용입니다.'),
('여덟 번째 게시물', '작성자8', '이것은 여덟 번째 게시물의 내용입니다.'),
('아홉 번째 게시물', '작성자9', '이것은 아홉 번째 게시물의 내용입니다.'),
('열 번째 게시물', '작성자10', '이것은 열 번째 게시물의 내용입니다.');







 UPDATE todo
           SET name = adss
              ,upd_date = now()
        WHERE no = 1

CREATE TABLE `todo` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `status` int DEFAULT '0',
  `reg_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `upd_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`no`)
) COMMENT='할일';

INSERT INTO `todo` (`name`, `status`, `reg_date`, `upd_date`) VALUES 
('아침 운동하기', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('출근 준비하기', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('회의 참석하기', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('점심 식사하기', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('업무 보고서 작성하기', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('저녁 운동하기', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('친구 만나기', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('영화 보기', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('책 읽기', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('잠자기', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 샘플 데이터
INSERT INTO product(name, price, img)
VALUES
('상품01', 11000, 'https://placehold.co/300x200'),
('상품02', 12000, 'https://placehold.co/300x200'),
('상품03', 13000, 'https://placehold.co/300x200'),
('상품04', 14000, 'https://placehold.co/300x200'),
('상품05', 15000, 'https://placehold.co/300x200'),
('상품06', 16000, 'https://placehold.co/300x200'),
('상품07', 17000, 'https://placehold.co/300x200'),
('상품08', 18000, 'https://placehold.co/300x200'),
('상품09', 19000, 'https://placehold.co/300x200'),
('상품10', 20000, 'https://placehold.co/300x200')
;