package db_projects.site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dbEx02 {

	public static void main(String[] args) {
		// deptno 데이터 모두 출력하기
		// SELECT deptno, dname, loc FROM dept
		
		try {
			// 1. connection 연결(세션생성) prot, ip, id, password, protocol을 기본으로 알려주기
			Connection conn = DriverManager.getConnection // ByteStream 소켓 연결
					  ("jdbc:oracle:thin:@13.124.112.253:1521:xe", "SCOTT3", "TIGER3");
			System.out.println("DB 연결 완료");
			
			// 2. 버퍼 달아서 통신(SELECT * FROM emp) 라이브러리로 프로토콜 알아서 붙여줌
			String sql = "SELECT deptno, dname, loc FROM dept"; // 끝에 세미콜론 필요 없음
			// 쿼리 적기
			PreparedStatement pstmt = conn.prepareStatement(sql); // 쿼리 넣기
			ResultSet rs = pstmt.executeQuery(); //SELECT
			// 결과 집합, 행 1개 불러옴
			// System.out.println(rs.next()); // 커서 한 칸 내리기 
			// 데이터가 있으면 트루, 없으면 펄스
			
			while(rs.next()) { // 커서 내리면서 트루일 때만 데이터 출력, 펄스면 와일 빠져나오기 
				System.out.println("deptno : " + rs.getInt("deptno")); // 컬럼명 쓰기 
				System.out.println("dname : " + rs.getString("dname"));
				System.out.println("loc : " + rs.getString("loc"));
				// 클래스로 파싱하기
			}
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
