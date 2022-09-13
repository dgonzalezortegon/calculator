package dani.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dani.application.ports.in.ICommand;
import dani.application.ports.in.IFactoryOperation;
import dani.controllers.mappers.OperationApiMapper;
import dani.controllers.mappers.OperationTypeMapper;
import dani.model.Oper;
import dani.model.OperationTypeRequestEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping
public class CalculatorApiController implements CalculatorApi {

	private final IFactoryOperation operationCreateUseCase;

	private final OperationApiMapper operationApiMapper;

	private final OperationTypeMapper operationTypeApiMapper;

	@Override
	public ResponseEntity<Oper> calculate(@NotNull @Valid Integer param1, @NotNull @Valid Integer param2,
			@Valid OperationTypeRequestEnum type) {
		log.info("calculate {} {}", param1, param2);

		ICommand command = operationCreateUseCase.branchCommand(operationTypeApiMapper.fromRequest(type));

		return ResponseEntity
				.ok(operationApiMapper.toModel(command.oper(operationApiMapper.toDto(param1, param2, type))));
	}

}
