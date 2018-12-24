/**
 * 系统公共函数
 * 
 * @author zhy
 * @date 2016-04-05
 * @version 1.0.0
 * 
 */
var UsePublic = {
	SUCCESS: 1,
	ERROR: -1,
	ERROR_URL: "jsp/error/500.jsp",
	NULL: 0,
	NULL_URL: "jsp/error/404.jsp",
	// 检测字符串是否为空 返回值：空=true;非空=false
	isNull: function(val) {
		val = trim(val); // 去掉字符串两边的空白符
		if(val) {
			return false;
		} else {
			return true;
		}
	},
	// 是否为数字
	isNumber: function(val) {
		var patrn = /^-{0,1}[0-9]+\.{0,1}\d{0,}$/;
		if(!patrn.test(val))
			return false;
		return true;
	},
	// 邮箱账号检测
	isMail: function(checkString) {
		// 正则：(以数字或字母开头后可跟下划线_或减号-或小数点.)或者(直接数字或字母)，@，(以数字或字母开头后可跟下划线_或减号-或小数点.)或者(直接数字或字母),.,跟2-3个字母
		var re = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(checkString) {
			if(re.test(checkString)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	},
	// 手机号码检测
	isPhone: function(checkString) {
		// 正则：以1开头，3|5|8第二位，0-9第三位，后跟8位数字 = 共11位号码
		var re = /^1[3|5|8][0-9]\d{8}$/;
		if(checkString) {
			if(re.test(checkString)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	},
	// 验证短日期(2007-06-05)
	isDate: function(str) {
		var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
		if(r == null) {
			return false;
		}
		var d = new Date(r[1], r[3] - 1, r[4]);
		return(d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d
			.getDate() == r[4]);
	},
	// 验证长日期(2007-06-05 10:57:10)
	isDateTime: function(str) {
		var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
		var r = str.match(reg);
		if(r == null) {
			return false;
		}
		var d = new Date(r[1], r[3] - 1, r[4], r[5], r[6], r[7]);
		return(d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] &&
			d.getDate() == r[4] && d.getHours() == r[5] &&
			d.getMinutes() == r[6] && d.getSeconds() == r[7]);
	},
	// 验证时间(10:57:10)
	isTime: function(str) {
		var a = str.match(/^(\d{1,2})(:)?(\d{1,2})\2(\d{1,2})$/);
		if(a == null) {
			return false;
		}
		if(a[1] > 24 || a[3] > 60 || a[4] > 60) {
			return false
		}
		return true;
	},
	// 全选
	checkedAll: function(obj, name) {
		var checekd = $(obj).attr("checked");
		if(checked) {
			$('input[name="+name+"').each(function() {
				$(this).attr("checked", "checked");
			});
		} else {
			$('input[name="+name+"').each(function() {
				$(this).attr("checked", false);
			});
		}
	},
	formToJSON: function(fromObj) {
		var tmp = {};
		var frm = $(fromObj).serializeArray();
		$.each(frm, function() {
			if(tmp[this.name]) {
				if(!tmp[this.name].push) {
					tmp[this.name] = [o[this.name]];
				}
				tmp[this.name].push(this.value || '');
			} else {
				tmp[this.name] = this.value || '';
			}
		});
		return tmp;
	},
	ajaxSubmit: function(urlVal, param, return_urlVal) {
		$.ajax({
			url: urlVal,
			type: "POST",
			data: param,
			dataType: "json",
			success: function(result) {
				if(result.code == UsePublic.SUCCESS) {
					window.location.href = return_urlVal;
				} else if(result.code == UsePublic.NULL) {
					window.parent.location.href = UsePublic.NULL_URL;
				} else if(result.code == UsePublic.ERROR) {
					window.parent.location.href = UsePublic.ERROR_URL;
				}
			},
			error: function(result) {
				window.parent.location.href = UsePublic.ERROR_URL;
			}
		});
	},
	ajaxDialog: function(urlVal, param, dialog) {
		$.ajax({
			url: urlVal,
			type: "POST",
			data: param,
			dataType: "json",
			success: function(result) {
				layer.close(dialog);
				layer.alert(result.message,function(){
					layer.close();
				});
			},
			error: function(result) {
				window.parent.location.href = UsePublic.ERROR_URL;
			}
		});
	}
};