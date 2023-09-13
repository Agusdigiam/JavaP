package com.box.boxservice.repository;

import com.box.boxservice.entity.File;
import com.box.boxservice.enums.HashTypeEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FileRepositoryImpl implements FileRepositoryCustom {

    @PersistenceContext
    EntityManager em;
    @Override
    public File findByHash(HashTypeEnum hashType, String hash, String account) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<File> cq = cb.createQuery(File.class);

        Root<File> file = cq.from(File.class);
        List<Predicate> predicates = new ArrayList<>();

        if (HashTypeEnum.SHA_256.equals(hashType)) {
            predicates.add(cb.equal(file.get("hash_sha_256"), hash));
        }
        if (HashTypeEnum.SHA_512.equals(hashType)) {
            predicates.add(cb.equal(file.get("hash_sha_512"), hash));
        }
        predicates.add(cb.equal(file.get("account"), account));
        cq.where(predicates.toArray(new Predicate[0]));
        File response = (File) em.createQuery(cq).getSingleResult();
        return response;
    }
}
