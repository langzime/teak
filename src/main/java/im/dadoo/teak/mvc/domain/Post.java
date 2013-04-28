package im.dadoo.teak.mvc.domain;

import im.dadoo.teak.util.Util;

public class Post{

	private Long id;
	private String title;
	private String author;
	private String html;
	private String text;
	private Long publishDatetime;
	private Long updateDatetime;
	private Long click;
	private String thumbnailPath;
	private Integer state;
	private Category category;
	
	public Post() {}
	
	public static Post create(String title, String author, String html,
			String thumbnailPath, Category category) {
		Post post = new Post();
		
		post.title = title;
		post.author = author;
		post.html = html;
		post.text = Util.parse(html);
		post.publishDatetime = System.currentTimeMillis();
		post.click = (long) 0;
		post.thumbnailPath = thumbnailPath;
		post.category = category;
		
		return post;
	}
	
	public Long getId() {
		return id;
	}
	
	private void setId(Long id) {
		this.id = id;
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
	
	public String getThumbnailPath() {
		return thumbnailPath;
	}
	
	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
}
