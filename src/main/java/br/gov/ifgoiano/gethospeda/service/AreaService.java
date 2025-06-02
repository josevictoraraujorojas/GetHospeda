package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.dto.AreaCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.AreaResumoDTO;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Area;
import br.gov.ifgoiano.gethospeda.repository.AreaRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AreaService {
    @Autowired
    AreaRepository areaRepository;
    Logger logger = Logger.getLogger(AreaService.class.getName());

    public List<AreaResumoDTO> findAll() {
        logger.info("findAll");
        List<Area> area = (List<Area>) areaRepository.findAll();
        return DataMapper.parseListObjects(area,AreaResumoDTO.class);
    }

    public AreaCompletoDTO findById(Long id) {
        logger.info("findById");
        Area area = areaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DataMapper.parseObject(area,AreaCompletoDTO.class);
    }

    public AreaCompletoDTO save(AreaCompletoDTO area) {
        logger.info("save");
        Area areaNova = DataMapper.parseObject(area,Area.class);
        areaNova = areaRepository.save(areaNova);
        AreaCompletoDTO areaCompletoDTO = DataMapper.parseObject(areaNova,AreaCompletoDTO.class);
        return areaCompletoDTO;
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

    public void deleteById(Long id) {
        areaRepository.deleteById(id);
    }


}
