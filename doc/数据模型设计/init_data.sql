INSERT INTO "user" VALUES('hulingfeng','123456');
INSERT INTO "user" VALUES('manager','123456');
INSERT INTO "user" VALUES('admin','admin');

drop sequence staff_id_seq;
create sequence staff_id_seq
minvalue 1
maxvalue 999999
start with 1
increment by 1;

--drop trigger staff_id_trigger;

create trigger staff_id_trigger;
before insert on "staff"      
for each row       
begin
	select staff_id_seq.nextval into :new."staff_id" from dual;      
end staff_id_trigger;

INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('xiaowang','0','38','360428199805224935','证券从业一级','13225079670','CY000001','6214838640158038','项目A','企业甲','特殊','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('xiaoming','1','21','230125198601204503','证券从业一级','13225079670','CY000002','6214838640158038','项目B','企业乙','特殊','B');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('xiaohong','2','28','320508198601029685','会计从业一级','13225079670','CY000003','6214838640158038','项目A','企业丙','特殊','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('zhaoqiang','1','26','230882199410171294','教师从业一级','13225079670','CY000004','6214838640158038','项目A','企业丁','特殊','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('staff01','2','28','15012219780519602X','会计从业一级','13225079670','CY000005','6214838640158038','项目A','企业甲','特殊','B');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('staff02','1','28','350723198104304033','证券从业一级','13225079670','CY000006','6214838640158038','项目G','企业甲','特殊','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('zhangsan','1','29','340181197301071157','教师从业一级','13225079670','CY000007','6214838640158038','项目A','企业乙','特殊','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('lisi','2','28','150921198704240150','证券从业一级','13225079670','CY000008','6214838640158038','项目C','企业丁','特殊','B');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('wangwu','1','41','340181199005207258','会计从业一级','13225079670','CY000009','6214838640158038','项目A','企业甲','特殊','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('zhaoliu','1','38','150623198209054541','证券从业一级','13225079670','CY000011','6214838640158038','项目A','企业乙','特殊','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('xiaoqi','2','19','411402198001142333','会计从业一级','13225079670','CY000012','6214838640158038','项目D','企业甲','特殊','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('huba','1','25','150921197301311212','证券从业一级','13225079670','CY000013','6214838640158038','项目A','企业甲','特殊','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('liushi','1','33','320602199207291759','教师从业一级','13225079670','CY000014','6214838640158038','项目A','企业丙','特殊','C');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('linglingqi','2','39','371402198706157233','证券从业一级','13225079670','CY000015','6214838640158038','项目F','企业丙','特殊','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('老王','2','37','37040619941030431X','会计从业一级','13225079670','CY000016','6214838640158038','项目A','企业甲','特殊','C');

drop sequence job_id_seq;
create sequence job_id_seq
minvalue 1
maxvalue 999999
start with 1
increment by 1;

--drop trigger job_id_trigger;

create or replace trigger job_id_trigger;
before insert on "jobs"      
for each row       
begin
	select job_id_seq.nextval into :new."job_id" from dual;      
end job_id_trigger;

INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('小学教师',4000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('中学老师',5000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('中学教师',6000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('大学教师',7000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('大学教授',8000,'普通');
--INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('小学教师',4000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('秘书',5000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('会计',6000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('董事长',100000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('财务总监',7000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('人力资源总监',7000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('技术研发人员',7000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('电力',6000,'特殊');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('水利',6000,'特殊');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('冶金',6000,'特殊');