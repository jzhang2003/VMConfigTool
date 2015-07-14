package com.minli.persistence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;


public class TaskLogBOF extends BaseBOF {
	private static TaskLogBOF s_instance = new TaskLogBOF();
	public static Logger logger = Logger.getLogger(TaskLogBOF.class);

	public static TaskLogBOF getInstance() {
		return s_instance;
	}

	protected TaskLogBOF() {
	}
	
	public void deleteTaskLogById(long taskLogId) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			TaskLogMapper taskLogMapper = sqlSession
					.getMapper(TaskLogMapper.class);
			taskLogMapper.deleteTaskLogById(taskLogId);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			sqlSession.close();
		}
	}


	public void insertTaskLog(TaskLog taskLog)
			throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			TaskLogMapper taskLogMapper = sqlSession
					.getMapper(TaskLogMapper.class);
			taskLogMapper.insertTaskLog(taskLog);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			sqlSession.close();
		}
	}
	
	public void batchInsertTaskLog(List<TaskLog> taskLogList)
			throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			TaskLogMapper taskLogMapper = sqlSession
					.getMapper(TaskLogMapper.class);
			Iterator<TaskLog> iter = taskLogList.iterator();
			TaskLog taskLog = null;
			while(iter.hasNext()) {
				taskLog = iter.next();
				taskLogMapper.insertTaskLog(taskLog);	
			}
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			sqlSession.close();
		}
	}

	public TaskLog getTaskLogById(long taskLogId)
			throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			TaskLogMapper taskLogMapper = sqlSession
					.getMapper(TaskLogMapper.class);
			TaskLog taskLog = taskLogMapper
					.getTaskLogById(taskLogId);
			return taskLog;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			sqlSession.close();
		}
	}
	
	public List<TaskLog> getAllTaskLog()
			throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			TaskLogMapper taskLogMapper = sqlSession
					.getMapper(TaskLogMapper.class);
			List<TaskLog> taskLogList = taskLogMapper.getAllTaskLog();
			return taskLogList;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new Exception(e.getMessage(), e.getCause());
		} finally {
			sqlSession.close();
		}
	}

	

	

	public static void main(String[] args) {
		TaskLogBOF bof = TaskLogBOF.getInstance();
		try {
			TaskLog taskLog = bof.getTaskLogById(100L);
			System.out.println(taskLog.getErrorMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
