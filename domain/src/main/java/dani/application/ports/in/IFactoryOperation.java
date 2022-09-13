package dani.application.ports.in;

import dani.application.domain.OperationEnum;

public interface IFactoryOperation {

	/**
	 * Método que devuelve la operación 
	 * 
	 * @param c
	 * @return
	 */
	ICommand getCommand(final OperationEnum type);

	
	/**
	 *  Método que devuelve la operación auditable 
	 *  
	 * @param type
	 * @return
	 */
	ICommand getCommandAuditable(final OperationEnum type);


	
	ICommand branchCommand(OperationEnum type);

}
