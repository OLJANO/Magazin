
package classes;

import entities.Client;
import java.util.Scanner;

public class ClientrProvider {

    Scanner sc = new Scanner(System.in);
    Client client = new Client();

    public Client addClient() {

        System.out.println("Имя");
        client.setName(sc.nextLine());
        System.out.println("Фамилия");
        client.setLastname(sc.nextLine());
        System.out.println("Email");
        client.setEmail(sc.nextLine());
        
        return client;
    }
}
