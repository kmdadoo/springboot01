package com.study.springboot.dao;

import java.util.List;

import com.study.springboot.dto.SimpleBbsDto;

// 나중에 사용하기 때문에 여기서 먼저 사용함.
public interface ISimpleBbsDao {

	public List<SimpleBbsDto> listDao();
	public SimpleBbsDto viewDao(String id);
	public int writeDao(String writer, String title, String content);
	public int deleteDao(String id);
}
