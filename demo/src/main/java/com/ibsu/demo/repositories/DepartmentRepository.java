package com.ibsu.demo.repositories;

import com.ibsu.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("from Department d where d.departmentName like concat('%',:name,'%')")
    List<Department> getByName(@Param("name") String name);

}
