-- 게시글 중에서 작성자가 '홍길동'인 게시글만 조회
SELECT * FROM NOTICE WHERE WRITER_ID = '홍길동';

-- 게시글 중에서 조회수가 100이 넘는 글만 조회
SELECT * FROM NOTICE WHERE HIT > 100;

-- 게시글 중에서 내용을 입력하지 않은 게시글을 조회
-- ★ NULL의 경우 = 연산자 사용 불가. 반드시 IS를 써야한다.
SELECT * FROM NOTICE WHERE CONTENT IS NULL;