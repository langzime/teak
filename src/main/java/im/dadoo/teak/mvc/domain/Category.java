package im.dadoo.teak.mvc.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Category {

	private Integer id;
	private String name;
	private String description;
	private Integer state;
	private Category sup;
	private Set<Category> subs = new HashSet<Category>();
	private Set<Post> posts = new TreeSet<Post>();

	public Category(){}
	
	public static Category create(String name, String description, Category sup) {
		Category category = new Category();
		category.name = name;
		category.description = description;
		category.state = 0;
		category.sup = sup;
		return category;
	}

	public Integer getId() {
		return id;
	}

	private void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Category getSup() {
		return sup;
	}

	public void setSup(Category sup) {
		this.sup = sup;
	}

	public Set<Category> getSubs() {
		return subs;
	}

	public void setSubs(Set<Category> subs) {
		this.subs = subs;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
}
