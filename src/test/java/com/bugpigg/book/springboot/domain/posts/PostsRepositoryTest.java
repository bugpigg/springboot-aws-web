package com.bugpigg.book.springboot.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest // H2 DB를 자동으로 실행해 준다.
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // Junit 에서 단위 테스트가 끝날때마다 수행되는 메소드 / 테스트 간 데이터의 침범을 막기 위해 / H2 DB에 데이터 남아 있는거 방지
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() // 테이블 posts 에 insert/update 쿼리를 실행한다.
                .title(title)
                .content(content)
                .author("bugpigg@gmail.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll(); // 테이블 posts 에 있는 모든 데이터를 조회해오는 메소드이다.

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    void BaseTimeEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        postsRepository.save(Posts.builder().title("title").content("content").author("author").build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        System.out.println(">>>>>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
