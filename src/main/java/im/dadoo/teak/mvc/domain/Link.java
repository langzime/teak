package im.dadoo.teak.mvc.domain;

public class Link {
	
	private Integer id;
	private String url;
	private String name;
	private String description;

	public Link(){}
	
	public static Link create(String name, String url, String description) {
		Link link = new Link();
		link.url = url;
		link.name = name;
		link.description = description;
		return link;
	}
	
	public Integer getId() {
		return id;
	}

	private void setId(Integer id) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
