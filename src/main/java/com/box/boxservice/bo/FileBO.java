package com.box.boxservice.bo;

import com.box.boxservice.dto.DocumentsDTO;
import com.box.boxservice.dto.FileDTO;
import com.box.boxservice.entity.File;
import com.box.boxservice.enums.HashTypeEnum;
import com.box.boxservice.service.FileService;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileBO {
    @Value("${path_temp}")
    private String PATH_TEMP;
    @Autowired
    FileService fileService;
    public List<DocumentsDTO> saveFiles(HashTypeEnum hashType, Collection<Part> parts) throws IOException {
        User principal  =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<DocumentsDTO> files= new ArrayList<DocumentsDTO>(parts.size());
        HashFunction hashFunction = hashType.equals(HashTypeEnum.SHA_256) ? Hashing.sha256():Hashing.sha512();
        for (final Part part : parts) {
            String path= PATH_TEMP+part.getSubmittedFileName();
            part.write(path);
            java.io.File fileTemp = new java.io.File(path);
            HashCode hashCode = Files.asByteSource(fileTemp).hash(hashFunction);
            String hash = hashCode.toString();
            File fileEntity = fileService.findByNameAndAccountID(part.getSubmittedFileName(),principal.getUsername());
            if(fileEntity == null){
                fileEntity = new File();
                fileEntity.setName(part.getSubmittedFileName());
                fileEntity.setAccount(principal.getUsername());
            }else{
                fileEntity.setLast_update(new Date());
            }
            fileEntity.setHash_sha_256(hashType.equals(HashTypeEnum.SHA_256) ? hash:fileEntity.getHash_sha_256());
            fileEntity.setHash_sha_512(hashType.equals(HashTypeEnum.SHA_512) ? hash:fileEntity.getHash_sha_512());
            fileService.save(fileEntity);
            files.add(new DocumentsDTO(part.getSubmittedFileName(),hash,fileEntity.getLast_update()));
        }
        return files;
    }

    public List<FileDTO> getAll() {
        User principal  =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<File> files = fileService.findAllByUser(principal.getUsername());
        return files
                .stream()
                .map(file -> new FileDTO(file.getName(),
                        file.getHash_sha_256(),
                        file.getHash_sha_512(),
                        file.getLast_update()))
                .collect(Collectors.toList());
    }

    public DocumentsDTO getDocument(HashTypeEnum hashType, String hash) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        File file = fileService.findFile(hashType,hash,principal.getUsername());
        return new DocumentsDTO(file.getName(),hash,file.getLast_update());
    }
}
