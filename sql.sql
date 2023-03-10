create table `user`
(
    `id`          bigint unsigned auto_increment primary key,
    `openid`      text,
    `session_key` text,
    `create_time` datetime default current_timestamp
);

create table `account_book`
(
    `id`          bigint unsigned auto_increment primary key,
    `name`        varchar(32),
    `description` varchar(64),
    `img`         text,
    `budget`      decimal unsigned,
    `create_time` datetime default current_timestamp
);

create table `record`
(
    `id`          bigint unsigned auto_increment primary key,
    `is_pay`      tinyint(1),
    `type`        tinyint(1),
    `amount`      decimal unsigned,
    `remark`      varchar(32),
    `time`        datetime,
    `create_time` datetime default current_timestamp
)
