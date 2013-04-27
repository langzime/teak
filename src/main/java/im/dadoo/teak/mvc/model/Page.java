package im.dadoo.teak.mvc.model;

import im.dadoo.teak.util.Util;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("t_page")
public class Page {

	@Id
	private long id;
	
	@Name
	private String url;
	
	@Column
	private String name;
	
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

	public Page(){}
	
	public Page(String name, String url, String title, String author, String content) {
		this(name, url, title, author, content, System.currentTimeMillis());
	}
	
	public Page(String name, String url, String title, String author, String content, long publishTime) {
		this.name = name;
		this.url = url;
		this.title = title;
		this.author = author;
		this.content = content;
		this.text = Util.parse(this.content);
		this.publishTime = publishTime;
		this.updateTime = System.currentTimeMillis();
		this.click = 0;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

}
