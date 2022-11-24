package uis.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    private JButton finishButton;
    private JButton addProductButton;
    private JButton addServiceButton;

    private ItemsPanel itemsPanel;
    private AddItemDialog newProductDialog;
    private AddItemDialog newServiceDialog;
    private FinishOrderDialog finishOrderDialog;

    public GUI() {
        setTitle("Order System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        initializeContent();
        addProductButton.addActionListener(this);
        addServiceButton.addActionListener(this);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(finishButton);
        buttonsPanel.add(addProductButton);
        buttonsPanel.add(addServiceButton);

        initializeItemsPanel();
        add(itemsPanel,BorderLayout.SOUTH);

        add(buttonsPanel,BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeContent() {
        finishButton = new JButton("Finish order");
        addProductButton = new JButton("Add product");
        addServiceButton = new JButton("Add service");

        newProductDialog = new AddItemDialog(this, "Product", "Price", "Quantity");
        newServiceDialog = new AddItemDialog(this, "Service", "Persons", "Hours");
        finishOrderDialog = new FinishOrderDialog(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addProductButton) {
                newProductDialog.showDialog();
            } else if (source == addServiceButton) {
                newServiceDialog.showDialog();
        }
    }

    private void initializeItemsPanel() {
        itemsPanel = new ItemsPanel(this,"Name","Price","Description");
    }


    public AddItemDialog getNewProductDialog() {
        return newProductDialog;
    }

    public AddItemDialog getNewServiceDialog() {
        return newServiceDialog;
    }

    public FinishOrderDialog getNewClientFinishDialog() {
        return finishOrderDialog;
    }

    public JButton getFinishButton() {
        return finishButton;
    }

    public ItemsPanel getItemsPanel() {
        return itemsPanel;
    }
}
