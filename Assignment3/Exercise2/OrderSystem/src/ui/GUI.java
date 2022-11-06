package ui;

import model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI implements UI{

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private UserInput userInput;

    public GUI(){
        prepareGUI();
        showEventDemo();
        userInput = UserInput.WAITING;
    }

    private void prepareGUI(){
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
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showEventDemo(){
        headerLabel.setText("Control in action: Button");

        JButton finishButton = new JButton("FINISH");
        JButton addProductButton = new JButton("ADD_PRODUCT");
        JButton addServiceButton = new JButton("ADD_SERVICE");

        finishButton.setActionCommand("FINISH");
        addProductButton.setActionCommand("ADD_PRODUCT");
        addServiceButton.setActionCommand("ADD_SERVICE");

        finishButton.addActionListener(new ButtonClickListener());
        addProductButton.addActionListener(new ButtonClickListener());
        addServiceButton.addActionListener(new ButtonClickListener());

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
    }

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
