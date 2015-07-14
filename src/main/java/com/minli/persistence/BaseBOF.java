package com.minli.persistence;


import org.apache.ibatis.session.SqlSessionFactory;

import com.minli.persistence.MyBatisUtil;

public class BaseBOF {
	static SqlSessionFactory sqlSessionFactory = null;
	static {
		sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
	}
}
