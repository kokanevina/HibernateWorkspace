package com.pojo;

public class Author {
	private int authorId;
	private String authorName;
	private double writingExp;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}
	public Author(int authorId, String authorName, double writingExp) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.writingExp = writingExp;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public double getWritingExp() {
		return writingExp;
	}
	public void setWritingExp(double writingExp) {
		this.writingExp = writingExp;
	}
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", writingExp=" + writingExp + "]";
	}
	
}
