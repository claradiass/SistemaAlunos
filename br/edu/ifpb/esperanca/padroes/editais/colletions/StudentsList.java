package br.edu.ifpb.esperanca.padroes.editais.colletions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifpb.esperanca.padroes.editais.model.Student;

public class StudentsList {
    private List<Student> studentsList;

    public StudentsList() {
        this.studentsList = new ArrayList<>();
    }

    public List<Student> viewStudentsList() {
        return studentsList;
    }

    public void addStudent(Student student){
        studentsList.add(student);
    }

    public void removeStudent(Student student){
        studentsList.remove(student);
    }

    //para cada objeto student, verifique se o método search retorna verdadeiro para o termo de pesquisa fornecido
    public List<Student> searchStudentByUserName(String letter){
        return studentsList.stream().filter(student -> student.searchByUserName(letter)).collect(Collectors.toList());
    }


}
