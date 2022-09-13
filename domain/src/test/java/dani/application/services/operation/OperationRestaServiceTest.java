
package dani.application.services.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dani.application.domain.OperationDto;
import dani.application.domain.OperationEnum;
import dani.application.ports.in.ICommandOperationUseCase;

@ExtendWith(SpringExtension.class)
public class OperationRestaServiceTest {

	private ICommandOperationUseCase service;

	@BeforeEach
	public void before() {
		service = new OperationRestaService();
	}

	@Test
	@DisplayName("Test Result Resta Service")
	void testOperResta() {

		OperationDto oper = OperationDto.builder().param1(1).param2(1).typeOperation(OperationEnum.RESTA).build();
		OperationDto actual = service.oper(oper);

		assertEquals(0, actual.getResult());

	}

}
