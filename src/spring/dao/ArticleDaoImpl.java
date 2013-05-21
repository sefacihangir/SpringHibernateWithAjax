package spring.dao;

import java.util.Date;
import java.util.List;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.model.Article;



@Repository("articleDao")
public class ArticleDaoImpl implements ArticleDao {

	@Autowired
	private SessionFactory sessionFactory;

	// To Save the article detail
	public void saveArticle(Article article) {
		article.setAddedDate(new Date());
		sessionFactory.getCurrentSession().saveOrUpdate(article);
	}
	
	// To get list of all articles
	@SuppressWarnings("unchecked")
	public List<Article> listArticles() {		
		return (List<Article>) sessionFactory.getCurrentSession().createCriteria(Article.class).list();
	}

	// To search articles using name
	@SuppressWarnings("unchecked")
	public List<Article> searchArticlesByKeyword(String keyword) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Article a where a.articleName like '%"+keyword+"%'");
		if(query.list().size()>0){
			return (List<Article>) query.list();
		}
		return null;
	}
}