package com.practica.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.practica.model.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio,Integer> {
	
	public List<Servicio> findServicesByTags(String tags);
	public List<Servicio> findServicesByCategory(String category);
	
}
