public class Student {

	private String first;
	private String last;
	private int numberGrade;
	private String letterGrade;

	public String getFirst() {
		return this.first;
	}
	
	public String getLast() {
		return this.last;
	}

	public int getNumberGrade() {
		return this.numberGrade;
	}

	public String getLetterGrade() {
		return this.letterGrade;
	}

	@Override
	public String toString() {
		return this.first + " " + this.last + ": " + this.letterGrade;
	}

	public Student(String first, String last, int grade) {
		this.first = first;
		this.last = last;
		this.numberGrade = grade;
		if(grade > 90) {
                        this.letterGrade = "A";
                } else if(grade > 80) {
                        this.letterGrade = "B";
                } else if(grade > 70) {
                        this.letterGrade = "C";
                } else if(grade > 60) {
                        this.letterGrade = "D";
                } else {
			this.letterGrade = "F";
		}
	}

}
	
