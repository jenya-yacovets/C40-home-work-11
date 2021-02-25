package shop;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Shop{
    private Map<Integer, Product> productList = null;

    public Shop() {
        this.initShop();
    }

    private void initShop() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.out"))) {
            Map<Integer, Product> list = (LinkedHashMap<Integer, Product>) ois.readObject();
            productList = list;
        } catch (IOException | ClassNotFoundException e) {
            productList = new LinkedHashMap<>();
        }
    }

    public void add(Product product) throws ExceptionDuplicationProduct {
        if(!productList.containsKey(product.getId())) {
            productList.put(product.getId(), product);
            this.serializable();
        } else {
            throw new ExceptionDuplicationProduct(product.getId());
        }
    }

    private void serializable() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.out"))) {
            oos.writeObject(productList);
        } catch (IOException e) {
            System.out.println("!!! При сериализации объекта произошла ошибка !!!");
        }
    }

    public ArrayList getAll() {
        ArrayList<Product> list = new ArrayList<>(productList.values());
        return list;
    }

    public void remove(int id) throws ExceptionProductNotFound {
        if (productList.remove(id) == null) {
            throw new ExceptionProductNotFound(id);
        }
    }

    public void edit(Product product) throws ExceptionProductNotFound {

        if (productList.containsKey(product.getId())) {
            productList.put(product.getId(), product);
        } else {
            throw new ExceptionProductNotFound(product.getId());
        }
    }
}