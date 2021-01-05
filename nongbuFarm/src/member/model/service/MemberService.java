package member.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

import member.model.dao.MemberDao;
import member.model.vo.Member;

//컨트롤러에서 넘겨받음 (뷰파일 --> 컨트롤러 --> 서비스 --> dao)
//서비스가 커넥션을 만들어서 dao에 넘긴다
//서비스의 역할 : db 연결/닫기, 트랜잭션 관리 : commit/rollback 전담하는 클래스 (dao의 역할을 분리 시킨것)
public class MemberService {
	// 의존성 주입(Dependency Injection : DI) = 사용할 클래스를 미리 여기서 선언 하는 것
	private MemberDao mdao = new MemberDao();

	public MemberService() {
	}

	// 로그인 처리용
	public Member selectLogin(String userId, String userPwd) {
		Connection conn = getConnection(); // db연결 위한 커넥션 준비 (DB연결)
		Member member = mdao.selectLogin(conn, userId, userPwd); // 셀렉트 조회 결과 Member클래스의 member가 받아라 >구동시킴
		close(conn); // 디비 연결 닫기
		return member; // 다시 컨트롤러로 리턴 //회원정보 전체 담아서 보내려고 Member반환
	}

	// 회원가입 처리용
	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = mdao.insertMember(conn, member);
		if (result > 0)
			commit(conn); // JDBCTemp의 commit 실행시킴
		else
			rollback(conn); // JDBCTemp의 rollback 실행시킴
		close(conn);
		return result;
	}

	// 회원탈퇴 처리용
	public int deleteMember(String userId) {
		Connection conn = getConnection();
		int result = mdao.deleteMember(conn, userId);
		if (result > 0)
			commit(conn); // JDBCTEMP의 commit 실행시킴
		else
			rollback(conn); // JDBCTEMP의 rollback 실행시킴
		close(conn);
		return result;
	}

	// 회원정보 수정 처리용
	public int updateMember(Member member) {
		Connection conn = getConnection();
		int result = mdao.updateMember(conn, member);
		if (result > 0)
			commit(conn); // JDBCTEMP의 commit 실행시킴
		else
			rollback(conn); // JDBCTEMP의 rollback 실행시킴
		close(conn);
		return result;
	}

	// 회원정보 조회 처리용
	public Member selectMember(String userId) {
		Connection conn = getConnection();
		Member member = mdao.selectMember(conn, userId);
		close(conn);
		return member;
	}

	// 관리자용 전체 회원 조회 처리용
	public ArrayList<Member> selectList() {
		Connection conn = getConnection();
		ArrayList<Member> list = mdao.selectList(conn);
		close(conn);
		return list;
	}

	public int selectCheckId(String userid) {
		Connection conn = getConnection();
		int idcount = mdao.selectCheckId(conn, userid);
		close(conn);
		return idcount;
	}

	public int updateUserLev(String userid, String userLev) {
		Connection conn = getConnection();
		int result = mdao.updateUserLev(conn, userid, userLev);
		if (result > 0)
			commit(conn); // JDBCTEMP의 commit 실행시킴
		else
			rollback(conn); // JDBCTEMP의 rollback 실행시킴
		close(conn);
		return result;
	}

	//이름,이메일로 아이디 찾기
	public String findId(String name, String email) {
		Connection conn = getConnection();
		String id =  mdao.findId(conn, name, email);
		close(conn); // 디비 연결 닫기
		return id;
	}

	//비밀번호 찾기
	public String findPw(String id,String phone){
		Connection conn = getConnection();
		String pw =  mdao.findPw(conn, id, phone);
		close(conn); // 디비 연결 닫기
		return pw;
	}
}
