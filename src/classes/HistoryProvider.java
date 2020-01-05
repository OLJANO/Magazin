/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entities.Client;
import entities.History;
import entities.Tovar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class HistoryProvider {

    Scanner sc = new Scanner(System.in);

    public History createHistory(List<Tovar> tovarList, List<Client> clientList) {

        History history = new History();
        System.out.println("№ клиента из списка");
        int iclient  = 0;
        for (Client client : clientList) {
            System.out.println((iclient  + 1) + ".  " + client.getName() + " " + client.getLastname() + " E-mail: " + client.getEmail());
            iclient++;
        }
        int clientNum = sc.nextInt();
        Client client = clientList.get(clientNum - 1);

        System.out.println("№ товара из списка");

        int ip = 0;
        for (Tovar p : tovarList) {
            if (p.getQuatity() > 0) {
                System.out.println((ip + 1) + ". Название: " + p.getTitle() + ", цена: " + p.getPrice() + "  euro, остаток: " + p.getQuatity());
            } else {
                System.out.print("");
            }
            ip++;
        }

//        System.out.println("Выбрать номер из списка");
        int tovarNum = (sc.nextInt() - 1);
        Tovar tovar = tovarList.get(tovarNum);

        if (tovar.getQuatity() > 0) {
            System.out.println("Продано: " + tovar.getTitle() + ", " + tovar.getPrice() + " euro");

            tovar.setQuatity(tovar.getQuatity() - 1);
//        if(tovar.getQuatity()>1){
//           tovar.setQuatity(tovar.getQuatity() - 1); 
//        }else{
//            tovarList.remove(idTovar);
//        }
            history.setClient(client);
            history.setTovar(tovar);
            history.setHistoryDate(new Date());
        } else {
            System.err.println("Товар \"" + tovar.getTitle() + "\", " + tovar.getPrice() + " euro закончился");
        }

        return history;
    }
}
