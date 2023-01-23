package com.KoreaIT.java.BAM.dao;

public class Dao {
	public int lastId;
	
	public int setArticleId() {
		return lastId + 1;
	}
}
