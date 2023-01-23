package com.KoreaIT.java.BAM.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.BAM.dto.Article;
import com.KoreaIT.java.BAM.util.Util;

public class ArticleController {
	List<Article> articles;
	Scanner sc;
	
	

	public ArticleController(List<Article> articles, Scanner sc) {
		this.articles = articles;
		this.sc = sc;
	}



	public void doWrite() {
		int id = articles.size() + 1;
		String regDate = Util.getNowDateStr();
		System.out.printf("제목 : ");
		String title = sc.nextLine();
		System.out.printf("내용 : ");
		String body = sc.nextLine();
		
		Article article = new Article(id,regDate,title,body);
		
		articles.add(article);
		
		System.out.printf("%d번 글이 생성되었습니다\n", id);
		
	}



	public void showList(String cmd) {
		if(articles.size() == 0) {
			System.out.println("게시물이 없습니다.");
			return;
		}
		
		List<Article> forPrintArticles = articles;
		
		String searchKeyword = cmd.substring("article list".length()).trim();
		
		if(searchKeyword.length() > 0) {
			System.out.printf("검색어 : " + searchKeyword);
			forPrintArticles = new ArrayList<>();
			
			for(Article article : articles) {
				if(article.title.contains(searchKeyword)) {
					forPrintArticles.add(article);
				}
			}
			
			if(forPrintArticles.size() == 0) {
				System.out.println("검색결과가 없습니다.");
				return;
			}
		}
		System.out.println("번호	|	제목		|	날짜				|	조회");
		for(int i = forPrintArticles.size()-1; i >= 0; i--) {
			Article article = forPrintArticles.get(i);
			
			System.out.printf("%d	|	%s		|	%s		|	%d\n", article.id, article.title, article.regDate, article.viewCnt);
		}
		
	}



	public void showDetail(String cmd) {
		String[] cmdBits = cmd.split(" ");
		int id = Integer.parseInt(cmdBits[2]);
		
		Article foundArticle = getArticleById(id);
		
		if(foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
			return;
		}
		
		foundArticle.addViewCnt();
		
		System.out.printf("번호 : %d \n", foundArticle.id);
		System.out.printf("날짜 : %s \n", foundArticle.regDate);
		System.out.printf("제목 : %s \n", foundArticle.title);
		System.out.printf("내용 : %s \n", foundArticle.body);
		System.out.printf("조회 : %d \n", foundArticle.viewCnt);
		
	}
	private int getArticleIndexById(int id) {
		int i = 0;
		for(Article article : articles) {
			if(article.id == id) {
				return i;
			}
			i++;
		}
		
		return -1;
	}
	
	private Article getArticleById(int id) {
		
		int index = getArticleIndexById(id);
		
		if(index != -1) {
			return articles.get(index);
		}
		return null;
	}



	public void doModify(String cmd) {
		String[] cmdBits = cmd.split(" ");
		int id = Integer.parseInt(cmdBits[2]);
		
		Article foundArticle = getArticleById(id);
		
		if(foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
			return;
		}
		
		System.out.printf("수정할 제목 : ");
		String title = sc.nextLine();
		System.out.printf("수정할 내용 : ");
		String body = sc.nextLine();
		foundArticle.title = title;
		foundArticle.body = body;
		System.out.printf("%d번 글이 수정되었습니다.\n", id);
		
	}



	public void doDelete(String cmd) {

		String[] cmdBits = cmd.split(" ");
		int id = Integer.parseInt(cmdBits[2]);
		
		int foundIndex = getArticleIndexById(id);
		
		if(foundIndex == -1) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
			return;
		}
		
		articles.remove(foundIndex);
		
		System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
		
	}
}
