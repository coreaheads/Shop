package shop.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class Item implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idx;
	private String itemName;
	private String itemContent;
	private int itemLevel;
	private int sale;
	private int itemPrice;
	private int itemCount;
	private int itemCategory;
	private String url;
	private char idDel;
	private MultipartFile imgFile;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(int idx, String itemName, String itemContent, int itemLevel, int sale, int itemPrice, int itemCount,
			int itemCategory, String url, char idDel, MultipartFile imgFile) {
		super();
		this.idx = idx;
		this.itemName = itemName;
		this.itemContent = itemContent;
		this.itemLevel = itemLevel;
		this.sale = sale;
		this.itemPrice = itemPrice;
		this.itemCount = itemCount;
		this.itemCategory = itemCategory;
		this.url = url;
		this.idDel = idDel;
		this.imgFile = imgFile;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}

	public int getItemLevel() {
		return itemLevel;
	}

	public void setItemLevel(int itemLevel) {
		this.itemLevel = itemLevel;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(int itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public char getIdDel() {
		return idDel;
	}

	public void setIdDel(char idDel) {
		this.idDel = idDel;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
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
		Item other = (Item) obj;
		if (idx != other.idx)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [idx=" + idx + ", itemName=" + itemName + ", itemContent=" + itemContent + ", itemLevel="
				+ itemLevel + ", sale=" + sale + ", itemPrice=" + itemPrice + ", itemCount=" + itemCount
				+ ", itemCategory=" + itemCategory + ", url=" + url + ", idDel=" + idDel + ", imgFile=" + imgFile + "]";
	}
	
	
	
}
