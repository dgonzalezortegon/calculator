package dani.controllers.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import dani.application.domain.OperationDto;
import dani.model.Oper;
import dani.model.OperationTypeRequestEnum;

@Mapper(componentModel = "spring", uses = OperationTypeMapper.class)
@JsonInclude(Include.NON_NULL)
public interface OperationApiMapper {

	Oper toModel(final OperationDto source);

	OperationDto toDto(final Oper source);

	@Mapping(target = "param1", source = "param1")
	@Mapping(target = "param2", source = "param2")
	@Mapping(target = "typeOperation", source = "type")
	OperationDto toDto(final Integer param1, final Integer param2, final OperationTypeRequestEnum type);

	List<Oper> toModels(Iterable<OperationDto> source);

}
