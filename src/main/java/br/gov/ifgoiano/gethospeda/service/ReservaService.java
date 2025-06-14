package br.gov.ifgoiano.gethospeda.service;

import br.gov.ifgoiano.gethospeda.controller.QuartoController;
import br.gov.ifgoiano.gethospeda.controller.ReservaController;
import br.gov.ifgoiano.gethospeda.dto.ReservaCompletoDTO;
import br.gov.ifgoiano.gethospeda.dto.ReservaCreateDTO;
import br.gov.ifgoiano.gethospeda.dto.ReservaResumoDTO;
import br.gov.ifgoiano.gethospeda.exception.ResourceNotFoundException;
import br.gov.ifgoiano.gethospeda.model.Reserva;
import br.gov.ifgoiano.gethospeda.model.StatusReserva;
import br.gov.ifgoiano.gethospeda.repository.ReservaRepository;
import br.gov.ifgoiano.gethospeda.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    private Logger logger = Logger.getLogger(ReservaService.class.getName());

    @Cacheable(value = "todasReservas")
    public List<ReservaResumoDTO> findAll() {
        logger.info("findAll");
        List<Reserva> reservas = reservaRepository.findAll();
        List<ReservaResumoDTO> dtos = DataMapper.parseListObjects(reservas, ReservaResumoDTO.class);
        dtos.forEach(dto -> {
            dto.add(linkTo(methodOn(ReservaController.class).findById(dto.getId())).withSelfRel());
        });
        return dtos;
    }

    @Cacheable(value = "reservasPorQuarto", key = "#quartoId")
    public List<ReservaResumoDTO> findByQuartoId(long quartoId) {
        logger.info("findByQuartoId");
        List<Reserva> reservas = reservaRepository.findByQuartoId(quartoId);
        return DataMapper.parseListObjects(reservas, ReservaResumoDTO.class);
    }

    @Cacheable(value = "reservasPorQuartoEStatus", key = "#quartoId + '-' + #status")
    public List<ReservaResumoDTO> findByQuartoIdAndStaus(long quartoId, StatusReserva status) {
        logger.info("findByQuartoIdAndStatus");
        List<Reserva> reservas = reservaRepository.findByQuartoIdAndStatus(quartoId, status);
        return DataMapper.parseListObjects(reservas, ReservaResumoDTO.class);
    }

    @Cacheable(value = "reserva", key = "#id")
    public ReservaCompletoDTO findById(Long id) {
        logger.info("findById");
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        ReservaCompletoDTO reservaCompletoDTO = DataMapper.parseObject(reserva, ReservaCompletoDTO.class);
        reservaCompletoDTO.add(linkTo(methodOn(QuartoController.class).findById(reserva.getQuarto().getId())).withSelfRel());
        return reservaCompletoDTO;
    }

    @CacheEvict(value = {"todasReservas", "reservasPorQuarto", "reservasPorQuartoEStatus", "reserva"}, allEntries = true)
    public ReservaCompletoDTO save(ReservaCreateDTO reserva) {
        logger.info("save");
        if (reservaRepository.findByQuartoIdAndStatus(reserva.getQuarto().getId(), StatusReserva.valueOf("CONCLUIDA")).isEmpty()) {
            Reserva reservaNova = reservaRepository.save(DataMapper.parseObject(reserva, Reserva.class));
            reservaNova.setStatus(StatusReserva.valueOf("CONCLUIDA"));
            return DataMapper.parseObject(reservaNova, ReservaCompletoDTO.class);
        }
        return null;
    }

    @CacheEvict(value = {"todasReservas", "reservasPorQuarto", "reservasPorQuartoEStatus", "reserva"}, allEntries = true)
    public ReservaCompletoDTO update(ReservaCompletoDTO reserva) {
        logger.info("update");
        Reserva newReserva = reservaRepository.findById(reserva.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        newReserva.setDataInicio(reserva.getDataInicio());
        newReserva.setDataFim(reserva.getDataFim());
        newReserva.setReserva(reserva.getReserva());
        newReserva.setValorTotal(reserva.getValorTotal());
        newReserva.setStatus(reserva.getStatus());

        return DataMapper.parseObject(reservaRepository.save(newReserva), ReservaCompletoDTO.class);
    }

    @CacheEvict(value = {"todasReservas", "reservasPorQuarto", "reservasPorQuartoEStatus", "reserva"}, allEntries = true)
    public void delete(Long id) {
        logger.info("delete");
        reservaRepository.deleteById(id);
    }
}
