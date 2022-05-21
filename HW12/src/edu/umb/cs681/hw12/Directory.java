package edu.umb.cs681.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;


public class Directory extends FSElement {
	
	private LinkedList<FSElement> child = new LinkedList<FSElement>();
	private LinkedList<File> fileList = new LinkedList<File>();
	private LinkedList<Directory> directoryList = new LinkedList<Directory>();

	
	public Directory(Directory parent, String name, int size, LocalDateTime createdTime) {
		super(parent, name, size, createdTime);
		if (parent != null)
			parent.appendChild(this);
	}
	public boolean isDirectory() {
		return true;
	}

	public  boolean isFile() {
		return false;
	}

	public LinkedList<FSElement> getChildren() {
		lock.lock();
		try{
			return child;
		} finally {
			lock.unlock();
		}
	}
	
	public void appendChild(FSElement child) {
		lock.lock();
		try{
			this.child.add(child);
			child.setParent(this);
		}finally {
			lock.unlock();
		}

	}
	
	public int countChildren() {
		lock.lock();
		try{
			return getChildren().size();
		}finally {
			lock.unlock();
		}
	}
		
	public LinkedList<Directory> getSubDirectories() {
		lock.lock();
		try{
		for (FSElement element : getChildren()) {
			if (element.isDirectory())
				directoryList.add((Directory) element);
		}
		return directoryList;
	}finally {
			lock.unlock();
		}
	}
	
	public LinkedList<File> getFiles() {
		lock.lock();
		try{
		for (FSElement element : child) {
			if (element.isFile()) {
				fileList.add((File) element);
			}
		}
		return fileList;
	}finally {
			lock.unlock();
		}
	}

	public int getTotalSize() {
		lock.lock();
		try{
		int totalSize = 0;
		for (FSElement element : getChildren()) {
			if (element.isDirectory())
				totalSize += ((Directory) element).getTotalSize();
			else
				totalSize += element.getSize();
		}
		return totalSize;
	}finally {
			lock.unlock();
		}
	}

}



