package com.hy.capstone.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao {
	private final SqlSession sql;
	
	@Autowired
	public UserDao(SqlSession sql) {
		this.sql = sql;
	}
	
	
	public int reg(UserVO vo) {
		return sql.insert("UserSQL.regUser", vo);
	}


	public UserVO login(UserVO vo) {
		return sql.selectOne("UserSQL.login",vo);
	}



}
