/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2019/12/2 10:05:49                           */
/*==============================================================*/


drop table "jobs" cascade constraints;

drop table "staff" cascade constraints;

drop table "user" cascade constraints;

/*==============================================================*/
/* Table: "jobs"                                                */
/*==============================================================*/
create table "jobs" 
(
   "job_id"             INTEGER              not null,
   "skill_type"         VARCHAR2(20)         not null,
   "standard_salary"    INTEGER,
   "job_type"           VARCHAR2(20)         not null,
   constraint PK_JOBS primary key ("job_id"),
   constraint AK_UQ_SKILL_JOBS unique ("skill_type")
);

/*==============================================================*/
/* Table: "staff"                                               */
/*==============================================================*/
create table "staff" 
(
   "staff_id"           INTEGER              not null,
   "staff_name"         VARCHAR2(20)         not null,
   "sex"                INTEGER              not null,
   "age"                INTEGER,
   "identity_id"        VARCHAR2(20)         not null,
   "job_grade"          VARCHAR2(20)         not null,
   "tel"                VARCHAR2(20)         not null,
   "card_id"            VARCHAR2(20)         not null,
   "salary_card_id"     VARCHAR2(50)         not null,
   "project"            VARCHAR2(50),
   "enterprise"         VARCHAR2(50),
   "job_type"           VARCHAR2(20),
   "grade"              VARCHAR2(20),
   constraint PK_STAFF primary key ("staff_id"),
   constraint AK_UQ_IDENTITY_STAFF unique ("identity_id"),
   constraint AK_UQ_CARDID_STAFF unique ("card_id")
);

/*==============================================================*/
/* Table: "user"                                                */
/*==============================================================*/
create table "user" 
(
   "username"           VARCHAR2(20)         not null,
   "password"           VARCHAR2(20)         not null,
   constraint PK_USER primary key ("username")
);

