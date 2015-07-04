package com.papa2.cube.record.dao;

import java.util.List;

import com.papa2.cube.api.record.bo.Record;

/**
 * 
 * @author xujiakun
 * 
 */
public interface IRecordDao {

	/**
	 * 获取停车系统数据.
	 * 
	 * @param record
	 * @return
	 */
	List<Record> getRecordList(Record record);

}
