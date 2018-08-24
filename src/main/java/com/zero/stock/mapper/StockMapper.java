package com.zero.stock.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.zero.stock.domain.Stock;

@Mapper
public interface StockMapper {
	int updateStockBases(List<Stock> lStocks);
	int updateStockBase(Stock stock);
	boolean insertStockBase(Stock stock) ;
	List<Stock> listAll();
}
