package com.box.boxservice.repository;

import com.box.boxservice.entity.File;
import com.box.boxservice.enums.HashTypeEnum;

public interface FileRepositoryCustom {

   File findByHash(HashTypeEnum hashType, String hash, String account);
}
