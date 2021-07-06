package com.automan.siberia.decorator.test;

public class MusicPhoneDecorate extends PhoneDecorate {

	public MusicPhoneDecorate(Phone p) {
		super(p);
	}

	@Override
	public void call() {
		p.call();
		System.out.println("打完电话听音乐");
	}
}
