package com.papa2.cube.api.record.bo;

import java.io.Serializable;

/**
 * 停车场系统数据.
 * 
 * @author xujiakun
 * 
 */
public class Record implements Serializable {

	private static final long serialVersionUID = 1223872017993622478L;

	/**
	 * 停车开始时间.
	 */
	private String startTime;

	/**
	 * 停车结束时间.
	 */
	private String endTime;

	/**
	 * 停车卡信息.
	 */
	private String cardNo;

	/**
	 * 车牌信息.
	 */
	private String carNo;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

}
