package shop.dto;

import java.io.Serializable;

public class Category implements Serializable{

	private int idx;
	private String categoryName;
	private int rootNum;
	private int step;
	private String division;
	private int seq;
	private char isDel;
	
public Category() {
	// TODO Auto-generated constructor stub
}

public Category(int idx, String categoryName, int rootNum, int step, String division, int seq, char isDel) {
	super();
	this.idx = idx;
	this.categoryName = categoryName;
	this.rootNum = rootNum;
	this.step = step;
	this.division = division;
	this.seq = seq;
	this.isDel = isDel;
}

public int getIdx() {
	return idx;
}

public void setIdx(int idx) {
	this.idx = idx;
}

public String getCategoryName() {
	return categoryName;
}

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

public int getRootNum() {
	return rootNum;
}

public void setRootNum(int rootNum) {
	this.rootNum = rootNum;
}

public int getStep() {
	return step;
}

public void setStep(int step) {
	this.step = step;
}

public String getDivision() {
	return division;
}

public void setDivision(String division) {
	this.division = division;
}

public int getSeq() {
	return seq;
}

public void setSeq(int seq) {
	this.seq = seq;
}

public char getIsDel() {
	return isDel;
}

public void setIsDel(char isDel) {
	this.isDel = isDel;
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
	Category other = (Category) obj;
	if (idx != other.idx)
		return false;
	return true;
}

@Override
public String toString() {
	return "Category [idx=" + idx + ", categoryName=" + categoryName + ", rootNum=" + rootNum + ", step=" + step
			+ ", division=" + division + ", seq=" + seq + ", isDel=" + isDel + "]";
}



	
	
	
}
