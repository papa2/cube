package com.papa2.cube.sync.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.papa2.cube.api.record.IRecordService;
import com.papa2.cube.api.record.bo.Record;
import com.papa2.cube.api.sync.ISyncService;
import com.papa2.cube.framework.util.EncryptUtil;
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

	private String parkCode;

	private String parkSecret;

	@Override
	public void sync() {
		List<Record> list = recordService.getRecordList("I");

		if (list != null && list.size() > 0) {
			list.addAll(recordService.getRecordList("O"));
		} else {
			list = recordService.getRecordList("O");
		}

		if (list != null && list.size() > 0) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("parkCode", parkCode);

			String timestamp = Long.toString(System.currentTimeMillis() / 1000);
			params.put("timestamp", timestamp);

			StringBuilder sb = new StringBuilder();
			sb.append("parkCode=").append(parkCode).append("&parkSecret=").append(parkSecret).append("&timestamp=")
				.append(timestamp);

			String signature = null;
			try {
				signature = EncryptUtil.encryptSHA(sb.toString());
			} catch (IOException e) {
				logger.error(e);
			}

			params.put("signature", signature);
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

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getParkSecret() {
		return parkSecret;
	}

	public void setParkSecret(String parkSecret) {
		this.parkSecret = parkSecret;
	}

}
