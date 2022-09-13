package dani.repositories.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dani.application.domain.OperationDto;
import dani.repositories.models.Operation;

@Mapper(componentModel = "spring")
public interface OperationMapper {

	@Mapping(target = "typeOperation", source = "codigoTipoOperation")
	@Mapping(target = "result", source = "resultado")
	OperationDto fromModel(Operation operation);

	@Mapping(target = "codigoTipoOperation", source = "typeOperation")
	@Mapping(target = "resultado", source = "result")
	Operation toModel(OperationDto operation);

	List<OperationDto> listMOtoDTO(List<Operation> operationsMOs);

}
