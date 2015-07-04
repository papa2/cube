package com.papa2.cube.sync.service.impl;

import com.papa2.cube.api.record.IRecordService;
import com.papa2.cube.api.sync.ISyncService;

/**
 * 
 * @author xujiakun
 * 
 */
public class SyncServiceImpl implements ISyncService {

	private IRecordService recordService;

	@Override
	public void sync() {
		recordService.getRecordList();

	}

	public IRecordService getRecordService() {
		return recordService;
	}

	public void setRecordService(IRecordService recordService) {
		this.recordService = recordService;
	}

}
