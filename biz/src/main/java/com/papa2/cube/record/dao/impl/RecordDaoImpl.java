package com.papa2.cube.record.dao.impl;

import java.util.List;

import com.papa2.cube.api.record.bo.Record;
import com.papa2.cube.framework.dao.impl.BaseDaoImpl;
import com.papa2.cube.record.dao.IRecordDao;

/**
 * 
 * @author xujiakun
 * 
 */
public class RecordDaoImpl extends BaseDaoImpl implements IRecordDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Record> getRecordList(String type, Record record) {
		if ("I".equals(type)) {
			return getSqlMapClientTemplate().queryForList("record.getRecordList1", record);
		} else if ("O".equals(type)) {
			return getSqlMapClientTemplate().queryForList("record.getRecordList2", record);
		}

		return null;
	}
}
