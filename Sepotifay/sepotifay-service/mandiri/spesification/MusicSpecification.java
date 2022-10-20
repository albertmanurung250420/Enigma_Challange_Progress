package com.mandiri.spesification;

import com.mandiri.dto.MusicSearchCriteria;
import com.mandiri.entity.Music;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MusicSpecification {
    public static Specification<Music> getSpecification(MusicSearchCriteria musicSearchCriteria){
        Specification<Music> specification = new Specification<Music>() {
            @Override
            public Predicate toPredicate(Root<Music> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if ( musicSearchCriteria.getTitle()!=null){
                    Predicate titlePredicate = criteriaBuilder.like(root.get("title"),"%"+musicSearchCriteria.getTitle()+"%");
                    predicates.add(titlePredicate);
                }
                if ( musicSearchCriteria.getComposer()!=null){
                    Predicate composerPredicate = criteriaBuilder.like(root.get("composer"),"%"+musicSearchCriteria.getComposer()+"%");
                    predicates.add(composerPredicate);
                }
                if ( musicSearchCriteria.getStudio()!=null){
                    Predicate studioPredicate = criteriaBuilder.like(root.get("studio"),"%"+musicSearchCriteria.getStudio()+"%");
                    predicates.add(studioPredicate);
                }
                if ( musicSearchCriteria.getArtistName()!=null){
                    Predicate artistNamePredicate = criteriaBuilder.like(root.get("artistName"),"%"+musicSearchCriteria.getArtistName()+"%");
                    predicates.add(artistNamePredicate);
                }
                Predicate[] arrPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrPredicate);
            }
        };
        return specification;
    }
}
