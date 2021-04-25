package ma.ensa.Models;

import javax.persistence.*;

@Entity
@Table(name="lignecommande")
public class LigneCommande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumn(name = "numCommande")
    Commande commande;
    @ManyToOne
    @JoinColumn(name = "codeArticle")
    Article article;
    int qteCde;

    public LigneCommande() {
    }

    public int getId() {
        return id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQteCde() {
        return qteCde;
    }

    public void setQteCde(int qteCde) {
        this.qteCde = qteCde;
    }

    @Override
    public String toString() {
        return "LigneCommande{" +
                "id=" + id +
                ", commande=" + commande +
                ", article=" + article +
                ", qteCde=" + qteCde +
                '}';
    }
}
