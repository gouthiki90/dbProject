package db_projects.site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dbEx03 {

	// PREpareStatement 변수 바인딩 하기
	public static void login(String username, String password) {
		try {
			// 1. connection 연결(세션생성) prot, ip, id, password, protocol을 기본으로 알려주기
			Connection conn = DriverManager.getConnection // ByteStream 소켓 연결
			("jdbc:oracle:thin:@13.124.112.253:1521:xe", "SCOTT3", "TIGER3");
			System.out.println("DB 연결 완료");

			// 2. 버퍼 달아서 통신(SELECT * FROM emp) 라이브러리로 프로토콜 알아서 붙여줌
			String sql = "SELECT * FROM usertbl WHERE username = ? AND password = ?"; // 끝에 세미콜론 필요 없음
			// 변수를 넣으면 공격 당할 수 있음
			PreparedStatement pstmt = conn.prepareStatement(sql); // 쿼리 넣기
			pstmt.setString(1, username); // 물음표의 첫 번째 자리
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery(); // SELECT
			// 결과 집합, 행 1개 불러옴
			// System.out.println(rs.next()); // 커서 한 칸 내리기
			// 데이터가 있으면 트루, 없으면 펄스

			while (rs.next()) { // 커서 내리면서 트루일 때만 데이터 출력, 펄스면 와일 빠져나오기
				System.out.println("로그인 되었습니다."); // 컬럼명 쓰기
				// 클래스로 파싱하기
				Session.isLogin = true; // 이렇게 하면 어떤 파일에서든 로그인 체크가 가능
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// sql injection 방어
	public static void main(String[] args) {
		login("love", "love1234");
		System.out.println(Session.isLogin);

	}
}
