import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Driver {

	public static void main(String[] args) {
		ArrayList<Student> students;
		try {
			students = populateStudents();
			printRoster(students);
			System.out.println("================");
			System.out.println("Class Trivia");
			Student best = calculateHighestGrade(students);
			System.out.println("Highest Grade: " + best.getFirst() + " " + best.getLast() + " " + best.getNumberGrade() + " = " + best.getLetterGrade());
			double average = calculateClassAverage(students);
			System.out.println("Class Average: " + Double.toString(average));
			double deviation = calculateClassDeviation(students, average);
			System.out.println("Class Standard Devation: " + Double.toString(deviation));
		} catch(Exception e) {
			System.out.println("Text file broken");
		}
	}

	public static Student calculateHighestGrade(ArrayList<Student> students) {
		if(students.size() == 0) {
			System.out.println("Class is empty");
			return null;
		} 
		Student best = students.get(0);
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getNumberGrade() > best.getNumberGrade()) {
				best = students.get(i);
			}
		}
		return best;
	}

	public static double calculateClassAverage(ArrayList<Student> students) {
		double sum = 0;
		for(Student i : students) {
			sum += i.getNumberGrade();
		}
		return sum / ((double) students.size());
	}

	public static double calculateClassDeviation(ArrayList<Student> students, double average) {
		double total = 0;
		for(Student i : students) {
			total += Math.pow((average - i.getNumberGrade()), 2);
		}
		return Math.sqrt(total / ((double) students.size()));
	}

	public static void printRoster(ArrayList<Student> students) {
		System.out.println("Student Roster");
		for(Student i : students) {
			System.out.println(i);
		}
	}

	public static ArrayList<Student> populateStudents() throws Exception {
		File file = new File("students.txt");
		Scanner sc = new Scanner(file);
		ArrayList<Student> students = new ArrayList<>();
		while(sc.hasNextLine()) {
			String[] info = sc.nextLine().split(" ");
			students.add(new Student(info[0], info[1], Integer.parseInt(info[2])));
		}
		return students;
	}

}
