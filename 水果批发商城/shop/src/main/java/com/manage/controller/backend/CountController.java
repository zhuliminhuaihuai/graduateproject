package com.manage.controller.backend;

import com.manage.common.ServerResponse;
import com.manage.service.ICountService;
import com.manage.vo.SumOrderMoneyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/manage/count/")
public class CountController {


    @Autowired
    private ICountService iCountService;

    //计算总数
    @RequestMapping("getTotal")
    @ResponseBody
    public ServerResponse getTotal() {
        return iCountService.getTotal();
    }

    //计算今日
    @RequestMapping("getToday")
    @ResponseBody
    public ServerResponse getToday() {
        return iCountService.getToday();
    }

    //计算昨日
    @RequestMapping("getYestoday")
    @ResponseBody
    public ServerResponse getYestoday() {
        return iCountService.getYestoday();
    }

    //计算本周
    @RequestMapping("getWeek")
    @ResponseBody
    public ServerResponse getWeek() {
        return iCountService.getWeek();
    }

    //计算本月
    @RequestMapping("getMonth")
    @ResponseBody
    public ServerResponse getMonth() {
        return iCountService.getMonth();
    }

    //统计当月每日的订单数和订单金额
    @RequestMapping("getMonthOrderNumAndMoney")
    @ResponseBody
    public ServerResponse<List<SumOrderMoneyVo>> getMonthOrderNumAndMoney() {
        return iCountService.getMonthOrderNumAndMoney();
    }
    //以当前日期为准向后统计后五天的销售总额
    @RequestMapping("getFiveDaysOrderMoney")
    @ResponseBody
    public ServerResponse<List<SumOrderMoneyVo>> getFiveDaysOrderMoney() {
        return iCountService.getFiveDaysOrderMoney();
    }

    /********************************************/
    //跳转折线图
    @RequestMapping("jumpEchartBrokenLine.html")
    public String jumpEchartBrokenLineHtml() {
        return "count/echart_brokenline";
    }

    //跳转饼图
    @RequestMapping("jumpEchartPieChart.html")
    public String jumpEchartPieChartHtml() {
        return "count/echart_piechart";
    }
}
