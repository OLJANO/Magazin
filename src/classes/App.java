
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entities.Client;
import entities.History;
import entities.Tovar;
import interfaces.Saveble;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class App {

    List<Tovar> tovarList = new ArrayList<>();
    List<Client> clientList = new ArrayList<>();
    List<History> historyList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Saveble saveble;

    public App(String flag) {
        switch (flag) {
            case "base":
                saveble = new SaveToBase();
                break;
            case "file":
                saveble = new SaveToFile();
                break;
            default:
                saveble = new SaveToBase();
                historyList = saveble.loadHistory();
                tovarList = saveble.loadTovar();
                clientList = saveble.loadClient();
                break;
        }

    }

    public App() {
        
    }

    public void run() {

        boolean checkKey = true;

        do {
            System.out.println("---------------------------");
            System.out.println("1. Новый товар");
            System.out.println("2. Новый пользователь");
            System.out.println("3. Покупка товара");
            System.out.println("4. Вывод списка товаров");
            System.out.println("5. Вывод списка пользователей");
            System.out.println("6. Вывод купленных товаров");
            System.out.println("0. Выход");
            System.out.println("---------------------------");
            String check = sc.nextLine();
            switch (check) {
                case "1":
                    System.out.println("Новый товар");
                    TovarProvider tovarProvider = new TovarProvider();
                    Tovar tovar = tovarProvider.addTovar();
                    tovarList.add(tovar);
                    saveble.addTovar(tovarList);
                    break;
                case "2":
                    System.out.println("Новый пользователь");
                    ClientrProvider clientrProvider = new ClientrProvider();
                    Client client = clientrProvider.addClient();
                    clientList.add(client);
                    saveble.addClient(clientList);
                    break;

                case "3":
                    System.out.println("Покупка товара");
                    int count = 0;
                    for (Tovar p : tovarList) {
                        if (p.getQuatity() > 0) {
                            count += p.getQuatity();
                        }
                    }

                    if (count < 1) {
                        System.err.println("Добавьте товар");
                        break;
                    }

                    HistoryProvider historyProvider = new HistoryProvider();
                    History history = historyProvider.createHistory(tovarList, clientList);
                    historyList.add(history);
                    saveble.addHistory(historyList);
                    for (int i = 0; i < historyList.size(); i++) {
                        System.out.println(historyList.get(i).toString());
                    }

                    break;
                case "4":
                    System.out.println("Вывод списка товаров");
                    for (Tovar t : tovarList) {
                        System.out.println("Товар: " + t.getTitle() + ",  цена:" + t.getPrice() + " руб., кол-во:" + t.getQuatity());
                    }
                    break;

                case "5":
                    System.out.println("Вывод списка пользователей");
                    for (Client c : clientList) {
                        System.out.println("Имя Фамилия: " + c.getName() + " " + c.getLastname() + ", Email: " + c.getEmail());
                    }
                    break;

                case "6":

                    System.out.println("Вывод купленных товаров: ");
//                    double sum = 0;
                    for (History h : historyList) {
                        System.out.println(h.getTovar().getTitle() + ", " + h.getTovar().getPrice() + ", " + h.getHistoryDate() + " " + h.getClient().getName() + " " + 
h.getClient().getLastname() + ", Email: " + h.getClient().getEmail());
//                        sum += client.getTovar().getPrice();
                    }

//                    double roundOff = (double) Math.round(sum * 100) / 100;
//                    System.out.println("Оборот: " + roundOff + " euro");
                    break;
                case "0":
                    System.out.println("");
                    checkKey = false;
                    break;

                default:
                    System.err.println("!?");
            }

        } while (checkKey);

    }

}
