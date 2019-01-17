package org.service.impl.system;

import java.util.List;

import org.dto.system.ScRoleDto;
import org.entity.system.ScMenu;
import org.entity.system.ScRole;
import org.entity.system.ScUser;
import org.mapper.system.ScRoleMapper;
import org.service.system.IScRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import zero.commons.basics.result.PageResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: ScRoleServiceImpl <br>
 * 描述: 角色表业务接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:24:52
 */
@Service
public class ScRoleServiceImpl extends BaseServiceImpl<ScRole, ScRoleMapper, ScRoleDto> implements IScRoleService {

	private static Logger logger = LoggerFactory.getLogger(ScRoleServiceImpl.class);

	@Autowired
	private ScRoleMapper mapper;

	@Override
	public PageResult<ScUser> roleUsers(ScRoleDto dto) {
		PageResult<ScUser> result = new PageResult<ScUser>();
		logger.info("开始执行page方法");
		if (dto == null) {
			result.setCode(ResultType.ERROR);
			result.setMessage("参数对象不能为空");
			return result;
		}
		if (dto.getPage() == null || dto.getPage() <= 0) {
			result.setCode(ResultType.ERROR);
			result.setMessage("参数对象number应为大于0的正整数");
			return result;
		}
		if (dto.getSize() == null || dto.getSize() <= 0) {
			result.setCode(ResultType.ERROR);
			result.setMessage("参数对象size应为大于0的正整数");
			return result;
		}
		try {
			int offset = (dto.getPage() - 1) * dto.getSize();
			PageInfo<ScUser> page = PageHelper.offsetPage(offset, dto.getSize()).doSelectPageInfo(new ISelect() {

				@Override
				public void doSelect() {
					mapper.findRoleUsers(dto.getCode());
				}
			});
			List<ScUser> list = page.getList();
			if (list != null && list.size() > 0) {
				Long total = page.getTotal();
				result.setData(list);
				result.setTotal(total);
				result.setCode(ResultType.SUCCESS);
				result.setMessage("查询数据成功");
			} else {
				result.setCode(ResultType.NULL);
				result.setMessage("查询数据为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("执行page方法报错，错误原因：" + e.getMessage());
			result.setCode(ResultType.ERROR);
			result.setMessage("执行分页方法失败");
		} finally {
			logger.info("执行page方法结束");
		}
		return result;
	}

	@Override
	public PageResult<ScMenu> roleMenus(ScRoleDto dto) {
		PageResult<ScMenu> result = new PageResult<ScMenu>();
		logger.info("开始执行page方法");
		if (dto == null) {
			result.setCode(ResultType.ERROR);
			result.setMessage("参数对象不能为空");
			return result;
		}
		if (dto.getPage() == null || dto.getPage() <= 0) {
			result.setCode(ResultType.ERROR);
			result.setMessage("参数对象number应为大于0的正整数");
			return result;
		}
		if (dto.getSize() == null || dto.getSize() <= 0) {
			result.setCode(ResultType.ERROR);
			result.setMessage("参数对象size应为大于0的正整数");
			return result;
		}
		try {
			int offset = (dto.getPage() - 1) * dto.getSize();
			PageInfo<ScMenu> page = PageHelper.offsetPage(offset, dto.getSize()).doSelectPageInfo(new ISelect() {
				@Override
				public void doSelect() {
					mapper.findRoleMenus(dto.getCode());
				}
			});
			List<ScMenu> list = page.getList();
			if (list != null && list.size() > 0) {
				Long total = page.getTotal();
				result.setData(list);
				result.setTotal(total);
				result.setCode(ResultType.SUCCESS);
				result.setMessage("查询数据成功");
			} else {
				result.setCode(ResultType.NULL);
				result.setMessage("查询数据为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("执行page方法报错，错误原因：" + e.getMessage());
			result.setCode(ResultType.ERROR);
			result.setMessage("执行分页方法失败");
		} finally {
			logger.info("执行page方法结束");
		}
		return result;
	}
}