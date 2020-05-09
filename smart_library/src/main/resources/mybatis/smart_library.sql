/*

	智能图书馆数据库设计

数据库名：smart_library

1、用户表 ：s_user

用户标识：uid
用户名： username
密码： password
盐值：salt
性别：gender(男1，女0）
电话：phone
邮箱：email
创建时间：create_time
修改时间：modified_time
专业：major
删除标识：is_delete（0代表未删除，1代表删除）

2、书籍类别表：s_book_category

类别标识：bcid
类别： type
删除标识：is_delete

3、书籍表：s_book

书籍标识：bid
作者: writer
类别: btype
书名：title
简介：content
图片：image
出版时间：publish_time
总页数: page
难度：difficult
删除标识：is_delete

4、问题表：s_question

问题标识：qid
类别：btype
题目：question
答案：answer
删除标识：is_delete

5、收藏表：s_collect

收藏标识：cid
类别标识：bcid
用户标识：uid
书籍标识：bid
创建时间：created_time
删除标识：is_delete

6、书籍评论表：s_comment

评论标识：cid
用户标识：uid
书籍表示：bid
评论内容：comment
创建时间：create_time
删除标识：id_delete

7、用户错题表 s_wrong

错题标识：wid
用户标识：uid
题目标识：qid
创建时间：create_time
删除标识：id_delete

*/
create table s_user(
	uid int(11) not null auto_increment,
	username varchar(255) not null,
	password varchar(255) not null,
	salt varchar(255) not null,
	gender varchar(255) not null,
	phone varchar (255) not null,
	email varchar (255) not null,
	is_delete varchar(255) not null,
	create_time varchar(255) not null,
	modified_time varchar(255) not null,
	major varchar(255) not null,
	primary key(uid)
)default charset=utf8

create table s_book_category(
	bcid int(11) not null auto_increment,
	type varchar(255) not null,
	is_delete varchar(255) not null,
	primary key(bcid)
)default charset=utf8

create table s_book(
	bid int(11) not null auto_increment,
	type varchar(255) not null,
	title varchar(255) not null,
	content varchar(255) not null,
	image varchar(255) not null,
	publish_time varchar(255) not null,
	page varchar(255) not null,
	diffcult varchar(255) not null,
	is_delete varchar(255) not null,
	primary key(bid)
)default charset=utf8

create table s_question(
	qid int(11) not null auto_increment,
	bid int(11) not,
	type varchar(255) not null,
	question varchar(255) not null,
	answer varchar(255) not null,
	is_delete varchar(255) not null,
	primary key(qid)
)default charset=utf8

create table s_collect(
	cid int(11) not null auto_increment,
	bcid varchar(255) not null,
	uid int(11) not null,
	bid int(11) not null,
	create_time varchar(255) not null,
	is_delete varchar(255) not null,
	primary key(cid)
)default charset=utf8

create table s_comment(
	cid int(11) not null auto_increment,
	uid int(11) not null,
	bid int(11) not null,
	comment varchar(255) not null,
	create_time varchar(255) not null,
	is_delete varchar(255) not null,
	primary key(cid)
)default charset=utf8

create table s_wrong(
	wid int(11) not null auto_increment,
	uid int(11) not null,
	qid int(11) not null,
	create_time varchar(255) not null,
	is_delete varchar(255) not null,
	primary key(wid)
)default charset=utf8

/*
	测试sql语句
*/

/*
	书籍
*/

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          '周志明',
          '软件类','深入理解java虚拟机','程序员必读',
          '../asserts/img/book/type/software/so7.jpg','2017-06-16',
          '2400','0'
        )

DELETE FROM s_book
WHERE bid=1
OR
(title='深入理解java虚拟机'
AND
writer='周志明'
)
/*
	插入计算机类书籍
*/
INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          'Gary Comell',
          '2','Java核心技术Ⅱ高级特性','让经典无限延伸......',
          '/asserts/img/book/type/software/so1.jpg','2020-05-01',
          '2400','0'
        )

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          'Cay S.Horstmann',
          '2','Java核心技术Ⅱ高级特性','系统全面讲解Java语言的核心概念......',
          '/asserts/img/book/type/software/so2.jpg','2020-05-01',
          '2400','0'
        )


INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          'Cay S.Horstmann',
          '2','Java核心技术','系统全面讲解Java语言的核心概念......',
          '/asserts/img/book/type/software/so3.jpg','2020-05-01',
          '2400','0'
        )

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          'Mark Allen Weiss',
          '2','数据结构与算法分析——C++描述','图灵原版计算机科学系列......',
          '/asserts/img/book/type/software/so4.jpg','2020-05-01',
          '2000','0'
        )

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          'Mark Allen Weiss',
          '2','数据结构与算法分析——Java描述','图灵原版计算机科学系列......',
          '/asserts/img/book/type/software/so4.jpg','2020-05-01',
          '2000','0'
        )

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          'Mark Allen Weiss',
          '2','数据结构与算法分析——Java描述','图灵原版计算机科学系列......',
          '/asserts/img/book/type/software/so5.jpg','2020-05-01',
          '2000','0'
        )

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          'Clifford A.Shaffer',
          '2','数据结构与算法分析——C++版','国外计算机科学教材系列......',
          '/asserts/img/book/type/software/so6.jpg','2020-05-01',
          '1800','0'
        )

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          '周志明',
          '2','深入理解java虚拟机','程序员必读……',
          '/asserts/img/book/type/software/so7.jpg','2017-06-16',
          '2200','0'
        )

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          '何海涛',
          '2','剑指Offer','面试官精讲典型编程题……',
          '/asserts/img/book/type/software/so8.jpg','2017-06-16',
          '1900','0'
        )

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          '牛广海',
          '3','语言艺术全书1','你值得拥有……',
          '/asserts/img/book/type/language/lan1.jpg','2017-06-16',
          '1500','0'
        )

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          '叶蜚声',
          '3','语言学纲要','我是独一无二的……',
          '/asserts/img/book/type/language/lan2.jpg','2017-06-16',
          '1300','0'
        )

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          '姜丽萍',
          '3','体验汉语基础教程','汉语是世界上最美的语言……',
          '/asserts/img/book/type/language/lan3.jpg','2017-06-16',
          '2600','0'
        )

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          '普希金',
          '1','普希金诗集','诗情画意，唯我独尊……',
          '/asserts/img/book/type/literature/lit1.jpg','2017-06-16',
          '2600','0'
        )

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          '山海经',
          '1','山海经','奇闻异见，洪荒猛兽……',
          '/asserts/img/book/type/literature/lit2.jpg','2017-06-16',
          '2600','0'
        )

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          '林海音',
          '1','城南旧事','百年百部中国儿童文学经典书籍……',
          '/asserts/img/book/type/literature/lit3.jpg','2017-06-16',
          '2100','0'
        )

INSERT INTO s_book(
          writer,
          btype,title,content,
          image,publish_time,
          page,is_delete
        )VALUES (
          '鲁迅',
          '1','阿Q正传','这本书是我写的，但是……',
          '/asserts/img/book/type/literature/lit4.jpg','2017-06-16',
          '2800','0'
        )
/*
	收藏测试
*/
SELECT 
s_book.bid,writer,
btype,title,content,
image,publish_time,
page,s_book.is_delete
FROM s_book 
INNER JOIN s_collect
ON s_collect.uid=1
AND s_book.bid=s_collect.bid
ORDER BY s_book.bid

/*
	评论测试
*/
SELECT 
cid,s1.uid,s1.bid,comment,
s1.created_time,s2.username,
s3.title,s3.writer,
s1.is_delete
AS
is_delete
FROM
s_comment s1,
s_user s2,
s_book s3
WHERE
s1.bid=2
AND
s1.uid=s2.uid
AND
s1.bid=s3.bid

/*
	根据专业推荐书籍
*/
SELECT 
s1.bid,writer,
btype,title,content,
image,publish_time,
page,s1.is_delete
FROM
s_book s1
INNER JOIN s_book_category s2
ON s2.bcid=2
AND s1.btype=s2.type
ORDER BY s1.bid

/*
	查问题
*/
SELECT
qid,bid,btype,
question,answer,
is_delete
AS
is_delete
FROM
s_question
WHERE
bid=#{bid}
