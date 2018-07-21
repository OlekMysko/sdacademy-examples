package pl.sdacademy.printer;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Printer {

	private final int documentsThreshold;
	private Stack<Document> printQueue;

	public Printer(int documentsThreshold) {
		this.printQueue = new Stack<>();
		this.documentsThreshold = documentsThreshold;
	}

	void print(Document document) {
		printQueue.push(document);
		if (printQueue.size() >= documentsThreshold) {
			while (!printQueue.isEmpty()) printQueue.pop().setPrinted(true);
		}
	}
}