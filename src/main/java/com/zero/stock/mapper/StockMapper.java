package com.zero.stock.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.zero.stock.domain.Stock;

@Mapper
public interface StockMapper {
	int updateStockBase(Stock stock);
	List<Stock> listAll();
}
