package uis.gui;

import entities.Item;
import usecases.OrderOutputData;
import utils.Utility;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ItemsPanel extends JPanel{

    private JTable table;
    private DefaultTableModel tableModel;

    public ItemsPanel(JFrame frame, String itemName, String itemPriceLabel, String itemDescriptionLabel) {
        initializeContent(new String[]{itemName, itemPriceLabel, itemDescriptionLabel});
        JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(panelS, BorderLayout.SOUTH);
    }

    private void initializeContent(String[] header){
        table = new JTable();
        tableModel = new DefaultTableModel(header,0);
        table.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 304, 500, 180);

        add(scrollPane);
        setUpTableData(null);
    }

    public void updateTable(OrderOutputData currentOrder) {
        setUpTableData(currentOrder);
    }


    private void setUpTableData(OrderOutputData currentOrder) {
        if(currentOrder != null && !currentOrder.getItems().isEmpty()) {
            tableModel.setRowCount(0);
            Utility.sortItems(currentOrder);
            List<Item> items = currentOrder.getItems();
            for (Item item : items) {
                tableModel.addRow(new Object[]{item.getName(), Utility.formatPrice(item.getPrice()), item.toString()});
            }
            table.setModel(tableModel);
            tableModel.fireTableDataChanged();
        }else{
            tableModel.setRowCount(0);
        }
    }
}
