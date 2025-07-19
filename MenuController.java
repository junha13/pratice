package project;

import java.util.Scanner;

public class MenuController {
	static Scanner scan;
	static Db_method db;
	static int number;
	
	static public void setContext() throws Exception {
	scan = new Scanner(System.in);
	db = new Db_method();
	}
	
	static public void run() {
	while(true) { // 숫자 이외의 문자 입력시 오류
			System.out.println("==기능을 선택하세요==");
			System.out.println("1. 직원이름으로 직원정보 검색하기");
			System.out.println("2. 입사년도로 직원정보 검색하기");
			System.out.println("3. 부서번호로 직원정보 검색하기");
			System.out.println("4. 직무로 직원정보 검색하기");
			System.out.println("5. 도시이름으로 직원정보 검색하기");
			System.out.println("6. 통계자료 출력하기");
			System.out.println("7. 부서장 성으로 부서원 정보 검색하기");
			System.out.println("8. 나라이름으로 직원정보 검색하기");
			System.out.println("0. 프로그램 종료하기");
			System.out.println("선택 >>");
			
			//String  //그럼 스트링으로 받고 예외처리 해야 할까 
			// 너무 많은 고민이 있었지만 ~~스토리만들기
			// 문자열이면 
			try {
			    int number = scan.nextInt();
			    if (number < 0 || number > 8) {
			        throw new SelectNumberException();
			    }
			//} catch (InputMismatchException e) {
			//    System.out.println(new SelectInputException().getMessage());
			//    break;
			} catch (SelectNumberException e) {
			    System.out.println(e.getMessage());
			    break;
			}
			switch (number) {
				case 1 -> { 
						System.out.print("직원 이름을 입력하세요 : ");
						scan.nextLine();
						String fullName = scan.nextLine();
						db.findEmpInfoByEmpName(fullName);
				}					
				case 2 -> {
						System.out.print("입사년도를 입력하세요 : ");
						int year = scan.nextInt();
						scan.nextLine();
						db.findEmpInfoByHireYear(year);
				}
				case 3 -> {
						System.out.println("부서번호를 입력하세요 : [ex100]");
						int dpId = scan.nextInt();
						scan.nextLine();
						db.findEmpInfoByDeptId(dpId);
				}
				case 4 -> {
						System.out.print("직무를 입력하세요 : ");
						scan.nextLine();
						String job = scan.nextLine();
						db.findEmpInfoByJobId(job);
				}
				case 5 -> {
					System.out.print("도시명을 입력하세요 : ");
					scan.nextLine();
					String cityName = scan.nextLine();
					db.findEmpInfoByCity(cityName);
				}
				case 6 -> {
					System.out.println("어떤 연봉 통계자료를 출력할까요?");
					System.out.println("1. 부서별");
					System.out.println("2. 직무별");
					System.out.println("3. 도시별");
					System.out.println("4. 나라별");
					System.out.println("5. 대륙별");
					int selectSummry = scan.nextInt();
					db.getEmpSummaryData(selectSummry);	
				}
				case 7 -> {
					System.out.print("부서장 성을 입력하세요 : ");
					scan.nextLine();
					String managerLastName = scan.nextLine();
					db.findEmpInfoByManagerLastName(managerLastName);
				}
				case 8 -> {
					System.out.print("나라이름을 입력하세요 : ");
					scan.nextLine();
					String countryName = scan.nextLine();
					db.findEmpInfoByCountryName(countryName);
				}
				case 0 -> { 
					db.close();
					System.out.println("프로그램 종료");
						return;
			}
			
		}
		} 
		} 
	
	}



