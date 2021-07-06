package com.automan.siberia.decorator.test;

public class PhoneDemo {
	public static void main(String[] args) {
		Phone p = new IPhone();
		p.call();
		System.out.println("------------");


		PhoneDecorate pd = new RingPhoneDecorate(p);
		pd.call();
		System.out.println("------------");


		pd = new MusicPhoneDecorate(p);
		pd.call();
		System.out.println("------------");

		pd = new RingPhoneDecorate(new MusicPhoneDecorate(p));
		pd.call();
		System.out.println("----------");

	}
}