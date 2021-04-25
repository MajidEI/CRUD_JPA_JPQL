package ma.ensa.Service.Impl;

import ma.ensa.Dao.ArticleDAO;
import ma.ensa.Dao.Impl.ArticleDAOImpl;
import ma.ensa.Models.Article;
import ma.ensa.Service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {
	@Override
	public List<Article> getAll() {
		ArticleDAO dao = new ArticleDAOImpl();
		return dao.getAll();
	}

	@Override
	public Article getById(int id) {
		ArticleDAO dao = new ArticleDAOImpl();
		return dao.getById(id);
	}

	@Override
	public Article getByName(String name) {
		ArticleDAO dao = new ArticleDAOImpl();
		return dao.getByName(name);
	}
}
