package com.milenarizzi.todosimple.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = Task.TABLE_NAME)
public class Task {
    public static final String TABLE_NAME = "task";

    
    public Task() {
    }

    
    public Task(Long id, User user, @NotNull @NotEmpty @Size(min = 1, max = 255) String description) {
        this.id = id;
        this.user = user;
        this.description = description;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;


    @ManyToOne //várias tarefas podem ser de 1 usuário.
    @JoinColumn(name = "user_id", nullable = false, updatable = false) //para fazer referencia a chave primária do user
    private User user;

    //descrição da tarefa
    @Column(name = "description", length = 255, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String description;


    public static String getTableName() {
        return TABLE_NAME;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


      //hascCode e equals foi implementado pelo professor
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) 
            return true;

        if (obj == null) 
            return false;

        if (!(obj instanceof Task)) 
            return false;

        Task other = (Task) obj;
        if (this.id == null) {
            if (other.id != null) {
                return false;
            } else if (!this.id.equals(other.id)) {
                return false;
            }
        }
        return Objects.equals(this.id, other.id) && Objects.equals(this.user, other.user)
        && Objects.equals(this.description, other.description);
    }







}
