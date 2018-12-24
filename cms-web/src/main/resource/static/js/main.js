//获取系统时间
var newDate = '';
getLangDate();
orderEcharts();
userEcharts();
productEcharts();
sellMoneyEcharts();
/**
 * 刷新时间
 */
function dateFilter(date) {
	if(date < 10) {
		return "0" + date;
	}
	return date;
}

function getLangDate() {
	var dateObj = new Date(); //表示当前系统时间的Date对象
	var year = dateObj.getFullYear(); //当前系统时间的完整年份值
	var month = dateObj.getMonth() + 1; //当前系统时间的月份值
	var date = dateObj.getDate(); //当前系统时间的月份中的日
	var day = dateObj.getDay(); //当前系统时间中的星期值
	var weeks = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
	var week = weeks[day]; //根据星期值，从数组中获取对应的星期字符串
	var hour = dateObj.getHours(); //当前系统时间的小时值
	var minute = dateObj.getMinutes(); //当前系统时间的分钟值
	var second = dateObj.getSeconds(); //当前系统时间的秒钟值
	var timeValue = "" + ((hour >= 12) ? (hour >= 18) ? "晚上" : "下午" : "上午"); //当前时间属于上午、晚上还是下午
	newDate = dateFilter(year) + "年" + dateFilter(month) + "月" + dateFilter(date) + "日 " + " " + dateFilter(hour) + ":" + dateFilter(minute) + ":" + dateFilter(second);
	document.getElementById("nowTime").innerHTML = "当前时间为： " + newDate + "　" + week;
	setTimeout("getLangDate()", 1000);
}
/**
 * 订单趋势图
 */
function orderEcharts() {
	var orderChart = echarts.init(document.getElementById('orderEcharts'));
	option = {
		title: {
			text: '订单趋势图'
		},
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			data: ['订单总量']
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		toolbox: {
			feature: {
				saveAsImage: {}
			}
		},
		xAxis: {
			type: 'category',
			boundaryGap: false,
			data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
		},
		yAxis: {
			type: 'value'
		},
		series: [{
			name: '订单总量',
			type: 'line',
			stack: '总量',
			data: [12, 32, 51, 66, 22, 62, 10, 38, 99, 20, 43, 12]
		}, ]
	};
	orderChart.setOption(option);
}

/**
 * 新增会员趋势图
 */
function userEcharts() {
	var userChart = echarts.init(document.getElementById('userEcharts'));
	option = {
		title: {
			text: '新增会员趋势图'
		},
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			data: ['新增会员总数']
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		toolbox: {
			feature: {
				saveAsImage: {}
			}
		},
		xAxis: {
			type: 'category',
			boundaryGap: false,
			data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
		},
		yAxis: {
			type: 'value'
		},
		series: [{
			name: '新增会员总数',
			type: 'line',
			stack: '总数',
			data: [12, 32, 51, 66, 22, 62, 10, 38, 99, 20, 43, 12]
		}, ]
	};
	userChart.setOption(option);
}
/**
 * 产品销售总量趋势图
 */
function productEcharts() {
	var productChart = echarts.init(document.getElementById('productEcharts'));
	option = {
		title: {
			text: '产品销售趋势图'
		},
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			data: ['产品销售总数']
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		toolbox: {
			feature: {
				saveAsImage: {}
			}
		},
		xAxis: {
			type: 'category',
			boundaryGap: false,
			data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
		},
		yAxis: {
			type: 'value'
		},
		series: [{
			name: '产品销售总数',
			type: 'line',
			stack: '总数',
			data: [12, 32, 51, 66, 22, 62, 10, 38, 99, 20, 43, 12]
		}, ]
	};
	productChart.setOption(option);
}
/**
 * 销售金额趋势图
 */
function sellMoneyEcharts() {
	var sellMoneyChart = echarts.init(document.getElementById('sellMoneyEcharts'));
	option = {
		title: {
			text: '销售金额趋势图'
		},
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			data: ['销售金额总金额']
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		toolbox: {
			feature: {
				saveAsImage: {}
			}
		},
		xAxis: {
			type: 'category',
			boundaryGap: false,
			data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
		},
		yAxis: {
			type: 'value'
		},
		series: [{
			name: '销售金额总金额',
			type: 'line',
			stack: '总金额',
			data: [210000, 32000, 51000, 660000, 22000, 330000, 100000, 380000, 99000, 200000, 430000, 120000]
		}, ]
	};
	sellMoneyChart.setOption(option);
}

layui.use(['jquery'], function() {
	$ = layui.jquery;
	$(".panel a").click(function() {
		$(this).find("cite").html($(this).attr("tab"))
		parent.addTab($(this));
	})
})