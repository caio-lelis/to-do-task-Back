package com.caiolelis.todosimple.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity  // Tratando User como uma entidade do banco de dados
@Table(name = User.TABLE_NAME)  // Definindo o nome da tabela

public class User {

    public interface CreateUser {} // Interface para criar um usuário
    public interface UpdateUser {} // Interface para atualizar um usuário

    public static final String TABLE_NAME = "user"; // Definindo o nome da tabela

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Definindo o tipo de geração de id
    @Column(name = "id", unique = true) // Definindo o nome da coluna e que ela é única
    private Long id; // Definindo o tipo de dado e o nome da coluna

    @Column(name = "username", unique = true, length = 100, nullable = false) // Definindo o nome da coluna e que ela é única
    @NotNull (groups = CreateUser.class ) // Definindo que não pode ser nulo
    @NotEmpty (groups = CreateUser.class ) // Definindo que não pode ser vazio
    @Size((groups = CreateUser.class ) , min = 2, max = 100) // Definindo o tamanho mínimo e máximo
    private String username; // Definindo o tipo de dado e o nome da coluna

    @Column(name = "password", length = 60, nullable = false) // Definindo o nome da coluna e que ela é única
    @NotNull (groups = {CreateUser.class, UpdateUser.class}) // Definindo que não pode ser nulo
    @NotEmpty (groups = {CreateUser.class, UpdateUser.class} ) // Definindo que não pode ser vazio
    @Size( groups = {CreateUser.class, UpdateUser.class} , min = 8, max = 60) // Definindo o tamanho mínimo e máximo
    @JsonProperty(access = Access.WRITE_ONLY) // Definindo que o campo não pode ser lido
    private String password; // Definindo o tipo de dado e o nome da coluna



    //private List<Task> tasks = new ArrayList<Task>(); // Definindo a lista de tarefas

    

    public User() {
    }



    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        //this.tasks = tasks;
    }
    


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void SetUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }


    public void SetPassword(String password) {
        this.password = password;
    }


    public String getPassword() {
        return this.password;
    }

    
    @Override
    public int hasgCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;

        if(getClass() != obj.getClass()) return false;

        User other = (User) obj;
        if(id == null) {
            if(other.id != null) return false;
        } else if(!id.equals(other.id)) return false;

        return true;
    }
}
