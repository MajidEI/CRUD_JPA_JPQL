package ma.ensa.Models;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int refCat;
    String cat;

    public Categorie() {
    }

    public int getRefCat() {
        return refCat;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
}
