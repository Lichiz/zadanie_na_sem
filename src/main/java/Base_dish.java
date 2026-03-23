public class Base_dish implements Dish_interface {
    @Override
    public int return_price() {
        return 50;
    }

    @Override
    public String return_name() {
        return "Нордское рагу";
    }
}