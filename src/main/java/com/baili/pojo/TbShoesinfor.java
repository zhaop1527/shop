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
public class TbShoesinfor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer shoesinforId;

    private Integer goodsId;

    /**
     * 风格
     */
    private String shoesinforShow;

    /**
     * 跟高
     */
    private String shoesinforHeight;

    /**
     * 材料
     */
    private String shoesinforMater;


}
