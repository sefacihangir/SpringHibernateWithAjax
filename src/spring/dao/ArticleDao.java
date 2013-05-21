package spring.dao;


import java.util.List;

import spring.model.Article;


public interface ArticleDao {
	// To Save the article detail
	public void saveArticle ( Article Article );
	
	// To get list of all articles
	public List<Article> listArticles();
	
	// To search article
	public List<Article> searchArticlesByKeyword(String keyword);
}