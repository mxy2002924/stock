package com.zero.stock.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.stock.domain.Stock;
import com.zero.stock.manager.FinaceQQManager;
import com.zero.stock.mapper.StockMapper;

@Service
public class StockService {
	@Autowired 
	FinaceQQManager finaceQQManager;
	@Autowired
	StockMapper stockMapper;
	
	public boolean syncFundStock() {
		int pageIndex = 1;
		while (true) {
			List<Stock> lStocks = finaceQQManager.loadFundStock(pageIndex);
			if(lStocks == null || lStocks.size() == 0)
				break;
			int rowAffect = stockMapper.updateStockBases(lStocks);
			System.out.println("rowaffect..."+rowAffect+"  "+lStocks.size());
			
			Stock last= lStocks instanceof LinkedList ?((LinkedList<Stock>) lStocks).getLast():lStocks.get(lStocks.size()-1);
			if(last.funds < 10)
				break;
			
			pageIndex++;
		}
		return true;
	}
}
