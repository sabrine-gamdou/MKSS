package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewClientServiceDialog extends JDialog implements ActionListener{
        JTextField serviceNameField = new JTextField(10);
        JTextField servicePersonsField = new JTextField(10);
        JTextField serviceHoursField = new JTextField(10);
        JButton saveButton = new JButton("Save");
        JButton quitButton = new JButton("Not save");
        String serviceName = "";
        int servicePersons = 0;
        int serviceHours = 0;

        public NewClientServiceDialog(JFrame f) {
            super(f, "New Service", true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            saveButton.addActionListener(this);
            quitButton.addActionListener(this);

            JPanel panelN = new JPanel(new GridLayout(0, 2, 5, 5));
            panelN.add(new JLabel("Service", JLabel.RIGHT));
            panelN.add(serviceNameField);
            panelN.add(new JLabel("Persons", JLabel.RIGHT));
            panelN.add(servicePersonsField);
            panelN.add(new JLabel("Hours", JLabel.RIGHT));
            panelN.add(serviceHoursField);
            panelN.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            add(panelN, BorderLayout.CENTER);

            JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            panelS.add(saveButton);
            panelS.add(quitButton);
            add(panelS, BorderLayout.SOUTH);
            pack();
        }

        public void showDialog() {
            serviceNameField.setText("");
            servicePersonsField.setText("");
            serviceHoursField.setText("");
            serviceName = "";
            servicePersons = 0;
            serviceHours = 0;
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == saveButton) {
                serviceName = serviceNameField.getText();
                servicePersons = servicePersonsField.getX();
                serviceHours = serviceHoursField.getX();
            } else if (source == quitButton) {
            }
            setVisible(false);
        }

        public String getServiceName() {
            return serviceName;
        }

        public int getPersons() {
            return servicePersons;
        }

        public int getHours() {
            return serviceHours;
        }
}
