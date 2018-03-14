package com.example.demo.domain;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.AppConfig;


@Dao(config = AppConfig.class)
@ConfigAutowireable
public interface ItemRepository {
	@Select
	Item findOne(String itemCode);
}
