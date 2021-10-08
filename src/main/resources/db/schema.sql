create table if not exists blog (
    id        bigint not null auto_increment,
    full_text longtext,
    title     varchar(255),
    views     integer,
    user_id   bigint,
    primary key (id)
);

create table if not exists user_role (
    user_id bigint not null,
    roles   varchar(255)
);

create table if not exists users (
    id                bigint not null auto_increment,
    email             varchar(255),
    phone_number      varchar(255),
    username          varchar(255) not null,
    password          varchar(255) not null,
    repeated_password varchar(255),
    active            bit    not null,
    primary key (id)
);

alter table blog
    add constraint blog_user_fork foreign key (user_id) references users (id);
alter table user_role
    add constraint users_user_role_fork foreign key (user_id) references users (id);