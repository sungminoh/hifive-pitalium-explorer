package com.htmlhifive.pitalium.explorer.response;

import java.sql.Time;

public class ResultDirectory {
	private Integer id;

	private String name;
	
	private long timestamp;
	
	private String dirTimestamp;

	private Integer numberOfResults;

	private Integer numberOfScreenshots;

	private Integer numberOfBrowsers;
	
	public ResultDirectory(){
		this(0, "", 0, "", 0, 0, 0);
	}

	public ResultDirectory(Integer id, String name, long timestamp, String dirTimestamp, Integer numberOfResults, Integer numberOfScreenshots, Integer numberOfBrowsers) {
		this.id = id;
		this.name = name;
		this.timestamp = timestamp;
		this.dirTimestamp = dirTimestamp;
		this.numberOfResults = numberOfResults;
		this.numberOfScreenshots = numberOfScreenshots;
		this.numberOfBrowsers = numberOfBrowsers;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getDirTimestamp() {
		return dirTimestamp;
	}
	
	public void setDirTimestamp(String dirTimestamp){
		this.dirTimestamp = dirTimestamp;
	}

	public Integer getNumberOfResults() {
		return numberOfResults;
	}

	public void setNumberOfResults(Integer numberOfResults) {
		this.numberOfResults = numberOfResults;
	}

	public Integer getNumberOfScreenshots() {
		return numberOfScreenshots;
	}

	public void setNumberOfScreenshots(Integer numberOfScreenshots) {
		this.numberOfScreenshots = numberOfScreenshots;
	}
	
	public Integer getNumberOfBrowsers() {
		return numberOfBrowsers;
	}
	
	public void setNumberOfBrowsers(Integer numberOfBrowsers) {
		this.numberOfBrowsers = numberOfBrowsers;
	}
}
