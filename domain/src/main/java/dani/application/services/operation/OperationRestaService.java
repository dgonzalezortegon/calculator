
package dani.application.services.operation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dani.application.domain.OperationDto;
import dani.application.ports.in.ICommandOperationUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class OperationRestaService implements ICommandOperationUseCase {

	@Override
	public OperationDto oper(final OperationDto c) {

		log.info("OperationRestaService");
		if (c == null) {
			return null;
		}
		Integer result = Optional.ofNullable(c.getParam1()).orElse(0) - Optional.ofNullable(c.getParam2()).orElse(0);

		return OperationDto.builder().param1(c.getParam1()).param2(c.getParam2()).result(result)
				.typeOperation(c.getTypeOperation()).build();
	}

}
