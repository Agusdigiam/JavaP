package com.box.boxservice.controller;

import com.box.boxservice.bo.FileBO;
import com.box.boxservice.dto.DocumentsDTO;
import com.box.boxservice.enums.HashTypeEnum;
import com.box.boxservice.dto.FileDTO;
import com.box.boxservice.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    @Autowired
    FileBO fileBO;
    @PostMapping("/hash")
    public ResponseEntity<ResponseDTO> saveDocuments(
            @RequestParam("hashType") HashTypeEnum hashType,
            HttpServletRequest request) {
        try {
            ResponseDTO response = new ResponseDTO(
                    hashType,
                    fileBO.saveFiles(hashType, request.getParts())
            );
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/doc")
    public ResponseEntity<DocumentsDTO> getDocument( @RequestParam("hashType") HashTypeEnum hashType,
                                                     @RequestParam("hash") String hash){
        DocumentsDTO document = fileBO.getDocument(hashType,hash);
        if(document == null)
            return ResponseEntity.notFound().build();
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<FileDTO>> getAll(){
        List<FileDTO> documents = fileBO.getAll();
        if(documents.isEmpty())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

}
