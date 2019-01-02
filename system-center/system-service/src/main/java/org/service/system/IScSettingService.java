package org.service.system;

import org.dto.system.ScSettingDto;
import org.entity.system.ScSetting;
import org.zero.spring.mybatis.IBaseService;

import zero.commons.basics.result.DataResult;

/**
 * 
 * 类: ScSetting <br>
 * 描述: 系统相关配置表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:31:19
 */
public interface IScSettingService extends IBaseService<ScSetting, ScSettingDto> {

	DataResult<ScSetting> tree(ScSettingDto dto);
}