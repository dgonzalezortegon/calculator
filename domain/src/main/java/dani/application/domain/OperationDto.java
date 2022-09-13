package dani.application.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer param1;
	private Integer param2;
	private Integer result;
	
	private OperationEnum typeOperation;

}
