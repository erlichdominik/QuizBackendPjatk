INSERT INTO quiz VALUES (1, 'default');

INSERT INTO answer VALUES (1, 'answer A');
INSERT INTO answer VALUES (2, 'answer B');
INSERT INTO answer VALUES (3, 'answer C');
INSERT INTO answer VALUES (4, 'answer D');

INSERT INTO answer VALUES (5, 'answer A');
INSERT INTO answer VALUES (6, 'answer B');
INSERT INTO answer VALUES (7, 'answer C');
INSERT INTO answer VALUES (8, 'answer D');


INSERT INTO answer VALUES (9, 'answer A');
INSERT INTO answer VALUES (10, 'answer B');
INSERT INTO answer VALUES (11, 'answer C');
INSERT INTO answer VALUES (12, 'answer D');

INSERT INTO answer VALUES (13, 'answer A');
INSERT INTO answer VALUES (14, 'answer B');
INSERT INTO answer VALUES (15, 'answer C');
INSERT INTO answer VALUES (16, 'answer D');

INSERT INTO question VALUES (1, 'question1', 2, 1), (2, 'question2', 3, 1), (3, 'question3',4, 1), (4, 'question4', null, 1);
-- INSERT INTO question VALUES (2, 'question2', null, 1);

INSERT INTO question_answer VALUES (1, false, 1, 1);
INSERT INTO question_answer VALUES (2, false, 2, 1);
INSERT INTO question_answer VALUES (3, true, 3, 1);
INSERT INTO question_answer VALUES (4, false, 4, 1);

INSERT INTO question_answer VALUES (5, false, 5, 2);
INSERT INTO question_answer VALUES (6, false, 6, 2);
INSERT INTO question_answer VALUES (7, true, 7, 2);
INSERT INTO question_answer VALUES (8, false, 8, 2);

INSERT INTO question_answer VALUES (9, false, 9, 3);
INSERT INTO question_answer VALUES (10, true, 10, 3);
INSERT INTO question_answer VALUES (11, false, 11, 3);
INSERT INTO question_answer VALUES (12, false, 12, 3);

INSERT INTO question_answer VALUES (13, true, 13, 4);
INSERT INTO question_answer VALUES (14, false, 14, 4);
INSERT INTO question_answer VALUES (15, false, 15, 4);
INSERT INTO question_answer VALUES (16, false, 16, 4);
