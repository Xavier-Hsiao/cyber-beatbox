import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class BeatBox {
    private ArrayList<JCheckBox> checkboxList;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;

    // Store the name of the instruments for building the GUI labels
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat",
           "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
           "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
           "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
           "Open Hi Conga"};

   // Store the drum channel
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args) {
        BeatBox beatBox = new BeatBox();
        beatBox.buildGUI();
    }

    public void buildGUI () {
        JFrame frame = new JFrame("Cyber BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        // Leave a margin between the edges of the panel
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        // Todo: addActionListener
        buttonBox.add(start);

        JButton upTempo = new JButton("Tempo Up");
        // Todo: addActionListener
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        // Todo: addActionListener
        buttonBox.add(downTempo);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (String instrumentName : instrumentNames) {
            JLabel instrumentLabel = new JLabel(instrumentName);
            instrumentLabel.setBorder(BorderFactory.createEmptyBorder(4, 1, 4, 1));
            nameBox.add(instrumentLabel);
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        frame.getContentPane().add(background);

        // For checkboxes 16x16 layout
        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);

        JPanel mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        // Generate checkboxes
        checkboxList = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            JCheckBox cb = new JCheckBox();
            cb.setSelected(false);
            checkboxList.add(cb);
            mainPanel.add(cb);
        }

        // Todo: set up Midi

        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }
}