package cn.tedu.store.entity;

import java.util.Date;

/**
 * 用户数据的实体类
 */
public class Comment extends BaseEntity {

    private static final long serialVersionUID = 8777086855777796877L;

    private Integer id;
    private Integer uid;
    private Integer bid;
    private String comm;
    private String title;
    private String writer;
    private String username;
    private Integer isdelete;
    private String created_user;
    private Date created_time;
    private String image;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getComm() {
		return comm;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getIsDelete() {
		return isdelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isdelete = isDelete;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCreated_user() {
		return created_user;
	}
	public void setCreated_user(String created_user) {
		this.created_user = created_user;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", uid=" + uid + ", bid=" + bid + ", comm=" + comm + ", title=" + title
				+ ", writer=" + writer + ", username=" + username + ", isdelete=" + isdelete + ", created_user="
				+ created_user + ", created_time=" + created_time + ", image=" + image + "]";
	}	
    
    // GET/SET/toString

}