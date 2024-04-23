package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Student;


public class StudentsList {
    private List<Student> studentsList;

    public StudentsList() {
        if (studentsList == null) {
            this.studentsList = new ArrayList<>();
        }
    }
    //sempre vai criar uma nova instância

    public List<Student> viewStudentsList() {
        return studentsList;
    } // private 

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

    public Student viewStudent(int id){
        return studentsList.get(id);
    }

    public void exitsUserName(String userNameToCheck) throws IllegalArgumentException {
        if(studentsList.stream().anyMatch(student -> student.exitsUserName(userNameToCheck))){
            throw new IllegalArgumentException("Username unavailable");
        }
    }

    public void disableAccount(int id){
        Student student = viewStudent(id);
        student.modifyStatusToDisable(); 
    }

    public void activeAccount(int id){
        Student student = viewStudent(id);
        student.modifyStatusToActivate(); 
    }

    public void updateStudentAccount(int id, String newName, String newUserName, String newPassword){
        Student student = viewStudent(id);
        student.updateStudent(newName, newUserName, newPassword);
    }
}
