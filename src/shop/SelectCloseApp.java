package shop;

public class SelectCloseApp implements Select {

    @Override
    public void run() throws ExceptionCloseApp {
        throw new ExceptionCloseApp();
    }

    @Override
    public String getName() {
        return "Выход";
    }
}
