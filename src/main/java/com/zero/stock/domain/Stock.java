package com.zero.stock.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zero.stock.utils.PinyinConverter;

public class Stock {	
	public int id;
	
	@JsonProperty("zqdm")
	public int code;//证券代码
	
	@JsonProperty("zqmc")
	public String name;// 证券名称
	public int dt_index;//next time to update.
	public String dt_date;
	public boolean dt_clear;// 最后一天的是否是完整的，交易日3点前可能不是了。uint8->bool 0,1
	public int dt_days;	//  记录的交易的天数
	
	@JsonProperty("ccsm")
	public int funds; // 基金家数
	
	@JsonProperty("ltbl")
	public float proportion;// 流通比例
	
	@JsonProperty("bcgs")
	public float share;	//持仓总数量  万股
	
	@JsonProperty("ccbd")
	public float sharedrift; 	//持股变动 万股
	public int  rank;			// 排名
	
	public String getEname() {
		return PinyinConverter.getPinyinIntial(name);
	}	
}
