package com.huayu.bo;

import java.util.Date;

import com.huayu.bo.base.ResourcesBase;

/**
* 
*
*/
public class Resources extends ResourcesBase {
	/**
	 * who download id
	 */
	private Long downloaderid;

	/**
	 * who download
	 */
	private String downloader;

	/**
	 * download date time
	 */
	private Date downloaddate;

	/**
	 * collector id
	 */
	private Long collectionId;
	/**
	 * collect date time
	 */
	private Date collectiondate;

	public Long getDownloaderid() {
		return downloaderid;
	}

	public void setDownloaderid(Long downloaderid) {
		this.downloaderid = downloaderid;
	}

	public String getDownloader() {
		return downloader;
	}

	public void setDownloader(String downloader) {
		this.downloader = downloader;
	}

	public Date getDownloaddate() {
		return downloaddate;
	}

	public void setDownloaddate(Date downloaddate) {
		this.downloaddate = downloaddate;
	}

	public Long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}

	public Date getCollectiondate() {
		return collectiondate;
	}

	public void setCollectiondate(Date collectiondate) {
		this.collectiondate = collectiondate;
	}

}