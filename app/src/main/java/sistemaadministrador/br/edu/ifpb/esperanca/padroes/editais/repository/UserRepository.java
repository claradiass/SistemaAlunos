package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository;
import java.util.List;

// definindo interface do repositório tanto para estudantes quanto para professores
// usando <T> para não especificar o tipo e poder ser usando tanto para student quanto para professor
public interface UserRepository<T>{

    void createAccount(T entity);
    void disableAccount(int id);
    void activeAccount(int id);
    void updateUser(T entity);
    T findById(int id);
    List<T> findAll();

}
