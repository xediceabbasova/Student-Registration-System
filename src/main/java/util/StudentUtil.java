package util;

import beans.Student;
import main.Config;

public class StudentUtil {

    public static Student fillStudent() {
        String name = MenuUtil.requireName();
        String surname = MenuUtil.requireSurname();
        String className = MenuUtil.requireClassname();
        int age = MenuUtil.requireAge();
        Student st = new Student(name, surname, age, className);
        return st;
    }

    public static void printAllRegisteredStudents() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            System.out.println(i + 1 + "." + st.getFullInfo());
        }
    }

    public static void RegisterStudents() {
        int count = InputUtil.requireNumber("neche telebe qeydiyyatdan kecireceksiniz?");
        Config.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ".Register");

            Config.students[i] = StudentUtil.fillStudent();
        }
        MenuUtil.showSuccessMessage();
        StudentUtil.printAllRegisteredStudents();
    }

    public static void findStudentsAndPrint() {
        String text = InputUtil.requireText("type name,surname or class name");
        Student[] result = findStudents(text);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getFullInfo());
        }

    }

    public static Student[] findStudents(String text) {
        int count = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                count++;
            }
        }

        Student[] result = new Student[count];
        int found = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                result[found] = st;
                found++;
            }
        }
        return result;
    }

    public static void updateStudentWithNewObject() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requireNumber("nechenci adamda deyisiklik etmek isteyirsiz?");

        System.out.println("Yeni melumatlari daxil edin:");
        Student s = StudentUtil.fillStudent();
        Config.students[i - 1] = s;
    }

    public static void updateStudentWithSameObject() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requireNumber("nechenci adamda deyisiklik etmek isteyirsiz?");

        System.out.println("Yeni melumatlari daxil edin:");
        Student selectedStudent = Config.students[i - 1];
        String changeParams = InputUtil.requireText("neleri deyismek isteyirsiniz? mes: 'name','surname','age'");

        if (changeParams.contains("'name'")) {
            selectedStudent.setName(InputUtil.requireText("name"));
        }
        if (changeParams.contains("'surname'")) {
            selectedStudent.setSurname(InputUtil.requireText("surname"));
        }
        if (changeParams.contains("'age'")) {
            selectedStudent.setAge(InputUtil.requireNumber("age"));
        }
        if (changeParams.contains("'classname'")) {
            selectedStudent.setClassName(InputUtil.requireText("class name"));

        }

    }

    public static void updateStudentWithSplit() {
        StudentUtil.printAllRegisteredStudents();
        int index = InputUtil.requireNumber("nechenci adamda deyisiklik etmek isteyirsiz?");

        System.out.println("Yeni melumatlari daxil edin:");
        Student selectedStudent = Config.students[index - 1];
        String changeParams = InputUtil.requireText("neleri deyismek isteyirsiniz? mes: name,surname,age");
        String[] parameters = changeParams.split(",");
        for (int i = 0; i < parameters.length; i++) {
            String param = parameters[i];
            if (param.equalsIgnoreCase("name")) {
                selectedStudent.setName(MenuUtil.requireName());
            } else if (param.equalsIgnoreCase("surname")) {
                selectedStudent.setSurname(MenuUtil.requireSurname());
            } else if (param.equalsIgnoreCase("age")) {
                selectedStudent.setAge(MenuUtil.requireAge());
            } else if (param.equalsIgnoreCase("classname")) {
                selectedStudent.setClassName(MenuUtil.requireClassname());

            }
        }
    }

}
