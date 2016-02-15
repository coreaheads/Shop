package shop.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Member implements Serializable{

	private static final long serialVersionUID = 1L;
	private int member_no;
	@NotNull
	@Size(min=4,message="아이디를 4자 이상 적어주세요.")
	private String member_id;
	@NotNull
	@Size(min=4,message="비밀번호를 4자 이상 적어주세요.")	
	private String member_pw;
	@NotNull
	@Size(min=2,message="이름을 2자 이상 적어주세요.")		
	private String member_name;
	private String member_post;
	private String member_addr;
	private String member_number;
	private int member_level_no;
	private int member_status_no;
	private Date member_regist_date;
	private MemberLevel memberLevel;
	private MemberStatus memberStatus;
	
	
	public Member(int member_no, String member_id, String member_pw, String member_name, String member_post,
			String member_addr, String member_number, int member_level_no, int member_status_no,
			Date member_regist_date, MemberLevel memberLevel, MemberStatus memberStatus) {
		super();
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_post = member_post;
		this.member_addr = member_addr;
		this.member_number = member_number;
		this.member_level_no = member_level_no;
		this.member_status_no = member_status_no;
		this.member_regist_date = member_regist_date;
		this.memberLevel = memberLevel;
		this.memberStatus = memberStatus;
	}

	public MemberLevel getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(MemberLevel memberLevel) {
		this.memberLevel = memberLevel;
	}

	public MemberStatus getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(MemberStatus memberStatus) {
		this.memberStatus = memberStatus;
	}

	public Member() {}

	public Member(int member_no, String member_id, String member_pw, String member_name, String member_post,
			String member_addr, String member_number, int member_level_no, int member_status_no,
			Date member_regist_date) {
		super();
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_post = member_post;
		this.member_addr = member_addr;
		this.member_number = member_number;
		this.member_level_no = member_level_no;
		this.member_status_no = member_status_no;
		this.member_regist_date = member_regist_date;
	}



	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_post() {
		return member_post;
	}

	public void setMember_post(String member_post) {
		this.member_post = member_post;
	}

	public String getMember_addr() {
		return member_addr;
	}

	public void setMember_addr(String member_addr) {
		this.member_addr = member_addr;
	}

	public String getMember_number() {
		return member_number;
	}

	public void setMember_number(String member_number) {
		this.member_number = member_number;
	}

	public int getMember_level_no() {
		return member_level_no;
	}

	public void setMember_level_no(int member_level_no) {
		this.member_level_no = member_level_no;
	}

	public int getMember_status_no() {
		return member_status_no;
	}

	public void setMember_status_no(int member_status_no) {
		this.member_status_no = member_status_no;
	}

	public Date getMember_regist_date() {
		return member_regist_date;
	}

	public void setMember_regist_date(Date member_regist_date) {
		this.member_regist_date = member_regist_date;
	}

	@Override
	public String toString() {
		return "Member [member_no=" + member_no + ", member_id=" + member_id + ", member_name=" + member_name
				+ ", member_post=" + member_post + ", member_addr=" + member_addr + ", member_number=" + member_number
				+ ", member_level_no=" + member_level_no + ", member_status_no=" + member_status_no
				+ ", member_regist_date=" + member_regist_date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((member_id == null) ? 0 : member_id.hashCode());
		result = prime * result + member_no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (member_id == null) {
			if (other.member_id != null)
				return false;
		} else if (!member_id.equals(other.member_id))
			return false;
		if (member_no != other.member_no)
			return false;
		return true;
	}
	
	
}
