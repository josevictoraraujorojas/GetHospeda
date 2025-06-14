package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.controller.AreaController;
import br.gov.ifgoiano.gethospeda.dto.AreaCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.AreaCreateDTO;
import br.gov.ifgoiano.gethospeda.dto.AreaResumoDTO;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Area;
import br.gov.ifgoiano.gethospeda.repository.AreaRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class AreaService {
    @Autowired
    AreaRepository areaRepository;
    Logger logger = Logger.getLogger(AreaService.class.getName());

    public List<AreaResumoDTO> findAll() {
        logger.info("findAll");
        List<Area> area = areaRepository.findAll();
        List<AreaResumoDTO> dtos = DataMapper.parseListObjects(area,AreaResumoDTO.class);
        dtos.forEach(dto -> {
            dto.add(linkTo(methodOn(AreaController.class).findById(dto.getId())).withSelfRel());
        });
        return dtos;
    }

    public AreaCompletoDTO findById(Long id) {
        logger.info("findById");
        Area area = areaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DataMapper.parseObject(area,AreaCompletoDTO.class);
    }

    public List<AreaResumoDTO> findByImovel(long id) {
        logger.info("findAll");
        List<Area> area = areaRepository.findByImovelId(id);
        return DataMapper.parseListObjects(area,AreaResumoDTO.class);
    }

    public AreaCompletoDTO save(AreaCreateDTO area) {
        logger.info("save");
        Area areaNova = DataMapper.parseObject(area,Area.class);
        areaNova = areaRepository.save(areaNova);
        return DataMapper.parseObject(areaNova,AreaCompletoDTO.class);
    }

    public AreaCompletoDTO update(AreaCompletoDTO area) {
        logger.info("update");
        Area newArea = areaRepository.findById(area.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        newArea.setTipo(area.getTipo());
        newArea.setDescricao(area.getDescricao());
        newArea.setHorarioDisponivel(area.getHorarioDisponivel());
        newArea.setRegrasDeUso(area.getRegrasDeUso());
        areaRepository.save(newArea);
        return DataMapper.parseObject(newArea,AreaCompletoDTO.class);
    }

    public boolean deleteById(Long id) {
        if (!areaRepository.findById(id).isEmpty()) {
            areaRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
