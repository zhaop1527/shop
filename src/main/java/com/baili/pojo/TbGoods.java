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
public class TbGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer goodsId;

    private String goodsName;

    /**
     * 价格
     */
    private String goodsPrse;

    /**
     * 品牌id
     */
    private String goodsBrandId;

    /**
     * 大类别
     */
    private Integer goodsCateId;

    /**
     * 小类别
     */
    private Integer goodsCatesId;


}
