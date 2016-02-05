package shop.dto;

public class Cart {
	
	private int idx;
	private String memberId;
	private String ip;
	private String itemId;
	private int itemCount;
	private int itemPrice;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int idx, String memberId, String ip, String itemId, int itemCount, int itemPrice) {
		super();
		this.idx = idx;
		this.memberId = memberId;
		this.ip = ip;
		this.itemId = itemId;
		this.itemCount = itemCount;
		this.itemPrice = itemPrice;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
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
		Cart other = (Cart) obj;
		if (idx != other.idx)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [idx=" + idx + ", memberId=" + memberId + ", ip=" + ip + ", itemId=" + itemId + ", itemCount="
				+ itemCount + ", itemPrice=" + itemPrice + "]";
	}
	
	
	
}
