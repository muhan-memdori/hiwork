-- 게시글 정보
DROP TABLE IF EXISTS `cms_bList` RESTRICT;

-- 회사정보
DROP TABLE IF EXISTS `cms_cInfo` RESTRICT;

-- 팀 목록
DROP TABLE IF EXISTS `cms_tList` RESTRICT;

-- 사원
DROP TABLE IF EXISTS `cms_worker` RESTRICT;

-- 권한
DROP TABLE IF EXISTS `cms_auth` RESTRICT;

-- 휴가 신청
DROP TABLE IF EXISTS `cms_vApp` RESTRICT;

-- 휴가 종류 
DROP TABLE IF EXISTS `cms_vKind` RESTRICT;

-- 댓글 정보
DROP TABLE IF EXISTS `cms_cmtInfo` RESTRICT;

-- 대화방
DROP TABLE IF EXISTS `cms_cRoom` RESTRICT;

-- 일정
DROP TABLE IF EXISTS `cms_calender` RESTRICT;

-- 게시판
DROP TABLE IF EXISTS `cms_category` RESTRICT;

-- 대화
DROP TABLE IF EXISTS `cms_chat` RESTRICT;

-- 대화방참여자
DROP TABLE IF EXISTS `cms_cGroup` RESTRICT;

-- 회사연혁
DROP TABLE IF EXISTS `cms_cHistory` RESTRICT;

-- 지사 목록
DROP TABLE IF EXISTS `cms_brList` RESTRICT;

-- 게시글 정보
CREATE TABLE `cms_bList` (
  `bNo`      INTEGER     NOT NULL, -- 게시글번호
  `ctNo`     INTEGER     NOT NULL, -- 게시판번호
  `wNo`      INTEGER     NOT NULL, -- 사원 번호
  `title`    VARCHAR(50) NOT NULL, -- 제목
  `regiDate` DATE        NOT NULL DEFAULT now(), -- 등록일
  `vCount`   INTEGER     NOT NULL, -- 조회수
  `aFile`    VARCHAR(50) NULL,     -- 첨부파일명
  `fSize`    INTEGER     NULL,     -- 첨부파일 용량
  `content`  MEDIUMTEXT  NULL,     -- 글내용
  `status`   INTEGER     NOT NULL DEFAULT 1 -- 활성상태
);

-- 게시글 정보
ALTER TABLE `cms_bList`
  ADD CONSTRAINT `PK_cms_bList` -- 게시글 정보 기본키
    PRIMARY KEY (
      `bNo` -- 게시글번호
    );

ALTER TABLE `cms_bList`
  MODIFY COLUMN `bNo` INTEGER NOT NULL AUTO_INCREMENT;

-- 회사정보
CREATE TABLE `cms_cInfo` (
  `crNo`   INTEGER      NOT NULL, -- 법인등록번호
  `cName`  VARCHAR(50)  NOT NULL, -- 회사명
  `map`    MEDIUMTEXT   NOT NULL, -- 지도
  `postNo` INTEGER      NOT NULL, -- 우편번호
  `addr`   VARCHAR(255) NOT NULL, -- 주소
  `tel`    VARCHAR(30)  NOT NULL, -- 전화번호
  `fax`    VARCHAR(30)  NOT NULL  -- 팩스번호
);

-- 회사정보
ALTER TABLE `cms_cInfo`
  ADD CONSTRAINT `PK_cms_cInfo` -- 회사정보 기본키
    PRIMARY KEY (
      `crNo` -- 법인등록번호
    );

-- 팀 목록
CREATE TABLE `cms_tList` (
  `tCode` VARCHAR(20) NOT NULL, -- 팀 코드
  `crNo`  INTEGER     NOT NULL, -- 법인등록번호
  `tName` VARCHAR(50) NOT NULL  -- 팀 이름
);

-- 팀 목록
ALTER TABLE `cms_tList`
  ADD CONSTRAINT `PK_cms_tList` -- 팀 목록 기본키
    PRIMARY KEY (
      `tCode` -- 팀 코드
    );

-- 사원
CREATE TABLE `cms_worker` (
  `wNo`      INTEGER      NOT NULL, -- 사원 번호
  `aCode`    INTEGER      NOT NULL, -- 권한 코드
  `tCode`    VARCHAR(20)  NULL,     -- 팀 코드
  `wName`    VARCHAR(50)  NOT NULL, -- 사원이름
  `email`    VARCHAR(40)  NOT NULL, -- 이메일
  `wPhoto`   VARCHAR(255) NOT NULL, -- 사원사진
  `rank`     MEDIUMTEXT   NOT NULL, -- 직급
  `eType`    MEDIUMTEXT   NOT NULL, -- 고용형태
  `regiDate` DATE         NOT NULL DEFAULT now(), -- 입사일
  `tel`      INTEGER      NOT NULL, -- 휴대폰번호
  `gender`   INTEGER      NOT NULL, -- 성별
  `tAnnu`    INTEGER      NOT NULL, -- 총 연차
  `pwd`      VARCHAR(255) NOT NULL, -- 비밀번호
  `eSt`      INTEGER      NOT NULL, -- 재직 상태
  `status`   INTEGER      NOT NULL DEFAULT 1 -- 활성상태
);

-- 사원
ALTER TABLE `cms_worker`
  ADD CONSTRAINT `PK_cms_worker` -- 사원 기본키
    PRIMARY KEY (
      `wNo` -- 사원 번호
    );

-- 이메일
CREATE UNIQUE INDEX `UIX_cms_worker`
  ON `cms_worker` ( -- 사원
    `email` ASC -- 이메일
  );

-- 휴대폰번호
CREATE UNIQUE INDEX `UIX_cms_worker2`
  ON `cms_worker` ( -- 사원
    `tel` ASC -- 휴대폰번호
  );

ALTER TABLE `cms_worker`
  MODIFY COLUMN `wNo` INTEGER NOT NULL AUTO_INCREMENT;

-- 권한
CREATE TABLE `cms_auth` (
  `aCode` INTEGER     NOT NULL, -- 권한 코드
  `name`  VARCHAR(50) NOT NULL  -- 권한명
);

-- 권한
ALTER TABLE `cms_auth`
  ADD CONSTRAINT `PK_cms_auth` -- 권한 기본키
    PRIMARY KEY (
      `aCode` -- 권한 코드
    );

-- 권한 유니크 인덱스
CREATE UNIQUE INDEX `UIX_cms_auth`
  ON `cms_auth` ( -- 권한
    `name` ASC -- 권한명
  );

-- 휴가 신청
CREATE TABLE `cms_vApp` (
  `vNo`   INTEGER     NOT NULL, -- 휴가신청번호
  `vCode` VARCHAR(20) NOT NULL, -- 휴가 코드
  `wNo`   INTEGER     NOT NULL, -- 사원 번호
  `adt`   DATE        NOT NULL, -- 신청일
  `sdt`   DATE        NOT NULL DEFAULT now(), -- 시작일
  `edt`   DATE        NOT NULL, -- 종료일
  `used`  INTEGER     NOT NULL, -- 사용연차일수
  `rs`    MEDIUMTEXT  NOT NULL, -- 신청사유
  `appr`  BOOLEAN     NOT NULL DEFAULT 0 -- 승인여부
);

-- 휴가 신청
ALTER TABLE `cms_vApp`
  ADD CONSTRAINT `PK_cms_vApp` -- 휴가 신청 기본키
    PRIMARY KEY (
      `vNo` -- 휴가신청번호
    );

-- 휴가 종류 
CREATE TABLE `cms_vKind` (
  `vCode` VARCHAR(20) NOT NULL, -- 휴가 코드
  `name`  VARCHAR(50) NOT NULL  -- 휴가명
);

-- 휴가 종류 
ALTER TABLE `cms_vKind`
  ADD CONSTRAINT `PK_cms_vKind` -- 휴가 종류  기본키
    PRIMARY KEY (
      `vCode` -- 휴가 코드
    );

-- 댓글 정보
CREATE TABLE `cms_cmtInfo` (
  `cNo`     INTEGER    NOT NULL, -- 댓글 번호
  `bNo`     INTEGER    NOT NULL, -- 게시글번호
  `stage`   INTEGER    NOT NULL, -- 단계
  `content` MEDIUMTEXT NOT NULL, -- 내용
  `rdt`     DATE       NOT NULL DEFAULT now(), -- 등록일
  `wNo`     INTEGER    NOT NULL, -- 사원 번호
  `momNo`   INTEGER    NULL,     -- 부모 댓글
  `status`  INTEGER    NOT NULL DEFAULT 1 -- 상태
);

-- 댓글 정보
ALTER TABLE `cms_cmtInfo`
  ADD CONSTRAINT `PK_cms_cmtInfo` -- 댓글 정보 기본키
    PRIMARY KEY (
      `cNo` -- 댓글 번호
    );

-- 대화방
CREATE TABLE `cms_cRoom` (
  `gChatNo` INTEGER     NOT NULL, -- 대화방번호
  `cName`   VARCHAR(50) NOT NULL, -- 채팅방명
  `cExpl`   MEDIUMTEXT  NULL      -- 채팅방설명
);

-- 대화방
ALTER TABLE `cms_cRoom`
  ADD CONSTRAINT `PK_cms_cRoom` -- 대화방 기본키
    PRIMARY KEY (
      `gChatNo` -- 대화방번호
    );

-- 일정
CREATE TABLE `cms_calender` (
  `calNo`   INTEGER      NOT NULL, -- 일정 번호
  `wNo`     INTEGER      NOT NULL, -- 사원 번호
  `title`   VARCHAR(50)  NOT NULL, -- 제목
  `sdt`     DATE         NOT NULL, -- 시작일
  `edt`     DATE         NOT NULL, -- 종료일
  `content` MEDIUMTEXT   NOT NULL, -- 내용
  `place`   VARCHAR(255) NULL      -- 장소
);

-- 일정
ALTER TABLE `cms_calender`
  ADD CONSTRAINT `PK_cms_calender` -- 일정 기본키
    PRIMARY KEY (
      `calNo` -- 일정 번호
    );

-- 게시판
CREATE TABLE `cms_category` (
  `ctNo`   INTEGER     NOT NULL, -- 게시판번호
  `ctName` VARCHAR(50) NOT NULL  -- 게시판명
);

-- 게시판
ALTER TABLE `cms_category`
  ADD CONSTRAINT `PK_cms_category` -- 게시판 기본키
    PRIMARY KEY (
      `ctNo` -- 게시판번호
    );

-- 대화
CREATE TABLE `cms_chat` (
  `cNo`      INTEGER     NOT NULL, -- 대화번호
  `wNo`      INTEGER     NOT NULL, -- 사원 번호
  `gChatNo`  INTEGER     NOT NULL, -- 대화방번호
  `cContent` MEDIUMTEXT  NOT NULL, -- 메시지
  `cName`    VARCHAR(50) NOT NULL, -- 메시지유형
  `cDate`    DATE        NOT NULL DEFAULT now() -- 생성일
);

-- 대화
ALTER TABLE `cms_chat`
  ADD CONSTRAINT `PK_cms_chat` -- 대화 기본키
    PRIMARY KEY (
      `cNo` -- 대화번호
    );

-- 대화방참여자
CREATE TABLE `cms_cGroup` (
  `wNo`     INTEGER NOT NULL, -- 사원 번호
  `gChatNo` INTEGER NOT NULL  -- 대화방번호
);

-- 대화방참여자
ALTER TABLE `cms_cGroup`
  ADD CONSTRAINT `PK_cms_cGroup` -- 대화방참여자 기본키
    PRIMARY KEY (
      `wNo`,     -- 사원 번호
      `gChatNo`  -- 대화방번호
    );

-- 회사연혁
CREATE TABLE `cms_cHistory` (
  `crhNo`    INTEGER    NOT NULL, -- 회사연혁번호
  `crNo`     INTEGER    NOT NULL, -- 법인등록번호
  `crhTitle` INTEGER    NOT NULL, -- 연혁 년도
  `content`  MEDIUMTEXT NOT NULL  -- 연혁 내용
);

-- 회사연혁
ALTER TABLE `cms_cHistory`
  ADD CONSTRAINT `PK_cms_cHistory` -- 회사연혁 기본키
    PRIMARY KEY (
      `crhNo` -- 회사연혁번호
    );

-- 지사 목록
CREATE TABLE `cms_brList` (
  `brCode` VARCHAR(20) NOT NULL, -- 지사 코드
  `crNo`   INTEGER     NOT NULL, -- 법인등록번호
  `brName` VARCHAR(50) NOT NULL  -- 지사이름
);

-- 지사 목록
ALTER TABLE `cms_brList`
  ADD CONSTRAINT `PK_cms_brList` -- 지사 목록 기본키
    PRIMARY KEY (
      `brCode` -- 지사 코드
    );

-- 게시글 정보
ALTER TABLE `cms_bList`
  ADD CONSTRAINT `FK_cms_category_TO_cms_bList` -- 게시판 -> 게시글 정보
    FOREIGN KEY (
      `ctNo` -- 게시판번호
    )
    REFERENCES `cms_category` ( -- 게시판
      `ctNo` -- 게시판번호
    );

-- 게시글 정보
ALTER TABLE `cms_bList`
  ADD CONSTRAINT `FK_cms_worker_TO_cms_bList` -- 사원 -> 게시글 정보
    FOREIGN KEY (
      `wNo` -- 사원 번호
    )
    REFERENCES `cms_worker` ( -- 사원
      `wNo` -- 사원 번호
    );

-- 팀 목록
ALTER TABLE `cms_tList`
  ADD CONSTRAINT `FK_cms_cInfo_TO_cms_tList` -- 회사정보 -> 팀 목록
    FOREIGN KEY (
      `crNo` -- 법인등록번호
    )
    REFERENCES `cms_cInfo` ( -- 회사정보
      `crNo` -- 법인등록번호
    );

-- 사원
ALTER TABLE `cms_worker`
  ADD CONSTRAINT `FK_cms_auth_TO_cms_worker` -- 권한 -> 사원
    FOREIGN KEY (
      `aCode` -- 권한 코드
    )
    REFERENCES `cms_auth` ( -- 권한
      `aCode` -- 권한 코드
    );

-- 사원
ALTER TABLE `cms_worker`
  ADD CONSTRAINT `FK_cms_tList_TO_cms_worker` -- 팀 목록 -> 사원
    FOREIGN KEY (
      `tCode` -- 팀 코드
    )
    REFERENCES `cms_tList` ( -- 팀 목록
      `tCode` -- 팀 코드
    );

-- 휴가 신청
ALTER TABLE `cms_vApp`
  ADD CONSTRAINT `FK_cms_vKind_TO_cms_vApp` -- 휴가 종류  -> 휴가 신청
    FOREIGN KEY (
      `vCode` -- 휴가 코드
    )
    REFERENCES `cms_vKind` ( -- 휴가 종류 
      `vCode` -- 휴가 코드
    );

-- 휴가 신청
ALTER TABLE `cms_vApp`
  ADD CONSTRAINT `FK_cms_worker_TO_cms_vApp` -- 사원 -> 휴가 신청
    FOREIGN KEY (
      `wNo` -- 사원 번호
    )
    REFERENCES `cms_worker` ( -- 사원
      `wNo` -- 사원 번호
    );

-- 댓글 정보
ALTER TABLE `cms_cmtInfo`
  ADD CONSTRAINT `FK_cms_bList_TO_cms_cmtInfo` -- 게시글 정보 -> 댓글 정보
    FOREIGN KEY (
      `bNo` -- 게시글번호
    )
    REFERENCES `cms_bList` ( -- 게시글 정보
      `bNo` -- 게시글번호
    );

-- 댓글 정보
ALTER TABLE `cms_cmtInfo`
  ADD CONSTRAINT `FK_cms_worker_TO_cms_cmtInfo` -- 사원 -> 댓글 정보
    FOREIGN KEY (
      `wNo` -- 사원 번호
    )
    REFERENCES `cms_worker` ( -- 사원
      `wNo` -- 사원 번호
    );

-- 일정
ALTER TABLE `cms_calender`
  ADD CONSTRAINT `FK_cms_worker_TO_cms_calender` -- 사원 -> 일정
    FOREIGN KEY (
      `wNo` -- 사원 번호
    )
    REFERENCES `cms_worker` ( -- 사원
      `wNo` -- 사원 번호
    );

-- 대화
ALTER TABLE `cms_chat`
  ADD CONSTRAINT `FK_cms_cGroup_TO_cms_chat` -- 대화방참여자 -> 대화
    FOREIGN KEY (
      `wNo`,     -- 사원 번호
      `gChatNo`  -- 대화방번호
    )
    REFERENCES `cms_cGroup` ( -- 대화방참여자
      `wNo`,     -- 사원 번호
      `gChatNo`  -- 대화방번호
    );

-- 대화방참여자
ALTER TABLE `cms_cGroup`
  ADD CONSTRAINT `FK_cms_worker_TO_cms_cGroup` -- 사원 -> 대화방참여자
    FOREIGN KEY (
      `wNo` -- 사원 번호
    )
    REFERENCES `cms_worker` ( -- 사원
      `wNo` -- 사원 번호
    );

-- 대화방참여자
ALTER TABLE `cms_cGroup`
  ADD CONSTRAINT `FK_cms_cRoom_TO_cms_cGroup` -- 대화방 -> 대화방참여자
    FOREIGN KEY (
      `gChatNo` -- 대화방번호
    )
    REFERENCES `cms_cRoom` ( -- 대화방
      `gChatNo` -- 대화방번호
    );

-- 회사연혁
ALTER TABLE `cms_cHistory`
  ADD CONSTRAINT `FK_cms_cInfo_TO_cms_cHistory` -- 회사정보 -> 회사연혁
    FOREIGN KEY (
      `crNo` -- 법인등록번호
    )
    REFERENCES `cms_cInfo` ( -- 회사정보
      `crNo` -- 법인등록번호
    );

-- 지사 목록
ALTER TABLE `cms_brList`
  ADD CONSTRAINT `FK_cms_cInfo_TO_cms_brList` -- 회사정보 -> 지사 목록
    FOREIGN KEY (
      `crNo` -- 법인등록번호
    )
    REFERENCES `cms_cInfo` ( -- 회사정보
      `crNo` -- 법인등록번호
    );
    
-- 권한 예제데이터
insert into cms_auth(aCode, name)
values(0, '사원');

insert into cms_auth(aCode, name)
values(1, '인사');

insert into cms_auth(aCode, name)
values(9, '관리자');

-- 회사정보 예제데이터
insert into cms_cInfo(crNo, cName, map, postNo, addr, tel, fax)
values(1248100998, '하이워크', '1', '1234', '서울특별시 서초구 신논현', '02-1111-1111', '02-3333-3333');

-- 팀목록 예제데이터
insert into cms_tList(tCode, crNo, tName)
values('1', '1248100998', '개발팀');
insert into cms_tList(tCode, crNo, tName)
values('2', '1248100998', '인사팀');
insert into cms_tList(tCode, crNo, tName)
values('3', '1248100998', '영양팀');
insert into cms_tList(tCode, crNo, tName)
values('9', '1248100998', '관리팀');


-- 사원 예제데이터
insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(1, 0, '1', '김태희', 'aaa@test.com', '태희.jpg', '사장', '계약직',
'2020-07-13', '01092628654', '2', '12', '1111', 0);

insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(2, 1, '2', '홍길동', 'bbb@test.com', '길동.jpg', '사원', '계약직',
'2020-07-13', '01011111111', '1', '13', '1111', 0);

insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(3, 9, '9', '임꺽정', 'ccc@test.com', '꺽정.jpg', '대리', '정규직',
'2020-07-13', '01022222222', '1', '12', '1111', 0);

insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(4, 9, '9', '나퇴근', 'ddd@test.com', '퇴근.jpg', '대리', '정규직',
'2020-07-13', '01033333333', '1', '12', '1111', 1);

insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(5, 0, '3', '박영양', 'eee@test.com', '영양.jpg', '주임', '정규직',
'2020-07-13', '01044444444', '1', '12', '1111', 0);

insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(10, 9, '9', '정관리', 'admin@test.com', '관리.jpg', '관리', '정규직',
'2020-07-13', '01055555555', '1', '12', '1111', 0);


-- 일정 예제데이터
insert into cms_calender(calNo, wNo, title, sdt, edt, content, place)
values('1', 1, '회의', '2021-01-13', '2021-01-15', '회의하는날', '회사');

insert into cms_calender(calNo, wNo, title, sdt, edt, content, place)
values('2', 2, '회의2', '2021-01-4', '2021-01-19', '회의하는날2', '회사');

insert into cms_calender(calNo, wNo, title, sdt, edt, content, place)
values('3', 2, '발표', '2021-01-28', '2021-01-28', '발표하는날', '회사');


-- 휴가 종류 예제데이터
insert into cms_vKind(vCode, name)
values('1', '병가');

insert into cms_vKind(vCode, name)
values('2', '연차');

insert into cms_vKind(vCode, name)
values('3', '반차');


-- 휴가 신청 예제데이터
insert into cms_vApp(vNo, vCode, wNo, adt, sdt, edt, used, rs, appr)
values(1, '1', 1, '2020-11-15', '2020-11-18', '2020-11-19', 1, '병가', 0);

insert into cms_vApp(vNo, vCode, wNo, adt, sdt, edt, used, rs, appr)
values(2, '2', 2, '2020-11-15', '2020-11-18', '2020-11-22', 4, '연차', 0);

insert into cms_vApp(vNo, vCode, wNo, adt, sdt, edt, used, rs, appr)
values(3, '3', 3, '2020-11-15', '2020-11-18', '2020-11-18', 0, '반차', 0);

-- 대화방 예제 데이터
insert into cms_cRoom(gChatNo, cName, cExpl)
values(1, '우리팀채팅방', '우리팀 회의방');

-- 대화방 참여자 예제 데이터
insert into cms_cGroup(wNo, gChatNo)
values(1, 1);

-- 대화 예제 데이터
insert into cms_chat(cNo, wNo, gChatNo, cContent, cName, cDate)
values(1, 1, 1, '안녕하세요', '텍스트', '2020-11-18');



-- 게시판 예제 데이터
insert into cms_category(ctNo, ctName)
values(1, "공지사항");

insert into cms_category(ctNo, ctName)
values(2, "사내소식");

insert into cms_category(ctNo, ctName)
values(3, "자유게시판");

insert into cms_category(ctNo, ctName)
values(4, "구내식단");



-- 게시글 정보 예제 데이터
insert into cms_bList(bNo, ctNo, wNo, title, regiDate, vCount, aFile, fSize, content)
values(1, 1, 1, '게시글 제목 테스트1', '2020-11-18', 0, '첨부파일명1', 1.5, '글 내용 테스트1');

insert into cms_bList(bNo, ctNo, wNo, title, regiDate, vCount, aFile, fSize, content)
values(2, 2, 2, '게시글 제목 테스트2', '2020-11-18', 0, '첨부파일명2', 1.7, '글 내용 테스트2');

insert into cms_bList(bNo, ctNo, wNo, title, regiDate, vCount, aFile, fSize, content)
values(3, 3, 3, '게시글 제목 테스트3', '2020-11-18', 0, '첨부파일명3', 2.3, '글 내용 테스트3');

insert into cms_bList(bNo, ctNo, wNo, title, regiDate, vCount, aFile, fSize, content)
values(4, 4, 5, '게시글 제목 테스트4', '2020-11-18', 0, '첨부파일명4', 1.5, '글 내용 테스트4');



-- 댓글 정보 예제 데이터
insert into cms_cmtInfo(cNo, bNo, stage, content, rdt, wNo, momNo)
values(1, 1, 1, "댓글 내용1", '2020-11-18', 1, 1);

insert into cms_cmtInfo(cNo, bNo, stage, content, rdt, wNo, momNo)
values(2, 2, 1, "댓글 내용2", '2020-11-18', 2, 2);

insert into cms_cmtInfo(cNo, bNo, stage, content, rdt, wNo, momNo)
values(3, 3, 1, "댓글 내용3", '2020-11-19', 3, 3);

insert into cms_cmtInfo(cNo, bNo, stage, content, rdt, wNo, momNo)
values(4, 4, 1, "댓글 내용4", '2020-11-20', 4, 4);

insert into cms_cmtInfo(cNo, bNo, stage, content, rdt, wNo, momNo)
values(5, 4, 2, "댓글 내용5", '2020-11-20', 5, 4);
