package com.winston.stone.lottery.repository;

import com.winston.stone.lottery.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author winston
 *         2017/6/17/017 19:59
 */
@RepositoryRestResource(collectionResourceRel = "aaa", path = "bbb", collectionResourceDescription = @Description("对对对"))
public interface DemoRepository extends JpaRepository<Demo, Long> {
    Demo findById(Long id);

    Demo findByName(@Param("name") String name);

    Demo findByAge(int age);
}
