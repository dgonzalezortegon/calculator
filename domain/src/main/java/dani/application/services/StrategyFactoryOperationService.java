
package dani.application.services;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import dani.application.domain.OperationEnum;
import dani.application.ports.in.ICommand;
import dani.application.ports.in.ICommandAuditable;
import dani.application.ports.in.ICommandOperationUseCase;
import dani.application.ports.in.IFactoryOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementación de la estrategía de las Operaciones
 * 
 * @author dgonzalez.ortegon
 *
 */

@Slf4j
@Service
@AllArgsConstructor
public class StrategyFactoryOperationService implements IFactoryOperation {

	private final ICommandOperationUseCase operationSumService;
	private final ICommandOperationUseCase operationRestaService;
	private final ICommandOperationUseCase noOperationService;

	private final ICommandAuditable commandAuditable;

	private AuditableProvider auditable;

	@Override
	public ICommand branchCommand(OperationEnum type) {
		log.info("applyCommand");
		if (auditable.is()) {
			return getCommandAuditable(type);
		}
		return getOperationDecision(type);
	}

	@Override
	public ICommandOperationUseCase getCommand(OperationEnum type) {
		log.info("OperationGetService");
		return getOperationDecision(type);
	}

	@Override
	public ICommandAuditable getCommandAuditable(OperationEnum type) {
		log.info("OperationGetService Auditable");
		commandAuditable.setCommand(getOperationDecision(type));
		return commandAuditable;
	}

	protected ICommandOperationUseCase getOperationDecision(OperationEnum typeOperation) {

		ICommandOperationUseCase operation = null;

		switch (typeOperation) {
		case RESTA:
			operation = operationRestaService;
			break;
		case SUM:
			operation = operationSumService;
			break;
		default:
			operation = noOperationService;
		}
		return operation;
	}

}
