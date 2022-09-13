package dani.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dani.repositories.models.Operation;

@Repository
public interface OperationJpaRepository extends JpaRepository<Operation, BigInteger> {

}
