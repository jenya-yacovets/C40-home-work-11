package shop;

import java.util.Scanner;

public class SelectAdd implements Select{
    private Shop shop = new Shop();
    private Scanner scanner = new Scanner(System.in);

    public SelectAdd(Shop shop) {
        this.shop = shop;
    }

    public SelectAdd() {
    }

    @Override
    public void run() {
        System.out.println("Введите Id товара:");
        int id = Helpers.selectNumber(1, 1000000);

        System.out.println("Введите название товара:");
        String name = scanner.next();

        System.out.println("Введите цену товара:");
        int price = Helpers.selectNumber(1, 1000000);

        try {
            shop.add(new Product(id, name, price));
            System.out.println("Товар - '" + name + "' успешно добавлен!");
        } catch(ExceptionDuplicationProduct e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Добавление товара";
    }
}
