package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.*;

public class Disc extends Media {
	
	private String director;
    private int length;
    
    // Constructor
    public Disc(int id, String title) {
    	super(id, title);
    }
	public Disc(int id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
	}
	
	public Disc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	// Getter and Setter
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void play() throws PlayerException {
    };
}
