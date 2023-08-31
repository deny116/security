//package com.example.security;
//
//import com.example.security.client.Client;
//import com.example.security.client.ClientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SecurityApplication {
//
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(SecurityApplication.class, args);
//    }
//    @Autowired
//    private ClientRepository clientRepository;
//
//    public void run(String... args) throws Exception {
//
//        Client client1 = new Client("Damian", "Kołcz", "94894646", "damian@gmail.com");
//
//        clientRepository.save(client1);
//    }
//}

package com.example.security;

//import com.example.security.client.Orders;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SecurityApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SecurityApplication.class, args);
        //        Item item1 = new Item("3545123", "Dell Inspirion", "100");
//        Item item2 = new Item("3545654", "Kellys", "50");
//        Item item3 = new Item("3545564", "Narty", "300");
//        Item item4 = new Item("3512332", "Skoda Fabia", "130");
//        Item item5 = new Item("3578978", "Asus", "150");
//        Item item6 = new Item("3545646", "Projektor", "110");
//        Item item7 = new Item("3578945", "Plecak turystyczny", "1000");
//        Item item8 = new Item("3545645", "hulajnoga", "1030");
//        Item item9 = new Item("3545645", "Asus", "400");
//        Item item10 = new Item("3585465", "Asus", "700");
//        ItemRepository itemRepository = context.getBean(ItemRepository.class);
//        itemRepository.save(item1);
//        itemRepository.save(item2);
//        itemRepository.save(item3);
//        itemRepository.save(item4);
//        itemRepository.save(item5);
//        itemRepository.save(item6);
//        itemRepository.save(item7);
//        itemRepository.save(item8);
//        itemRepository.save(item9);
//        itemRepository.save(item10);
//
//
//        Client client2 = new Client("Alicja", "Kołcz", "32412343124", "alicja@gmail.com");
//        Client client3 = new Client("Magda", "Kołcz", "412341234", "magda@gmail.com");
//        Client client4 = new Client("Sebastian", "Nowak", "12341234", "sebastian@gmail.com");
//        Client client5 = new Client("Marek", "Kowalksi", "54353252345", "marek@gmail.com");
//        Client client6 = new Client("Tomek", "Bester", "23452345", "tomek@gmail.com");
//        Client client7 = new Client("Stefan", "Mieczkowski", "2345234523", "stefan@gmail.com");
//        Client client8 = new Client("Damian", "Raniś", "234523542345", "damian@gmail.com");
//        ClientRepository clientRepository = context.getBean(ClientRepository.class);
//        clientRepository.save(client2);
//        clientRepository.save(client3);
//        clientRepository.save(client4);
//        clientRepository.save(client5);
//        clientRepository.save(client6);
//        clientRepository.save(client7);
//        clientRepository.save(client8);
    }
}