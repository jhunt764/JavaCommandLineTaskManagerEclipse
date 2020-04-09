package com.jacobhunt.handson;

import java.util.ArrayList;
import java.util.Scanner;

public class FinalHandsOn {
	
//	list of tasks = array list?
	static ArrayList<Task> tasks;
//	read from the console
	static Scanner sc;

	public static void main(String[] args) {
//initialize my arraylist
		tasks = new ArrayList<Task>();
//initialize scanner
		sc = new Scanner(System.in);
		
		tasks.add(new Task("Fix the car window"));
		tasks.add(new Task("Workout"));
		tasks.add(new Task("Job search"));
		tasks.add(new Task("Shave to door"));
		tasks.add(new Task("Meal prep"));
		
		
		boolean running = true;
		
		do {
			displayMenu();
			int menuChoice = readChoice();
			
			switch(menuChoice) {
			case 1:
				System.out.println("Name of the task to add:");
				String taskName = sc.nextLine();
				addTask(taskName);
				break;
			case 2:
//				listTasks();
				System.out.println("Item to remove:");
				listTasks();
				int removeId = readChoice();
				removeTask(removeId);
				break;
			case 3:
//				listTasks();
				System.out.println("Item to complete:");
				listTasks();
				int completeId = readChoice();
				completeTask(completeId);
				break;
			case 4:
				listTasks();
				break;
			case 0:
				running = false;
				break;
				default:
					System.out.println("unknown menu choice");
					
				}
			
		}while(running);

	}

	public static void displayMenu() {
		System.out.println("|||||-- Task Manager--|||||");
		System.out.println("	1. add a task");
		System.out.println("	2. remove a task");
		System.out.println("	3. mark as complete");
		System.out.println("	4. lists tasks");
		System.out.println("	0. quit");
		System.out.println("What would you like to do?:");
	}
	
	public static int readChoice() {
		int result = sc.nextInt();
		sc.nextLine();
		return result;
	}
	
	public static void listTasks() {
		System.out.println("--Tasks--");
		for(int i = 0; i< tasks.size(); i++) {
			System.out.println(i+1+". " + tasks.get(i).toString());
		}
	}
	
	public static void completeTask(int id) {
		tasks.get(id-1).setComplete(true);
	}
	
	public static void removeTask(int id) {
		tasks.remove(id-1);
	}
	
	public static void addTask(String name) {
		tasks.add(new Task(name));
	}
}
