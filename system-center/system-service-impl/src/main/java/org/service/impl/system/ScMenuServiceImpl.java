package org.service.impl.system;

import java.util.ArrayList;
import java.util.List;

import org.dto.system.ScMenuDto;
import org.entity.system.ScMenu;
import org.entity.system.ScSetting;
import org.mapper.system.ScMenuMapper;
import org.mapper.system.ScSettingMapper;
import org.service.system.IScMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

import zero.commons.basics.StringUtils;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: ScMenuServiceImpl <br>
 * 描述: 系统菜单业务接口实现类<br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 上午11:59:08
 */
@Service
public class ScMenuServiceImpl extends BaseServiceImpl<ScMenu, ScMenuMapper, ScMenuDto> implements IScMenuService {

	@Autowired
	private ScMenuMapper mapper;

	@Autowired
	private ScSettingMapper settingMapper;

	@Value("${system.menu.status}")
	private String statusCode;

	/**
	 * 
	 * 方法: navs <br>
	 * 
	 * @return
	 * @see org.service.system.IScMenuService#navs()
	 */
	@Override
	public DataResult<ScMenu> navs() {
		DataResult<ScMenu> result = new DataResult<ScMenu>();
		try {
			List<ScMenu> list = mapper.navs("SS1077459485900926976");
			if (list != null && list.size() > 0) {
				result.setData(tree(list));
				result.setCode(ResultType.SUCCESS);
				result.setMessage("加载成功");
				return result;
			} else {
				result.setCode(ResultType.NULL);
				result.setMessage("加载菜单为空");
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("加载菜单失败，失败原因：" + e.getMessage());
			return result;
		}
	}

	private List<ScMenu> tree(List<ScMenu> list) {
		List<ScMenu> tree = new ArrayList<ScMenu>();
		for (ScMenu m : list) {
			if (StringUtils.equals(m.getParentCode(), "0")) {
				tree.add(m);
			}
			for (ScMenu menu : list) {
				if (StringUtils.equals(menu.getParentCode(), m.getCode())) {
					if (m.getChildren() == null) {
						m.setChildren(new ArrayList<ScMenu>());
					}
					m.getChildren().add(menu);
				}
			}
		}
		return tree;
	}

	/**
	 * 
	 * 方法: status <br>
	 * 
	 * @return
	 * @see org.service.system.IScMenuService#status()
	 */
	@Override
	public List<ScSetting> status() {
		return settingMapper.selectSetting(statusCode);
	}
}