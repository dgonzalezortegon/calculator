package dani.controllers.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dani.application.domain.OperationDto;
import dani.model.Oper;
import lombok.SneakyThrows;

@ExtendWith(SpringExtension.class)
class OperationApiMapperTest {

	@InjectMocks
	private OperationApiMapperImpl operationDTOMapper;

	@Mock
	private OperationTypeMapper operationTypeMapper;

	@Test
	@SneakyThrows
	@DisplayName("Should response mapped")
	void testShouldBuildResponseMapped() {

		Oper expected = createOper();
		var input = createOpeartionDTO();
		var responseActual = operationDTOMapper.toModel(input);

		assertEquals(expected, responseActual);
	}

	@Test
	@SneakyThrows
	@DisplayName("Should dto domain")
	void testShouldBuildToDTO() {

		Oper input = createOper();
		var expected = createOpeartionDTO();
		var responseActual = operationDTOMapper.toDto(input);

		assertEquals(expected, responseActual);
	}

	private OperationDto createOpeartionDTO() {

		return OperationDto.builder().param1(1).param2(2).typeOperation(null).build();
	}

	private Oper createOper() {
		Oper input = new Oper();
		input.setParam1(1);
		input.setParam2(2);
		input.setTypeOperation(null);

		return input;
	}

}
