import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class FileAnalysis extends JPanel implements ActionListener, Runnable{
	private final int WIDTH = 600, HEIGHT = 600;
	private String fileName = "Avengers";
	private String content;
	
	// return an array of size 26, where each entry in the array is the 
	// frequency of the corresponding letter (the first value represents 
	// the frequency of 'a', the second 'b', and so on
	private int[] calcFrequencies() {
		int[] x = new int[26];
		int index = 0;
		for(int i = 97; i<123; i++) {
			int count = 0;
			for(int j = 0; j<content.length(); j++) {
				if(content.charAt(j)==i)
					count++;
			}
			x[index] = count;
			index++;
		}
		return x;
	}
	
	// returns the number of words in the file
	private int numWords() {
		int spaces = 1; 
		for(int i =0; i<content.length(); i++) {
			if(content.charAt(i)==32)
				spaces++;
	}
		return spaces;
	}
	
	// returns the number of lines in the file
	private int numLines() {
		int lines = 0;
		for(int i = 0; i<content.length(); i++) {
			if(content.charAt(i) == '\n')	
				lines++;
		}
		return lines;
	}
	
	// returns the most common letter in the file
	private char mostCommonLetter() {
		int max = 0;
		char most = content.charAt(0);
		char c = content.charAt(0);
		for(int i = 97; i<123; i++) {
			int count = 0;
			for(int j = 0; j<content.length(); j++) {
				if(content.charAt(j)==i) {
					count++;
					c = content.charAt(j);
				}
			}
			if(max < count) {
				max = count;
				most = c;
			}
		}
		return most;
	}
	
	// returns the most common word in the file
	private String mostCommonWord() {
		ArrayList<String> words = new ArrayList<String>();
		
		/*for(String word : content.split(" ")) {
				words.add(word);
		}
		
		for(int j = 0; j<words.size()-1; j++) {
			int minindex = j;
			for(int k = j+1; k<words.size(); k++) {
				if(words.get(k).compareTo(words.get(minindex))<0)
					minindex = k;
				String temp = words.get(j);
				words.set(j, words.get(minindex));
				words.set(minindex, temp);
			}
		}
		
		String max = words.get(0);
		int maxint = 0;
		int count = 1;
		for(int i = 0; i<words.size()-1; i++) {
			for(int j = i+1; j<words.size(); j++) {
				if(words.get(i).equals(words.get(j)))
					count++;
			}
			if(count > maxint) {
				maxint = count;
				max = words.get(i);
			}
		}
		return max;
	}
	*/
		int temp = 0;
		ArrayList<Integer> freq = new ArrayList<Integer>();
		for(int i = 0; i<content.length(); i++) {
			if(content.charAt(i)==' ') {
				if(!words.contains(content.substring(0, i))) {
					words.add(content.substring(0, i));
					content.substring(i);
					freq.add(1);
					}
				for(int j = 0; j<words.size(); j++) {
					if(words.get(j).equals(content.substring(0, i))) {
						temp = freq.get(j);
						freq.set(j, temp+1);
					}
				}
			}
		}
		
		int max = 0;
		String word = words.get(0);
		for(int i = 0; i<freq.size(); i++) {
			if(max < freq.get(i)) {
				max = freq.get(i);
				word = words.get(i);
			}
		}
		return word;		
	}
	
	// returns the ten most common words (of length > 5) in 
	// the file, in order from most common to least common
	private String[] tenMostCommonWords() {
		ArrayList<String> words = new ArrayList<String>();
		String[] ten = new String[10];
		
		/*for(String word : content.split(" ")) {
				words.add(word);
		}
		
		for(int j = 0; j<words.size()-1; j++) {
			int minindex = j;
			for(int k = j+1; k<words.size(); k++) {
				if(words.get(k).compareTo(words.get(minindex))<0)
					minindex = k;
				String temp = words.get(j);
				words.set(j, words.get(minindex));
				words.set(minindex, temp);
			}
		}
		
		String maxs = words.get(0);
		int maxint = 0;
		int count = 1;
		for(int k = 0; k<ten.length; k++) {
			count = 1;
			maxint = 0;
			for(int i = 0; i<words.size()-1; i++) {
				for(int j = i+1; j<words.size(); j++) {
					if(words.get(i).equals(words.get(j)))
						count++;
				}
				if(count > maxint && words.get(i).length()>5) {
					maxint = count;
					maxs = words.get(i);
				}
			}
			ten[k] = maxs;
			while(words.contains(maxs)) {
			words.remove(words.indexOf(maxs));
			}
	}	
		return ten;
		*/
		int temp = 0;
		ArrayList<Integer> freq = new ArrayList<Integer>();
		for(int i = 0; i<content.length(); i++) {
			if(content.charAt(i)==' ') {
				if(!words.contains(content.substring(0, i))) {
					words.add(content.substring(0, i));
					content.substring(i);
					freq.add(1);
					}
				for(int j = 0; j<words.size(); j++) {
					if(words.get(j).equals(content.substring(0, i)))
						temp = freq.get(j);
						freq.set(j, temp+1);
				}
			}
		}
		
		int max = 0;
		String word = words.get(0);
		for(int i = 0; i<freq.size(); i++) {
			if(max < freq.get(i)) {
				max = freq.get(i);
				word = words.get(i);
			}
		}
		String[] arr = {""};
		return arr;		
	}
	
	// returns the longest sentence in the file
	private String longestSentence() {
		ArrayList<String> sen = new ArrayList<String>();
		for(int i = 0; i<content.length(); i++) {
			if(content.charAt(i)=='.') {
				sen.add(content.substring(0, content.indexOf(".")));
				content = content.substring(content.indexOf(".")+1);
			}
		}
		
		int MaxIndex = 0;
		String longest = sen.get(0);
		int count = 0;
		for(int j = 0; j<sen.size(); j++) {
			for(String word : content.split(" ")) {
				count++;
			}
			if(count > MaxIndex) {
				MaxIndex = count;
				longest = sen.get(j);
			}
		}
		return longest;
	}
	
	// returns the percent of characters in the file that are vowels.
	// cast the decimal to a string, shorten it to a few decimal 
	// points, then add a % sign to the end
	private String percentVowels() {
		int vowelnum = 0;
		int all = 0;
		for(int i = 0; i<content.length(); i++) {
			if(content.charAt(i)=='a' || content.charAt(i)=='e' || content.charAt(i)=='i' || 
					content.charAt(i)=='u' || content.charAt(i)=='o'){
						vowelnum++;
					}
			if(i == content.length()-1)
				all = i;
		}
		double per = ((double)(vowelnum)/(all)) *100;
		String percent = per + "%";
		return percent;
	}
	
	
	// ***** STOP HERE ***** //

	private JTextArea displayarea;
	private JButton freqButton, numWordsButton, numLinesButton, 
			mostCommonLetterButton, mostCommonWordButton, tenMostCommonButton, 
			longestSentenceButton, clearButton, percentVowelsButton;
	
	public FileAnalysis() throws IOException {
		// read actor file, save it as instance variable
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		for (int letter = in.read(); letter != -1; letter = in.read()) {
			content += (char)letter;
		}
		in.close();
		content = content.toLowerCase();
	}
	
	public void run() {}
	
	public void start_game() {
		
		// the main container
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// the inner container
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		panel.setBorder(BorderFactory.createTitledBorder("File Analysis"));
		
		// text container
		displayarea = new JTextArea();
		displayarea.setEditable(false);
		
		// create and add listeners to the buttons
		freqButton = new JButton("Letter Frequencies");
		freqButton.addActionListener(this);
		numWordsButton = new JButton("Number of Words in File");
		numWordsButton.addActionListener(this);
		numLinesButton = new JButton("Number of Lines in File");
		numLinesButton.addActionListener(this);
		mostCommonLetterButton = new JButton("Most Common Letter");
		mostCommonLetterButton.addActionListener(this);
		mostCommonWordButton = new JButton("Most Common Word");
		mostCommonWordButton.addActionListener(this);
		tenMostCommonButton = new JButton("10 Most Common Words");
		tenMostCommonButton.addActionListener(this);
		longestSentenceButton = new JButton("Longest Sentence");
		longestSentenceButton.addActionListener(this);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		percentVowelsButton = new JButton("Percent Vowels");
		percentVowelsButton.addActionListener(this);
		
		// add a scroll bar to the text area
		JScrollPane scroll = new JScrollPane (displayarea);
		scroll.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(400,475));
		panel.add(scroll);
		
		// create three containers for the three button rows 
		JPanel innerPanel2 = new JPanel(),innerPanel3 = new JPanel(),
				innerPanel4 = new JPanel();
		innerPanel2.add(freqButton);
		innerPanel2.add(numWordsButton);
		innerPanel2.add(numLinesButton);
		innerPanel3.add(mostCommonLetterButton);
		innerPanel3.add(mostCommonWordButton);
		innerPanel3.add(tenMostCommonButton);
		innerPanel4.add(percentVowelsButton);
		innerPanel4.add(longestSentenceButton);
		innerPanel4.add(clearButton);
		panel.add(innerPanel2);
		panel.add(innerPanel3);
		panel.add(innerPanel4);
		
		// final setup on the frame
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		// beginning text display
		displayarea.setText("\n   Currently working in "+fileName+".");
		
		// start the runner
		this.setFocusable(true);
		Thread t = new Thread(this);
		t.start();
	}
	
	public static void main(String[] args) {
		FileAnalysis d;
		try {
			d = new FileAnalysis();
			d.start_game();
		} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	// listener for our buttons
	public void actionPerformed(ActionEvent e) {
		String output="";
		if (e.getSource() == freqButton) {
			int[] freq = calcFrequencies();
			output = "\n   Letter frequencies in " + fileName+": \n";
			for (int i = 0; i < freq.length; i++) 
				output += "\n      "+(char)(i+97)+": " +freq[i];
		}
		else if (e.getSource() == numLinesButton) {
			int count = numLines();
			output = "\n   Number of lines in "+fileName+": ";
			output += count;
		}
		else if (e.getSource() == numWordsButton) {
			int count = numWords();
			output = "\n   Number of words in "+fileName+": ";
			output += count;
		}
		else if (e.getSource() == mostCommonLetterButton) {
			char common = mostCommonLetter();
			output += "\n   Most common letter in "+fileName+": "+common;
		}
		else if (e.getSource() == mostCommonWordButton) {
			String common = mostCommonWord();
			output += "\n   Most common word in "+fileName+": "+common;
		}

		else if (e.getSource() == tenMostCommonButton) {
			String[] common = tenMostCommonWords();
			output += "\n   10 most common words in "+fileName+
					" (of at least length 5):\n";
			for (int i = 0; i < common.length; i++)
				output += "\n      "+(i+1)+". "+common[i];
		}
		else if (e.getSource() == longestSentenceButton) {
			String sentence = longestSentence();
			output += "\n   Longest sentence in "+fileName+":";
			output += "\n\n      "+sentence;
		}
		else if (e.getSource() == percentVowelsButton) {
			output += "\n   Vowels make up "+percentVowels() +
					" of letters in "+fileName+".";
		}
		else if (e.getSource() == clearButton) {
			displayarea.setText("\n   Currently working in "+fileName+".");
		}
		displayarea.setText(displayarea.getText()+"\n"+output+"\n");
	}
}
