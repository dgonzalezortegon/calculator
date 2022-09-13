package dani.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dani.repositories.config.ConfigTest;
import dani.repositories.models.Operation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ConfigTest.class)
@Slf4j
class OperationJpaRepositoryTest {

	private static final Long TEST_ID = 1L;
	private static final BigInteger TEST_BIG_ID_1 = BigInteger.valueOf(TEST_ID);

	@Autowired
	private OperationJpaRepository operationJpaRepository;

	@DisplayName("Should get all Operations")
	@SneakyThrows
	@Test
	@DirtiesContext(methodMode = MethodMode.BEFORE_METHOD)
	void shouldGetAllOperations() {

		var actual = operationJpaRepository.findAll();

		assertNotNull(actual);
		assertThat(actual).hasSize(2);

	}

	@Test
	@DirtiesContext(methodMode = MethodMode.BEFORE_METHOD)
	void shouldSaveOperation() {

		Operation operation = Operation.builder().codigoOperation(TEST_BIG_ID_1).codigoTipoOperation("SUM").resultado(1).build();

		var actual = operationJpaRepository.save(operation);

		assertEquals(operation.getCodigoTipoOperation(), actual.getCodigoTipoOperation());
	}

}
