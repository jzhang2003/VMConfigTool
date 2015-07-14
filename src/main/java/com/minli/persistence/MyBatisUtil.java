package com.minli.persistence;

import java.io.IOException; 
import java.io.Reader; 
  
import org.apache.ibatis.io.Resources; 
import org.apache.ibatis.session.SqlSessionFactory; 
import org.apache.ibatis.session.SqlSessionFactoryBuilder; 
  
public class MyBatisUtil  { 
    private  static SqlSessionFactory sqlSessionFactory = null; 
    static { 
       String resource = "mybatis-config.xml"; 
       Reader reader = null; 
       try { 
           reader = Resources.getResourceAsReader(resource); 
       } catch (IOException e) { 
           System.out.println(e.getMessage()); 
           
       } 
       
       try{
           sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); 
       } catch (Exception e) {
       		e.printStackTrace();
       }
    } 
    
    public static SqlSessionFactory getSqlSessionFactory() { 
       return sqlSessionFactory; 
    } 
} 