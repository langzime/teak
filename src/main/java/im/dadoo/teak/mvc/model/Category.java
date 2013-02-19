package im.dadoo.teak.mvc.model;

import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("t_category")
public class Category {

	@Id
	private int id;
	
	@Column
	private String name;
	
	@Name
	private String url;
	
	@Column
	private String description;
	
	@Column
	private int parentId;
	
	@Column
	private int type;
	
	@Many(target = Post.class, field = "categoryId")
	private List<Post> articles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Post> getArticles() {
		return articles;
	}

	public void setArticles(List<Post> articles) {
		this.articles = articles;
	}
	
}
