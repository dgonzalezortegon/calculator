package dani.controllers.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dani.application.domain.OperationEnum;
import dani.model.OperationTypeRequestEnum;
import lombok.SneakyThrows;

@ExtendWith(SpringExtension.class)
class OperationTypeMapperTest {

	@InjectMocks
	private OperationTypeMapperImpl operationTypeMapper;


	@Test
	@SneakyThrows
	@DisplayName("Should response OperationTypeRequestEnum mapped")
	void testShouldBuildResponseMapped() {

		var expected = OperationTypeRequestEnum.SUM;
		var responseActual = operationTypeMapper.toModel(OperationEnum.SUM);

		assertEquals(expected, responseActual);
	}

	@Test
	@SneakyThrows
	@DisplayName("Should dto domain")
	void testShouldBuildToDTO() {

		var expected = OperationEnum.SUM;
		var responseActual = operationTypeMapper.fromRequest(OperationTypeRequestEnum.SUM);

		assertEquals(expected, responseActual);
	}


}
