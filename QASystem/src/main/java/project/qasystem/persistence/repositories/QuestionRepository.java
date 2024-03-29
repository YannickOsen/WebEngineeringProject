package project.qasystem.persistence.repositories;

        import org.springframework.data.domain.Sort;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import project.qasystem.persistence.model.Question;
        import project.qasystem.persistence.model.User;

        import java.util.Collection;
        import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

        Question findById(long id);
        List<Question> findByUser(User user);
        List<Question> findByIsAnswered(boolean isAnswered);
        List<Question> findAllByOrderByDateDesc();
        List<Question> findByTitle(String title);
        List<Question> findByIsSolved(boolean isSolved);
}
