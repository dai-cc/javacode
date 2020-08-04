create database java13_chatroom;

use java13_chatroom;

drop table if exists user;
create table user{
    userId int primary key auto_increment,--设置int类型的userId为自增主键，插入第一条数据为1，第二条数据为2，不用程序员自己设置
    name varchar(50) unique,--用户登录时使用的名字，相当于qq号
    password varchar(50),
    nikeName varchar(50),--用户登录完成后界面显示的名称，相当于qq昵称
    lastLogout datetime --上次退出时间
};

drop table if exists channel;
create table channel{
    channelId int primary key auto_increment,
    channelName varchar(50)
};

drop table if exists message;
create table message{
    messageId int primary key auto_increment,
    userId int, --表示谁发送的消息
    channelId int,
    context text, --消息正文
    sendTime datetime  --消息的发送时间
};