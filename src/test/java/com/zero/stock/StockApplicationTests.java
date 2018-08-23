package com.zero.stock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zero.stock.mapper.StockMapper;
import com.zero.stock.utils.PinyinConverter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockApplicationTests {
	 @Autowired
	 StockMapper stockMapper;
	 
	@Test
	public void contextLoads() {
		System.out.println("hello...."+PinyinConverter.getPinyinIntial("a^我们无连夜"));		
	}

}
