/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entities.Tovar;
import entities.History;
import entities.Client;
import interfaces.Saveble;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Admin
 */
public class SaveToBase implements Saveble {

    EntityManager em;
    EntityTransaction tx;

    public SaveToBase() {
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("MagazinPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @Override
    public void addTovar(List<Tovar> tovarList) {
        List<Tovar> tovarListSave = loadTovar();

        for (int i = 0; i < tovarList.size(); i++) {
            if (tovarListSave.contains(tovarList.get(i))
                    && !tovarListSave.get(i).equals(tovarList.get(i))) {
                tx.begin();
                em.merge(tovarList.get(i));
                tx.commit();
            } else if (tovarList.get(i).getId() == null) {
                tx.begin();
                em.persist(tovarList.get(i));
                tx.commit();
            } else {
                continue;
            }
        }
    }

    @Override
    public List<Tovar> loadTovar() {
        return em.createQuery("SELECT t FROM Tovar t")
                .getResultList();
    }

    @Override
    public void addHistory(List<History> historyList) {
        List<History> historyListSaved = loadHistory();
        for (int i = 0; i < historyList.size(); i++) {
            if (historyListSaved.contains(historyList.get(i))
                    && !historyListSaved.get(i).equals(historyList.get(i))) {
                tx.begin();
                em.merge(historyList.get(i));
                tx.commit();
            } else if (historyList.get(i).getId() == null) {
                tx.begin();
                em.persist(historyList.get(i));
                tx.commit();
            } else {
                continue;
            }
        }
    }

    @Override
    public List<History> loadHistory() {
        return em.createQuery("SELECT h FROM History h")
                .getResultList();
    }

    @Override
    public void addClient(List<Client> clientList) {
        List<Client> clientListSaved = loadClient();
        for (int i = 0; i < clientList.size(); i++) {
            if (clientListSaved.contains(clientList.get(i))
                    && !clientListSaved.get(i).equals(clientList.get(i))) {
                tx.begin();
                em.merge(clientList.get(i));
                tx.commit();
            } else if (clientList.get(i).getId() == null) {
                tx.begin();
                em.persist(clientList.get(i));
                tx.commit();
            } else {
                continue;
            }
        }
    }

    @Override
    public List<Client> loadClient() {
        return em.createQuery("SELECT c FROM Client c")
                .getResultList();
    }

}
