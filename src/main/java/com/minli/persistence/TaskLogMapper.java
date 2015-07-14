package com.minli.persistence;


import java.util.HashMap;
import java.util.List;



public interface TaskLogMapper {
	public void insertTaskLog(TaskLog taskLog);
	public void updateTaskLog(TaskLog taskLog);
	public void deleteTaskLogById(long taskLogId);
	public TaskLog getTaskLogById(long taskLogId);
	public List<TaskLog> getAllTaskLog();
}
