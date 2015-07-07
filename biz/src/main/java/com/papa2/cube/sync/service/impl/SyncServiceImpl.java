package com.papa2.cube.sync.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.papa2.cube.api.record.IRecordService;
import com.papa2.cube.api.record.bo.Record;
import com.papa2.cube.api.sync.ISyncService;
import com.papa2.cube.framework.util.HttpUtil;
import com.papa2.cube.framework.util.LogUtil;

/**
 * 
 * @author xujiakun
 * 
 */
public class SyncServiceImpl implements ISyncService {

	private Logger logger = Logger.getLogger(SyncServiceImpl.class);

	private IRecordService recordService;

	private String platformRecordUrl;

	private String serialNo;

	@Override
	public void sync() {
		List<Record> list = recordService.getRecordList();

		if (list != null && list.size() > 0) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("serialNo", serialNo);
			params.put("recordList", JSON.toJSONString(list));

			try {
				HttpUtil.post(platformRecordUrl, params);
			} catch (Exception e) {
				logger.error(LogUtil.parserBean(list), e);
			}
		}
	}

	public IRecordService getRecordService() {
		return recordService;
	}

	public void setRecordService(IRecordService recordService) {
		this.recordService = recordService;
	}

	public String getPlatformRecordUrl() {
		return platformRecordUrl;
	}

	public void setPlatformRecordUrl(String platformRecordUrl) {
		this.platformRecordUrl = platformRecordUrl;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

}
