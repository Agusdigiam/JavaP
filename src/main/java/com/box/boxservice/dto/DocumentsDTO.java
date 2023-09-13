package com.box.boxservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class DocumentsDTO {
    private String fileName;
    private String hash;
    private Date lastUpload;
}



