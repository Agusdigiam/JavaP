package com.box.boxservice.dto;

import com.box.boxservice.enums.HashTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDTO {
    HashTypeEnum algorithm;
    List<DocumentsDTO> documents;
}
