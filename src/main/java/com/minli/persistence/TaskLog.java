package com.minli.persistence;

import java.util.Date;

public class TaskLog {
	private long taskLogId;
	private int taskStatus;
	private String logData;
	private String errorMessage;
	private Date creationDate;
	
	
	public long getTaskLogId() {
		return taskLogId;
	}

	public void setTaskLogId(long taskLogId) {
		this.taskLogId = taskLogId;
	}

	public int getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(int taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getLogData() {
		return logData;
	}

	public void setLogData(String logData) {
		this.logData = logData;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public TaskLog(long taskLogId, int taskStatus, String logData, String errorMessage, Date creationDate) {
		super();
		this.taskLogId = taskLogId;
		this.taskStatus = taskStatus;
		this.logData = logData;
		this.errorMessage = errorMessage;
		this.creationDate =creationDate;

	}
	
	public TaskLog() {
		super();
	}
	
	
}
