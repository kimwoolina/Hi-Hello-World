package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import member.model.vo.Member;
import static common.JDBCTemp.close; // common의 static 메소드만 import해라

//쿼리문 작성해서 db로 전달해서 실행하고 결과받음
//select 문은 받은 결과(ResultSet)를 vo객체에 옮겨 저장(결과매핑)해서 리턴 처리함
public class MemberDao {
	public MemberDao() {
	}

	// 로그인 처리용 메소드 : select
	public Member selectLogin(Connection conn, String userId, String userPwd) {
		Member m = null; // 선언
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from users where user_id = ? and user_pwd = ?";

		try {
			// statement객체는 쿼리생성 완성해 놓고 쿼리문 넣어서 실행이지만. pstmt는 미완성된 쿼리로 객체부터 먼저 생성한후 쿼리문을
			// 완성시키는 진행함
			pstmt = conn.prepareStatement(query); // PreparedStatement객체 생성
			// 객체 생성 후에 쿼리문을 완성시킴
			pstmt.setString(1, userId); // .set자료형(물음표의순번/*무조건 1부터시작*/, 전달할값)
			pstmt.setString(2, userPwd); // 2번째 물음표에 userPwd 적용해라

			// 쿼리문 실행시키고 결과 받음
			rset = pstmt.executeQuery(); // 이미 pstmt객체가 쿼리내용을 가지고 있으므로 > statement객체와 다른점

			if (rset.next()) {
				m = new Member(); // 생성

				m.setUserId(rset.getString("user_id")); // 컬럼명은 대소문자 구분 x //rset의 정보 꺼내서 m객체에 저장하는 작업
				m.setUserPwd(rset.getString("user_pwd")); // 두번째 컬럼(userpwd)
				m.setUserName(rset.getString("user_name"));
				m.setStartDate(rset.getDate("user_start_date"));
				m.setLastModified(rset.getDate("user_modify_date"));
				m.setPhone(rset.getString("phone"));
				m.setAddr(rset.getString("addr"));
				m.setEmail(rset.getString("email"));
				m.setMyBlock(rset.getString("my_block"));
				m.setUserLev(rset.getString("user_lev"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}

	// 회원 가입 처리용 메소드 : insert
	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;

		//String query = "insert into users values (?, ?, ?, sysdate, sysdate, ?, ?, ?, null, default) ";
		String query = "insert into users values (?, ?, ?, sysdate, sysdate, ?, ?, ?, null, 'A') ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getAddr());
			pstmt.setString(6, member.getEmail());

			result = pstmt.executeUpdate(); // select > executequery, dml > executeUpdate

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 회원 탈퇴 처리용 메소드 : delete
	public int deleteMember(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "delete from users where user_id = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);

			result = pstmt.executeUpdate(); // select > executequery, dml > executeUpdate

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 회원 정보 보기 처리용 메소드 : select
	public Member selectMember(Connection conn, String userId) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from users where user_id = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				m = new Member(); // 생성

				m.setUserId(rset.getString("user_id")); // 컬럼명은 대소문자 구분 x //rset의 정보 꺼내서 m객체에 저장하는 작업
				m.setUserPwd(rset.getString("user_pwd")); // 두번째 컬럼(userpwd)
				m.setUserName(rset.getString("user_name"));
				m.setStartDate(rset.getDate("user_start_date"));
				m.setLastModified(rset.getDate("user_modify_date"));
				m.setPhone(rset.getString("phone"));
				m.setAddr(rset.getString("addr"));
				m.setEmail(rset.getString("email"));
				m.setMyBlock(rset.getString("my_block"));
				m.setUserLev(rset.getString("user_lev"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}

	// 회원 정보 수정 처리용 메소드 : update
	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update users set user_pwd = ?, phone = ?, addr = ?, email = ?, user_modify_date = sysdate where user_id = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserPwd());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddr());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getUserId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 관리자용 회원 전체 조회 처리용 메소드 : select
	public ArrayList<Member> selectList(Connection conn) {
		ArrayList<Member> list = new ArrayList<Member>();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * from users";

		try {
			stmt = conn.createStatement(); // 쿼리문 실행 위한 객체 생성
			rset = stmt.executeQuery(query); // 결과 rset이 받음
			while (rset.next()) { // resultSet 표모양으로 생긴 객체임. 제일 첫번째칸 BOF(비기너 파일) > Row1, row2 , ... , EOF > 가장 처음에
									// BOF값 받음. BOF에서 ROW1로 넘어가는 동작이 next. EOF 위치로 내려오면 자동으로 false가 리턴됨. > 반복문 끝남.
									// (다음 행이 존재할 경우 true)
				Member m = new Member(); // 한 행의 정보를 저장할 객체 생성

				m.setUserId(rset.getString("user_id")); // 컬럼명은 대소문자 구분 x //rset의 정보 꺼내서 m객체에 저장하는 작업
				m.setUserPwd(rset.getString("user_pwd")); // 두번째 컬럼(userpwd)
				m.setUserName(rset.getString("user_name"));
				m.setStartDate(rset.getDate("user_start_date"));
				m.setLastModified(rset.getDate("user_modify_date"));
				m.setPhone(rset.getString("phone"));
				m.setAddr(rset.getString("addr"));
				m.setEmail(rset.getString("email"));
				m.setMyBlock(rset.getString("my_block"));
				m.setUserLev(rset.getString("user_lev"));

				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	public int selectCheckId(Connection conn, String userid) {
		int idcount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select count(user_id) from users where user_id = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				idcount = rset.getInt(1);
				System.out.println("idcount : " + idcount);
			} // 없으면 0 있으면 1개
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return idcount;
	}

	public int updateUserLev(Connection conn, String userid, String userLev) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update users set user_lev = ? where user_id = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userLev);
			pstmt.setString(2, userid);

			result = pstmt.executeUpdate();
		} catch (Exception e) {	
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 이름,이메일로 아이디 찾기
	public String findId(Connection conn, String name, String email) {
		String userId = null; // 찾을아이디
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select user_id from users where user_name = ? and email = ?";

		try {
			pstmt = conn.prepareStatement(query); 
			pstmt.setString(1, name);
			pstmt.setString(2, email); 

			rset = pstmt.executeQuery(); 
			while (rset.next()) {
				userId = rset.getString("user_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return userId;
	}

	// 비밀번호 찾기
	public String findPw(Connection conn, String id, String phone) {
		String userPw = null; //찾을 비밀번호
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select user_pwd from users where user_id = ? and phone = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, phone);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				userPw = rset.getString("user_pwd");
			}
			//System.out.println(userPw);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userPw;
	}


}