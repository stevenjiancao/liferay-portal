/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.social.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the SocialEquityLog service. Represents a row in the &quot;SocialEquityLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.social.model.impl.SocialEquityLogModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.social.model.impl.SocialEquityLogImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialEquityLog
 * @see com.liferay.portlet.social.model.impl.SocialEquityLogImpl
 * @see com.liferay.portlet.social.model.impl.SocialEquityLogModelImpl
 * @generated
 */
public interface SocialEquityLogModel extends BaseModel<SocialEquityLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a social equity log model instance should use the {@link SocialEquityLog} interface instead.
	 */

	/**
	 * Returns the primary key of this social equity log.
	 *
	 * @return the primary key of this social equity log
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this social equity log.
	 *
	 * @param primaryKey the primary key of this social equity log
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the equity log ID of this social equity log.
	 *
	 * @return the equity log ID of this social equity log
	 */
	public long getEquityLogId();

	/**
	 * Sets the equity log ID of this social equity log.
	 *
	 * @param equityLogId the equity log ID of this social equity log
	 */
	public void setEquityLogId(long equityLogId);

	/**
	 * Returns the group ID of this social equity log.
	 *
	 * @return the group ID of this social equity log
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this social equity log.
	 *
	 * @param groupId the group ID of this social equity log
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this social equity log.
	 *
	 * @return the company ID of this social equity log
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this social equity log.
	 *
	 * @param companyId the company ID of this social equity log
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this social equity log.
	 *
	 * @return the user ID of this social equity log
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this social equity log.
	 *
	 * @param userId the user ID of this social equity log
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this social equity log.
	 *
	 * @return the user uuid of this social equity log
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this social equity log.
	 *
	 * @param userUuid the user uuid of this social equity log
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the asset entry ID of this social equity log.
	 *
	 * @return the asset entry ID of this social equity log
	 */
	public long getAssetEntryId();

	/**
	 * Sets the asset entry ID of this social equity log.
	 *
	 * @param assetEntryId the asset entry ID of this social equity log
	 */
	public void setAssetEntryId(long assetEntryId);

	/**
	 * Returns the action ID of this social equity log.
	 *
	 * @return the action ID of this social equity log
	 */
	@AutoEscape
	public String getActionId();

	/**
	 * Sets the action ID of this social equity log.
	 *
	 * @param actionId the action ID of this social equity log
	 */
	public void setActionId(String actionId);

	/**
	 * Returns the action date of this social equity log.
	 *
	 * @return the action date of this social equity log
	 */
	public int getActionDate();

	/**
	 * Sets the action date of this social equity log.
	 *
	 * @param actionDate the action date of this social equity log
	 */
	public void setActionDate(int actionDate);

	/**
	 * Returns the active of this social equity log.
	 *
	 * @return the active of this social equity log
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this social equity log is active.
	 *
	 * @return <code>true</code> if this social equity log is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this social equity log is active.
	 *
	 * @param active the active of this social equity log
	 */
	public void setActive(boolean active);

	/**
	 * Returns the expiration of this social equity log.
	 *
	 * @return the expiration of this social equity log
	 */
	public int getExpiration();

	/**
	 * Sets the expiration of this social equity log.
	 *
	 * @param expiration the expiration of this social equity log
	 */
	public void setExpiration(int expiration);

	/**
	 * Returns the type of this social equity log.
	 *
	 * @return the type of this social equity log
	 */
	public int getType();

	/**
	 * Sets the type of this social equity log.
	 *
	 * @param type the type of this social equity log
	 */
	public void setType(int type);

	/**
	 * Returns the value of this social equity log.
	 *
	 * @return the value of this social equity log
	 */
	public int getValue();

	/**
	 * Sets the value of this social equity log.
	 *
	 * @param value the value of this social equity log
	 */
	public void setValue(int value);

	/**
	 * Returns the extra data of this social equity log.
	 *
	 * @return the extra data of this social equity log
	 */
	@AutoEscape
	public String getExtraData();

	/**
	 * Sets the extra data of this social equity log.
	 *
	 * @param extraData the extra data of this social equity log
	 */
	public void setExtraData(String extraData);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(SocialEquityLog socialEquityLog);

	public int hashCode();

	public CacheModel<SocialEquityLog> toCacheModel();

	public SocialEquityLog toEscapedModel();

	public String toString();

	public String toXmlString();
}