package dani.api;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import dani.application.domain.OperationDto;
import dani.application.domain.OperationEnum;
import dani.application.ports.in.ICommandOperationUseCase;
import dani.application.ports.in.IFactoryOperation;
import dani.controllers.mappers.OperationApiMapper;
import dani.controllers.mappers.OperationTypeMapper;
import dani.model.Oper;
import dani.model.OperationTypeRequestEnum;
import lombok.SneakyThrows;

@WebMvcTest
//@Import(DefaultExceptionHandler.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = { CalculatorApiController.class })
class OperationControllerAdapterTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IFactoryOperation operationCreateUseCase;

	@MockBean
	private OperationApiMapper operationApiMapper;
	
	@MockBean
	private  OperationTypeMapper operationTypeApiMapper;
	
	@MockBean
	private ICommandOperationUseCase command;

	@Test
	@SneakyThrows
	@DisplayName("Should get Sum Operation")
	void testShouldGetSumOperation() {

		Oper response = getTestResponse();
		OperationDto source = OperationDto.builder().param1(1).param2(2).typeOperation(OperationEnum.SUM).result(3).build();
		
		given(operationApiMapper.toModel(source)).willReturn(response);
		given(operationApiMapper.toDto(1,2,OperationTypeRequestEnum.SUM)).willReturn(source);
		given(operationTypeApiMapper.fromRequest(OperationTypeRequestEnum.SUM)).willReturn(OperationEnum.SUM);
		
		given(operationCreateUseCase.getCommand(OperationEnum.SUM)).willReturn(command);
		given(operationCreateUseCase.branchCommand(OperationEnum.SUM)).willReturn(command);
		
		given(command.oper(source)).willReturn(source);

		mockMvc.perform(get("/calculator").param("param1", "1").param("param2", "2").param("type", "SUM")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.result", is(response.getResult())))
				.andExpect(jsonPath("$.typeOperation", is(response.getTypeOperation().toString())));

	}

	private Oper getTestResponse() {
		Oper input = new Oper();
		input.setParam1(1);
		input.setParam2(2);
		input.setResult(3);
		input.setTypeOperation(OperationTypeRequestEnum.SUM);
		return input;
	}

}

