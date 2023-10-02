package com.library.sb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.sb.entity.Login;
import com.library.sb.repository.LoginRepository;
import com.library.sb.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginRepository lrepo;

	@Override
	public Login loginUser(String userName, String password) {
		Login login = lrepo.findByUserNameAndPassword(userName, password);
		return login;
	}


}
