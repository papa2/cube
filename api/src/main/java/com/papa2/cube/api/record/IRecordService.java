package com.papa2.cube.api.record;

import java.util.List;

import com.papa2.cube.api.record.bo.Record;

/**
 * 获取停车场系统数据.
 * 
 * @author xujiakun
 * 
 */
public interface IRecordService {

	/**
	 * 获得所有信息.
	 * 
	 * @param type
	 * @return
	 */
	List<Record> getRecordList(String type);

}
