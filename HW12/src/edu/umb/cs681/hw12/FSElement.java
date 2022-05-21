package edu.umb.cs681.hw12;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;


public abstract class FSElement {
	private String name;
	private int size;
	private LocalDateTime creationTime;
	private Directory parent;
	public ReentrantLock lock = new ReentrantLock();

	public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
	}
	
	public int getSize() {
		return size;
	}
	
	public String getName() {
		return name;
	}


	public Directory getParent() {
		return parent;
	}
	
	public void setParent(Directory parent) {
		this.parent = parent;
	}
	
	protected abstract boolean isDirectory();
	protected abstract boolean isFile();


}
