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
		
		//Loop : 사용자에게 지원정보 입력 질문
		//[1] 지원한 공고 정보를 입력하세요
		//[2] 부가 정보를 입력하시겠습니까? (지원한 기업의 복지수준) -- 일단 제외
		do {
			
			try {
				
				//입력
				System.out.println("----먼저, 지원 공고에 대한 사전 질문을 입력하세요-----");
				System.out.print("이력서 제출을 완료했습니까? (y/n) : ");
				if (reader.readLine().equalsIgnoreCase("y")) {
					
					System.out.print("이력서 제출일 : ");
					vo1.setApply_date(reader.readLine());
					vo1.setApply_state("서류완료");
					
					System.out.print("이력서 링크가 있습니까? (y/n) : ");
					if (reader.readLine().equalsIgnoreCase("y")) {
						System.out.print("이력서 링크를 입력하세요 : ");
						vo1.setApply_doc(reader.readLine());
					}
					
				}else {
					vo1.setApply_state("대기");
				}
				
				dao.insertApplyInfo(vo1); //지원상태에 대해 DB에 넣기
				//dao = MyApplyDao.getInstance();//갱신 -- 해야하나?
				
				System.out.println(); 
				System.out.println();
				System.out.println("----이제, 지원하려는 기업 정보를 입력하세요-----");
				System.out.print("기업명 : ");
				String com_name = reader.readLine();
				
				//이미 그 기업명이 등록된 적이 있다면 DB정보만 가져온다
				if (compMap.containsValue(com_name)) {
					com_no = getComNo(com_name);
				}
				//그렇지 않다면 DB에 새로 등록
				else {
					vo2.setCom_name(com_name);
					System.out.print("기업카테고리 : ");
					vo2.setCom_cat(reader.readLine());
					System.out.print("기업주력사업 : ");
					vo2.setCom_focus(reader.readLine());
				}
				
				//apply_no
				applyNo_max = dao.getMaxApplyNo();
				vo2.setApply_no(applyNo_max);
				
				dao.insertComInfo(vo2);
				compMap = dao.getCompMap(); //얘는 갱신 필요
				//dao = MyApplyDao.getInstance();//한번 더 갱신
				
				System.out.println(); 
				System.out.println();
				System.out.println("----마지막으로, 지원하려는 공고 정보를 입력하세요-----");
				System.out.print("공고명 : ");
				vo3.setRec_name(reader.readLine());
				System.out.print("공고링크 : ");
				vo3.setRec_link(reader.readLine());
				System.out.print("필수자격 : ");
				vo3.setRec_req(reader.readLine());
				System.out.print("우대요건 : ");
				vo3.setRec_pref(reader.readLine());
				
				System.out.print("이력서마감일 : ");
				String doc_date = reader.readLine();
				vo3.setDoc_date(doc_date);
				
				System.out.print("코딩테스트일 : ");
				String cotest_date = reader.readLine();
				
				//입력값 확인 : 이력서일보다 일찍 시작하는지 확인 
				while (!isAfter(cotest_date,doc_date)) {
					System.out.print("잘못된 날짜입니다. 다시입력하세요 : ");
					cotest_date = reader.readLine();
				}
				vo3.setCotest_date(cotest_date);
				
				System.out.print("면접일 : ");
				String intvw_date = reader.readLine();
				
				//입력값 확인 : 코테일보다 일찍 시작하는지 확인 
				while (!isAfter(intvw_date,cotest_date)) {
					System.out.print("잘못된 날짜입니다. 다시입력하세요 : ");
					intvw_date = reader.readLine();
				}
				vo3.setIntvw_date(intvw_date);
				
				System.out.print("지원마감일 : ");
				String rec_end = reader.readLine();
				
				//입력값 확인 : 면접일보다 일찍 종료되는지 확인 
				while (!isAfter(rec_end,intvw_date)) {
					System.out.print("잘못된 날짜입니다. 다시입력하세요 : ");
					rec_end = reader.readLine();
				}
				vo3.setRec_end(rec_end);
				
				vo3.setCom_no(getComNoMax()); //기업정보 저장시 올라간 idx정보 입력
				
				dao.insertRecInfo(vo3);
				
				System.out.println(); 
				System.out.println();
				System.out.println("------모든 입력 완료------");
				System.out.print("다른 지원 정보를 입력하시겠습니까? (y/n) :");
				yn = reader.readLine();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}while(yn.equalsIgnoreCase("y"));
		
		//출력
		System.out.println(); 
		System.out.println();
		System.out.println("-----------현재까지 지원 목록-----------");
		
		List<MyApplyListVo> myApplyList = dao.selectMyApplyList();
		
		System.out.println("[00][기업][분야][주력사업][공고명][지원상태]");
		for (MyApplyListVo a : myApplyList) {
			
			System.out.printf("[%02d][%s][%s][%s][%s][%s]\n",
					a.getApply_no(),a.getCom_name(),a.getCom_cat(), a.getCom_focus(), a.getCom_name(), a.getApply_state());
			
		}
		
	}

	//첫번째 날짜가, 두번째 날짜 다음에 오는 날짜인지 확인
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
		
		return -1; //해당하는 comNo없음
	}


}
