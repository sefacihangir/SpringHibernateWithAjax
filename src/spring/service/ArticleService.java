package spring.service;

import java.util.List;

import spring.model.Article;


public interface ArticleService {

	public void addArticle(Article article);

	public List<Article> listArticles();
	
	public List<Article> searchArticlesByKeyword(String keyword);
}