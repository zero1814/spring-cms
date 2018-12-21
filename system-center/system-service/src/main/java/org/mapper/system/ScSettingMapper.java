package org.mapper.system;

import org.dto.system.ScSettingDto;
import org.entity.system.ScSetting;
import org.zero.spring.mybatis.IBaseMapper;

/**
 * 
 * 类: ScSettingMapper <br>
 * 描述: 系统参数设置表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午2:24:32
 */
public interface ScSettingMapper extends IBaseMapper<ScSetting, ScSettingDto> {
}