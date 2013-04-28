package im.dadoo.teak.mvc.domain;

import im.dadoo.teak.util.Util;

public class Page {

	private Long id;
	private String name;
	private String title;
	private String author;
	private String html;
	private String text;
	private Long publishDatetime;
	private Long updateDatetime;
	private Long click;
	private Integer state;

	public Page(){}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getPublishDatetime() {
		return publishDatetime;
	}

	public void setPublishDatetime(Long publishDatetime) {
		this.publishDatetime = publishDatetime;
	}

	public Long getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Long updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public Long getClick() {
		return click;
	}

	public void setClick(Long click) {
		this.click = click;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
}
