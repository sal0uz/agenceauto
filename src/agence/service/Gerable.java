package agence.service;

import java.util.List;

public interface Gerable<T> {
    void ajouter(T element);
    List<T> listerTous();
    T trouverParId(int id);
    void supprimer(int id);
}
