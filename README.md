# Cyber BeatBox Drum Machine

The **Cyber BeatBox Drum Machine** is an interactive, multi-instrument step sequencer built using Java. I use it as a hands-on exercise to explore several aspects of Java development, including **GUI**, **audio handling (MIDI)** and **networking** to enable social sharing of music patterns.

The primary goal is to create a fully functional drum machine that allows users to create, play, and share custom drum loops.

## 🎶 Core Features

The application's interface features a matrix where rows represent instruments and columns represent 16 music "beats".

- **16-Beat Step Sequencer**: A grid of checkboxes allows users to program a custom rhythm by marking which instruments play on which of the 16 available beats.

- **Playback Controls**:
	- **Start/Stop**: Initiates and halts the continuous looping of the programmed pattern.
	- **Tempo Up/Tempo Down**: Controls the playback speed of the loop.

- **Networking & Social Sharing**:
	- `sendIt` **Functionality**: Allows the user to "capture" amd transmit their current pattern (drum loop) to a central BeatBox server. This enables other players to access and listen to the creation.
	- **Pattern Loading**: Displays incoming patterns shared by other players. Users can load any od these patterns by clicking on the associated message.

### 🧐 What is MIDI?

`MIDI` stands for **Musical Instrument Digital Interface**, a standard protocol for getting different kinds of electronic sound equipment to communicate. `MIDI` data does not actually include any *sound*, but it does include the *instructions* that a MIDI-reading instrument can play back.
Think of a MIDI file like an HTML document and the instrument that renders the MIDI file (i.e. *plays* it) is like the web browser.

## 🛠️ Technology Stack

- **GUI**: Java Swing
- **Audio**: JAVA MIDI API