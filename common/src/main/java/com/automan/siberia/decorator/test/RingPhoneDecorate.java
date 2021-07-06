package com.automan.siberia.decorator.test;

public class RingPhoneDecorate extends PhoneDecorate {


	public RingPhoneDecorate(Phone p) {
		super(p);
	}

	@Override
    public void call() {
        System.out.println("打电话之前响铃");
        p.call();
    }
}
