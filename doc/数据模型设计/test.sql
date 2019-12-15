-- test sql ----------------------------------------------------------------------------------------------------------------------
SELECT * FROM "t_user"
select 1 from dual
SELECT * FROM "user" WHERE "username" = 'hulingfeng'

drop sequence staff_id_seq;
create sequence staff_id_seq
minvalue 1
maxvalue 999999
start with 1
increment by 1;

drop trigger staff_id_trigger

create or replace trigger staff_id_trigger
before insert on "staff"      
for each row       
begin
	select staff_id_seq.nextval into :new."staff_id" from dual;      
end staff_id_trigger;

SELECT staff_id_seq.currval FROM dual
SELECT staff_id_seq.nextval FROM dual

INSERT INTO "user" VALUES('hulingfeng','123456')
INSERT INTO "user" VALUES('lisi','123456')


INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('xiaowang','0','38','360428199805224935','证券从业一级','13225079670','CY000001','6214838640158038','项目A','企业甲','特殊','A');


UPDATE "staff" SET "sex"='1' WHERE "staff_id"=1

DELETE FROM "staff"

SELECT "sex",COUNT("sex") "count" FROM "staff" WHERE "job_type"='普通'  
-- AND "age" BETWEEN '18' AND '30' 
GROUP BY "sex";

SELECT * FROM "staff" WHERE "staff_name" LIKE CONCAT(CONCAT('%', 'li'), '%')

drop sequence job_id_seq;
create sequence job_id_seq
minvalue 1
maxvalue 999999
start with 1
increment by 1;

create or replace trigger job_id_trigger
before insert on "jobs"      
for each row       
begin
	select job_id_seq.nextval into :new."job_id" from dual;      
end job_id_trigger;


INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('冶金',6000,'特殊');

SELECT DISTINCT "project" FROM "staff" WHERE "project" IS NOT NULL

SELECT COUNT(*) FROM "staff" WHERE "card_id"='CY201912050001'

SELECT MAX("card_id") FROM "staff"

DELETE FROM "staff"

SELECT COUNT(*) FROM "staff" WHERE "age">30



SELECT (CASE 
	WHEN ("age">=18 AND "age"<30) THEN
		'18-30岁'
	WHEN ("age">=30 AND "age"<45) THEN
		'30-45岁'
	WHEN ("age">=45 AND "age"<60) THEN
		'45-60岁'
	ELSE
		'其他(小于18大于60)'
	END) "ageInterval",COUNT(*) "num" FROM "staff" 
	WHERE "job_type" = '普通'
	GROUP BY (CASE 
	WHEN ("age">=18 AND "age"<30) THEN
		'18-30岁'
	WHEN ("age">=30 AND "age"<45) THEN
		'30-45岁'
	WHEN ("age">=45 AND "age"<60) THEN
		'45-60岁'
	ELSE
		'其他(小于18大于60)'
	END) ORDER BY "ageInterval";


SELECT (CASE
	WHEN ("age">=18 AND "age"<30) THEN
		'18-30岁'
	WHEN ("age">=30 AND "age"<45) THEN
		'30-45岁'
	WHEN ("age">=45 AND "age"<60) THEN
		'45-60岁'
        ELSE '其他(小于18大于60)'
        END) "ageInterval",COUNT(*) "count" FROM "staff"
				GROUP BY (CASE
	WHEN ("age">=18 AND "age"<30) THEN
		'18-30岁'
	WHEN ("age">=30 AND "age"<45) THEN
		'30-45岁'
	WHEN ("age">=45 AND "age"<60) THEN
		'45-60岁'
        ELSE '其他(小于18大于60)'
        END) ORDER BY "ageInterval";

SELECT * FROM "enterprise"
SELECT * FROM "project" WHERE "company_id"=1

INSERT INTO "staff"("staff_name","sex","age","identity_id","tel","card_id","salary_card_id","job_type","grade") VALUES ('aaa','0','21','360428199805224937','13225079670','CY201912050020','32424242','普通','A');

DELETE FROM "staff"

SELECT "staff".*,
"join"."project_id",
"project_name",
"setup_date",
"project_grade",
"note",
"company_name",
"address",
"register_date",
"principal",
"type",
"business_phone",
"asset"
FROM (SELECT * FROM "staff" WHERE "staff_id" = '3') "staff"
LEFT JOIN "join" ON "staff"."staff_id" = "join"."staff_id"
LEFT JOIN "project" ON "join"."project_id" = "project"."project_id"
LEFT JOIN "enterprise" ON "staff"."company_id" = "enterprise"."company_id";
WHERE 
-- "join"."project_id"='1' AND 
"card_id" = 'CY201912080020'

SELECT "temp".* FROM (SELECT * FROM "staff" WHERE "staff_id" = '2') "temp"

DELETE FROM "join" WHERE "staff_id" = '1' AND "project_id" = '1'



--init data----------------------------------------------------------------------------------------------------------
DELETE FROM "user"

INSERT INTO "user" VALUES('hulingfeng','4QrcOUm6Wau+VuBX8g+IPg==');
INSERT INTO "user" VALUES('manager','4QrcOUm6Wau+VuBX8g+IPg==');
INSERT INTO "user" VALUES('admin','ISMvKXpXpadDiUoOSoAfww==');

drop sequence staff_id_seq;
create sequence staff_id_seq
minvalue 1
maxvalue 999999
start with 1
increment by 1;

drop trigger staff_id_trigger;

create or replace trigger staff_id_trigger
before insert on "staff"      
for each row       
begin
	select staff_id_seq.nextval into :new."staff_id" from dual;      
end staff_id_trigger;

INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('xiaowang','0','38','360428199805224935','证券从业一级','13225079670','CY201912050001','6214838640158038','项目A','企业甲','普通','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('xiaoming','1','21','230125198601204503','证券从业一级','13225079670','CY201912050002','6214838640158038','项目B','企业乙','普通','B');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('xiaohong','2','28','320508198601029685','会计从业一级','13225079670','CY201912050003','6214838640158038','项目A','企业丙','普通','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('zhaoqiang','1','26','230882199410171294','教师从业一级','13225079670','CY201912050004','6214838640158038','项目A','企业丁','普通','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('staff01','2','28','15012219780519602X','会计从业一级','13225079670','CY201912050005','6214838640158038','项目A','企业甲','普通','B');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('staff02','1','28','350723198104304033','证券从业一级','13225079670','CY201912050006','6214838640158038','项目G','企业甲','普通','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('zhangsan','1','29','340181197301071157','教师从业一级','13225079670','CY201912050007','6214838640158038','项目A','企业乙','普通','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('lisi','2','28','150921198704240150','证券从业一级','13225079670','CY201912050008','6214838640158038','项目C','企业丁','普通','B');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('wangwu','1','41','340181199005207258','会计从业一级','13225079670','CY201912050009','6214838640158038','项目A','企业甲','普通','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('zhaoliu','1','38','150623198209054541','证券从业一级','13225079670','CY201912050010','6214838640158038','项目A','企业乙','普通','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('xiaoqi','2','19','411402198001142333','会计从业一级','13225079670','CY201912050011','6214838640158038','项目D','企业甲','普通','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('huba','1','25','150921197301311212','证券从业一级','13225079670','CY201912050012','6214838640158038','项目A','企业甲','普通','A');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('liushi','1','33','320602199207291759','教师从业一级','13225079670','CY201912050013','6214838640158038','项目A','企业丙','普通','C');
INSERT INTO "staff"("staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES ('linglingqi','2','39','371402198706157233','证券从业一级','13225079670','CY201912050014','6214838640158038','项目F','企业丙','普通','A');


INSERT INTO "staff"("staff_id","staff_name","sex","age","identity_id","job_grade","tel","card_id","salary_card_id","project","enterprise","job_type","grade") VALUES (staff_id_seq.nextval,'老王','2','52','37040619941120431X','数控操机从业一级','13225079670','CY201912050019','6214838640158038','项目A','企业甲','特殊','A');

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
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('中学老师',5000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('中学教师',6000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('大学教师',7000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('大学教授',8000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('秘书',5000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('会计',6000,'普通');
INSERT INTO "jobs"("skill_type","standard_salary","job_type") VALUES('董事长',100000,'普通');
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

DELETE FROM "enterprise";
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

INSERT INTO "join" VALUES ('1','1')


-- init end -------------------------------------------------------------------------------------------------------------------