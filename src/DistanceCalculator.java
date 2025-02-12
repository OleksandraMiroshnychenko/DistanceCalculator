import javax.swing.*; // Імпортує бібліотеку для створення графічного інтерфейсу
import java.awt.*; // Імпортує бібліотеку для управління розміщенням компонентів
import java.awt.event.ActionEvent; // Імпортує клас для обробки подій кнопок
import java.awt.event.ActionListener; // Імпортує інтерфейс для слухача подій

// Головний клас програми, який розширює JFrame (основне вікно програми)
public class DistanceCalculator extends JFrame {
    // Поля для введення координат точок
    private JTextField txtX1, txtX2, txtX3, txtY1, txtY2, txtY3;
    // Поля для відображення результатів обчислень
    private JLabel lblEuclidean, lblCityBlock, lblChebyshev;

    // Конструктор класу
    public DistanceCalculator() {
        setTitle("Калькулятор метрик"); // Встановлює заголовок вікна
        setSize(400, 200); // Встановлює розміри вікна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Закриває програму при закритті вікна
        setLayout(new BorderLayout()); // Встановлює макет вікна

        // Верхня панель із заголовком
        JPanel panelTop = new JPanel();
        panelTop.add(new JLabel("Калькулятор метрик розробила Мірошниченко Олександра"));
        add(panelTop, BorderLayout.NORTH);

        // Центральна панель для введення даних і виводу результатів
        JPanel panelCenter = new JPanel(new GridLayout(3, 4, 5, 5)); // Сітка 3x4 з проміжками 5px
        panelCenter.add(new JLabel("V1")); // Додає мітку для першого вектора
        txtX1 = new JTextField(); panelCenter.add(txtX1); // Поля введення для першого вектора
        txtX2 = new JTextField(); panelCenter.add(txtX2);
        txtX3 = new JTextField(); panelCenter.add(txtX3);

        panelCenter.add(new JLabel("V2")); // Додає мітку для другого вектора
        txtY1 = new JTextField(); panelCenter.add(txtY1); // Поля введення для другого вектора
        txtY2 = new JTextField(); panelCenter.add(txtY2);
        txtY3 = new JTextField(); panelCenter.add(txtY3);

        // Поля для відображення результатів
        lblEuclidean = new JLabel("Evklid:"); panelCenter.add(lblEuclidean);
        lblCityBlock = new JLabel("City:"); panelCenter.add(lblCityBlock);
        lblChebyshev = new JLabel("Cheb:"); panelCenter.add(lblChebyshev);

        add(panelCenter, BorderLayout.CENTER);

        // Панель з кнопками
        JPanel panelRight = new JPanel(new GridLayout(2, 1, 5, 5)); // 2x1 сітка для кнопок
        JButton btnCalculate = new JButton("Обрахувати"); // Кнопка для обчислення
        JButton btnClear = new JButton("Очистити"); // Кнопка для очищення
        panelRight.add(btnCalculate);
        panelRight.add(btnClear);
        add(panelRight, BorderLayout.EAST);

        // Додає обробник подій для кнопки обчислення
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Зчитує введені користувачем значення та перетворює у числа
                    double x1 = Double.parseDouble(txtX1.getText());
                    double x2 = Double.parseDouble(txtX2.getText());
                    double x3 = Double.parseDouble(txtX3.getText());
                    double y1 = Double.parseDouble(txtY1.getText());
                    double y2 = Double.parseDouble(txtY2.getText());
                    double y3 = Double.parseDouble(txtY3.getText());

                    // Обчислення Евклідової відстані
                    double euclidean = Math.sqrt(Math.pow(x1 - y1, 2) + Math.pow(x2 - y2, 2) + Math.pow(x3 - y3, 2));
                    // Обчислення міської відстані (манхеттенська відстань)
                    double cityBlock = Math.abs(x1 - y1) + Math.abs(x2 - y2) + Math.abs(x3 - y3);
                    // Обчислення відстані Чебишова
                    double chebyshev = Math.max(Math.max(Math.abs(x1 - y1), Math.abs(x2 - y2)), Math.abs(x3 - y3));

                    // Вивід результатів у відповідні поля
                    lblEuclidean.setText("Evklid: " + String.format("%.4f", euclidean));
                    lblCityBlock.setText("City: " + String.format("%.4f", cityBlock));
                    lblChebyshev.setText("Cheb: " + String.format("%.4f", chebyshev));
                } catch (NumberFormatException ex) {
                    // Відображення помилки, якщо введені дані не є числами
                    JOptionPane.showMessageDialog(null, "Помилка вводу! Перевірте дані.", "Помилка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Додає обробник подій для кнопки очищення
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Очищення всіх полів введення
                txtX1.setText("");
                txtX2.setText("");
                txtX3.setText("");
                txtY1.setText("");
                txtY2.setText("");
                txtY3.setText("");
                // Скидання результатів
                lblEuclidean.setText("Evklid:");
                lblCityBlock.setText("City:");
                lblChebyshev.setText("Cheb:");
            }
        });
    }

    // Головний метод програми
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // Виконує створення вікна у потоці графічного інтерфейсу
            new DistanceCalculator().setVisible(true); // Створює екземпляр класу і відображає вікно
        });
    }
}

