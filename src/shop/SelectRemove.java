package shop;

public class SelectRemove implements Select{
    private Shop shop = new Shop();

    public SelectRemove(Shop shop) {
        this.shop = shop;
    }

    public SelectRemove() {
    }

    @Override
    public void run() throws ExceptionCloseApp {
        System.out.println("Введите Id товара который нужно удалить:");
        int id = Helpers.selectNumber(1, 1000000);

        try {
            shop.remove(id);
            System.out.println("Товар с id - " + id + " успешно удален!");
        } catch (ExceptionProductNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Удаление товара";
    }
}
