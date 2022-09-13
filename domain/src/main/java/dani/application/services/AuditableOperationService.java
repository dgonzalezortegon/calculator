
package dani.application.services;

import org.springframework.stereotype.Service;

import dani.application.domain.OperationDto;
import dani.application.ports.in.ICommandAuditable;
import dani.application.ports.in.ICommandOperationUseCase;
import dani.application.ports.out.OperationRepositoryPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuditableOperationService implements ICommandAuditable {

	private ICommandOperationUseCase commandService;

	private final OperationRepositoryPort operationRepositoryAdapter;

	public AuditableOperationService(OperationRepositoryPort operationRepositoryAdapter) {
		super();
		this.operationRepositoryAdapter = operationRepositoryAdapter;
	}

	@Override
	public OperationDto oper(final OperationDto input) {

		log.debug("AuditableOperationService {}", input.getTypeOperation());

		if (commandService == null) {
			return null;
		}
		
		OperationDto result = commandService.oper(input);
		//Audit
		operationRepositoryAdapter.save(result);
		return result;
	}

	@Override
	public void setCommand(ICommandOperationUseCase command) {
		this.commandService = command;
	}

}
