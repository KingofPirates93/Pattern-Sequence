import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;


class P3GUI extends JFrame {

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
    //user input value
    private int userInput;


    //constructor
    private P3GUI() {
        System.out.println( "calling P3GUI" );
        createView();
    }


    //main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater( () -> {
            new P3GUI();

        } );
    }


    private int getUserInput() {
        int USERIN = 0;
        try {
            USERIN = Integer.parseInt( INPUT.getText() );
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog( null, "INVALID INPUT, PLEASE ENTER AN INTEGER GREATER THAN 0." );
        }
        return USERIN;
    }

    private void setUserInput() {
    }

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
        ITM.setSelected( true );
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

        RCM.addActionListener( e -> {
            if (RCM.isSelected()) {
                ITM.setSelected( false );
                INPUT.setText( "" );
            }
        } );

        ITM.addActionListener( e -> {
            if (ITM.isSelected()) {
                RCM.setSelected( false );
                INPUT.setText( "" );
            }
        } );

        //compute button
        COMPUTE.addActionListener( new computeListener() );


        //write on close.
        DOonEXIT EXIT = new DOonEXIT();
        FRAME.addWindowListener( EXIT );
    }

    private class DOonEXIT extends WindowAdapter {
        private DOonEXIT() {
            System.out.println( "Calling DO ON EXIT CLASS" );
        }

        @Override
        public void windowClosing(WindowEvent e) {

            try {
                int iterativeE;
                int recursiveE;
                FileWriter fw = new FileWriter( "OutData.txt" );
                for (int n = 0; n <= 15; n++) {
                    Sequence.computeIterative( n );
                    iterativeE = Sequence.getEfficiency();
                    Sequence.computeRecursive( n );
                    recursiveE = Sequence.getEfficiency();
                    fw.write( n + "," + iterativeE + "," + recursiveE + "\n" );
                }
                fw.close();
            } catch (IOException ex) {
                getLogger( P3GUI.class.getName() ).log( Level.SEVERE, null, ex );
            } finally {
                System.exit( 0 );
            }
        }
    }

    private class computeListener implements ActionListener {
        private computeListener() {
            System.out.println( "Calling COMPUTE LISTENER CLASS" );
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setUserInput();
            if (userInput < 0) {
                JOptionPane.showMessageDialog( null, "Invalid Input" );
            } else if (ITM.isSelected()) {
                DISPLAY.setText( String.valueOf( Sequence.computeIterative( getUserInput() ) ) );
                EFFDIS.setText( String.valueOf( Sequence.getEfficiency() ) );
            } else if (RCM.isSelected()) {
                DISPLAY.setText( String.valueOf( Sequence.computeRecursive( getUserInput() ) ) );
                EFFDIS.setText( String.valueOf( Sequence.getEfficiency() ) );
            }
            INPUT.setText( "" );
        }

    }
}
