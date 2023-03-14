import exceptions.ExceptionCryptographie;
import protocoles.Protocole;
import protocoles.ProtocoleSolitaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Window extends JFrame {
    ImageIcon alice = new ImageIcon(".\\src\\alice.png");
    ImageIcon bob = new ImageIcon(".\\src\\bob.png");
    JTextArea text1 = new JTextArea();
    JTextArea text2 = new JTextArea();
    JButton bChiffrer = new JButton("Chiffrer");
    JButton bDechiffrer = new JButton("Déchiffrer");
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();

    File currentFile = null;

    Protocole protoS = new ProtocoleSolitaire();
    public Window() {
        super("Algorithme du Solitaire");
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        };
        addWindowListener(l);
        GridLayout gl = new GridLayout(3, 2);
        gl.setHgap(7); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
        gl.setVgap(7); //Cinq pixels d'espace entre les lignes (V comme Vertical)
        panel.setLayout(gl);


        GridLayout gl1 = new GridLayout(2, 1);
        gl1.setHgap(7); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
        gl1.setVgap(7); //Cinq pixels d'espace entre les lignes (V comme Vertical)
        panel2.setLayout(gl1);

        addMenuBar();
        addIcones();
        addText();
        addButtons();
        panel.add(panel2);

        this.add(panel);

        setVisible(true);
        setSize(500,500);
    }

    public void searchFile() throws IOException {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(this); //replace null with your swing container
        if(returnVal == JFileChooser.APPROVE_OPTION)
            currentFile = chooser.getSelectedFile();

        if(currentFile != null){
            BufferedReader in = new BufferedReader(new FileReader(currentFile));
            String line = in.readLine();
            while(line != null){
                text1.append(line + "\n");
                line = in.readLine();
            }
        }
    }

    public void addMenuBar(){
        JMenuBar menubar = new JMenuBar();
        // Créer le menu
        JMenu menu = new JMenu("Menu");
        JMenuItem e1 = new JMenuItem("Import File");
        JMenuItem e2 = new JMenuItem("Clear");
        e1.addActionListener(evt -> {
            try {
                searchFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        e2.addActionListener(evt -> clear());

        menu.add(e1);
        menu.add(e2);

        menubar.add(menu);
        this.setJMenuBar(menubar);
    }

    public void clear(){
        text1.setText("");
        text2.setText("");
    }

    public void addButtons(){
        bDechiffrer.setEnabled(false);
        bChiffrer.setEnabled(true);

        bChiffrer.addActionListener(evt -> {
            try {
                if (!text1.getText().isEmpty()){
                    String msg = protoS.chiffrer(text1.getText());
                    text2.setText(msg);
                    if(currentFile != null)
                        writeFile(msg);
                    text1.setText("");
                    bDechiffrer.setEnabled(true);
                    bChiffrer.setEnabled(false);
                }else {
                    JOptionPane.showMessageDialog(this,
                            "Aucun message saisi",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }

            } catch (ExceptionCryptographie e) {
                e.gerer();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bDechiffrer.addActionListener(evt -> {
            try {
                if (!text2.getText().isEmpty()){
                    String msg = protoS.dechiffrer(text2.getText());
                    text1.setText(msg);
                    text2.setText("");
                    if(currentFile != null){
                        writeFile(msg);
                        currentFile = null;
                    }
                    bChiffrer.setEnabled(true);
                    bDechiffrer.setEnabled(false);
                }else {
                    JOptionPane.showMessageDialog(this,
                            "Aucun message saisi",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }

            } catch (ExceptionCryptographie e) {
                e.gerer();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        getContentPane().add(bChiffrer, "Center");
        getContentPane().add(bDechiffrer, "Center");

        panel2.add(bChiffrer);
        panel2.add(bDechiffrer);
    }

    public void addIcones(){

        JLabel aliceIcon = new JLabel();
        aliceIcon.setIcon(alice);
        aliceIcon.setHorizontalAlignment(JLabel.CENTER);

        JLabel bobIcon = new JLabel();
        bobIcon.setIcon(bob);
        bobIcon.setHorizontalAlignment(JLabel.CENTER);

        panel.add(aliceIcon);
        panel.add(bobIcon);
    }

    public void addText(){

        text1.setBounds(20,75,250,200);

        text2.setBounds(20,75,250,200);
        text2.setEnabled(false);

        panel.add(text1);
        panel.add(text2);

    }

    public void writeFile(String message) throws IOException {
        FileWriter fw = new FileWriter(currentFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(message);
        bw.close();
    }
}
