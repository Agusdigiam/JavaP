package com.box.boxservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class FileDTO {
    private String fileName;
    private String hash_sha_256;
    private String hash_sha_512;
    private Date lastUpload;
}
