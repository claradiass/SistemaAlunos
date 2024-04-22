package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Professor;


public class ProfessorsList {
    private List<Professor> professorsList;

    public ProfessorsList() {
        if (professorsList == null) {
            this.professorsList = new ArrayList<>();
        }
    }

    public List<Professor> viewProfessorsList() {
        return professorsList;
    }

    public void addProfessor(Professor professor){
        professorsList.add(professor);
    }

    public void removeProfessor(Professor professor){
        professorsList.remove(professor);
    }

    //para cada objeto Professor, verifique se o método search retorna verdadeiro para o termo de pesquisa fornecido
    public List<Professor> searchProfessorByUserName(String letter){
        return professorsList.stream().filter(professor -> professor.searchByUserName(letter)).collect(Collectors.toList());
    }

    public Professor viewProfessor(int id){
        return professorsList.get(id);
    }

    public void exitsUserName(String userNameToCheck) throws IllegalArgumentException {
        if(professorsList.stream().anyMatch(professor -> professor.exitsUserName(userNameToCheck))){
            throw new IllegalArgumentException("Username unavailable");
        }
    }
}