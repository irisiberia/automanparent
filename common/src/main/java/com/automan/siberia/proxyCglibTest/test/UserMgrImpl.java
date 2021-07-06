package com.automan.siberia.proxyCglibTest.test;

public class UserMgrImpl implements UserMgr {

	@Override
	public void addUser() {
		System.out.println("1: 插入记录到usr表");
		System.out.println("2: 做日志在另一张表");
	}
	
}
