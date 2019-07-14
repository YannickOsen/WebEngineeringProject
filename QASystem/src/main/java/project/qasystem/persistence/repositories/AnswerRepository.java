package project.qasystem.persistence.repositories;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import project.qasystem.persistence.DTOs.AnswerDTO;
        import project.qasystem.persistence.model.Answer;
        import project.qasystem.persistence.model.Question;
        import project.qasystem.persistence.model.User;

        import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

        Answer findById(long id);
        List<Answer> findByQuestion(Question question);
        List<Answer> findByUser(User user);
        List<Answer> findByIsAcceptedAnswer(boolean isAcceptedAnswer);

        /**Use this for when you want to sort questions by amount of answers.
         * @param question the question you want to know the amount of answers for.
         *
         * @return the number of answers this question has.
         * */
        int countByQuestion(Question question);
}
