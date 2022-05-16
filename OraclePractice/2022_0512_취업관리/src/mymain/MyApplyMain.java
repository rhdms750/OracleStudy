package mymain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import dao.MyApplyDao;
import vo.ApplyInfoVo;
import vo.ComInfoVo;
import vo.MyApplyListVo;
import vo.RecInfoVo;

public class MyApplyMain {
	
	static MyApplyDao dao = MyApplyDao.getInstance();
	static Map<Integer,String> compMap = dao.getCompMap();
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String yn = "y";
		
		ApplyInfoVo vo1 = new ApplyInfoVo();
		ComInfoVo   vo2 = new ComInfoVo();
		RecInfoVo   vo3 = new RecInfoVo();
		
		int com_no, comNo_max;
		int applyNo_max;
		
		//Loop : ����ڿ��� �������� �Է� ����
		//[1] ������ ���� ������ �Է��ϼ���
		//[2] �ΰ� ������ �Է��Ͻðڽ��ϱ�? (������ ����� ��������) -- �ϴ� ����
		do {
			
			try {
				
				//�Է�
				System.out.println("----����, ���� ���� ���� ���� ������ �Է��ϼ���-----");
				System.out.print("�̷¼� ������ �Ϸ��߽��ϱ�? (y/n) : ");
				if (reader.readLine().equalsIgnoreCase("y")) {
					
					System.out.print("�̷¼� ������ : ");
					vo1.setApply_date(reader.readLine());
					vo1.setApply_state("�����Ϸ�");
					
					System.out.print("�̷¼� ��ũ�� �ֽ��ϱ�? (y/n) : ");
					if (reader.readLine().equalsIgnoreCase("y")) {
						System.out.print("�̷¼� ��ũ�� �Է��ϼ��� : ");
						vo1.setApply_doc(reader.readLine());
					}
					
				}else {
					vo1.setApply_state("���");
				}
				
				dao.insertApplyInfo(vo1); //�������¿� ���� DB�� �ֱ�
				//dao = MyApplyDao.getInstance();//���� -- �ؾ��ϳ�?
				
				System.out.println(); 
				System.out.println();
				System.out.println("----����, �����Ϸ��� ��� ������ �Է��ϼ���-----");
				System.out.print("����� : ");
				String com_name = reader.readLine();
				
				//�̹� �� ������� ��ϵ� ���� �ִٸ� DB������ �����´�
				if (compMap.containsValue(com_name)) {
					com_no = getComNo(com_name);
				}
				//�׷��� �ʴٸ� DB�� ���� ���
				else {
					vo2.setCom_name(com_name);
					System.out.print("���ī�װ� : ");
					vo2.setCom_cat(reader.readLine());
					System.out.print("����ַ»�� : ");
					vo2.setCom_focus(reader.readLine());
				}
				
				//apply_no
				applyNo_max = dao.getMaxApplyNo();
				vo2.setApply_no(applyNo_max);
				
				dao.insertComInfo(vo2);
				compMap = dao.getCompMap(); //��� ���� �ʿ�
				//dao = MyApplyDao.getInstance();//�ѹ� �� ����
				
				System.out.println(); 
				System.out.println();
				System.out.println("----����������, �����Ϸ��� ���� ������ �Է��ϼ���-----");
				System.out.print("����� : ");
				vo3.setRec_name(reader.readLine());
				System.out.print("����ũ : ");
				vo3.setRec_link(reader.readLine());
				System.out.print("�ʼ��ڰ� : ");
				vo3.setRec_req(reader.readLine());
				System.out.print("����� : ");
				vo3.setRec_pref(reader.readLine());
				
				System.out.print("�̷¼������� : ");
				String doc_date = reader.readLine();
				vo3.setDoc_date(doc_date);
				
				System.out.print("�ڵ��׽�Ʈ�� : ");
				String cotest_date = reader.readLine();
				
				//�Է°� Ȯ�� : �̷¼��Ϻ��� ���� �����ϴ��� Ȯ�� 
				while (!isAfter(cotest_date,doc_date)) {
					System.out.print("�߸��� ��¥�Դϴ�. �ٽ��Է��ϼ��� : ");
					cotest_date = reader.readLine();
				}
				vo3.setCotest_date(cotest_date);
				
				System.out.print("������ : ");
				String intvw_date = reader.readLine();
				
				//�Է°� Ȯ�� : �����Ϻ��� ���� �����ϴ��� Ȯ�� 
				while (!isAfter(intvw_date,cotest_date)) {
					System.out.print("�߸��� ��¥�Դϴ�. �ٽ��Է��ϼ��� : ");
					intvw_date = reader.readLine();
				}
				vo3.setIntvw_date(intvw_date);
				
				System.out.print("���������� : ");
				String rec_end = reader.readLine();
				
				//�Է°� Ȯ�� : �����Ϻ��� ���� ����Ǵ��� Ȯ�� 
				while (!isAfter(rec_end,intvw_date)) {
					System.out.print("�߸��� ��¥�Դϴ�. �ٽ��Է��ϼ��� : ");
					rec_end = reader.readLine();
				}
				vo3.setRec_end(rec_end);
				
				vo3.setCom_no(getComNoMax()); //������� ����� �ö� idx���� �Է�
				
				dao.insertRecInfo(vo3);
				
				System.out.println(); 
				System.out.println();
				System.out.println("------��� �Է� �Ϸ�------");
				System.out.print("�ٸ� ���� ������ �Է��Ͻðڽ��ϱ�? (y/n) :");
				yn = reader.readLine();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}while(yn.equalsIgnoreCase("y"));
		
		//���
		System.out.println(); 
		System.out.println();
		System.out.println("-----------������� ���� ���-----------");
		
		List<MyApplyListVo> myApplyList = dao.selectMyApplyList();
		
		System.out.println("[00][���][�о�][�ַ»��][�����][��������]");
		for (MyApplyListVo a : myApplyList) {
			
			System.out.printf("[%02d][%s][%s][%s][%s][%s]\n",
					a.getApply_no(),a.getCom_name(),a.getCom_cat(), a.getCom_focus(), a.getCom_name(), a.getApply_state());
			
		}
		
	}

	//ù��° ��¥��, �ι�° ��¥ ������ ���� ��¥���� Ȯ��
	private static boolean isAfter(String cotest_date, String doc_date) {

		String[] dates = {cotest_date, doc_date};
		
		LocalDate[] date = new LocalDate[2];
		
		for (int i = 0; i < 2; i++) {
			
			int year = Integer.parseInt(dates[i].substring(0,4));
			int month = Integer.parseInt(dates[i].substring(5,7));
			int day = Integer.parseInt(dates[i].substring(8,10));
			
			date[i] = LocalDate.of(year, month, day);
		}
		
		return date[0].isAfter(date[1]);
	}

	private static int getComNoMax() {
		return Collections.max(compMap.keySet());
	}

	private static int getComNo(String com_name) {
		
		for (int comNo : compMap.keySet()) {
			String comName = compMap.get(comNo);
			
			if (comName.equalsIgnoreCase(com_name)) {
				return comNo;
			}
		}
		
		return -1; //�ش��ϴ� comNo����
	}


}
