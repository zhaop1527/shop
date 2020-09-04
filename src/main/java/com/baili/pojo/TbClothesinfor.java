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
public class TbClothesinfor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer clothesinforId;

    private Integer goodsId;

    /**
     * 风格
     */
    private String clothesinforShow;

    /**
     * 领子
     */
    private String clothesinforCollor;

    /**
     * 材料
     */
    private String clothesinforMater;


}
