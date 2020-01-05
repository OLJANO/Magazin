/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Client;
import entities.History;
import entities.Tovar;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Saveble {

    public void addTovar(List<Tovar> prodList);

    public List<Tovar> loadTovar();

    public void addClient(List<Client> clientList);

    public List<Client> loadClient();

    public void addHistory(List<History> historyList);

    public List<History> loadHistory();
}
