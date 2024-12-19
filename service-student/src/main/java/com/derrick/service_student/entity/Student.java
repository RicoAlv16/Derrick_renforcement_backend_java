package com.derrick.service_student.entity;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {

    @Id
    private String id;    // ID de l'étudiant
    private String name;  // Nom de l'étudiant
    private int age;      // Âge de l'étudiant
    private String schoolId; // ID de l'école associée

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getSchoolId() {
        return this.schoolId;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public void setSchoolId(final String schoolId) {
        this.schoolId = schoolId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Student)) {
            return false;
        } else {
            Student other = (Student)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getAge() != other.getAge()) {
                return false;
            } else {
                label49: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label49;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label49;
                    }

                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                Object this$schoolId = this.getSchoolId();
                Object other$schoolId = other.getSchoolId();
                if (this$schoolId == null) {
                    if (other$schoolId != null) {
                        return false;
                    }
                } else if (!this$schoolId.equals(other$schoolId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Student;
    }

    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getAge();
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $schoolId = this.getSchoolId();
        result = result * 59 + ($schoolId == null ? 43 : $schoolId.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = this.getId();
        return "Student(id=" + var10000 + ", name=" + this.getName() + ", age=" + this.getAge() + ", schoolId=" + this.getSchoolId() + ")";
    }

    public Student() {
    }

    public Student(final String id, final String name, final int age, final String schoolId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.schoolId = schoolId;
    }

}
