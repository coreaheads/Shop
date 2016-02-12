package shop.dto;

public class BoardComment {
	private int idx;
	private String writer;
	private String content;
	private int like_cnt;
	private int bad_cnt;
	private String create_date;
	private String update_date;
	private char is_del;
	private int reproot;
	private int repstep;
	private int repindent;
	private int boardnum;
	private String ip;
	public BoardComment() {
		// TODO Auto-generated constructor stub
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLike_cnt() {
		return like_cnt;
	}
	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}
	public int getBad_cnt() {
		return bad_cnt;
	}
	public void setBad_cnt(int bad_cnt) {
		this.bad_cnt = bad_cnt;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public char getIs_del() {
		return is_del;
	}
	public void setIs_del(char is_del) {
		this.is_del = is_del;
	}
	public int getReproot() {
		return reproot;
	}
	public void setReproot(int reproot) {
		this.reproot = reproot;
	}
	public int getRepstep() {
		return repstep;
	}
	public void setRepstep(int repstep) {
		this.repstep = repstep;
	}
	public int getRepindent() {
		return repindent;
	}
	public void setRepindent(int repindent) {
		this.repindent = repindent;
	}
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public BoardComment(int idx, String writer, String content, int like_cnt, int bad_cnt, String create_date,
			String update_date, char is_del, int reproot, int repstep, int repindent, int boardnum, String ip) {
		super();
		this.idx = idx;
		this.writer = writer;
		this.content = content;
		this.like_cnt = like_cnt;
		this.bad_cnt = bad_cnt;
		this.create_date = create_date;
		this.update_date = update_date;
		this.is_del = is_del;
		this.reproot = reproot;
		this.repstep = repstep;
		this.repindent = repindent;
		this.boardnum = boardnum;
		this.ip = ip;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idx;
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
		BoardComment other = (BoardComment) obj;
		if (idx != other.idx)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BoardComment [idx=" + idx + ", writer=" + writer + ", content=" + content + ", like_cnt=" + like_cnt
				+ ", bad_cnt=" + bad_cnt + ", create_date=" + create_date + ", update_date=" + update_date + ", is_del="
				+ is_del + ", reproot=" + reproot + ", repstep=" + repstep + ", repindent=" + repindent + ", boardnum="
				+ boardnum + ", ip=" + ip + "]";
	}
	
	
}
