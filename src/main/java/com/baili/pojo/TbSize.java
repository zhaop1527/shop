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
public class TbSize implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sizeId;

    private String colorId;

    /**
     * 尺码名字
     */
    private String sizeName;

    /**
     * 库存
     */
    private Double sizeStock;


}
