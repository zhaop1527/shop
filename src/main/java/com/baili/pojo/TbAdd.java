package com.baili.pojo;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhao
 * @since 2020-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbAdd implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userAddId;

    private String userAddress;

    private String userId;


}
