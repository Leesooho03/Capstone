package com.hy.capstone.user;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImple implements UserService {

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Override
	public int reg(UserVO vo) {
		return userDao.reg(vo);
	}

	@Override
	public UserVO login(UserVO vo, HttpSession session) {
		UserVO login_chk = userDao.login(vo);
		if(login_chk !=null) {
			session.setAttribute("user_name", vo.getUser_name());
			session.setAttribute("user_rank", vo.getUser_rank());
			session.setAttribute("login_chk", login_chk);
		}
		return login_chk;
	}

}
