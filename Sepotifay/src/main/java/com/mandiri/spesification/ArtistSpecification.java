package com.mandiri.spesification;

import com.mandiri.entity.Artists;
import com.mandiri.dto.ArtistsSearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class    ArtistSpecification {
    public static Specification<Artists> getSpecification(ArtistsSearchCriteria artistSearchCriteria){
        Specification<Artists> specification = new Specification<Artists>() {
            @Override
            public Predicate toPredicate(Root<Artists> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (artistSearchCriteria.getName()!=null){
                    Predicate namePredicate = criteriaBuilder.like(root.get("name"),"%"+artistSearchCriteria.getName()+"%");
                    predicates.add(namePredicate);
                }
                if (artistSearchCriteria.getBirthPlace()!=null){
                    Predicate birthPlacePredicate = criteriaBuilder.like(root.get("birthPlace"),"%"+artistSearchCriteria.getBirthPlace()+"%");
                    predicates.add(birthPlacePredicate);
                }
                if(artistSearchCriteria.getStartBirthDate()!=null){
                    Predicate predicateStart = criteriaBuilder.greaterThan(root.get("birthDate"),artistSearchCriteria.getStartBirthDate());
                    predicates.add(predicateStart);
                }
                if(artistSearchCriteria.getEndBirthDate()!=null){
                    Predicate predicateEnd = criteriaBuilder.lessThan(root.get("birthDate"),artistSearchCriteria.getEndBirthDate());
                    predicates.add(predicateEnd);
                }
                if (artistSearchCriteria.getEmail()!=null){
                    Predicate emailPredicate = criteriaBuilder.like(root.get("email"),"%"+artistSearchCriteria.getEmail()+"%");
                    predicates.add(emailPredicate);
                }
                if (artistSearchCriteria.getPhone()!=null){
                    Predicate phonePredicate = criteriaBuilder.like(root.get("phone"),"%"+artistSearchCriteria.getPhone()+"%");
                    predicates.add(phonePredicate);
                }
                if (artistSearchCriteria.getGender()!=null){
                    Predicate genderPredicate = criteriaBuilder.like(root.get("gender"),"%"+artistSearchCriteria.getGender()+"%");
                    predicates.add(genderPredicate);
                }
                Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
        return specification;
    }
}
