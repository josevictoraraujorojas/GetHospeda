package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.dto.ImovelCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.ImovelResumoDTO;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Imovel;
import br.gov.ifgoiano.gethospeda.repository.ImovelRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository imovelRepository;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public List<ImovelResumoDTO> findAll() {
        logger.info("findAll");
        List<Imovel> imoveis = imovelRepository.findAll();
        return DataMapper.parseListObjects(imoveis, ImovelResumoDTO.class);
    }

    public ImovelCompletoDTO findById(Long id) {
        logger.info("findById");
        Imovel imovel = imovelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No records found for this ID"));
        return DataMapper.parseObject(imovel, ImovelCompletoDTO.class);
    }

    public ImovelCompletoDTO save(ImovelCompletoDTO imovel) {
        logger.info("save");
        return DataMapper.parseObject(imovelRepository.save(DataMapper.parseObject(imovel,Imovel.class)),ImovelCompletoDTO.class);
    }

    public ImovelCompletoDTO update(ImovelCompletoDTO imovel) {
        logger.info("update");
        Imovel entity = imovelRepository.findById(imovel.getId()).orElseThrow(()->new ResourceNotFoundException("No records found for this ID"));
        entity.setTitulo(imovel.getTitulo());
        entity.setDescricao(imovel.getDescricao());
        entity.setEndereco(imovel.getEndereco());
        entity.setCidade(imovel.getCidade());
        entity.setEstado(imovel.getEstado());
        entity.setCep(imovel.getCep());
        entity.setPrecoDiaria(imovel.getPrecoDiaria());
        entity.setPoliticaDeCancelamento(imovel.getPoliticaDeCancelamento());
        entity.setStatus(imovel.getStatus());
        return DataMapper.parseObject(imovelRepository.save(entity), ImovelCompletoDTO.class);
    }

    public void delete(Long id) {
        logger.info("delete");
        imovelRepository.deleteById(id);
    }


}
