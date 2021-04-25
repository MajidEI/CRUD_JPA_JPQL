package ma.ensa.Dao;

import ma.ensa.Models.Article;

import java.util.List;

public interface ArticleDAO {
	public List<Article> getAll();
	public Article getById(int id);
	public Article getByName(String name);
}
