package com.minli.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession; 
import org.apache.ibatis.session.SqlSessionFactory; 
import org.junit.Test; 

import com.minli.persistence.*;
  
public class TaskLogBOFTest { 
    static SqlSessionFactory sqlSessionFactory = null; 
    static { 
       sqlSessionFactory = MyBatisUtil.getSqlSessionFactory(); 
    } 
    
    @Test 
    public void testAdd() { 
       SqlSession sqlSession = sqlSessionFactory.openSession(); 
       try { 
    	   TaskLogMapper taskLogMapper = sqlSession.getMapper(TaskLogMapper.class); 
    	   TaskLog taskLog = new TaskLog(0,1,"somelog2","someerror2",new Date()); 
    	   taskLogMapper.insertTaskLog(taskLog); 
           sqlSession.commit();
       } finally { 
           sqlSession.close(); 
       } 
    }
    
//    @Test 
//    public void testUpdate() { 
//       SqlSession sqlSession = sqlSessionFactory.openSession(); 
//       try { 
//    	   TaskLogMapper taskLogMapper = sqlSession.getMapper(TaskLogMapper.class); 
//    	   TaskLog taskLog = taskLogMapper.getTaskLogById(1000000001);
//    	   taskLog.setErrorMessage("more error");
//    	   taskLogMapper.updateTaskLog(taskLog); 
//           sqlSession.commit();
//       } finally { 
//           sqlSession.close(); 
//       } 
//    }
//    
//    @Test 
//    public void testDelete() { 
//       SqlSession sqlSession = sqlSessionFactory.openSession(); 
//       try { 
//    	   TaskLogMapper taskLogMapper = sqlSession.getMapper(TaskLogMapper.class); 
//    	   taskLogMapper.deleteTaskLogById(1000000001);
//           sqlSession.commit();
//       } finally { 
//           sqlSession.close(); 
//       } 
//    } 
//    
//    @Test 
//    public void getTaskLogById() { 
//       SqlSession sqlSession = sqlSessionFactory.openSession(); 
//       try { 
//    	   TaskLogMapper taskLogMapper = sqlSession.getMapper(TaskLogMapper.class); 
//    	   TaskLog taskLog = taskLogMapper.getTaskLogById(1000000001);
//           System.out.println("errorMessage: "+taskLog.getErrorMessage()+"|logData: "+taskLog.getLogData()); 
//       } catch (Exception e) {
//    	   e.printStackTrace();
//       } finally { 
//           sqlSession.close(); 
//       } 
//    }
    

    
    
    
    @Test 
    public void getAllTaskLog() { 
       SqlSession sqlSession = sqlSessionFactory.openSession(); 
       try { 
    	   TaskLogMapper taskLogMapper = sqlSession.getMapper(TaskLogMapper.class); 
    	   List<TaskLog> taskLogList = taskLogMapper.getAllTaskLog();
           System.out.println("errorMessage: "+taskLogList.get(1).getErrorMessage()+"|logData: "+taskLogList.get(1).getLogData()); 
       } catch (Exception e) {
    	   e.printStackTrace();
       } finally { 
           sqlSession.close(); 
       } 
    }
    
    
 
  
} 