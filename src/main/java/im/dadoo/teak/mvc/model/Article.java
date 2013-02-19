package im.dadoo.teak.mvc.model;

import java.sql.Timestamp;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Table("t_article")
public class Article {

	public Article(){}
	
	public Article(String author, String title, 
			String headerImagePath, String content, int categoryId) {
		this.id = -1;
		this.author = author;
		this.title = title;
		this.headerImagePath = headerImagePath;
		this.content = content;
		this.categoryId = categoryId;
		this.publishTime = new Timestamp(System.currentTimeMillis());
		this.click = 0;
		this.category = null;
	}
	
	@Id
	private long id;
	
	@Column
	private String author;
	
	@Column
	private String title;
	
	@Column
	private String headerImagePath;
	
	@Column
	private String content;
	
	@Column
	private Timestamp publishTime;
	
	@Column
	private long click;
	
	@Column
	private int categoryId;
	
	@One(target = Category.class, field = "categoryId")
	private Category category;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHeaderImagePath() {
		return headerImagePath;
	}

	public void setHeaderImagePath(String headerImagePath) {
		this.headerImagePath = headerImagePath;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public long getClick() {
		return click;
	}

	public void setClick(long click) {
		this.click = click;
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

}
