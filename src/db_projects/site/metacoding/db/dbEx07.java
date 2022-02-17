package db_projects.site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.driver.OracleDriver;

public class dbEx07 {
// INSERT 하기
	public static void main(String[] args) {
		try {
			// 1. connection 연결(세션생성) prot, ip, id, password, protocol을 기본으로 알려주기
			Connection conn = DriverManager.getConnection // ByteStream 소켓 연결
					  ("jdbc:oracle:thin:@13.124.112.253:1521:xe", "SCOTT3", "TIGER3");
			System.out.println("DB 연결 완료");
			
			// 2. 버퍼 달아서 통신(SELECT * FROM emp) 라이브러리로 프로토콜 알아서 붙여줌
			String sql = "DELETE FROM userTbl WHERE id = ?"; // 끝에 세미콜론 필요 없음
			// 쿼리 적기
			PreparedStatement pstmt = conn.prepareStatement(sql); // 쿼리 넣기
			pstmt.setInt(1, 7); // 물음표의 순서, 값
			// erro -1, 성공 처리된 row개수, 아무변화 없으면 0
			int result = pstmt.executeUpdate(); // delete, insert, update
			// 내부에 커밋 들고 있어서 삭제하면 HD에 삭제됨 
			// 결과 집합, 행 1개 불러옴
			// System.out.println(rs.next()); // 커서 한 칸 내리기 
			// 데이터가 있으면 트루, 없으면 펄스
				
			if(result > 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		}
		catch (Exception e1) {
			e1.printStackTrace();
			}
		
	
	}

		
	}


