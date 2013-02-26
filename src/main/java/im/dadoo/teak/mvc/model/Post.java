package im.dadoo.teak.mvc.model;

import java.sql.Timestamp;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Table("t_post")
public class Post {

	public Post(){}
	
	public Post(String title, String author, String content, int categoryId) {
		this.title = title;
		this.author = author;
		this.content = content;
		this.text = content;
		this.publishTime = System.currentTimeMillis();
		this.click = 0;
		this.headerImageName = null;
		this.categoryId = categoryId;
	}
	
	@Id
	private long id;
	
	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column
	private String content;
	
	@Column
	private String text;
	
	@Column
	private long publishTime;
	
	@Column
	private long updateTime;
	
	@Column
	private long click;
	
	@Column
	private String headerImageName;
	
	@Column
	private int categoryId;
	
	@One(target = Category.class, field = "categoryId")
	private Category category;
	
	private boolean newPost;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	public long getClick() {
		return click;
	}

	public void setClick(long click) {
		this.click = click;
	}

	public String getHeaderImageName() {
		return headerImageName;
	}

	public void setHeaderImageName(String headerImageName) {
		this.headerImageName = headerImageName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isNewPost() {
		return newPost;
	}

	public void setNewPost(boolean newPost) {
		this.newPost = newPost;
	}

}
