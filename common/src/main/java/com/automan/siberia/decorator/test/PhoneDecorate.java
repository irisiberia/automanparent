package com.automan.siberia.decorator.test;

public abstract class PhoneDecorate implements Phone {

	protected Phone p;

	public PhoneDecorate(Phone p) {
		this.p = p;
	}

}
