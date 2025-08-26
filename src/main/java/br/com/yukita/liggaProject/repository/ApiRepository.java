package br.com.yukita.liggaProject.repository;

import br.com.yukita.liggaProject.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApiRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAllByType(String type);
    List<Activity> findAllByKidFriendly(boolean kidFriendly);

}
