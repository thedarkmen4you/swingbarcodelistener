package pe.blobfish.barcode.test;

import pe.blobfish.barcode.BarcodeAwareAWTEventListener;
import pe.blobfish.barcode.BarcodeCapturedListener;

import javax.swing.*;
import java.awt.*;

public class SimpleTest extends JFrame {
    public SimpleTest() throws HeadlessException {

        Toolkit.getDefaultToolkit().addAWTEventListener(new BarcodeAwareAWTEventListener(new BarcodeCapturedListener() {
            @Override
            public void barcodeCaptured(String barcode) {
                JOptionPane.showMessageDialog(SimpleTest.this, "barcode captured: " + barcode);
            }
        }), AWTEvent.KEY_EVENT_MASK);


        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(new JLabel("Capture barcode demo"));
        getContentPane().add(new JTextField(25));
    }

    public static void main(String[] args) {
        SimpleTest simpleTest = new SimpleTest();
        simpleTest.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        simpleTest.setVisible(true);
        simpleTest.pack();
    }
}