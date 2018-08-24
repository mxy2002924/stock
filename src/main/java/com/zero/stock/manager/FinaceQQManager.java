package com.zero.stock.manager;

import java.util.List;

import org.springframework.stereotype.Service;

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
@Service
public class FinaceQQManager {
	/**
	 * 
	 * @param pageIndex :start from 1
	 * @return
	 */
	public List<Stock> loadFundStock(int pageIndex) {
		//colum param :0..3 ，年报，季报，半年报之类的值; 测试中反正value 3 才可以得到最新报告期的值.
		String url = String.format("http://web.ifzq.gtimg.cn/fund/zcjj/zcjj/allzc?colum=3&order=desc&page=%d&pagesize=100&bgrq=&_var=v_jjcg", pageIndex);
		String response = HttpRequest.get(url).body();
		if(response == null)
			throw new DaoRequestException("request url data is null. "+url);
		int i1 = response.indexOf('[');
		int i2 = response.indexOf("}]");
		if(i1>0 && i2 > i1) 
			response = response.substring(i1, i2+2);

		ObjectMapper mapper = new ObjectMapper();
		try {			
			List<Stock> lst = mapper.readValue(response, new TypeReference<List<Stock>>() {});
			return lst;
		} catch (Throwable e) {
			throw new DaoRequestException("parse json err:",e);
		}		
	}
}
