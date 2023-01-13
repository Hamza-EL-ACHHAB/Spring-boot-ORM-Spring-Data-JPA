package ma.ensa.ormjpaspringboot;

import ma.ensa.ormjpaspringboot.entities.Patient;
import ma.ensa.ormjpaspringboot.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OrmJpaSpringBootApplication implements CommandLineRunner {
    /*Je demande a Spring de chercher une implementation de cette interface et l'injecter
      mm si je n'ai pas creer l'impl mais Spring dispose d'une class de Spring Data qui va etre injecter
      spring dispose deja d'une implementation Generique*/
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmJpaSpringBootApplication.class, args);

    }

    /*Apres le demarrage de Spring cette methode s'execute*/
    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            patientRepository.save(new Patient(null,"Hamza",new Date(),Math.random()>0.5?true:false,(int) Math.random()*100));
        }
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(1,5));
        System.out.println("Total Pages :" + patients.getTotalPages());
        System.out.println("Total Elements" + patients.getTotalElements());
        System.out.println("Page Number" + patients.getNumber());
        List<Patient> content = patients.getContent();
        //Page<Patient> patientMalade = patientRepository.findByMalade(false,PageRequest.of(0,4));
        //Page<Patient> patientsPage = patientRepository.cherchezPatients("%H%",15);
        content.forEach(p->{
            System.out.println("======================");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissace());
            System.out.println(p.getScore());
            System.out.println(p.isMalade());
        });
        System.out.println("**********************");
        Patient patient = patientRepository.findById(1L).orElse(null);
        if (patient!=null){
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
        else {System.out.println("Not Found");}
        patient.setScore(780);
        patientRepository.save(patient);
        patientRepository.deleteById(2L);
    }
}
