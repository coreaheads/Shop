package shop.dto;

import java.io.Serializable;

public class OrderList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idx;
	private int orderNum;
	private int member_status_no;
	private int member_no;
	private int itemId;
	private int itemCount;
	private String postCode;
	private String addr1;
	private String addr2;
	private int totalPrice;
	private String celNum;
	private String orderDate;
	private String tbnum;
	private String depositor;
	private int payment_no;
	private String ip;
	private String orderStatus;

	public OrderList() {
		// TODO Auto-generated constructor stub
	}

	public OrderList(int idx, int orderNum, int member_status_no, int member_no, int itemId, int itemCount,
			String postCode, String addr1, String addr2, int totalPrice, String celNum, String orderDate, String tbnum,
			String depositor, int payment_no, String ip, String orderStatus) {
		super();
		this.idx = idx;
		this.orderNum = orderNum;
		this.member_status_no = member_status_no;
		this.member_no = member_no;
		this.itemId = itemId;
		this.itemCount = itemCount;
		this.postCode = postCode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.totalPrice = totalPrice;
		this.celNum = celNum;
		this.orderDate = orderDate;
		this.tbnum = tbnum;
		this.depositor = depositor;
		this.payment_no = payment_no;
		this.ip = ip;
		this.orderStatus = orderStatus;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getMember_status_no() {
		return member_status_no;
	}

	public void setMember_status_no(int member_status_no) {
		this.member_status_no = member_status_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCelNum() {
		return celNum;
	}

	public void setCelNum(String celNum) {
		this.celNum = celNum;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getTbnum() {
		return tbnum;
	}

	public void setTbnum(String tbnum) {
		this.tbnum = tbnum;
	}

	public String getDepositor() {
		return depositor;
	}

	public void setDepositor(String depositor) {
		this.depositor = depositor;
	}

	public int getPayment_no() {
		return payment_no;
	}

	public void setPayment_no(int payment_no) {
		this.payment_no = payment_no;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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
		OrderList other = (OrderList) obj;
		if (idx != other.idx)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderList [idx=" + idx + ", orderNum=" + orderNum + ", member_status_no=" + member_status_no
				+ ", member_no=" + member_no + ", itemId=" + itemId + ", itemCount=" + itemCount + ", postCode="
				+ postCode + ", addr1=" + addr1 + ", addr2=" + addr2 + ", totalPrice=" + totalPrice + ", celNum="
				+ celNum + ", orderDate=" + orderDate + ", tbnum=" + tbnum + ", depositor=" + depositor
				+ ", payment_no=" + payment_no + ", ip=" + ip + ", orderStatus=" + orderStatus + "]";
	}

	
	
}
