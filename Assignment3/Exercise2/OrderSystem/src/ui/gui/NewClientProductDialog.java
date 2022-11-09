package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewClientProductDialog extends JDialog implements ActionListener{
        JTextField productNameField = new JTextField(10);
        JTextField productPriceField = new JTextField(10);
        JTextField productQuantityField = new JTextField(10);
        JButton saveButton = new JButton("Save");
        JButton quitButton = new JButton("Not save");
        String productName = "";
        int productPrice = 0;
        int productQuantity = 0;

        public NewClientProductDialog(JFrame f) {
            super(f, "New Product", true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            saveButton.addActionListener(this);
            quitButton.addActionListener(this);

            JPanel panelN = new JPanel(new GridLayout(0, 2, 5, 5));
            panelN.add(new JLabel("Product", JLabel.RIGHT));
            panelN.add(productNameField);
            panelN.add(new JLabel("Price", JLabel.RIGHT));
            panelN.add(productPriceField);
            panelN.add(new JLabel("Quantity", JLabel.RIGHT));
            panelN.add(productQuantityField);
            panelN.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            add(panelN, BorderLayout.CENTER);

            JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            panelS.add(saveButton);
            panelS.add(quitButton);
            add(panelS, BorderLayout.SOUTH);
            pack();
        }

        public void showDialog() {
            productNameField.setText("");
            productPriceField.setText("");
            productQuantityField.setText("");
            productName = "";
            productPrice = 0;
            productQuantity = 0;
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == saveButton) {
                productName = productNameField.getText();
                productPrice = productPriceField.getX();
                productQuantity = productQuantityField.getX();
            } else if (source == quitButton) {
            }
            setVisible(false);
        }

        public String getProductName() {
            return productName;
        }

        public int getPrice() {
            return productPrice;
        }

        public int getQuantity() {
            return productQuantity;
        }
}
