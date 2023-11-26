package com.milenarizzi.todosimple.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milenarizzi.todosimple.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // utilizando a forma pronta do JPA
    List<Task> findByUser_Id(Long id);

    // utilizando uma query com automação do spring
    // @Query(value = "SELECT t FROM Task t WHERE t.user.id = :id")
    // List<Task> findByUser_Id(Long id);

    // utilizando query com sql puro
    // @Query(value = "SELECT * FROM task t WHERE t.user_id = :id", nativeQuery =
    // true)
    // List<Task> findByUser_Id(Long id);

}
