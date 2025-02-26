package com.studentapp.repository;

import com.studentapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Fetch students by name
    List<Student> findByName(String name);

    // Fetch students by attendance status
    List<Student> findByAttendance(boolean attendance);

    // Update attendance status for a student
    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.attendance = :status WHERE s.id = :id")
    void updateAttendance(Long id, boolean status);
}
