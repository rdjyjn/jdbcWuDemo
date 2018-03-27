package com.ruide.wu.test;

import java.util.List;

import com.ruide.wu.db.DBManager;
import com.ruide.wu.vo.Dept;

public class Test {
	public static void main(String[] args) {
		String sql=" select * from dept ";
		DBManager db=new DBManager();
		List<Dept> list=db.executeQuery(sql);
		for(Dept d:list){
			System.out.println(d.getDname());
		}
		/*
		 * 测试，测试 ！
		 * */
		System.out.println("ceshi");
		System.out.println("二次测试");
	}
}
