package com.KoreaIT.java.BAM.dao;

public class Dao {
	public int lastId;
	
	public int getNewId() {
		return lastId + 1;
	}
}
