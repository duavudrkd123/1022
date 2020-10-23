package co.micol.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.board.vo.MemberVO;

public class MemberDao extends DAO { // 상위 dao를 상속받아서 사용하겠다
	private PreparedStatement psmt; // sql 명령문을 실행할때 사용한다
	private ResultSet rs; // select후 결과 set을 받을때.
	private MemberVO vo;

	private final String SELECT_ALL = "SELECT * FROM MEMBER";
	// 보통은 final을 사용해서 수정못하게 만드어준다, 상수는 대문자로 만들어주고, 쿼리도 대문자로 써준다
	private final String SELECT = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
// 한행을 검색하는 쿼리를 만들어주었다. ?는 두개
	private final String INSERT = "INSERT INTO MEMBER (ID, NAME, PASSWORD, ADDRESS, TEL, ENTERDATE) VALUES(?,?,?,?,?,?)";

	public List<MemberVO> selectAll() { // 멤버리스트 전체를 가져오는 메소드,
		// list는 int, string, date ... 타입을 한꺼번에 다루기 편하다.
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			psmt = conn.prepareStatement(SELECT_ALL); // conn은 extends DAO덕분에 사용가능 //dbms에게 c쿼리 전달
			rs = psmt.executeQuery();
			while (rs.next()) { // rs.next()은 값이 있으면 tru 업으면 fas

				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setEnterdate(rs.getDate("enterdate"));
				vo.setAuthor(rs.getString("author"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public MemberVO select(MemberVO vo) { // 한행을 검색할떄
		try {
			psmt = conn.prepareStatement(SELECT);
			// ?대응을 만들어 보자
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				loginCheck();
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setEnterdate(rs.getDate("enterdate"));
				vo.setAuthor(rs.getString("author"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public int update(MemberVO vo) { // 멤버테이블에 업데이트
		int n = 0;

		return n;
	}

	public int delete(MemberVO vo) { // 멤버테이블에 삭제
		int n = 0;

		return n;
	}

	public int insert(MemberVO vo) { // 멤버테이블에 인서트하는거
		int n = 0;
		try {
			psmt = conn.prepareStatement(INSERT);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getPassword());
			psmt.setString(4, vo.getAddress());
			psmt.setString(5, vo.getTel());
			psmt.setDate(6, vo.getEnterdate());
			n = psmt.executeUpdate(); // insert update 쿼리는 executeupdate쓰고
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(); //db연결을 끊어준다.
		}
	}
}
// close를 하는 이유는 모든 커넥션을 끊어 주기 위해서 사용한다.
//이렇게 해주면 멤버dao 끝난다.
