package shop.dto;

public class BoardConfig {
	private int idx;
	private String board_name;
	private String board_code;
	private String baord_type;
	private String url;
	private char is_delete;
	private String create_time;
	private String update_time;
	private char is_open;
	private char is_reply;
	private char is_comment;
	private int editer;
	private char is_file;
	private int file_cnt;
	private char is_readonly;
	private char is_viewcnt;
	private char is_lock;
	private char is_notice;
	private char is_del;
	public BoardConfig() {
		// TODO Auto-generated constructor stub
	}
	public BoardConfig(int idx, String board_name, String board_code, String baord_type, String url, char is_delete,
			String create_time, String update_time, char is_open, char is_reply, char is_comment, int editer,
			char is_file, int file_cnt, char is_readonly, char is_viewcnt, char is_lock, char is_notice, char is_del) {
		super();
		this.idx = idx;
		this.board_name = board_name;
		this.board_code = board_code;
		this.baord_type = baord_type;
		this.url = url;
		this.is_delete = is_delete;
		this.create_time = create_time;
		this.update_time = update_time;
		this.is_open = is_open;
		this.is_reply = is_reply;
		this.is_comment = is_comment;
		this.editer = editer;
		this.is_file = is_file;
		this.file_cnt = file_cnt;
		this.is_readonly = is_readonly;
		this.is_viewcnt = is_viewcnt;
		this.is_lock = is_lock;
		this.is_notice = is_notice;
		this.is_del = is_del;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_code() {
		return board_code;
	}
	public void setBoard_code(String board_code) {
		this.board_code = board_code;
	}
	public String getBaord_type() {
		return baord_type;
	}
	public void setBaord_type(String baord_type) {
		this.baord_type = baord_type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public char getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(char is_delete) {
		this.is_delete = is_delete;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public char getIs_open() {
		return is_open;
	}
	public void setIs_open(char is_open) {
		this.is_open = is_open;
	}
	public char getIs_reply() {
		return is_reply;
	}
	public void setIs_reply(char is_reply) {
		this.is_reply = is_reply;
	}
	public char getIs_comment() {
		return is_comment;
	}
	public void setIs_comment(char is_comment) {
		this.is_comment = is_comment;
	}
	public int getEditer() {
		return editer;
	}
	public void setEditer(int editer) {
		this.editer = editer;
	}
	public char getIs_file() {
		return is_file;
	}
	public void setIs_file(char is_file) {
		this.is_file = is_file;
	}
	public int getFile_cnt() {
		return file_cnt;
	}
	public void setFile_cnt(int file_cnt) {
		this.file_cnt = file_cnt;
	}
	public char getIs_readonly() {
		return is_readonly;
	}
	public void setIs_readonly(char is_readonly) {
		this.is_readonly = is_readonly;
	}
	public char getIs_viewcnt() {
		return is_viewcnt;
	}
	public void setIs_viewcnt(char is_viewcnt) {
		this.is_viewcnt = is_viewcnt;
	}
	public char getIs_lock() {
		return is_lock;
	}
	public void setIs_lock(char is_lock) {
		this.is_lock = is_lock;
	}
	public char getIs_notice() {
		return is_notice;
	}
	public void setIs_notice(char is_notice) {
		this.is_notice = is_notice;
	}
	public char getIs_del() {
		return is_del;
	}
	public void setIs_del(char is_del) {
		this.is_del = is_del;
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
		BoardConfig other = (BoardConfig) obj;
		if (idx != other.idx)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BoardConfig [idx=" + idx + ", board_name=" + board_name + ", board_code=" + board_code + ", baord_type="
				+ baord_type + ", url=" + url + ", is_delete=" + is_delete + ", create_time=" + create_time
				+ ", update_time=" + update_time + ", is_open=" + is_open + ", is_reply=" + is_reply + ", is_comment="
				+ is_comment + ", editer=" + editer + ", is_file=" + is_file + ", file_cnt=" + file_cnt
				+ ", is_readonly=" + is_readonly + ", is_viewcnt=" + is_viewcnt + ", is_lock=" + is_lock
				+ ", is_notice=" + is_notice + ", is_del=" + is_del + "]";
	}
	
}
