package cn.tedu.store.vo;

import java.io.Serializable;

/**
 * 购物车数据的VO类
 */
public class CartVO implements Serializable {

    private static final long serialVersionUID = -1375921507047753775L;

    private Integer tid;
    private Integer uid;
    private Integer bid;
    private String title;
    private String image;
    private String writer;
	private String question;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "CartVO [tid=" + tid + ", uid=" + uid + ", bid=" + bid + ", title=" + title + ", image=" + image
				+ ", writer=" + writer + ", question=" + question + "]";
	}
    
	
    // SET/GET/toString
    
}
