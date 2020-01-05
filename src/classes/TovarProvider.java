/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entities.Tovar;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class TovarProvider {

    Scanner sc = new Scanner(System.in);
    Tovar tovar = new Tovar();

    public Tovar addTovar() {

        System.out.println("Название");
        tovar.setTitle(sc.nextLine());
        System.out.println("Цена");
        tovar.setPrice(new Double(sc.nextLine()));
        System.out.println("Кол-во");
        tovar.setQuatity(new Integer(sc.nextLine()));
        return tovar;
        
    }

}
