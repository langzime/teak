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
	private int supId;
	
	@Column
	private int type;
	
	@Many(target = Post.class, field = "categoryId")
	private List<Post> posts;
	
	@Many(target = Category.class, field = "supId")
	private List<Category> subCategories;

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

	public int getSupId() {
		return supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}
	
}
