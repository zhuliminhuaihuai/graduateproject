package com.manage.service;

import com.manage.common.ServerResponse;
import com.manage.vo.SumOrderMoneyVo;

import java.util.List;

public interface ICountService {


    //计算总数
    ServerResponse getTotal();

    //计算今日
    ServerResponse getToday();

    //计算昨日
    ServerResponse getYestoday();

    //计算本周
    ServerResponse getWeek();

    //计算本月
    ServerResponse getMonth();

    //统计当月每日的订单数和订单金额
    ServerResponse<List<SumOrderMoneyVo>> getMonthOrderNumAndMoney();

    //以当前日期为准向后统计后五天的销售总额
    ServerResponse<List<SumOrderMoneyVo>> getFiveDaysOrderMoney();
}
