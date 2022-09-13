package dani.repositories.models;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * The persistent class for the Operation database table.
 * 
 */
@Getter
@Setter
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "operation")
public class Operation  implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "operacion_seq")
  @SequenceGenerator(name = "operacion_seq", allocationSize = 1)
  @Column(name = "codigo_operation")
  private BigInteger codigoOperation;
  
  @Column(name = "codigo_tipo_operation")
  private String codigoTipoOperation;
  
  @Column(name = "resultado")
  private Integer resultado;

 
}
