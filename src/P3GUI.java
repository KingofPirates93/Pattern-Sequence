import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Program: Pattern Sequence
 * Package: Default
 * Class: P3GUI
 * PSVM class
 * Author: Swapnil Patel
 * Date: 9/25/2017
 */


public class P3GUI extends JFrame {

    //variable initialization
    //GUI
    private JFrame FRAME;
    private JPanel PANEL;
    private JButton COMPUTE;
    private JRadioButton ITM;
    private JRadioButton RCM;
    private JTextField INPUT;
    private JTextField DISPLAY;
    private JTextField EFFDIS;
    private JLabel RESULT;
    private JLabel INPUTL;
    private JLabel EFF;
    private JLabel B;


    //filewriter
    private FileWriter fileWriter;
    private File RCWXOUT;
    private File ITRWXOUT;
    private File CSVOUT;

    //storage arrays
    private ArrayList<String> ITRLIST;
    private ArrayList<String> RCLIST;
    private ArrayList<String> CSVLIST;

    //user input value
    private int userInput;


    //GUI interface
    private void createView() {

        FRAME = new JFrame( "Almost Fibb" );
        PANEL = new JPanel();
        COMPUTE = new JButton( "Compute!" );
        ITM = new JRadioButton( "Iterative Method" );
        RCM = new JRadioButton( "Recursive Method" );
        INPUT = new JTextField();
        DISPLAY = new JTextField();
        EFFDIS = new JTextField();
        RESULT = new JLabel( "Result: " );
        INPUTL = new JLabel( "Input a Value: " );
        EFF = new JLabel( "Efficiency: " );
        B = new JLabel( "" );

        //jigsawing everything together.
        FRAME.add( PANEL );
        PANEL.setLayout( new GridLayout( 5, 2, 0, 10 ) );
        PANEL.add( ITM );
        PANEL.add( RCM );
        PANEL.add( INPUTL );
        PANEL.add( INPUT );
        PANEL.add( B );
        PANEL.add( COMPUTE );
        PANEL.add( RESULT );
        PANEL.add( DISPLAY );
        DISPLAY.setEditable( false );
        PANEL.add( EFF );
        PANEL.add( EFFDIS );
        EFFDIS.setEditable( false );


        //frame size
        FRAME.setSize( 550, 250 );
        FRAME.setVisible( true );
        FRAME.setLocationRelativeTo( null );
        FRAME.setResizable( false );
        FRAME.setTitle( "Java Sequencing" );

        //write on close.
        WRITEONCLOSE EXIT = new WRITEONCLOSE();
        addWindowListener( EXIT );
            }

    private class WRITEONCLOSE extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            super.windowClosing( e );
        }
    }


    //constructor
    private P3GUI() {createView();}


    //main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater( () -> {
            P3GUI SQNCE = new P3GUI();
        } );


    }

}
