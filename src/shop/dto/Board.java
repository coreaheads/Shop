package shop.dto;

import org.springframework.web.multipart.MultipartFile;

public class Board {

	private int idx;	
	private int board_code;        
	private int categorys;          
	private String title;         
	private String writer;         
	private String passwd;         
	private String email;         
	private String content;	
	private String remote_addr;         
	private String create_time;                 
	private String update_time;                 
	private String is_notice;          
	private int likecnt;          
	private int badcnt;           
	private String is_comment;              
	private String is_reply;              
	private String is_private;              
	private int seq;     
	private int levels;   
	private int step;      
	private int filecnt;       
	private int hits;   
	private int member_seq;           
	private String is_del;
	private MultipartFile imgFile;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int idx, int board_code, int categorys, String title, String writer, String passwd, String email,
			String content, String remote_addr, String create_time, String update_time, String is_notice, int likecnt,
			int badcnt, String is_comment, String is_reply, String is_private, int seq, int levels, int step,
			int filecnt, int hits, int member_seq, String is_del) {
		super();
		this.idx = idx;
		this.board_code = board_code;
		this.categorys = categorys;
		this.title = title;
		this.writer = writer;
		this.passwd = passwd;
		this.email = email;
		this.content = content;
		this.remote_addr = remote_addr;
		this.create_time = create_time;
		this.update_time = update_time;
		this.is_notice = is_notice;
		this.likecnt = likecnt;
		this.badcnt = badcnt;
		this.is_comment = is_comment;
		this.is_reply = is_reply;
		this.is_private = is_private;
		this.seq = seq;
		this.levels = levels;
		this.step = step;
		this.filecnt = filecnt;
		this.hits = hits;
		this.member_seq = member_seq;
		this.is_del = is_del;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getBoard_code() {
		return board_code;
	}

	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}

	public int getCategorys() {
		return categorys;
	}

	public void setCategorys(int categorys) {
		this.categorys = categorys;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemote_addr() {
		return remote_addr;
	}

	public void setRemote_addr(String remote_addr) {
		this.remote_addr = remote_addr;
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

	public String getIs_notice() {
		return is_notice;
	}

	public void setIs_notice(String is_notice) {
		this.is_notice = is_notice;
	}

	public int getLikecnt() {
		return likecnt;
	}

	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}

	public int getBadcnt() {
		return badcnt;
	}

	public void setBadcnt(int badcnt) {
		this.badcnt = badcnt;
	}

	public String getIs_comment() {
		return is_comment;
	}

	public void setIs_comment(String is_comment) {
		this.is_comment = is_comment;
	}

	public String getIs_reply() {
		return is_reply;
	}

	public void setIs_reply(String is_reply) {
		this.is_reply = is_reply;
	}

	public String getIs_private() {
		return is_private;
	}

	public void setIs_private(String is_private) {
		this.is_private = is_private;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getFilecnt() {
		return filecnt;
	}

	public void setFilecnt(int filecnt) {
		this.filecnt = filecnt;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}

	public String getIs_del() {
		return is_del;
	}

	public void setIs_del(String is_del) {
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
		Board other = (Board) obj;
		if (idx != other.idx)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Board [idx=" + idx + ", board_code=" + board_code + ", categorys=" + categorys + ", title=" + title
				+ ", writer=" + writer + ", passwd=" + passwd + ", email=" + email + ", content=" + content
				+ ", remote_addr=" + remote_addr + ", create_time=" + create_time + ", update_time=" + update_time
				+ ", is_notice=" + is_notice + ", likecnt=" + likecnt + ", badcnt=" + badcnt + ", is_comment="
				+ is_comment + ", is_reply=" + is_reply + ", is_private=" + is_private + ", seq=" + seq + ", levels="
				+ levels + ", step=" + step + ", filecnt=" + filecnt + ", hits=" + hits + ", member_seq=" + member_seq
				+ ", is_del=" + is_del + "]";
	}
	

}
