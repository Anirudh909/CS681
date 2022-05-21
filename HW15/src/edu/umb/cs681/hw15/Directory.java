package edu.umb.cs681.hw15;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Directory extends FSElement {

	private LinkedList<File> fileList = new LinkedList<File>();
	private LinkedList<Directory> directoryList = new LinkedList<Directory>();
	private ConcurrentLinkedQueue<FSElement> child = new ConcurrentLinkedQueue<>();
	
	public Directory(Directory parent, String name, int size, LocalDateTime createdTime) {
		super(parent, name, size, createdTime);
		if (parent != null)
			parent.appendChild(this);
	}

	public ConcurrentLinkedQueue<FSElement> getChildren() {
		return child;
	}

	
	public void appendChild(FSElement child) {
		this.child.add(child);
		child.setParent(this);
	}
	
	public int countChildren() {
		return getChildren().size();
	}
		
	public LinkedList<Directory> getSubDirectories() {
		for (FSElement element : getChildren()) {
			if (element.isDirectory())
				directoryList.add((Directory) element);
		}
		return directoryList;
	}
	
	public LinkedList<File> getFiles() {
		for (FSElement element : child) {
			if (element.isFile()) {
				fileList.add((File) element);
			}
		}
		return fileList;
	}

	public int getTotalSize() {
		int totalSize = 0;
		for (FSElement element : getChildren()) {
			if (element.isDirectory())
				totalSize += ((Directory) element).getTotalSize();
			else
				totalSize += element.getSize();
		}
		return totalSize;
	}


    
	public boolean isDirectory() {
		return true;
	}
	
	public  boolean isFile() {
		return false;
	}



}



