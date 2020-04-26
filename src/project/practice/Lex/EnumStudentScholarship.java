package project.practice.Lex;

class Student {
    private int studentId;
    private String name;
    private int totalMarks;
    private enum Grade {
        A(5000), B(4000), C(3000), D(2000), E(0);
        private final int scholarshipAmount;
        Grade(int scholarshipAmount) {
            this.scholarshipAmount = scholarshipAmount;
        }
        public int getScholarshipAmount() {
            return scholarshipAmount;
        }
    }

    int getStudentId() {
        return studentId;
    }
    void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
    public int getTotalMarks() {
        return totalMarks;
    }
    void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

     Grade calculateGrade(){
        return totalMarks >= 250 ? Grade.A : totalMarks >= 200 ? Grade.B : totalMarks >= 175 ? Grade.C : totalMarks >= 150 ? Grade.D : Grade.E ;
    }
    int calculateScholarshipAmount(Grade grade) {
        return grade.scholarshipAmount;
    }
}


public class EnumStudentScholarship {
    public static void main(String[] args) {
        Student stud = new Student();
        stud.setStudentId(1000);
        stud.setTotalMarks(280);
        stud.setName("alvin");
        System.out.println("Student Details");
        System.out.println("Student Id:" + stud.getStudentId());
        System.out.println("Student Name:" + stud.getName());
        System.out.println("Student Grade:" + stud.calculateGrade());
        System.out.println("Scholarship amount:" + stud.calculateScholarshipAmount(stud.calculateGrade()));
    }
}