package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.DBConnectException;
import exception.SQLQueryException;


public class Db_method { 
	
	static public Connection conn;
	// 생성자에 커넥션을 넣어서 실행 -> main에 db객체 생성
	
	public Db_method() {
		try {
			conn = DriverManager.getConnection(DBConfig.set("urhl"), DBConfig.set("userName"), DBConfig.set("passWord"));
	// 실행 오류 시 DB 연결 실패 메세지 전송
		} catch (SQLException e) {
			System.out.println(new DBConnectException(DBConfig.set("url"), DBConfig.set("userName"), DBConfig.set("passWord")).getMessage());
		}
	}
	
	// 직원정보를 담은 리스트 생성과 sql 실행, 들어오는 값으로 sql과 파라메타값 (object)를 받음
	
	
	// 위와 같은 메서드로 집계함수 정보를 담은 리스트 생성과 sql 실행

	
		//기능들 메서드
		public void findEmpInfoByEmpName(String fullName) { // 직원이름
		List<EmpInfo> empList = CreateList.executeQuery(DBConfig.set("getEmpInfoByEmpNameSql"), fullName);
		System.out.println("==이름이 " + fullName + "인 직원정보==");
		if(empList.size()==0) {
			System.out.println("직원이 존재하지 않습니다!");
		}
		for(EmpInfo emp : empList) {
			System.out.println(emp);
			}
		}	
		public void findEmpInfoByHireYear(int year) { // 입사년도 작동 ㅇ
		List<EmpInfo> empList = CreateList.executeQuery(DBConfig.set("getEmpInfoByHireYearSql"), year);
		System.out.println("==" + year + "년 입사 직원정보==");
		if(empList.size()==0) {
			System.out.println("직원이 존재하지 않습니다!");
		}
		for(EmpInfo emp : empList) {
			System.out.println(emp);
			}
		}
		public void findEmpInfoByDeptId(int deptId) { // 부서번호 작동 o
			List<EmpInfo> empList = CreateList.executeQuery(DBConfig.set("getEmpInfoByDeptIdSql"), deptId);
			System.out.println("==부서번호가 " + deptId + "인 직원정보==");
			if(empList.size()==0) {
				System.out.println("직원이 존재하지 않습니다!");
			}
			for(EmpInfo emp : empList) {
				System.out.println(emp);
			}
		}
		public void findEmpInfoByJobId(String job) { // 직무 작동 ㅇ
			List<EmpInfo> empList = CreateList.executeQuery(DBConfig.set("getEmpInfoByJobIdSql"), job);
			System.out.println("==" + job + "직군인 직원정보==");
			if(empList.size()==0) {
				System.out.println("직원이 존재하지 않습니다!");
			}
			for(EmpInfo emp : empList) {
				System.out.println(emp);
			}
		}	
		public void findEmpInfoByCity(String cityName) {
			List<EmpInfo> empList = CreateList.executeQuery(DBConfig.set("getEmpInfoByCityNameSelect"), cityName);
			System.out.println("==" + cityName + "에서 근무하는 직원정보==");
			if(empList.size()==0) {
				System.out.println("직원이 존재하지 않습니다!");
			}
			for(EmpInfo emp : empList) {
				System.out.println(emp);
			}
		}
		public void getEmpSummaryData(int selectSummaryN) {
			List<SummryData> sumDataList;
			
			if(selectSummaryN == 1) {
				sumDataList = CreateList.executeQueryS(DBConfig.set("sumDpId"));
				System.out.println("==부서별 연봉 통계입니다==");
			}else if(selectSummaryN == 2) {
				sumDataList = CreateList.executeQueryS(DBConfig.set("sumJob"));
				System.out.println("==직무별 연봉 통계입니다==");
			}else if(selectSummaryN == 3){
				sumDataList = CreateList.executeQueryS(DBConfig.set("sumCity"));
				System.out.println("==도시별 연봉 통계입니다==");
			}else if(selectSummaryN == 4){
				sumDataList = CreateList.executeQueryS(DBConfig.set("sumCountry"));
				System.out.println("==나라별 연봉 통계입니다==");
			}else if(selectSummaryN == 5){
				sumDataList = CreateList.executeQueryS(DBConfig.set("sumRegion"));
				System.out.println("==대륙별 연봉 통계입니다==");
			}else {
				System.out.println("==잘못입력하셨습니다==");
				return;
			}
			
			for(SummryData sum : sumDataList) {
				System.out.println(sum);
			}
		}
		public void findEmpInfoByManagerLastName(String managerLastName) { 
			List<EmpInfo> empList = CreateList.executeQuery(DBConfig.set("getEmpInfoByManagerId"), managerLastName);
			System.out.println("==매니저 성이 " + managerLastName + "인 부서원정보==");
			if(empList.size()==0) {
				System.out.println("직원이 존재하지 않습니다!");
			}
			for(EmpInfo emp : empList) {
				System.out.println(emp);
			}
		}
		public void findEmpInfoByCountryName(String countryName) { // 나라이름
			List<EmpInfo> empList = CreateList.executeQuery(DBConfig.set("getEmpInfoByCountryName"), countryName);
			System.out.println("==" + countryName + "에서 근무하는 직원정보==");
			if(empList.size()==0) {
				System.out.println("직원이 존재하지 않습니다!");
			}
			for(EmpInfo emp : empList) {
				System.out.println(emp);
			}
		}
		// 콘솔 닫는 메서드 
		public void close() {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
					System.out.println("DB 연결 해제");
				}
			} catch (SQLException e) {
					
			}
		}

	
}
	
