package com.baili.pojo;

import java.time.LocalDateTime;
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
public class TbOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer orderId;

    private Integer sizeId;

    private String orderState;

    private LocalDateTime orderTime;

    private Integer userId;

    private Integer orderNum;

    private Integer userAddId;


}
