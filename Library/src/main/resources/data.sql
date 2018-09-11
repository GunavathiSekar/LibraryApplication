-- BOOKCAT_ID  	NAME 
insert into BOOK_CATEGORY  values (201,'Cat1');
insert into BOOK_CATEGORY  values (202,'Cat2');
insert into BOOK_CATEGORY  values (203,'Cat3');
insert into BOOK_CATEGORY  values (204,'Cat4');
insert into BOOK_CATEGORY  values (205,'Cat5');
insert into BOOK_CATEGORY  values (206,'Cat6');
insert into BOOK_CATEGORY  values (207,'Cat7');

-- BOOK_ID  	BOOKNAME  	BOOKCAT_ID  

insert into BOOK  values (101,'harrypotter',201);
insert into BOOK  values (102,'alchemist',201);
insert into BOOK  values (103,'gonegal',201);
insert into BOOK  values (104,'2states',201);
insert into BOOK  values (105,'The Monk',201);
insert into BOOK  values (106,'Twilight',201);
insert into BOOK  values (107,'revolution2020',201);

-- SELECT * FROM BOOK_REQUEST;
-- BOOKREQID  	BOOK  	CATEGORY  	STATUS  	USERID  

insert into BOOK_REQUEST values (301,101,'Q',1);
insert into BOOK_REQUEST values (302,102,'Q',2);
insert into BOOK_REQUEST values (303,103,'Q',1);
insert into BOOK_REQUEST values (304,104,'R',2);
insert into BOOK_REQUEST values (305,101,'R',1);
insert into BOOK_REQUEST values (306,102,'R',1);
insert into BOOK_REQUEST values (307,107,'I',3);
insert into BOOK_REQUEST values (308,108,'I',4);
insert into BOOK_REQUEST values (309,102,'Q',2);
insert into BOOK_REQUEST values (310,108,'Q',1);
-- SELECT * FROM BOOKREVIEW;
-- BOOKREVID  	BOOKID  	REVIEW  	USERID  

insert into BOOK_REVIEW values (401,101,'Good',1);
insert into BOOK_REVIEW values (402,103,'Good',1);
insert into BOOK_REVIEW values (403,102,'Good',2);
insert into BOOK_REVIEW values (404,104,'Good',2);
insert into BOOK_REVIEW values (405,107,'Good',3);
insert into BOOK_REVIEW values (406,108,'Good',4);
insert into BOOK_REVIEW values (407,101,'AweSome Book',1);
insert into BOOK_REVIEW values (408,104,'AweSome Book',1);
insert into BOOK_REVIEW values (409,105,'AweSome Book',1);
-- SELECT * FROM LIKEREVIEW;
-- LIKEID  	BOOKREWID  	COMMENTS  	USERID  	LIKE  

insert into LIKE_REVIEW values (501,'L','OK',401,2);
insert into LIKE_REVIEW values (502,'L','OK',401,3);
insert into LIKE_REVIEW values (503,'L','OK',401,4);
insert into LIKE_REVIEW values (504,'L','OK',401,5);
insert into LIKE_REVIEW values (505,'D','OK',402,2);
insert into LIKE_REVIEW values (506,'D','OK',402,4);
insert into LIKE_REVIEW values (507,'L','OK',401,6);
insert into LIKE_REVIEW values (508,'L','OK',401,1);
