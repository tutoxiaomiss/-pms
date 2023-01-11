package com.ybt.pojo;

public class News {
	private int id;
	private String type;
	private String title;
	private String content;
	private String date;
	private String author;

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	public News(int id, String type, String title, String content, String date, String author) {
		super();
		this.id = id;
		this.type = type;
		this.title = title;
		this.content = content;
		this.date = date;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {

		return date;
	}

	public void setDate(String date) {

		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", type=" + type + ", title=" + title + ", content=" + content + ", date=" + date
				+ ", author=" + author + "]";
	}

}
