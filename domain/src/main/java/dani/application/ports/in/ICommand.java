package dani.application.ports.in;

import dani.application.domain.OperationDto;

public interface ICommand {
	
	OperationDto oper(OperationDto input);

}
