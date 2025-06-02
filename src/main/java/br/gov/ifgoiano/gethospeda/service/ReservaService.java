package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.dto.ReservaCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.ReservaResumoDTO;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Reserva;
import br.gov.ifgoiano.gethospeda.repository.ReservaRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    private Logger logger = Logger.getLogger(ReservaService.class.getName());

    public List<ReservaResumoDTO> findAll() {
        logger.info("Findall");
        List<Reserva> reservas = reservaRepository.findAll();
        return DataMapper.parseListObjects(reservas, ReservaResumoDTO.class);
    }

    public ReservaCompletoDTO findById(Long id) {
        logger.info("FindById");
        Reserva reserva = reservaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        return DataMapper.parseObject(reserva, ReservaCompletoDTO.class);
    }

    public ReservaCompletoDTO save(ReservaCompletoDTO reserva) {
        logger.info("Save");
        Reserva reservaNova = reservaRepository.save(DataMapper.parseObject(reserva, Reserva.class));
        return DataMapper.parseObject(reservaNova, ReservaCompletoDTO.class);
    }
    public ReservaCompletoDTO update(ReservaCompletoDTO reserva) {
        logger.info("Update");
        Reserva newReserva = reservaRepository.findById(reserva.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        newReserva.setDataInicio(reserva.getDataInicio());
        newReserva.setDataFim(reserva.getDataFim());
        newReserva.setReserva(reserva.getReserva());
        newReserva.setValorTotal(reserva.getValorTotal());
        newReserva.setStatus(reserva.getStatus());

        return DataMapper.parseObject(reservaRepository.save(newReserva), ReservaCompletoDTO.class);
    }
    public void delete(Long id) {
        logger.info("Delete");
        reservaRepository.deleteById(id);
    }


}
