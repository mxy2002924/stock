package com.zero.stock.manager;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kevinsawicki.http.HttpRequest;
import com.zero.stock.dao.DaoRequestException;
import com.zero.stock.domain.Stock;

/**
 * grab finace data from qq.
 * @author ghost
 * @since 2018.8.21
 */
public class FinaceQQManager {	
	public List<Stock> loadFundStock() {
		//colum param :0..3 ，年报，季报，半年报之类的值; 测试中反正value 3 才可以得到最新报告期的值.
		String url = "http://web.ifzq.gtimg.cn/fund/zcjj/zcjj/allzc?colum=3&order=desc&page=1&pagesize=100&bgrq=&_var=v_jjcg";		
		String response = HttpRequest.get(url).body();
		if(response == null)
			throw new DaoRequestException("request url data is null. "+url);

		ObjectMapper mapper = new ObjectMapper();
		try {
			List<Stock> lst = mapper.readValue(response, new TypeReference<List<Stock>>() {});
			return lst;
		} catch (Throwable e) {
			new DaoRequestException("parse json err:",e);
		}
		return null;
	}
}
