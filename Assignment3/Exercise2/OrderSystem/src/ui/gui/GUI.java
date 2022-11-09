package ui.gui;

import model.Order;
import ui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements UI, ActionListener {

    JButton finishButton = new JButton("FINISH");
    JButton addProductButton = new JButton("ADD_PRODUCT");
    JButton addServiceButton = new JButton("ADD_SERVICE");

    NewClientProductDialog newClientProductDialog;
    NewClientServiceDialog newClientServiceDialog;
    NewClientFinishDialog newClientFinishDialog;

    public GUI() {
        setTitle("Modal Dialog Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); setSize(400,400);
        finishButton.addActionListener(this);
        addProductButton.addActionListener(this);
        addServiceButton.addActionListener(this);

        add(finishButton);
        add(addProductButton);
        add(addServiceButton);

        newClientProductDialog = new NewClientProductDialog(this);
        newClientServiceDialog = new NewClientServiceDialog(this);
        newClientFinishDialog = new NewClientFinishDialog(this);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addProductButton) {
                newClientProductDialog.showDialog();
                System.out.println("Product: "+ newClientProductDialog.getProductName());
                System.out.println("Price: "+ newClientProductDialog.getPrice());
                System.out.println("Quantity: "+ newClientProductDialog.getQuantity());
            } else if (source == addServiceButton) {
                newClientServiceDialog.showDialog();
                System.out.println("Service: "+ newClientServiceDialog.getServiceName());
                System.out.println("Persons: "+ newClientServiceDialog.getPersons());
            System.out.println("Hours: "+ newClientServiceDialog.getHours());
        } else if (source == finishButton) {
            newClientFinishDialog.showDialog();
            //Schließe bestellung ab und drucke Summe, Checkout-Time und bestellte Produkte
            System.out.println("Ordered products/ services:" + newClientFinishDialog.getOrder());
            System.out.println("Sum: "+ newClientFinishDialog.getSum());
            System.out.println("Checkout time: " + newClientFinishDialog.getCheckoutTime());
        }
    }


    private UserInput userInput;
/*    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private UserInput userInput;

    public GUI(){
        prepareGUI();
        showEventDemo();
        userInput = UserInput.WAITING;
    }*/



  /*  private void prepareGUI(){
        //Hauptfenster
        mainFrame = new JFrame("OrderSystem");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        //Bedienfeld erstellen
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        //Hinzufügen der Komponenten
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showEventDemo(){
        headerLabel.setText("Whats your choice?");

        //Buttons erzeugen
        JButton finishButton = new JButton("FINISH");
        JButton addProductButton = new JButton("ADD_PRODUCT");
        JButton addServiceButton = new JButton("ADD_SERVICE");

        //ActionCommand setzen
        finishButton.setActionCommand("FINISH");
        addProductButton.setActionCommand("ADD_PRODUCT");
        addServiceButton.setActionCommand("ADD_SERVICE");

        //ActionListener hinzufügen
        finishButton.addActionListener(new ButtonClickListener());
        addProductButton.addActionListener(new ButtonClickListener());
        addServiceButton.addActionListener(new ButtonClickListener());

        //Buttons zum Panel hinzufügen
        controlPanel.add(finishButton);
        controlPanel.add(addProductButton);
        controlPanel.add(addServiceButton);

        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if( command.equals( "FINISH" ))  {
                statusLabel.setText("FINISH Button clicked.");
                userInput = UserInput.FINISH;
            } else if( command.equals( "ADD_PRODUCT" ) )  {
                statusLabel.setText("ADD_PRODUCT Button clicked.");
                userInput = UserInput.ADD_PRODUCT;
            } else {
                statusLabel.setText("ADD_SERVICE Button clicked.");
                userInput = UserInput.ADD_SERVICE;
            }
        }
    }*/

    public void printCurrentOrder(){

    }

    public void createOrder() {

    }

    @Override
    public void printMenu() {

    }

    @Override
    public void printFinishedOrder(Order currentOrder) {

    }

    @Override
    public UserInput readInput() {
        return userInput;
    }

    @Override
    public String formatPrice(int priceInCent) {
        return null;
    }

    @Override
    public void sortItems(Order currentOrder) {

    }

    @Override
    public void printError(String error) {

    }

    @Override
    public void printInfo(String info) {

    }
}
