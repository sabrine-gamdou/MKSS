package uis.gui;

public class AddItemDialog extends JDialog {
    private JTextField itemNameField;
    private JTextField priceField;
    private JTextField quantityField;

    private JButton saveButton;
    private JButton quitButton;

    public AddItemDialog(JFrame frame, String itemName, String itemPriceLabel, String itemQuantityLabel) {
        super(frame, "New "+ itemName, true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initializeContent();
        JPanel panelN = new JPanel(new GridLayout(0, 2, 5, 5));
        panelN.add(new JLabel(itemName, JLabel.RIGHT));
        panelN.add(itemNameField);
        panelN.add(new JLabel(itemPriceLabel, JLabel.RIGHT));
        panelN.add(priceField);
        panelN.add(new JLabel(itemQuantityLabel, JLabel.RIGHT));
        panelN.add(quantityField);
        panelN.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panelN, BorderLayout.CENTER);

        JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelS.add(saveButton);
        panelS.add(quitButton);
        add(panelS, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(frame);
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    private void initializeContent(){
        itemNameField = new JTextField(10);
        priceField = new JTextField(10);
        quantityField = new JTextField(10);
        saveButton = new JButton("Save");
        quitButton = new JButton("Cancel");
    }

    public void showDialog() {
        itemNameField.setText("");
        priceField.setText("");
        quantityField.setText("");
        setVisible(true);
    }

    public String getItemName() {
        return itemNameField.getText();
    }

    public int getItemsPriceLabel() {
        try{
            return Integer.parseInt(priceField.getText());
        }catch(NumberFormatException e){
            e.printStackTrace();
            return -1;
        }
    }

    public int getQuantityLabel() {
        try{
            return Integer.parseInt(quantityField.getText());
        }catch(NumberFormatException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
