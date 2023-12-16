insert into Student (ID, FIRST_NAME, LAST_NAME, CLASS_NUM)
values(1,'mostafa', 'ahmad',120);
insert into Student (ID, FIRST_NAME, LAST_NAME, CLASS_NUM)
values(2,'dalya', 'mohamed',120);
insert into Student (ID, FIRST_NAME, LAST_NAME, CLASS_NUM)
values(3,'taha', 'adel',120);
insert into Course (ID, NAME, NUM_OF_STUDENTS, CLASS_NUM)
values(10001,'software engineering', 0,120);
insert into Course (ID, NAME, NUM_OF_STUDENTS, CLASS_NUM)
values(10002,'OOP', 0,120);
insert into Course (ID, NAME, NUM_OF_STUDENTS, CLASS_NUM)
values(10003,'DS', 0,120);
insert into quiz (ID, COURSE_NAME, QUIZ_TYPE)
values(666,'software engineering', 'final');
insert into quiz (ID, COURSE_NAME, QUIZ_TYPE)
values(333,'OOP', 'mid-term');

insert into Teacher (ID, NAME, COURSE_NAME)
values(956,'mohamed abdelgwaad', 'software engineering');
insert into Teacher (ID, NAME, COURSE_NAME)
values(957,'mostafa adel', 'DS');