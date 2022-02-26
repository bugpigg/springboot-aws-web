package com.bugpigg.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> { // Entity 클래스, PK 타입 -> 기본적인 CRUD 메소드가 자동 생성된다.

}
