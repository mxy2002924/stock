package com.zero.stock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zero.stock.mapper.StockMapper;
import com.zero.stock.service.StockService;
import com.zero.stock.util.PinyinConverter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockApplicationTests {
	 @Autowired
	 StockService stockService;
	 
	@Test
	public void contextLoads() {
		System.out.println("hello...."+stockService.syncFundStock());		
	}

}
