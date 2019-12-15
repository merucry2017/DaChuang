package cn.tedu.store.entity;

/**
 * 商品数据的实体类
 */
public class Books extends BaseEntity {

    private static final long serialVersionUID = 5960164494648879998L;

    private Long id;
    private String writer;
    private String itemType;
    private String title;
    private String content;
    private String image;
    private Integer status;
    private Integer priority;
    private String publishTime;
    private Integer page;
    private String themeWords;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getThemeWords() {
		return themeWords;
	}
	public void setThemeWords(String themeWords) {
		this.themeWords = themeWords;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", writer=" + writer + ", itemType=" + itemType + ", title=" + title + ", content="
				+ content + ", image=" + image + ", status=" + status + ", priority=" + priority + ", publishTime="
				+ publishTime + ", page=" + page + ", themeWords=" + themeWords + "]";
	}
	  

}
