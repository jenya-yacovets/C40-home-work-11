package shop;

public class SelectAdd implements Select{
    private Shop shop = new Shop();

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
        String name = Helpers.selectString();

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
