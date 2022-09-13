package dani.repositories.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import dani.application.domain.OperationDto;
import dani.application.ports.out.OperationRepositoryPort;
import dani.repositories.OperationJpaRepository;
import dani.repositories.mappers.OperationMapper;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class OperationRepositoryAdapter implements OperationRepositoryPort {


  private final OperationJpaRepository operationJpaRepository;
  
  private final OperationMapper operationMapper;



  @Override
  public List<OperationDto> findAll() {

    var campaingsMOs = operationJpaRepository.findAll();

    return operationMapper.listMOtoDTO(campaingsMOs);

  }


  @Override
  public OperationDto save(OperationDto campaings) {

    var operationModel = operationMapper.toModel(campaings);

    var operationSaved = operationJpaRepository.save(operationModel);

    return operationMapper.fromModel(operationSaved);

  }


}
