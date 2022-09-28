package com.Rmgyantra.javaUtility;

import java.util.Random;

public class RandomNum {
	public int randomNum()
	{
		Random r=new Random();
		int rnum = r.nextInt(2000);
		return rnum;
	}

}
