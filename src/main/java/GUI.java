import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.function.Function;

public class GUI {
    private static final int MAX_SELECTION = 3;
    private final List<String> orderHistory = new ArrayList<>();

    private final Map<JCheckBox, Function<Dish_interface, Dish_interface>> decoratorsMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }

    public GUI() {
        JFrame frame = new JFrame("Таверна");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        initOption("Огненный соус (+10)", d -> new Sauce_dec(d));
        initOption("Двойная оленина (+20)", d -> new Deer_meat_dec(d));
        initOption("Снежные ягоды (+5)", d -> new Wild_berries_dec(d));
        initOption("Нордская лепешка (+7)", d -> new Nordic_bread_dec(d));

        JPanel checkPanel = new JPanel(new GridLayout(0, 1));
        for (JCheckBox cb : decoratorsMap.keySet()) {
            cb.addActionListener(e -> checkLimit());
            checkPanel.add(cb);
        }

        JButton orderBtn = new JButton("Оформить заказ");
        JButton logBtn = new JButton("Квитки заказов");

        orderBtn.addActionListener(e -> processOrder());
        logBtn.addActionListener(e -> showLogs());

        frame.add(new JLabel("Выберите добавки (<= 3):"));
        frame.add(checkPanel);
        frame.add(orderBtn);
        frame.add(logBtn);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initOption(String text, Function<Dish_interface, Dish_interface> func) {
        decoratorsMap.put(new JCheckBox(text), func);
    }

    private void checkLimit() {
        long count = decoratorsMap.keySet().stream().filter(AbstractButton::isSelected).count();
        for (JCheckBox cb : decoratorsMap.keySet()) {
            if (!cb.isSelected()) {
                cb.setEnabled(count < MAX_SELECTION);
            }
        }
    }

    private void processOrder() {
        Dish_interface finalDish = new Base_dish();

        for (Map.Entry<JCheckBox, Function<Dish_interface, Dish_interface>> entry : decoratorsMap.entrySet()) {
            if (entry.getKey().isSelected()) {
                finalDish = entry.getValue().apply(finalDish);
            }
        }

        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String result = String.format("[%s] %s — %d септимов", time, finalDish.return_name(), finalDish.return_price());

        orderHistory.add(result);
        JOptionPane.showMessageDialog(null, "Заказ принят!\n" + result);
    }

    private void showLogs() {
        if (orderHistory.isEmpty()) {
            JOptionPane.showMessageDialog(null, "История пуста");
            return;
        }
        JOptionPane.showMessageDialog(null, String.join("\n", orderHistory));
    }
}