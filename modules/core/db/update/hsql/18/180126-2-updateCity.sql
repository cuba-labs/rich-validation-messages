update DEMO_CITY set TITLE = '' where TITLE is null ;
alter table DEMO_CITY alter column TITLE set not null ;
