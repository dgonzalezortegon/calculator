package dani.application.ports.in;

public interface ICommandAuditable extends ICommand {

	void setCommand(ICommandOperationUseCase command);

}
