package shop.dto;

import java.io.Serializable;

public class MemberStatus implements Serializable{

	private static final long serialVersionUID = 1L;
	private int member_status_no;
	private String member_status_name;
	private int member_status_count;
	public MemberStatus() {
		// TODO Auto-generated constructor stub
	}
	public MemberStatus(int member_status_no, String member_status_name, int member_status_count) {
		super();
		this.member_status_no = member_status_no;
		this.member_status_name = member_status_name;
		this.member_status_count = member_status_count;
	}
	public int getMember_status_no() {
		return member_status_no;
	}
	public void setMember_status_no(int member_status_no) {
		this.member_status_no = member_status_no;
	}
	public String getMember_status_name() {
		return member_status_name;
	}
	public void setMember_status_name(String member_status_name) {
		this.member_status_name = member_status_name;
	}
	public int getMember_status_count() {
		return member_status_count;
	}
	public void setMember_status_count(int member_status_count) {
		this.member_status_count = member_status_count;
	}
	@Override
	public String toString() {
		return "MemberStatus [member_status_no=" + member_status_no + ", member_status_name=" + member_status_name
				+ ", member_status_count=" + member_status_count + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((member_status_name == null) ? 0 : member_status_name.hashCode());
		result = prime * result + member_status_no;
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
		MemberStatus other = (MemberStatus) obj;
		if (member_status_name == null) {
			if (other.member_status_name != null)
				return false;
		} else if (!member_status_name.equals(other.member_status_name))
			return false;
		if (member_status_no != other.member_status_no)
			return false;
		return true;
	}
	
}
