import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class Student {
    String name;
    String roll;
    String grade;

    public Student(String name, String roll, String grade) {
        this.name = name;
        this.roll = roll;
        this.grade = grade;
    }

    public String toString() {
        return "Name: " + name + "\nRoll no: " + roll + "\nGrade: " + grade;
    }
}

class StudentManage{
    private final ArrayList<Student> stu;

    public StudentManage() {
        stu = new ArrayList<>();
    }

    public void addStudent(Student student) {
        stu.add(student);
    }

    public void removeStudent(String roll) {
        stu.removeIf(student -> student.roll.equals(roll));
    }

    public Student searchStudent(String roll) {
        for (Student stud : stu) {
            if (stud.roll.equals(roll)) {
                return stud;
            }
        }
        return null;
    }

    public ArrayList<Student> getAllStudents() {
        return new ArrayList<>(stu);
    }
}

public class SManage {
    private final StudentManage st;

    private JFrame jf = new JFrame();
    private JButton b1, b2, b3, b4;
    private JTextField t1, t2, t3, t4;
    private JLabel l1, l2, l3, l4;
    private JTextArea ta;

    public SManage() {
        st = new StudentManage();

        l1 = new JLabel("Name: ");
        jf.add(l1);
        t1 = new JTextField(20);
        jf.add(t1);

        l2 = new JLabel("Roll no: ");
        jf.add(l2);
        t2 = new JTextField(20);
        jf.add(t2);

        l3 = new JLabel("Grade: ");
        jf.add(l3);
        t3 = new JTextField(20);
        jf.add(t3);

        b1 = new JButton("ADD");
        b2 = new JButton("REMOVE");
        b3 = new JButton("SEARCH");
        b4 = new JButton("DISPLAY");

        ta = new JTextArea(10, 30);
        JScrollPane sp= new JScrollPane(ta);
        jf.add(sp);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String name = t1.getText();
                    String roll = t2.getText();
                    String grade = t3.getText();

                    if (name.isEmpty() || roll.isEmpty() || grade.isEmpty()) {
                        JOptionPane.showMessageDialog(jf, "All the fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Student student = new Student(name, roll, grade);
                    st.addStudent(student);

                    try (FileOutputStream fout = new FileOutputStream("Students.txt", true)) {
                        fout.write(student.toString().getBytes());
                        fout.write("\n---------------\n".getBytes());
                    }

                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                } catch (Exception e) {
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String roll = t2.getText();
                    if (roll.isEmpty()) {
                        JOptionPane.showMessageDialog(jf, "Enter Roll no to remove student.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    st.removeStudent(roll);
                    disp();

                    try (FileOutputStream fout = new FileOutputStream("Students.txt", false)) {
                        for (Student student : st.getAllStudents()) {
                            fout.write(student.toString().getBytes());
                            fout.write("\n---------------\n".getBytes());
                        }
                    }

                    t2.setText("");
                } catch (Exception e) {
                    }
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String roll = t2.getText();
                    if (roll.isEmpty()) {
                        JOptionPane.showMessageDialog(jf, "Enter Roll no to search for a student.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Student student = st.searchStudent(roll);
                    if (student != null) {
                        JOptionPane.showMessageDialog(jf, student.toString(), "Student Found", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(jf, "Student not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    t2.setText("");
                } catch (Exception e) {
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    disp();
                } catch (Exception e) {
                }
            }
        });

        jf.add(b1);
        jf.add(b2);
        jf.add(b3);
        jf.add(b4);

        jf.setLayout(new FlowLayout());
        jf.setSize(800, 800);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    private void disp() {
        ta.setText("");
        for (Student student : st.getAllStudents()) {
            ta.append(student.toString() + "\n---------------\n");
        }
    }

    public static void main(String[] args) {
        new SManage();
    }
}
