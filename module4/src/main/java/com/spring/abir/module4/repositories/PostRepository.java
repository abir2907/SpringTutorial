package com.spring.abir.module4.repositories;

import com.spring.abir.module4.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
