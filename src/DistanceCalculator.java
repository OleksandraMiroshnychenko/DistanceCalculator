import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DistanceCalculator extends JFrame {
    private JTextField txtX1, txtX2, txtX3, txtY1, txtY2, txtY3;
    private JLabel lblEuclidean, lblCityBlock, lblChebyshev;

    public DistanceCalculator() {
        setTitle("Калькулятор метрик");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelTop = new JPanel();
        panelTop.add(new JLabel("Калькулятор метрик розробив Мірошниченко Олександра"));
        add(panelTop, BorderLayout.NORTH);

        JPanel panelCenter = new JPanel(new GridLayout(3, 4, 5, 5));
        panelCenter.add(new JLabel("V1"));
        txtX1 = new JTextField(); panelCenter.add(txtX1);
        txtX2 = new JTextField(); panelCenter.add(txtX2);
        txtX3 = new JTextField(); panelCenter.add(txtX3);

        panelCenter.add(new JLabel("V2"));
        txtY1 = new JTextField(); panelCenter.add(txtY1);
        txtY2 = new JTextField(); panelCenter.add(txtY2);
        txtY3 = new JTextField(); panelCenter.add(txtY3);

        lblEuclidean = new JLabel("Evklid:"); panelCenter.add(lblEuclidean);
        lblCityBlock = new JLabel("City:"); panelCenter.add(lblCityBlock);
        lblChebyshev = new JLabel("Cheb:"); panelCenter.add(lblChebyshev);

        add(panelCenter, BorderLayout.CENTER);

        JPanel panelRight = new JPanel(new GridLayout(2, 1, 5, 5));
        JButton btnCalculate = new JButton("Обрахувати");
        JButton btnClear = new JButton("Очистити");
        panelRight.add(btnCalculate);
        panelRight.add(btnClear);
        add(panelRight, BorderLayout.EAST);

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x1 = Double.parseDouble(txtX1.getText());
                    double x2 = Double.parseDouble(txtX2.getText());
                    double x3 = Double.parseDouble(txtX3.getText());
                    double y1 = Double.parseDouble(txtY1.getText());
                    double y2 = Double.parseDouble(txtY2.getText());
                    double y3 = Double.parseDouble(txtY3.getText());

                    double euclidean = Math.sqrt(Math.pow(x1 - y1, 2) + Math.pow(x2 - y2, 2) + Math.pow(x3 - y3, 2));
                    double cityBlock = Math.abs(x1 - y1) + Math.abs(x2 - y2) + Math.abs(x3 - y3);
                    double chebyshev = Math.max(Math.max(Math.abs(x1 - y1), Math.abs(x2 - y2)), Math.abs(x3 - y3));

                    lblEuclidean.setText("Evklid: " + String.format("%.4f", euclidean));
                    lblCityBlock.setText("City: " + String.format("%.4f", cityBlock));
                    lblChebyshev.setText("Cheb: " + String.format("%.4f", chebyshev));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Помилка вводу! Перевірте дані.", "Помилка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtX1.setText("");
                txtX2.setText("");
                txtX3.setText("");
                txtY1.setText("");
                txtY2.setText("");
                txtY3.setText("");
                lblEuclidean.setText("Evklid:");
                lblCityBlock.setText("City:");
                lblChebyshev.setText("Cheb:");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DistanceCalculator().setVisible(true);
        });
    }
}
