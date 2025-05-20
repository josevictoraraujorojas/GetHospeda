package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Area;
import br.gov.ifgoiano.gethospeda.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AreaService {
    @Autowired
    AreaRepository areaRepository;
    Logger logger = Logger.getLogger(AreaService.class.getName());

    public List<Area> findAll() {
        logger.info("findAll");
        return areaRepository.findAll();
    }

    public Area findById(Long id) {
        logger.info("findById");
        return areaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Area save(Area area) {
        logger.info("save");
        return areaRepository.save(area);
    }

    public Area update(Area area) {
        logger.info("update");
        Area newArea = areaRepository.findById(area.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        newArea.setTipo(area.getTipo());
        newArea.setDescricao(area.getDescricao());
        newArea.setHorarioDisponivel(area.getHorarioDisponivel());
        newArea.setRegrasDeUso(area.getRegrasDeUso());
        return areaRepository.save(newArea);
    }

    public void deleteById(Long id) {
        areaRepository.deleteById(id);
    }


}
