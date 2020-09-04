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
public class TbImg implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer imgId;

    private String imgUrl;

    private Integer goodsId;

    private String sizeId;


}
