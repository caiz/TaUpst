package com.taupst.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taupst.dao.UserDao;
import com.taupst.model.User;
import com.taupst.queryhelper.UserQueryHelper;
import com.taupst.service.UserService;
import com.taupst.util.Page;


@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private UserDao userDao;// = DaoFactory.getUserDao();

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return this.userDao.getUserById(userId);
	}

	@Override
	public Page getUserByHelper(Page page, UserQueryHelper helper) {

		page.setTotalRecNum((long) this.userDao.getUserCountByHelper(helper));
		page.setPageContent(this.userDao.getUserByHelper(helper,
				page.getStartIndex(), page.getEndIndex()));
		return page;
	}

	@Override
	public int test() {
		return this.userDao.test();
	}

	@Override
	public boolean saveUserInfo(Map<String, String> stuInfo) {
		return this.userDao.saveUserInfo(stuInfo);
	}

	@Override
	public boolean isUserExist(String student_id, String school) {
		return this.userDao.isUserExist(student_id, school);
	}

	@Override
	public Map<String, String> login(String student_id, String pwd,
			String school) {
		return this.userDao.login(student_id, pwd, school);
	}
}
