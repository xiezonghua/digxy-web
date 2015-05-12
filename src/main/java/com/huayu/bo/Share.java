package com.huayu.bo;

import com.huayu.bo.base.ShareBase;

/**
* 
*
*/
public class Share extends ShareBase {

	private String resname;
	/**
	 * type
	 */
	private Byte restype;

	/**
	 * dic type
	 */
	private Byte dictype;

	/**
	 * who commit
	 */
	private Long uploaderid;

	/**
	 * who commit
	 */
	private String uploader;
	/**
	 * click times
	 */
	private Integer clicktimes;

	/**
	 * download times
	 */
	private Integer downloadtimes;

	/**
	 * document class
	 */
	private Byte resstar;

	/**
	 * resource state
	 */
	private Byte resstatus;

	public String getResname() {
		return resname;
	}

	public void setResname(String resname) {
		this.resname = resname;
	}

	public Byte getRestype() {
		return restype;
	}

	public void setRestype(Byte restype) {
		this.restype = restype;
	}

	public Byte getDictype() {
		return dictype;
	}

	public void setDictype(Byte dictype) {
		this.dictype = dictype;
	}

	public Long getUploaderid() {
		return uploaderid;
	}

	public void setUploaderid(Long uploaderid) {
		this.uploaderid = uploaderid;
	}

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public Integer getClicktimes() {
		return clicktimes;
	}

	public void setClicktimes(Integer clicktimes) {
		this.clicktimes = clicktimes;
	}

	public Integer getDownloadtimes() {
		return downloadtimes;
	}

	public void setDownloadtimes(Integer downloadtimes) {
		this.downloadtimes = downloadtimes;
	}

	public Byte getResstar() {
		return resstar;
	}

	public void setResstar(Byte resstar) {
		this.resstar = resstar;
	}

	public Byte getResstatus() {
		return resstatus;
	}

	public void setResstatus(Byte resstatus) {
		this.resstatus = resstatus;
	}

}