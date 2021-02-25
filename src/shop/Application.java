package shop;

import java.util.*;

public class Application {
    private Shop shop = new Shop();
    private Map<Integer, Select> selectMap = new LinkedHashMap<>();

    public Application(Shop shop) {
        this.shop = shop;
        this.initApp();
    }

    public Application() {
    }

    private void initApp() {
        selectMap.put(1, new SelectGetAll(shop));
        selectMap.put(2, new SelectAdd(shop));
        selectMap.put(3, new SelectRemove(shop));
        selectMap.put(4, new SelectEdit(shop));
        selectMap.put(0, new SelectCloseApp());
    }

    public void start() {
        System.out.println("======== Добро пожаловать в магазин ========");
        try {
            this.run();
        } catch (ExceptionCloseApp e) {
            System.out.println("======== Пока прощай ========");
        }
    }

    private void run() throws ExceptionCloseApp {
        while (true) {
            this.mainMenu();
            int number = Helpers.selectNumber(0, 4);

            Select callSelect = selectMap.get(number);
            callSelect.run();
        }
    }

    private void mainMenu() {
        System.out.println("+++++ Выберите что вас интересует +++++");

        for (Map.Entry<Integer, Select> entry: selectMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());
        }
    }
}
