package com.papa2.cube.record.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.papa2.cube.api.record.IRecordService;
import com.papa2.cube.api.record.bo.Record;
import com.papa2.cube.framework.util.LogUtil;
import com.papa2.cube.record.dao.IRecordDao;

public class RecordServiceImpl implements IRecordService {

	private Logger logger = Logger.getLogger(RecordServiceImpl.class);

	private IRecordDao recordDao;

	@Override
	public List<Record> getRecordList() {
		Record record = new Record();

		try {
			return recordDao.getRecordList(record);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(record), e);
		}

		return null;
	}

	public IRecordDao getRecordDao() {
		return recordDao;
	}

	public void setRecordDao(IRecordDao recordDao) {
		this.recordDao = recordDao;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

}
