package ui.gui;

import model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Map;

public class NewClientFinishDialog extends JDialog implements ActionListener {
    JTextField orderField = new JTextField(10);
    JTextField sumField = new JTextField(10);
    JTextField checkoutTimeField = new JTextField(10);
    JButton quitButton = new JButton("Quit");
    Map<Integer,Order> order; //oder liste?
    int sum;
    LocalDateTime checkoutTime;

    public NewClientFinishDialog(JFrame f) {
        super(f, "Finished order", true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        quitButton.addActionListener(this);

        JPanel panelN = new JPanel(new GridLayout(0, 2, 5, 5));
        panelN.add(new JLabel("Order", JLabel.RIGHT));
        //panelN.add(orderField);
        panelN.add(new JLabel("Sum", JLabel.RIGHT));
        //panelN.add(sumField);
        panelN.add(new JLabel("Checkout time", JLabel.RIGHT));
        //panelN.add(checkoutTimeField);
        panelN.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panelN, BorderLayout.CENTER);

        JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelS.add(quitButton);
        add(panelS, BorderLayout.SOUTH);
        pack();
    }

    public void showDialog() {
        orderField.setText("");
        sumField.setText("");
        checkoutTimeField.setText("");
        order = null;
        sum = 0;
        checkoutTime = checkoutTime;
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        setVisible(false);
    }

    public Map getOrder() {
        return order;
    }

    public int getSum() {
        return sum;
    }

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }
}
