package com.blog.model;

public class Blog {
	private Long id;
	private String title;
	private String content;
	private String Date;
	private String author;

	public Blog(Long id, String title, String content, String date,
			String author) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		Date = date;
		this.author = author;
	}

	public Blog() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content
				+ ", Date=" + Date + ", author=" + author + "]";
	}
}
