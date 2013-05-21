package spring.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.ArticleDao;
import spring.model.Article;


@Service("articleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	public ArticleServiceImpl() {
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addArticle(Article article) {
		articleDao.saveArticle(article);
	}

	public List<Article> listArticles() {
		return articleDao.listArticles();
	}

	@Override
	public List<Article> searchArticlesByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return articleDao.searchArticlesByKeyword(keyword);
	}


}