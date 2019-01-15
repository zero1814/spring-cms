package org.service.impl.system;

import java.util.ArrayList;
import java.util.List;

import org.dto.system.ScSettingDto;
import org.entity.system.ScSetting;
import org.mapper.system.ScSettingMapper;
import org.service.system.IScSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

import zero.commons.basics.StringUtils;
import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: ScSettingServiceImpl <br>
 * 描述: 系统相关配置表业务接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:31:19
 */
@Service
public class ScSettingServiceImpl extends BaseServiceImpl<ScSetting, ScSettingMapper, ScSettingDto>
		implements IScSettingService {

	@Autowired
	private ScSettingMapper mapper;

	@Override
	public DataResult<ScSetting> tree(ScSettingDto dto) {
		DataResult<ScSetting> result = new DataResult<ScSetting>();
		try {
			List<ScSetting> list = mapper.selectAll(dto);
			if (list != null && list.size() > 0) {
				result.setData(tree(list));
				result.setCode(ResultType.SUCCESS);
				result.setMessage("查询成功");
			} else {
				result.setCode(ResultType.NULL);
				result.setMessage("查询数据为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.NULL);
			result.setMessage("查询系统配置信息错误，错误原因：" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: delete <br>
	 * 
	 * @param code
	 * @return
	 * @see org.zero.spring.mybatis.BaseServiceImpl#delete(java.lang.String)
	 */
	@Override
	public BaseResult delete(String code) {
		BaseResult result = new BaseResult();
		ScSettingDto dto = new ScSettingDto();
		dto.setParentCode(code);
		List<ScSetting> children = mapper.selectAll(dto);
		if (children != null && children.size() > 0) {
			result.setCode(ResultType.ERROR);
			result.setMessage("对象包含子数据无法删除");
			return result;
		}
		result = super.delete(code);
		return result;
	}

	private List<ScSetting> tree(List<ScSetting> list) {
		List<ScSetting> tree = new ArrayList<ScSetting>();
		for (ScSetting parent : list) {
			if (StringUtils.equals(parent.getCode(), "0")) {
				tree.add(parent);
			}
			for (ScSetting child : list) {
				if (StringUtils.equals(child.getParentCode(), parent.getCode())) {
					if (parent.getChildren() == null) {
						parent.setChildren(new ArrayList<ScSetting>());
					}
					parent.getChildren().add(child);
				}
			}
		}
		return tree;
	}
}