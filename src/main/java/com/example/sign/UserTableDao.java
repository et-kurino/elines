package com.example.sign;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;

import com.example.config.AppConfig;

@Dao(config = AppConfig.class)
	public interface UserTableDao {



	    @Insert
	    int insert(UserDto userDto);

}

