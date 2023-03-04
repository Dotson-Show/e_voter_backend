package com.evoter.user.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;


/**
 * @author showunmioludotun
 */
@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "email_unique",
                        columnNames = {"email"}
                ),
                @UniqueConstraint(
                        name = "nin_unique",
                        columnNames = {"nin"}
                )
        }
)
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    private String sex;
    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;
    @Column(
            name = "nin",
            nullable = false
    )
    private String nin;
    @Column(
            name = "email",
            nullable = false
    )
    private String email;
    @Column(
            name = "password",
            nullable = false
    )
    private String password;
    private boolean admin;
    private boolean superAdmin;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "created_at",
            nullable = false
    )
    private Date createdAt;

    @PrePersist
    private void onCreate() {
        createdAt = new Date();
    }

    public User(Long id, String name, String sex, Integer age, String nin, String email, String password, boolean admin, boolean superAdmin, Date createdAt) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.nin = nin;
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.superAdmin = superAdmin;
        this.createdAt = createdAt;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        this.superAdmin = superAdmin;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return admin == user.admin && superAdmin == user.superAdmin && Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(sex, user.sex) && Objects.equals(age, user.age) && Objects.equals(nin, user.nin) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, age, nin, email, password, admin, superAdmin, createdAt);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", nin='" + nin + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", superAdmin=" + superAdmin +
                ", createdAt=" + createdAt +
                '}';
    }
}
