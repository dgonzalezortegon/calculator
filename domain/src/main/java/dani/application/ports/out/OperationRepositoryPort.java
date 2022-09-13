package dani.application.ports.out;

import java.util.List;

import dani.application.domain.OperationDto;

public interface OperationRepositoryPort  {

	List<OperationDto> findAll();

	OperationDto save(OperationDto operation);

}
