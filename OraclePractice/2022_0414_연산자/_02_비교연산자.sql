-- �Խñ� �߿��� �ۼ��ڰ� 'ȫ�浿'�� �Խñ۸� ��ȸ
SELECT * FROM NOTICE WHERE WRITER_ID = 'ȫ�浿';

-- �Խñ� �߿��� ��ȸ���� 100�� �Ѵ� �۸� ��ȸ
SELECT * FROM NOTICE WHERE HIT > 100;

-- �Խñ� �߿��� ������ �Է����� ���� �Խñ��� ��ȸ
-- �� NULL�� ��� = ������ ��� �Ұ�. �ݵ�� IS�� ����Ѵ�.
SELECT * FROM NOTICE WHERE CONTENT IS NULL;