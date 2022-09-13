package dani.controllers.mappers;

import javax.validation.Valid;

import org.mapstruct.Mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import dani.application.domain.OperationEnum;
import dani.model.OperationTypeRequestEnum;

@Mapper(componentModel = "spring")
@JsonInclude(Include.NON_NULL)
public interface OperationTypeMapper {

	OperationTypeRequestEnum toModel(final OperationEnum source);

	OperationEnum fromRequest(@Valid final OperationTypeRequestEnum source);

}
