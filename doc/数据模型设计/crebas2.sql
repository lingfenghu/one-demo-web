/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2019/12/9 17:51:48                           */
/*==============================================================*/


alter table "join"
   drop constraint FK_JOIN_JOIN_STAFF;

alter table "join"
   drop constraint FK_JOIN_JOIN2_PROJECT;

alter table "project"
   drop constraint FK_PROJECT_HAVE_ENTERPRI;

alter table "staff"
   drop constraint FK_STAFF_HIRE_ENTERPRI;

drop table "enterprise" cascade constraints;

drop table "jobs" cascade constraints;

drop index "join2_FK";

drop index "join_FK";

drop table "join" cascade constraints;

drop index "have_FK";

drop table "project" cascade constraints;

drop index "hire_FK";

drop table "staff" cascade constraints;

drop table "user" cascade constraints;

/*==============================================================*/
/* Table: "enterprise"                                          */
/*==============================================================*/
create table "enterprise" 
(
   "company_id"         INTEGER              not null,
   "company_name"       VARCHAR2(50)         not null,
   "address"            VARCHAR2(100),
   "register_date"      DATE,
   "principal"          VARCHAR2(20),
   "type"               VARCHAR2(50),
   "business_phone"     VARCHAR2(20),
   "asset"              NUMBER(10,3),
   constraint PK_ENTERPRISE primary key ("company_id"),
   constraint AK_UQ_COMPANYNAME_ENTERPRI unique ("company_name")
);

/*==============================================================*/
/* Table: "jobs"                                                */
/*==============================================================*/
create table "jobs" 
(
   "job_id"             INTEGER              not null,
   "skill_type"         VARCHAR2(20)         not null,
   "standard_salary"    INTEGER,
   "job_type"           VARCHAR2(20)         not null,
   constraint PK_JOBS primary key ("job_id")
);

/*==============================================================*/
/* Table: "join"                                                */
/*==============================================================*/
create table "join" 
(
   "staff_id"           INTEGER              not null,
   "project_id"         INTEGER              not null,
   constraint PK_JOIN primary key ("staff_id", "project_id")
);

/*==============================================================*/
/* Index: "join_FK"                                             */
/*==============================================================*/
create index "join_FK" on "join" (
   "staff_id" ASC
);

/*==============================================================*/
/* Index: "join2_FK"                                            */
/*==============================================================*/
create index "join2_FK" on "join" (
   "project_id" ASC
);

/*==============================================================*/
/* Table: "project"                                             */
/*==============================================================*/
create table "project" 
(
   "project_id"         INTEGER              not null,
   "company_id"         INTEGER,
   "project_name"       VARCHAR2(50)         not null,
   "setup_date"         DATE,
   "project_grade"      VARCHAR2(10),
   "note"               CLOB,
   constraint PK_PROJECT primary key ("project_id")
);

/*==============================================================*/
/* Index: "have_FK"                                             */
/*==============================================================*/
create index "have_FK" on "project" (
   "company_id" ASC
);

/*==============================================================*/
/* Table: "staff"                                               */
/*==============================================================*/
create table "staff" 
(
   "staff_id"           INTEGER              not null,
   "company_id"         INTEGER,
   "staff_name"         VARCHAR2(20)         not null,
   "sex"                INTEGER              not null,
   "age"                INTEGER,
   "identity_id"        VARCHAR2(20)         not null,
   "job_grade"          VARCHAR2(20),
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
/* Index: "hire_FK"                                             */
/*==============================================================*/
create index "hire_FK" on "staff" (
   "company_id" ASC
);

/*==============================================================*/
/* Table: "user"                                                */
/*==============================================================*/
create table "user" 
(
   "username"           VARCHAR2(20)         not null,
   "password"           VARCHAR2(50)         not null,
   constraint PK_USER primary key ("username")
);

alter table "join"
   add constraint FK_JOIN_JOIN_STAFF foreign key ("staff_id")
      references "staff" ("staff_id");

alter table "join"
   add constraint FK_JOIN_JOIN2_PROJECT foreign key ("project_id")
      references "project" ("project_id");

alter table "project"
   add constraint FK_PROJECT_HAVE_ENTERPRI foreign key ("company_id")
      references "enterprise" ("company_id");

alter table "staff"
   add constraint FK_STAFF_HIRE_ENTERPRI foreign key ("company_id")
      references "enterprise" ("company_id");

