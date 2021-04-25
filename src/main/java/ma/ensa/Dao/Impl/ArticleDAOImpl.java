package ma.ensa.Dao.Impl;

import ma.ensa.Dao.ArticleDAO;
import ma.ensa.Models.Article;
import ma.ensa.Models.Client;
import ma.ensa.Utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ArticleDAOImpl implements ArticleDAO {
	@Override
	public List<Article> getAll() {
		EntityManager em = HibernateUtil.getEm();
		Query q = em.createQuery("Select a from Article a");
		List<Article> articles = (List<Article>) q.getResultList();
		return articles;
	}

	@Override
	public Article getById(int id) {
		EntityManager em = HibernateUtil.getEm();
		Query q = em.createQuery("Select a from Article a where a.codeArticle= :code");
		q.setParameter("code",id);

		Article article = (Article) q.getResultList().stream().findFirst().orElse(null);
		return article;
	}

	@Override
	public Article getByName(String name) {
		EntityManager em = HibernateUtil.getEm();
		Query q = em.createQuery("Select a from Article a where a.designation= :code");
		q.setParameter("code",name);

		Article article = (Article) q.getResultList().stream().findFirst().orElse(null);
		return article;
	}
}
