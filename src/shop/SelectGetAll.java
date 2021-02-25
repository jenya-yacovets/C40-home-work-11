package shop;

import java.util.Collections;
import java.util.List;

public class SelectGetAll implements Select{
    private Shop shop = new Shop();

    public SelectGetAll(Shop shop) {
        this.shop = shop;
    }

    public SelectGetAll() {
    }

    @Override
    public void run() throws ExceptionCloseApp {
        this.sortMenu();

        int sort = Helpers.selectNumber(0, 5);

        List<Product> list = shop.getAll();

        switch (sort) {
            case 1:
                Collections.sort(list, new ProductSortByPrice());
                System.out.println(list);
                break;
            case 2:
                Collections.sort(list, new ProductSortByPrice().reversed());
                System.out.println(list);
                break;
            case 3:
                Collections.reverse(list);
                System.out.println(list);
                break;
            case 4:
                System.out.println(list);
                break;
            case 5:
                break;
            case 0:
                throw new ExceptionCloseApp();
        }
    }

    private void sortMenu() {
        System.out.println("----- Выберите метод сортировки -----");
        System.out.println("1 - По возрастанию цены");
        System.out.println("2 - По убыванию цены");
        System.out.println("3 - Сначала самые новые");
        System.out.println("4 - Сначала самые старые");
        System.out.println("5 - <<< Назад в основное меню");
        System.out.println("0 - Выход");
    }

    @Override
    public String getName() {
        return "Вывод всех товаров >>>";
    }
}
