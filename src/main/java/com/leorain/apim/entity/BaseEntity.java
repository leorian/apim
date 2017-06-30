package com.leorain.apim.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiezg@317hu.com on 2017/6/30 0030.
 */
public abstract class BaseEntity implements Serializable{

    /**
     * 创建人
     */
    private long createUserId;

    /**
     * 创建时间
     */
    private Date createDateTime;

    /**
     * 更新人
     */
    private long updateUserId;

    /**
     * 更新时间
     */
    private Date updateDateTime;

    public long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
