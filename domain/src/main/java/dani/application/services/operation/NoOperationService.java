
package dani.application.services.operation;

import org.springframework.stereotype.Service;

import dani.application.domain.OperationDto;
import dani.application.ports.in.ICommandOperationUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class NoOperationService implements ICommandOperationUseCase {

	@Override
	public OperationDto oper(final OperationDto c) {

		log.info("NoOperationService");
		if (c == null) {
			return null;
		}

		return OperationDto.builder().param1(c.getParam1()).param2(c.getParam2()).result(0).build();
	}

}
