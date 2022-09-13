
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
public class OperationSumServiceTest {

	private ICommandOperationUseCase service;

	@BeforeEach
	public void before() {
		service = new OperationSumService();
	}

	@Test
	@DisplayName("Test Result Sum Service")
	void testOperSum() {

		OperationDto oper = OperationDto.builder().param1(1).param2(1).typeOperation(OperationEnum.SUM).build();
		OperationDto actual = service.oper(oper);

		assertEquals(2, actual.getResult());

	}

	@Test
	@DisplayName("Test Result Null Sum Service when the input is null")
	void testOperSumNull() {

		OperationDto oper = null;
		OperationDto actual = service.oper(oper);

		assertEquals(null, actual);

	}

}
