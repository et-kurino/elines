package com.example.signup;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;

import com.AppConfig;

@Dao(config = AppConfig.class)
	public interface UserTableDao {



	    @Insert
	    int insert(UserDto userDto);

}

