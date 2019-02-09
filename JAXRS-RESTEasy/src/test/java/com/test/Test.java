package com.test;

import java.util.List;

import com.sindhe.model.Website;
import com.sindhe.service.ServiceImpl;


public class Test {
//https://codereview.stackexchange.com/questions/126621/simple-singleton-database-connection-pool
	@org.junit.Test
	public void Tests() {

		//System.out.println( new ServiceImpl().getRecordsById(1));
		/*List<Website> list = new ServiceImpl().getAllRecords();
		System.out.println(list.get(0).getId());*/
		System.out.println(new ServiceImpl().deleteById((long) 1));

	}
}
