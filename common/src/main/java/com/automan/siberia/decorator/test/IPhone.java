package com.automan.siberia.decorator.test;

public class IPhone implements Phone {

	@Override
	public void call() {
		System.out.println("可以打电话了");
	}

}
