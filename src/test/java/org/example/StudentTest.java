package org.example;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private static List<Student> students;

    @BeforeAll
    public static void initClass() {
        students = new ArrayList<>();
    }

    @AfterAll
    public static void cleanClass() {
        students.clear();
    }

    @BeforeEach
    public void initMethod() {
        Student student = new Student("John Doe", 20);
        students.add(student);
    }

    @AfterEach
    public void cleanMethod() {
        students.clear();
    }

    @Test
    public void testDataCreation() {
        assertNotNull(students);
        assertEquals(1, students.size());
        assertEquals("John Doe", students.get(0).getName());
        assertEquals(20, students.get(0).getAge());
    }

    @Test
    public void testStudentEnrolment() {
        students.get(0).enrollCourse("Math");
        students.get(0).enrollCourse("History");

        List<String> enrolledCourses = students.get(0).getEnrolledCourses();
        assertNotNull(enrolledCourses);
        assertEquals(2, enrolledCourses.size());
        assertTrue(enrolledCourses.contains("Math"));
        assertTrue(enrolledCourses.contains("History"));
    }

    @Test
    public void testStudentGrade() {
        students.get(0).setGrade("Math", "A");
        students.get(0).setGrade("History", "B");

        assertEquals("A", students.get(0).getGrade("Math"));
        assertEquals("B", students.get(0).getGrade("History"));
    }
}
