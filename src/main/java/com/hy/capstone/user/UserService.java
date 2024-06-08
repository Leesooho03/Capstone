package com.hy.capstone.user;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface UserService {

	int reg(UserVO vo);

	UserVO login(UserVO vo, HttpSession session);


}
