/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2019/11/24 21:16:12                          */
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
   "skill_type"         VARCHAR2(20),
   "standard_salary"    INTEGER,
   "job_type"           VARCHAR2(20),
   constraint PK_JOBS primary key ("job_id")
);

/*==============================================================*/
/* Table: "staff"                                               */
/*==============================================================*/
create table "staff" 
(
   "staff_id"           INTEGER              not null,
   "staff_name"         VARCHAR2(20)         not null,
   "sex"                INTEGER,
   "age"                INTEGER,
   "identity_id"        VARCHAR2(20)         not null,
   "job_grade"          VARCHAR2(20),
   "tel"                VARCHAR2(20),
   "card_id"            VARCHAR2(20),
   "salary_cart_id"     VARCHAR2(50),
   "project"            VARCHAR2(50),
   "enterprise"         VARCHAR2(50),
   "job_type"           VARCHAR2(20),
   "grade"              VARCHAR2(20),
   constraint PK_STAFF primary key ("staff_id")
);

/*==============================================================*/
/* Table: "user"                                                */
/*==============================================================*/
create table "user" 
(
   "username"           VARCHAR2(20)         not null,
   "password"           VARCHAR2(20),
   constraint PK_USER primary key ("username")
);

