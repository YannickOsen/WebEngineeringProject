package project.qasystem.persistence.repositories;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import project.qasystem.persistence.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
