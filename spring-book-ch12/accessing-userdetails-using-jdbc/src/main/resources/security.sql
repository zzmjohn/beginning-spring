create table users(
username varchar_ignorecase(128) not null primary key,
password varchar_ignorecase(512) not null,
enabled boolean not null);

create table authorities (
username varchar_ignorecase(128) not null,
authority varchar_ignorecase(128) not null);

create unique index idx_auth_username on authorities (username,authority);

create table groups (
id bigint not null,
group_name varchar_ignorecase(128) not null);

alter table groups add constraint pk_groups primary key(id);

create table group_authorities (
group_id bigint not null,
authority varchar_ignorecase(128) not null,
constraint fk_group_authorities_group foreign key(group_id) references groups(id));

create table group_members (
id bigint not null,
username varchar_ignorecase(128) not null,
group_id bigint not null,
constraint fk_group_members_group foreign key(group_id) references groups(id));     

alter table group_members add constraint pk_group_members primary key(id);

insert into users(username,password,enabled) values ('user1','secret',true);
insert into users(username,password,enabled) values ('user2','secret',true);

insert into authorities(username,authority) values ('user1','ROLE_USER');
insert into authorities(username,authority) values ('user2','ROLE_USER');  
insert into authorities(username,authority) values ('user2','ROLE_EDITOR');