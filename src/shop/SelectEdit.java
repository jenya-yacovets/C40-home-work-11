package shop;

import java.util.Scanner;

public class SelectEdit implements Select{
    private Shop shop = new Shop();
    private Scanner scanner = new Scanner(System.in);

    public SelectEdit(Shop shop) {
        this.shop = shop;
    }

    public SelectEdit() {
    }

    @Override
    public void run() throws ExceptionCloseApp {
        System.out.println("Введите Id товара который нужно обновить:");
        int id = Helpers.selectNumber(1, 1000000);

        System.out.println("Введите новое название товара:");
        String name = scanner.next();

        System.out.println("Введите новую цену товара:");
        int price = Helpers.selectNumber(1, 1000000);

        try {
            shop.edit(new Product(id, name, price));
            System.out.println("Товар успегно обновлен!");
        } catch (ExceptionProductNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Редактирование товара";
    }
}
