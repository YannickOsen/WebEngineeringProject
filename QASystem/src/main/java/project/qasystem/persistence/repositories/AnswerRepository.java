package project.qasystem.persistence.repositories;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import project.qasystem.persistence.model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
