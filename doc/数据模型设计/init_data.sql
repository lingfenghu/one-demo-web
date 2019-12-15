INSERT INTO "user" VALUES('hulingfeng','4QrcOUm6Wau+VuBX8g+IPg==');
INSERT INTO "user" VALUES('manager','4QrcOUm6Wau+VuBX8g+IPg==');
INSERT INTO "user" VALUES('admin','ISMvKXpXpadDiUoOSoAfww==');

drop sequence staff_id_seq;
create sequence staff_id_seq
minvalue 1
maxvalue 999999
start with 1
increment by 1;

--这里不用触发器，因为后端需要得到新插入的数据id
--drop trigger staff_id_trigger;
--create or replace trigger staff_id_trigger
--before insert on "staff"      
--for each row       
--begin
--	select staff_id_seq.nextval into :new."staff_id" from dual;      
--end staff_id_trigger;

INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'xiaowang','0','38','360428199805224935','','13225079670','CY201912050001','6214838640158038','','','普通','C');
INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'xiaoming','1','21','230125198601204503','','13225079670','CY201912050002','6214838640158038','','','普通','C');
INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'xiaohong','2','28','320508198601029685','','13225079670','CY201912050003','6214838640158038','','','普通','A');
INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'zhaoqiang','1','26','230882199410171294','','13225079670','CY201912050004','6214838640158038','','','普通','C');
INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'staff01','2','28','15012219780519602X','','13225079670','CY201912050005','6214838640158038','','','普通','B');
INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'staff02','1','28','350723198104304033','','13225079670','CY201912050006','6214838640158038','','','普通','A');
INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'zhangsan','1','29','340181197301071157','','13225079670','CY201912050007','6214838640158038','','','普通','C');
INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'lisi','2','28','150921198704240150','','13225079670','CY201912050008','6214838640158038','','','普通','C');
INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'wangwu','1','41','340181199005207258','','13225079670','CY201912050009','6214838640158038','','','普通','B');
INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'zhaoliu','1','38','150623198209054541','','13225079670','CY201912050010','6214838640158038','','','普通','A');
INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'xiaoqi','2','19','411402198001142333','','13225079670','CY201912050011','6214838640158038','','','普通','C');
INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'huba','1','25','150921197301311212','','13225079670','CY201912050012','6214838640158038','','','特殊','C');
INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'liushi','1','33','320602199207291759','','13225079670','CY201912050013','6214838640158038','','','特殊','C');
INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'linglingqi','2','39','371402198706157233','','13225079670','CY201912050014','6214838640158038','','','特殊','A');
INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'小明','2','52','37040619941120431X','','13225079670','CY201912050015','6214838640158038','','','特殊','A');

drop sequence job_id_seq;
create sequence job_id_seq
minvalue 1
maxvalue 999999
start with 1
increment by 1;

drop trigger job_id_trigger;

create or replace trigger job_id_trigger
before insert on "jobs"      
for each row       
begin
	select job_id_seq.nextval into :new."job_id" from dual;      
end job_id_trigger;

INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('小学教师',4000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('中学教师',5000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('大学教师',7000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('大学教授',8000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('秘书',5000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('会计',6000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('董事长',50000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('财务总监',7000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('人力资源总监',7000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('技术研发人员',7000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('电力',6000,'特殊');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('水利',6000,'特殊');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('冶金',6000,'特殊');

drop sequence company_id_seq;
create sequence company_id_seq
minvalue 1
maxvalue 999999
start with 1
increment by 1;

drop trigger company_id_trigger;

create or replace trigger company_id_trigger
before insert on "enterprise"      
for each row       
begin
	select company_id_seq.nextval into :new."company_id" from dual;      
end company_id_trigger;

INSERT INTO "enterprise"("company_name") VALUES ('企业甲');
INSERT INTO "enterprise"("company_name") VALUES ('企业乙');
INSERT INTO "enterprise"("company_name") VALUES ('企业丙');
INSERT INTO "enterprise"("company_name") VALUES ('企业丁');

drop sequence project_id_seq;
create sequence project_id_seq
minvalue 1
maxvalue 999999
start with 1
increment by 1;

drop trigger project_id_trigger;

create or replace trigger project_id_trigger
before insert on "project"      
for each row       
begin
	select project_id_seq.nextval into :new."project_id" from dual;      
end project_id_trigger;

INSERT INTO "project"("company_id","project_name")VALUES(1,'项目A');
INSERT INTO "project"("company_id","project_name")VALUES(1,'项目B');
INSERT INTO "project"("company_id","project_name")VALUES(2,'项目C');
INSERT INTO "project"("company_id","project_name")VALUES(2,'项目D');
INSERT INTO "project"("company_id","project_name")VALUES(3,'项目E');
INSERT INTO "project"("company_id","project_name")VALUES(3,'项目F');
INSERT INTO "project"("company_id","project_name")VALUES(4,'项目G');