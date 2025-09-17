package co.edu.udem.ejemplodockercompose.service;

import co.edu.udem.ejemplodockercompose.model.Estudiante;
import co.edu.udem.ejemplodockercompose.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    public Estudiante create(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Estudiante update(Estudiante estudiante) {
        Optional<Estudiante> estudianteObj = estudianteRepository.findById(estudiante.getId());

        if (estudianteObj.isPresent()) {
            Estudiante nuevoEstudiante = estudianteObj.get();
            nuevoEstudiante.setNombres(estudiante.getNombres());
            nuevoEstudiante.setApellidos(estudiante.getApellidos());
            nuevoEstudiante.setEmail(estudiante.getEmail());
            return estudianteRepository.save(nuevoEstudiante);
        } else {
            throw new RuntimeException("Estudiante no encontrado: " + estudiante.getId());
        }
    }
}
