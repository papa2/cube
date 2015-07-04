package com.papa2.cube.record.dao.impl;

import java.util.List;

import com.papa2.cube.api.record.bo.Record;
import com.papa2.cube.framework.dao.impl.BaseDaoImpl;
import com.papa2.cube.record.dao.IRecordDao;

public class RecordDaoImpl extends BaseDaoImpl implements IRecordDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Record> getRecordList(Record record) {
		return getSqlMapClientTemplate().queryForList("record.getRecordList", record);
	}

}
