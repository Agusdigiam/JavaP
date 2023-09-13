package com.box.boxservice.repository;

import com.box.boxservice.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface FileRepository extends JpaRepository<File,Integer> , FileRepositoryCustom {
    public File findByNameAndAccount(String name, String account);
    List<File> findByAccount(String email);
}
