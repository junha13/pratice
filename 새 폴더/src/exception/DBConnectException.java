package exception;

import project.DBMethod;

public class DBConnectException extends Exception{
	public DBConnectException(String url, String username, String password) {
		super("//오류가 발생하였습니다 \n오류번호 03: DB연결 오류 \nDB 주소를 다시 확인해주세요//\n입력값 : \n[" + url + "]\n[" + username +"]\n[" +password + "]//");
		
	}

}

