use new_servlet;

CREATE TABLE role(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL,
	code VARCHAR(255) NOT NULL,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

create table user (
	id bigint NOT NULL PRIMARY KEY auto_increment,
    username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
    fullname VARCHAR(255) NOT NULL,
    status int not null,
    roleid bigint not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null

);

alter table user add constraint fk_user_role foreign key (roleid) references role(id);

create table news (
	id bigint NOT NULL PRIMARY KEY auto_increment,
    title VARCHAR(255) NULL,
	thumbnail VARCHAR(255) NULL,
    shortdescription text NOT NULL,
	content text NOT NULL,
    categoryid bigint NOT NULL,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null

);

create table category (
	id bigint NOT NULL PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL,
	code VARCHAR(255) NOT NULL,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null

);

alter table news add constraint fk_news_category foreign key (categoryid) references category(id);

create table comment (
	id bigint NOT NULL PRIMARY KEY auto_increment,
    content text not NULL,
	code VARCHAR(255) NOT NULL,
    user_id bigint not null,
    news_id bigint not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null

);

alter table comment add constraint fk_comment_user foreign key (user_id) references user(id);
alter table comment add constraint fk_comment_news foreign key (news_id) references news(id);
