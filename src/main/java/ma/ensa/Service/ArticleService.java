package ma.ensa.Service;

import ma.ensa.Models.Article;

import java.util.List;

public interface ArticleService {
	public List<Article> getAll();
	public Article getById(int id);
	public Article getByName(String name);

}
