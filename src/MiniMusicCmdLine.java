import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMusicCmdLine {
	public static void main (String[] args) {
		MiniMusicCmdLine mini = new MiniMusicCmdLine();
		if (args.length < 2) {
			System.out.println("Don't forget the instrument and note args!");
		}
		else {
			int instrument = Integer.parseInt(args[0]);
			int note = Integer.parseInt(args[1]);
			mini.play(instrument, note);
		}
	}

	public void play (int instrument, int note) {
		try {
			/**
			 * The sequencer is the object that takes all the MIDI data
			 * and sends it to the right instruments.
			 */
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack();

			/**
			 * The Message says what to do.
			 * The MidiEvent says when to do it.
			 * The MidiEvebt = a combination of the Message + the moment in time when that msg should fire.
			 */
			ShortMessage msg1 = new ShortMessage();
			msg1.setMessage(ShortMessage.PROGRAM_CHANGE, 1, instrument, 0);
			MidiEvent changeInstrument = new MidiEvent(msg1, 1);
			track.add(changeInstrument);

			ShortMessage msg2 = new ShortMessage();
			msg2.setMessage(ShortMessage.NOTE_ON, 1, note, 100);
			MidiEvent noteOn = new MidiEvent(msg2, 1);
			track.add(noteOn);

			ShortMessage msg3 = new ShortMessage();
			msg3.setMessage(ShortMessage.NOTE_OFF, 1, note, 100);
			MidiEvent noteOff = new MidiEvent(msg3, 16 );
			track.add(noteOff);

			player.setSequence(seq); // Selecting the song to play
			player.start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}