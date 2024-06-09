package pe.edu.cibertec.soap.repository;

import org.springframework.stereotype.Repository;
import pe.edu.cibertec.soap.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}