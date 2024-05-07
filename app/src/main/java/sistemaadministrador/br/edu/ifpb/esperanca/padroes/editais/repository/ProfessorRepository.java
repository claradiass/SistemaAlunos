package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository;

import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;

public class ProfessorRepository {
    private DataService<Professor> dataService;
    private static ProfessorRepository instance;

    public ProfessorRepository(DataService<Professor> dataService) {
        this.dataService = dataService;
    }

    public static ProfessorRepository getInstance(DataService<Professor> dataService){
        if (instance == null){
            instance = new ProfessorRepository(new InMemoryProfessor());
        }
        return instance;
    }

    public void updateRepository(DataService<Professor> dataService){
        this.dataService = dataService;
    }

    public void createAccount(Professor professor) {
        dataService.createAccount(professor);
    }

    public void disableAccount(int id) {
        dataService.disableAccount(id);
    }

    public void activeAccount(int id) {
        dataService.activeAccount(id);
    }

    public void updateUser(int idProfessor, Professor professor) {
        dataService.updateUser(idProfessor, professor);
    }

    public Professor findById(int id) {
        return (Professor) dataService.findById(id);
    }

    public List<Professor> findAll() {
        return dataService.findAll();
    }

    public List<Professor> searchAccount(String termo) {
        return dataService.searchAccount(termo);
    } 
}