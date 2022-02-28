package com.bugpigg.book.springboot.domain.posts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends
    JpaRepository<Posts, Long> { // Entity 클래스, PK 타입 -> 기본적인 CRUD 메소드가 자동 생성된다.

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
        // SpringDataJpa 에서 제공하지 않는 메소드는 이와 같이 쿼리로 작성할 수 있다.
    List<Posts> findAllDesc();
}
