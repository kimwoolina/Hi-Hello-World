package member.model.vo;

import java.sql.Date;

//do(domain object) == vo(value object) == dto(data transfer object)
//VO명은 테이블명과 이름을 맞춘다.
//반드시 직렬화 해야 한다.
//컬럼값 저장하는 용도로 만들어진 객체
public class Member implements java.io.Serializable { 
	private static final long serialVersionUID = 1L;
	
	private String userId; //회원 아이디 저장
	private String userPwd; //회원 암호
	private String userName; //회원 이름
	private Date startDate; //회원 가입 날짜
	private Date lastModified; //회원정보 마지막 수정날짜
	private String phone; //회원 전화번호
	private String addr; //회원 주소
	private String email; //회원 이메일
	private String myBlock; //차단한 회원
	private String userLev; //사용자분류 --A이면 구매자 , B이면 판매자, C이면 구매자이자 판매자, D이면 관리자(디폴트 기본값은 A)
	
	public Member() {} //기본생성자 > 기본값으로 초기화 시켜라(ex. String > null)

	public Member(String userId, String userPwd, String userName, Date startDate, Date lastModified, String phone,
			String addr, String email, String myBlock, String userLev) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.startDate = startDate;
		this.lastModified = lastModified;
		this.phone = phone;
		this.addr = addr;
		this.email = email;
		this.myBlock = myBlock;
		this.userLev = userLev;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMyBlock() {
		return myBlock;
	}

	public void setMyBlock(String myBlock) {
		this.myBlock = myBlock;
	}

	public String getUserLev() {
		return userLev;
	}

	public void setUserLev(String userLev) {
		this.userLev = userLev;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", startDate="
				+ startDate + ", lastModified=" + lastModified + ", phone=" + phone + ", addr=" + addr + ", email="
				+ email + ", myBlock=" + myBlock + ", userLev=" + userLev + "]";
	}
	
}
