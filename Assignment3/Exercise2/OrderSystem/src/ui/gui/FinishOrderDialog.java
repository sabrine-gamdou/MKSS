package uis.gui;

import model.Order;
import utils.Utility;

public class FinishOrderDialog extends JDialog{

    private JLabel sumField;
    private JLabel checkoutTimeField;
    private JButton quitButton;
    private ItemsPanel items;

    public FinishOrderDialog(JFrame frame) {
        super(frame, "Finished order", true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initializeContent();

        items = new ItemsPanel(frame,"Name","Price","Description");

        quitButton.addActionListener(e -> setVisible(false));

        JPanel panelN = new JPanel(new GridLayout(0, 2, 5, 5));

        panelN.add(new JLabel("Sum", JLabel.RIGHT));
        panelN.add(sumField);
        panelN.add(new JLabel("Checkout time", JLabel.RIGHT));
        panelN.add(checkoutTimeField);
        panelN.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panelN, BorderLayout.BEFORE_FIRST_LINE);

        JPanel itemsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        itemsPanel.add(items);
        add(itemsPanel);

        JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelS.add(quitButton);
        add(panelS, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(frame);
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    private void initializeContent() {
        sumField = new JLabel("0");
        checkoutTimeField = new JLabel("00:00");
        quitButton = new JButton("Quit");
    }

    public void showDialog(Order currentOrder) {
        items.updateTable(currentOrder);
        sumField.setText(Utility.formatPrice(currentOrder.getSum()));
        checkoutTimeField.setText(Utility.formatCheckoutTime(currentOrder.getCheckoutTime()));
        setVisible(true);
    }
}
