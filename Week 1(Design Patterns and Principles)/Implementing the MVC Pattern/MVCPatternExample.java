public class MVCPatternExample {

    
    static class Student {
        private String name;
        private String id;
        private String grade;

        public Student(String name, String id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    
    static class StudentView {
        public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
            System.out.println("Student Details:");
            System.out.println("Name: " + studentName);
            System.out.println("ID: " + studentId);
            System.out.println("Grade: " + studentGrade);
        }
    }

    
    static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public String getStudentName() {
            return model.getName();
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public String getStudentId() {
            return model.getId();
        }

        public void setStudentId(String id) {
            model.setId(id);
        }

        public String getStudentGrade() {
            return model.getGrade();
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public void updateView() {
            view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
        }
    }

    
    public static void main(String[] args) {
        
        Student student = new Student("Sourajit Datta", "78968", "A");

        
        StudentView view = new StudentView();

        
        StudentController controller = new StudentController(student, view);

        
        System.out.println("Initial Student Details:");
        controller.updateView();

        
        System.out.println("\nUpdating Student Details...");
        controller.setStudentName("Lionel Messi");
        controller.setStudentId("67890");
        controller.setStudentGrade("B");
        System.out.println("\nUpdated Student Details:");
        controller.updateView();
    }
}
