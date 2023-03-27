package com.practica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.exceptions.ResourceNotFoundException;
import com.practica.model.Servicio;
import com.practica.repositories.ServicioRepository;

@Service
public class ServicioService {
	
	@Autowired
	private ServicioRepository servicioRepository;	
	
	public List<Servicio> getServices(){
		return servicioRepository.findAll();
	}
	public List<Servicio> getServicesByTagName(String tag){
		return servicioRepository.findServicesByTags(tag);
	}
	public List<Servicio> getServicesByCategory(String tag){
		return servicioRepository.findServicesByCategory(tag);
	}
	public Servicio saveService(Servicio service) {
		return servicioRepository.save(service);
	}

    public Servicio updateServicio(Servicio servicio) throws ResourceNotFoundException {
        Optional<Servicio> optionalOldService = servicioRepository.findById(servicio.getId());
        if (optionalOldService.isPresent()) {
            Servicio oldService = optionalOldService.get();
            oldService.setName(servicio.getName());
            oldService.setDescription(servicio.getDescription());
            oldService.setTags(servicio.getTags());
            oldService.setUrlimg(servicio.getUrlimg());
            oldService.setCategory(servicio.getCategory());
            oldService.setUrl(servicio.getUrl());
            Servicio updatedService = servicioRepository.save(oldService);
            return updatedService;
        } else {
            throw new ResourceNotFoundException("Recurso no encontrado!");
        }
    }
    
    public void deleteServiceById(Integer id)throws ResourceNotFoundException {
		 Optional<Servicio> student = servicioRepository.findById(id);
		    if(!student.isPresent()) {
				throw new ResourceNotFoundException("El servicio no se ha encontrado!");
			}else {
				  servicioRepository.deleteById(id);
			}
	}
}
	
