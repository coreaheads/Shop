package shop.dto;

import java.io.Serializable;

public class MemberLevel implements Serializable{


	private static final long serialVersionUID = 1L;
	private int member_level_no;
	private String member_level_name;
	private int member_level_count;
	public MemberLevel() {
		// TODO Auto-generated constructor stub
	}
	public MemberLevel(int member_level_no, String member_level_name, int member_level_count) {
		super();
		this.member_level_no = member_level_no;
		this.member_level_name = member_level_name;
		this.member_level_count = member_level_count;
	}
	@Override
	public String toString() {
		return "MemberLevel [member_level_no=" + member_level_no + ", member_level_name=" + member_level_name
				+ ", member_level_count=" + member_level_count + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + member_level_count;
		result = prime * result + ((member_level_name == null) ? 0 : member_level_name.hashCode());
		result = prime * result + member_level_no;
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
		MemberLevel other = (MemberLevel) obj;
		if (member_level_count != other.member_level_count)
			return false;
		if (member_level_name == null) {
			if (other.member_level_name != null)
				return false;
		} else if (!member_level_name.equals(other.member_level_name))
			return false;
		if (member_level_no != other.member_level_no)
			return false;
		return true;
	}
	public int getMember_level_no() {
		return member_level_no;
	}
	public void setMember_level_no(int member_level_no) {
		this.member_level_no = member_level_no;
	}
	public String getMember_level_name() {
		return member_level_name;
	}
	public void setMember_level_name(String member_level_name) {
		this.member_level_name = member_level_name;
	}
	public int getMember_level_count() {
		return member_level_count;
	}
	public void setMember_level_count(int member_level_count) {
		this.member_level_count = member_level_count;
	}
	
}
