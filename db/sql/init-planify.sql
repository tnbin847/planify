-- 데이터베이스 생성
create database planify;
use planify;

-- 개발을 위한 계정 생성 및 생성된 데이터베이스에 대한 권한 부여
create user 'tnbin847'@'%' identified by '9785';
grant all privileges on planify.* to 'tnbin847'@'%';

-- 새로고침
flush privileges;



-- 테이블 생성
create table user_account (
	id						bigint				unique not null auto_increment comment '사용자계정번호',
	login_id				varchar(20)			not null comment '계정 로그인 아이디',
	password				varchar(255)		not null comment '계정 비밀번호',
	name					varchar(12)			not null comment '사용자 이름',
	email					varchar(40)			not null comment '이메일',
	login_type				varchar(7)			not null comment '가입방식에 따른 로그인 유형 (DEFAULT : 일반가입유저 / OAUTH : 소셜가입유저)',
	activated				tinyint(1)			not null comment '계정활성화여부 (1: 활성화 / 0: 비활성화)',
	created_at				datetime			not null default now() comment '가입일자',
	updated_at				datetime			not null comment '변경일자',
	primary key (id)
) engine = innodb default charset = utf8mb4 comment '사용자 계정';


create table user_authority (
	user_id					bigint				not null comment '사용자계정번호',
	role					varchar(20)			not null comment '부여된 권한명',
	used_at					char(1)				not null comment '권한사용여부',
	created_at				datetime			not null comment '등록일자',
	updated_at				datetime			not null comment '변경일자',
	foreign key (user_id) references user_account (id) on update cascade on delete cascade
) engine = innodb default charset = utf8mb4 comment '사용자 계정별 권한 정보';
