package com.box.boxservice.service;

import com.box.boxservice.dto.FileDTO;
import com.box.boxservice.entity.File;
import com.box.boxservice.enums.HashTypeEnum;
import com.box.boxservice.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FileService {
    @Autowired
    FileRepository fileRepository;

    public  File save(File file){
        return fileRepository.save(file);
    }

    public File findByNameAndAccountID(String fileName, String email){
        return fileRepository.findByNameAndAccount(fileName, email);
    }
    public List<File> findAllByUser(String email) {
        return fileRepository.findByAccount(email);
    }

    public File findFile(HashTypeEnum hashType, String hash, String username) {
        return fileRepository.findByHash(hashType,hash,username);
    }
}
