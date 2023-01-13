package ma.ensa.ormjpaspringboot.repositories;

import ma.ensa.ormjpaspringboot.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient,Long> {
     List<Patient> findByMalade(boolean m);
     Page<Patient> findByMalade(boolean m, Pageable pageable);
     Page<Patient> findByMaladeAndScoreLessThan(boolean m,int score,Pageable pageable);
     Page<Patient> findByMaladeIsTrueAndScoreLessThan(int score,Pageable pageable);
     /*Page<Patient> findByDateNaissaceBetweenAndMaladeIsFalseOrNomLike(Date d1, Date d2,String mc);
     @Query("select p from Patient p where p.nom like :x  and p.score < :z")
     Page<Patient> cherchezPatients(@Param("x") String nom , @Param("z") int scoreMin);*/
}
