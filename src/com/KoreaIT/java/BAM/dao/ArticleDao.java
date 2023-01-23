package com.KoreaIT.java.BAM.dao;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.java.BAM.dto.Article;

public class ArticleDao extends Dao {
	private List<Article> articles;
	
	public ArticleDao() {
		articles = new ArrayList<>();
	}

	public void add(Article article) {
		articles.add(article);
		lastId++;
	}
	
	public void remove(Article foundArticle) {
		articles.remove(foundArticle);
	}

	public List<Article> getForPrintArticles(String searchKeyword) {
		
		if (searchKeyword != null && searchKeyword.length() != 0) {
			
			System.out.println("검색어 : " + searchKeyword);

			List<Article> forPrintArticles = new ArrayList<>();

			for (Article article : articles) {
				if (article.title.contains(searchKeyword)) {
					forPrintArticles.add(article);
				}
			}
			return forPrintArticles;
		}
		return articles;
	}
	
	public int getArticleIndexById(int id) {
		int i = 0;

		for (Article article : articles) {
			if (article.id == id) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public Article getArticleById(int id) {
		int index = getArticleIndexById(id);

		if (index != -1) {
			return articles.get(index);
		}
		return null;
	}

}
