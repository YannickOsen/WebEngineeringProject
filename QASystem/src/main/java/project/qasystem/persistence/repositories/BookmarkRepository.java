package project.qasystem.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.qasystem.persistence.model.Bookmark;
import project.qasystem.persistence.model.User;
import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    public List<Bookmark> findByUser(User user);
}
